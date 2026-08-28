package edu.pvr.concepts.multithreading.completablefuture.daemonthread;

import java.util.concurrent.CompletableFuture;

public class UseOfCompletableFutureWithJoin {

    public CompletableFuture<Void> completableFutureUseCase() {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing Task 1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Completed Task 1");
            return "Result 1";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing Task 2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Completed Task 2");
            return "Result 2";
        });

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing Task 3");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Completed Task 3");
            return "Result 3";
        });

// Combine all futures and process results when all complete
        return CompletableFuture.allOf(task1, task2, task3).thenRun(() -> {
            try {
                System.out.println(task1.get());
                System.out.println(task2.get());
                System.out.println(task3.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {

        UseOfCompletableFutureWithJoin useOfCompletableFuture = new UseOfCompletableFutureWithJoin();
        useOfCompletableFuture.completableFutureUseCase().join();

        System.out.println("Main thread completed!");
    }
}
