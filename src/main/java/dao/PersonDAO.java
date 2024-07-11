package dao;

import Model.Person;

import java.util.Collection;

public interface PersonDAO {
    void persist(Person person);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findAll();
    void remove(Person person);
}
