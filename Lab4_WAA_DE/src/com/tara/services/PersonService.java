package com.tara.services;

import com.tara.model.Person;

import java.util.List;

/**
 * Created by tara on 11/27/16.
 */
public interface PersonService {
    public void save(Person person);
    public void delete(int id);
    public List<Person> showAll();
    public boolean checkUserExists(int id);
}
