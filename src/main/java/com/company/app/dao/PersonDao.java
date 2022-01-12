package com.company.app.dao;

import com.company.app.entity.Person;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Component
public class PersonDao {

    public void create(String inputString, Set<Person> set){
        String[] s = inputString.split(" ");
        set.add(new Person(s[1], s[2]));
    }

    public void read(Set<Person> set){
        if (CollectionUtils.isEmpty(set)) {
            System.out.println("Список пуст.");
        } else {
            set.forEach(System.out::println);
        }
    }

    public void update(String inputString, Set<Person> set){
        String[] s = inputString.split(" ");
        Person person = new Person(s[1], s[2]);
        if (set.contains(person)) {
            set.remove(person);
            set.add(new Person(s[4], s[5]));
        }
    }

    public void delete(String inputString, Set<Person> set){
        String[] s = inputString.split(" ");
        Person person = new Person(s[1], s[2]);
        set.remove(person);
    }
}
