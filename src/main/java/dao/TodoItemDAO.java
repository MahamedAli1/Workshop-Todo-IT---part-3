package dao;

import Model.TodoItem;

import java.util.Collection;
import java.util.Date;

public interface TodoItemDAO {
    void persist(TodoItem item);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findAllByDoneStatus(boolean status);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadlineBefore(Date date);
    Collection<TodoItem> findByDeadlineAfter(Date date);
    void remove(TodoItem item);
}
