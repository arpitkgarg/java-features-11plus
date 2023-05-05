package feature.projectloom.virtualthreads;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualThreadDemoTest {

    private final VirtualThreadDemo virtualThreadDemo = new VirtualThreadDemo();

    @Test
    public void test_noOfVirtualThreadsDemo_preVirtualThread(){

        assertThrows( OutOfMemoryError.class, virtualThreadDemo::noOfThreadsBeforeVirtualThread);

    }

    @Test
    public void test_noOfVirtualThreadsDemo_postVirtualThread(){

        assertTrue(virtualThreadDemo.noOfVirtualThreadsDemo() > 150000);
    }

    @Test
    public void testPerformanceBeforeVirtualThread() throws ExecutionException, InterruptedException {

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            tasks.add(new Task(i));
        }

        long time = System.currentTimeMillis();

        long sum =  virtualThreadDemo.performanceBeforeVirtualThread(tasks);

        time = System.currentTimeMillis() - time;
        System.out.println("sum = " + sum + "; time = " + time + " ms");
    }

    @Test
    public void testPerformanceAfterVirtualThread() throws ExecutionException, InterruptedException {

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            tasks.add(new Task(i));
        }

        long time = System.currentTimeMillis();

        long sum =  virtualThreadDemo.performanceAfterVirtualThread(tasks);

        time = System.currentTimeMillis() - time;
        System.out.println("sum = " + sum + "; time = " + time + " ms");
    }
    @Test
    public void test_CreationOfThread_preVirtualThread() throws InterruptedException {
        Runnable runnable = () -> System.out.println(Thread.currentThread());
        virtualThreadDemo.preVirtualThread(runnable);
    }

    @Test
    public void test_CreationOfThread_postVirtualThread() throws InterruptedException {
        Runnable runnable = () -> System.out.println(Thread.currentThread());
        virtualThreadDemo.postVirtualThread(runnable);
    }

    @Test
    public void test_CreationOfThreadPostVirtualThread() throws InterruptedException {
        Runnable printThread = () -> System.out.println(Thread.currentThread());
        virtualThreadDemo.virtualThreadDemo2(printThread);
    }
}
