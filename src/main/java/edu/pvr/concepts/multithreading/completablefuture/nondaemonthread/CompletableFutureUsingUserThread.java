package edu.pvr.concepts.multithreading.completablefuture.nondaemonthread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureUsingUserThread {

    public void completableFutureUseCase() {
        // 1. Create an ExecutorService (uses non-daemon user threads by default)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 2. Pass the executor as the second argument to supplyAsync
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> executeTask("Task 1", "Result 1"), executor);
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> executeTask("Task 2", "Result 2"), executor);
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> executeTask("Task 3", "Result 3"), executor);

        // 3. Chain thenRunAsync with the executor so the callback also uses a user thread
        CompletableFuture.allOf(task1, task2, task3).thenRunAsync(() -> {
            System.out.println(task1.join());
            System.out.println(task2.join());
            System.out.println(task3.join());

            // 4. Shutdown the executor when finished so the JVM can eventually exit
            executor.shutdown();
        }, executor);
    }

    private String executeTask(String taskName, String result) {
        System.out.println("Executing " + taskName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed " + taskName);
        return result;
    }

    public static void main(String[] args) {
        CompletableFutureUsingUserThread useOfCompletableFuture = new CompletableFutureUsingUserThread();
        useOfCompletableFuture.completableFutureUseCase();

        System.out.println("Main thread completed! Now main thread will complete but jvm waits for non-daemon threads to complete");
    }
}
