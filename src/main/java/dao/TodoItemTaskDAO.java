package dao;

import Model.TodoItemTask;

import java.util.Collection;
public interface TodoItemTaskDAO {
    void persist(TodoItemTask task);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonId(int personId);
    void remove(TodoItemTask task);
}
