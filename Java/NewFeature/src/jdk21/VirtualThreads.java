package jdk21;

import java.util.concurrent.Executors;

public class VirtualThreads {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> System.out.println("Hello from Virtual Thread!"));
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    // we have 3 ways
    // extend Thread override run() method
    // implements Runnable interface implement run() method
    // Using Executor Framework
    // ExecutorService, executor.submit
}