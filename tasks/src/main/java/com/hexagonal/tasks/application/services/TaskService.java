package com.hexagonal.tasks.application.services;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.CreateTaskUseCase;
import com.hexagonal.tasks.domain.ports.in.DeleteTaskUseCase;
import com.hexagonal.tasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonal.tasks.domain.ports.in.UpdateTaskUseCase;

import java.util.List;
import java.util.Optional;

public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase,
                       UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase,
                       GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }


    @Override
    public Optional<Task> getTask(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return updateTaskUseCase.updateTask(id, updatedTask);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(taskId);
    }
}