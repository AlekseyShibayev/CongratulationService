package com.company.app.entity;

import java.util.Objects;

public class Person {

    String name;
    String birthday;

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + " " + birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
