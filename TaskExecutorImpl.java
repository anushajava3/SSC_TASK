package com.taskexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

public class TaskExecutorImpl implements TaskExecutor {
    private ExecutorService executor;

    public TaskExecutorImpl(int numThreads) {
        this.executor = Executors.newFixedThreadPool(numThreads);
    }

    @Override
    public <T> Future<T> submitTask(Task<T> task) {
        return executor.submit((Callable<T>) task::call);
    }
}