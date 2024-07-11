package Model;

import dao.Sequencers.PersonSequencer;
import dao.*;
import dao.impl.AppUserDAOImpl;
import dao.impl.PersonDAOImpl;
import dao.impl.TodoItemDAOImpl;
import dao.impl.TodoItemTaskDAOImpl;

import java.util.Date;

import static Model.AppRole.ROLE_APP_ADMIN;

public class App {
    public static void main(String[] args) {
        // Initialize DAOs
        AppUserDAO appUserDAO = new AppUserDAOImpl();
        PersonDAO personDAO = new PersonDAOImpl();
        TodoItemDAO todoItemDAO = new TodoItemDAOImpl();
        TodoItemTaskDAO todoItemTaskDAO = new TodoItemTaskDAOImpl();

        // Create and persist AppUser
        AppUser appUser1 = new AppUser("mohamed_ali", "password123", AppRole.ROLE_APP_USER);
        appUserDAO.persist(appUser1);
        AppUser appUser2 = new AppUser("admin", "admin pass", ROLE_APP_ADMIN);
        appUserDAO.persist(appUser2);

        // Fetch and display all AppUsers
        System.out.println("All AppUsers:");
        appUserDAO.findAll().forEach(user -> System.out.println(user.getUsername()));

        // Create and persist Person
        Person person1 = new Person(PersonSequencer.nextId(), "Mohamed Ali", "mohamed.ali@example.com");
        personDAO.persist(person1);
        Person person2 = new Person(PersonSequencer.nextId(), "Will Smith", "Will.smith@example.com");
        personDAO.persist(person2);

        // Fetch and display all Persons
        System.out.println("\nAll Persons:");
        personDAO.findAll().forEach(person -> System.out.println(person.getId()));

        // Create and persist TodoItem
        TodoItem todoItem1 = new TodoItem(1, "Finish report", false, new Date(), person1);
        todoItemDAO.persist(todoItem1);
        TodoItem todoItem2 = new TodoItem(2, "Plan vacation", false, new Date(), person2);
        todoItemDAO.persist(todoItem2);

        // Fetch and display all TodoItems
        System.out.println("\nAll TodoItems:");
        todoItemDAO.findAll().forEach(item -> System.out.println(item.getTitle()));

        // Create and persist TodoItemTask
        TodoItemTask task1 = new TodoItemTask(1, todoItem1, true, person1);
        todoItemTaskDAO.persist(task1);
        TodoItemTask task2 = new TodoItemTask(2, todoItem2, false, person2);
        todoItemTaskDAO.persist(task2);

        // Fetch and display all TodoItemTasks
        System.out.println("\nAll TodoItemTasks:");
        todoItemTaskDAO.findAll().forEach(task -> System.out.println(task.getId()));
    }
}
