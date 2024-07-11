package dao.impl;

import Model.Person;
import dao.PersonDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PersonDAOImpl implements PersonDAO {
    private final Map<Integer, Person> personMap = new HashMap<>();

    @Override
    public void persist(Person person) {
        personMap.put(person.getId(), person);
    }

    @Override
    public Person findById(int id) {
        return personMap.get(id);
    }

    @Override
    public Person findByEmail(String email) {
        return personMap.values().stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Person> findAll() {
        return personMap.values();
    }

    @Override
    public void remove(Person person) {
        personMap.remove(person.getId());
    }
}
