package com.tara.services;

import com.tara.dao.PersonDAO;
import com.tara.dao.PersonDAOImpl;
import com.tara.model.Person;

import java.util.List;

/**
 * Created by tara on 11/27/16.
 */
public class PersonServiceImpl implements PersonService {

    private PersonDAO dao = new PersonDAOImpl();

    @Override
    public void save(Person person) {
        dao.save(person);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<Person> showAll() {
        return dao.showAll();
    }

    @Override
    public boolean checkUserExists(int id) {
        return dao.checkUserExists(id);
    }
}
