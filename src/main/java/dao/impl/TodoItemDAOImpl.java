package dao.impl;

import Model.TodoItem;
import dao.TodoItemDAO;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

;

public class TodoItemDAOImpl implements TodoItemDAO {
    private final Map<Integer, TodoItem> todoItemMap = new HashMap<>();

    @Override
    public void persist(TodoItem item) {
        todoItemMap.put(item.getId(), item);
    }

    @Override
    public TodoItem findById(int id) {
        return todoItemMap.get(id);
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItemMap.values();
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean status) {
        return todoItemMap.values().stream()
                .filter(item -> item.isDone() == status)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return todoItemMap.values().stream()
                .filter(item -> item.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return todoItemMap.values().stream()
                .filter(item -> item.getCreator().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(Date date) {
        return todoItemMap.values().stream()
                .filter(item -> item.getDeadline().before(date))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(Date date) {
        return todoItemMap.values().stream()
                .filter(item -> item.getDeadline().after(date))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(TodoItem item) {
        todoItemMap.remove(item.getId());
    }
}
