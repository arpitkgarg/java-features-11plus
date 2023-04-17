package learn.features.projectloom;

import learn.features.projectloom.virtualthreads.Task;
import learn.features.projectloom.virtualthreads.VirtualThreadDemo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualThreadDemoTest {

    private VirtualThreadDemo virtualThreadDemo = new VirtualThreadDemo();


    @Test
    public void testVirtualThreadDemo1() throws InterruptedException {
        Runnable runnable = () -> {
            for(int i=0; i<1000; i++) {
                System.out.println("Index: " + i + " " + Thread.currentThread());
            }
        };

        virtualThreadDemo.virtualThreadDemo1(runnable);
    }

    @Test
    public void testVirtualThreadDemo2() throws InterruptedException {
        Runnable printThread = () -> System.out.println(Thread.currentThread());
        virtualThreadDemo.virtualThreadDemo2(printThread);
    }

    @Test
    public void testVirtualThreadDemo_preVirtualThread(){

        assertThrows( OutOfMemoryError.class, ()-> virtualThreadDemo.noOfThreadsBeforeVirtualThread());

    }

    @Test
    public void testVirtualThreadDemo_postVirtualThread(){

        assertTrue(virtualThreadDemo.noOfVirtualThreadsDemo() > 150000);
    }


    @Test
    public void testVirtualThreadDemo4() throws ExecutionException, InterruptedException {

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            tasks.add(new Task(i));
        }

        long time = System.currentTimeMillis();

        long sum =  virtualThreadDemo.performanceBeforeVirtualThread(tasks);

        time = System.currentTimeMillis() - time;
        System.out.println("sum = " + sum + "; time = " + time + " ms");
    }

    @Test
    public void testVirtualThreadDemo4_1() throws ExecutionException, InterruptedException {

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            tasks.add(new Task(i));
        }

        long time = System.currentTimeMillis();

        long sum =  virtualThreadDemo.performanceAfterVirtualThread(tasks);

        time = System.currentTimeMillis() - time;
        System.out.println("sum = " + sum + "; time = " + time + " ms");
    }
}
