package Model;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(int id, TodoItem todoItem, boolean b, Person assignee) {
        if (todoItem == null) {
            throw new IllegalArgumentException("Model.TodoItem cannot be null");
        }
        this.id = id;
        this.todoItem = todoItem;
        this.assignee = assignee;
        this.assigned = (assignee != null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    private void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("Model.TodoItem cannot be null");
        }
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = (assignee != null);
    }

    @Override
    public String toString() {
        return "Model.TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (assigned ? 1 : 0);
        result = 31 * result + todoItem.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItemTask that = (TodoItemTask) o;

        if (id != that.id) return false;
        if (assigned != that.assigned) return false;
        return todoItem.equals(that.todoItem);
    }
}
