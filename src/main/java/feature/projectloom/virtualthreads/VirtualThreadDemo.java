package feature.projectloom.virtualthreads;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class VirtualThreadDemo {

    public long noOfVirtualThreadsDemo() {
        var counter = new AtomicInteger();

        while (counter.longValue() < 150000) {
            Thread.startVirtualThread(() -> {
                int count = counter.incrementAndGet();
                System.out.println("Thread count = " + count);
                LockSupport.park(); //Disables the current thread for thread scheduling purposes unless the permit is available.
            });
        }

        return counter.longValue();
    }

    public void noOfThreadsBeforeVirtualThread() {
        var counter = new AtomicInteger();
        while (true) {
            new Thread(() -> {
                int count = counter.incrementAndGet();
                System.out.println("Thread count = " + count);
                LockSupport.park();
            }).start();
        }
    }

    public void virtualThreadDemo2(Runnable runnable) throws InterruptedException {

        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        ThreadFactory kernelThreadFactory = Thread.ofPlatform().factory();

        Thread virtualThread = virtualThreadFactory.newThread(runnable);
        Thread kernelThread = kernelThreadFactory.newThread(runnable);

        virtualThread.start();
        kernelThread.start();

        virtualThread.join();
        kernelThread.join();
    }

    public void postVirtualThread(Runnable runnable) throws InterruptedException {
        Thread vThread = Thread.ofVirtual().start(runnable);
        vThread.join();
    }

    public  void preVirtualThread(Runnable runnable) throws InterruptedException {
        System.out.println("Pre virtual thread");
        Thread t = new Thread(runnable);
        t.start();
        t.join();
    }


    private void viewCarrierThreadPoolSize() {
      //  final ThreadFactory factory = Thread.ofVirtual().name("routine-", 0).factory();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, numberOfCores() + 10)
                    .forEach(i -> executor.submit(() -> {
                        try {
                            sleep(Duration.ofSeconds(5L));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Wake up" + Thread.currentThread());

                    }));
        }
    }


    private int numberOfCores() {

        var noCores = Runtime.getRuntime().availableProcessors();
        System.out.println(noCores);
        return noCores;
    }

    public long performanceBeforeVirtualThread(List<Task> tasks) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(100);
        long sum = getSum(tasks, executor);
        executor.shutdown();
        return sum;
    }

    public long performanceAfterVirtualThread(List<Task> tasks) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        long sum = getSum(tasks, executor);
        executor.shutdown();
        return sum;
    }

    private long getSum(List<Task> tasks, ExecutorService executor) throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = executor.invokeAll(tasks);

        long sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }
        return sum;
    }
}


 