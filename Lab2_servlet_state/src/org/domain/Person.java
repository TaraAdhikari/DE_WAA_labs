package org.domain;

/**
 * Created by tara on 11/12/16.
 */
public class Person {
    private int key;
    private String firstName;
    private String lastName;

    public Person() {}

    public Person(int key, String firstName, String lastName) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public int getKey(int key) {
//        return this.key;
//    }


    public void setKey(int key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "key = " + key +
                ", firstName = " + firstName +
                ", lastName = " + lastName ;
    }

    public int getKey() {
        return this.key;
    }
}
