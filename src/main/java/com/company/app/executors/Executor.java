package com.company.app.executors;

import com.company.app.constants.ConsoleConstants;
import com.company.app.controllers.ConsoleController;
import com.company.app.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

@Component
public class Executor implements Runnable {

    private Set<Person> set;

    @Autowired
    ConsoleController consoleController;

    @PostConstruct
    public void init() {
        this.set = new HashSet<>();
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            execute(reader);
        } catch (Exception e) {
            ConsoleConstants.MANUAL.forEach(System.out::println);
            execute(reader);
        }
    }

    void execute(BufferedReader reader) {
        String inputString = getInputString(reader);
        consoleController.process(inputString, set);
        execute(reader);
    }

    private String getInputString(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
