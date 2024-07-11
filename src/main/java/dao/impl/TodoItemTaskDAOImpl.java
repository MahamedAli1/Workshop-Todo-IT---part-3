package dao.impl;

import Model.TodoItemTask;
import dao.TodoItemTaskDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TodoItemTaskDAOImpl implements TodoItemTaskDAO {
    private final Map<Integer, TodoItemTask> todoItemTaskMap = new HashMap<>();

    @Override
    public void persist(TodoItemTask task) {
        todoItemTaskMap.put(task.getId(), task);
    }

    @Override
    public TodoItemTask findById(int id) {
        return todoItemTaskMap.get(id);
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return todoItemTaskMap.values();
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        return todoItemTaskMap.values().stream()
                .filter(task -> task.isAssigned() == status)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return todoItemTaskMap.values().stream()
                .filter(task -> task.getAssignee().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(TodoItemTask task) {
        todoItemTaskMap.remove(task.getId());
    }
}
