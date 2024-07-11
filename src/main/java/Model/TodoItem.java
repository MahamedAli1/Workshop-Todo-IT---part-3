package Model;

import java.util.Date;

public class TodoItem {
    private final int id;
    private String title;
    private boolean done;
    private Date deadline;
    private Person creator;

    public TodoItem(int id, String title, boolean done, Date deadline, Person creator) {
        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null");
        }
        this.id = id;
        this.title = title;
        this.done = done;
        this.deadline = deadline;
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        if (creator == null) {
            throw new IllegalArgumentException("Creator cannot be null");
        }
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", done=" + done +
                ", deadline=" + deadline +
                ", creator=" + creator +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + (done ? 1 : 0);
        result = 31 * result + deadline.hashCode();
        result = 31 * result + creator.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (id != todoItem.id) return false;
        if (done != todoItem.done) return false;
        if (!title.equals(todoItem.title)) return false;
        if (!deadline.equals(todoItem.deadline)) return false;
        return creator.equals(todoItem.creator);
    }
}
