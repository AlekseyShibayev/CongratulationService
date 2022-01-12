package com.company.app.controllers;

import com.company.app.dao.PersonDao;
import com.company.app.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ConsoleController {

    @Autowired
    PersonDao personDao;

    public void process(String inputString, Set<Person> set) {
        if (inputString.startsWith("create")) {
            personDao.create(inputString, set);
        } else if (inputString.startsWith("read")) {
            personDao.read(set);
        } else if (inputString.startsWith("update") && inputString.contains("to")) {
            personDao.update(inputString, set);
        } else if (inputString.startsWith("delete")) {
            personDao.delete(inputString, set);
        }
    }
}
