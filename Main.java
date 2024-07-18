package com.taskexecutor;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
	

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TaskExecutor taskExecutor = new TaskExecutorImpl(3);

        TaskGroup group1 = new TaskGroup(UUID.randomUUID());
        TaskGroup group2 = new TaskGroup(UUID.randomUUID());

        Task<String> task1 = new Task<>(UUID.randomUUID(), group1, TaskType.READ, () -> {
            Thread.sleep(1000);
            return "Task 1 completed";
        });

        Task<String> task2 = new Task<>(UUID.randomUUID(), group2, TaskType.WRITE, () -> {
            Thread.sleep(2000);
            return "Task 2 completed";
        });

        Future<String> future1 = taskExecutor.submitTask(task1);
        Future<String> future2 = taskExecutor.submitTask(task2);

        System.out.println(future1.get());
        System.out.println(future2.get());
       

       

        

        

       
    }
}