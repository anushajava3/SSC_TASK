package com.taskexecutor;

import java.util.concurrent.Future;

public interface TaskExecutor {
    <T> Future<T> submitTask(Task<T> task);
}