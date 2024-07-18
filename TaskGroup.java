package com.taskexecutor;

import java.util.UUID;

public class TaskGroup {
    private UUID id;

    public TaskGroup(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}