package org.domain.org.dao;

import org.domain.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tara on 11/12/16.
 */
public class PersonDao {
    private Person person;
    private List<Person> personList;

    public PersonDao() {
        personList = new ArrayList<>();
    }

    public void addPerson(Person person){
        this.personList.add(person);
        System.out.println(personList.size());
    }

    public void deletePerson(int key){
        for (Iterator<Person> it = personList.iterator();
             it.hasNext(); ) {
            Person thisPerson = it.next();
            if (thisPerson.getKey() == key) {
                it.remove();
            }
        }
    }

    public List<Person> getAllPerson(){

        return this.personList;
    }

    public void displayPerson(){
        for(Person person: personList){
            person.toString();
        }
    }
}
