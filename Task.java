package com.taskexecutor;

import java.util.UUID;
import java.util.concurrent.Callable;

public class Task<T> implements Callable<T> {
    private UUID id;
    private TaskGroup group;
    private TaskType type;
    private Callable<T> task;

    public Task(UUID id, TaskGroup group, TaskType type, Callable<T> task) {
        this.id = id;
        this.group = group;
        this.type = type;
        this.task = task;
    }

    @Override
    public T call() throws Exception {
        return task.call();
    }
}