package com.company.app.executors;

import com.company.app.constants.ConsoleConstants;
import com.company.app.controllers.ConsoleController;
import com.company.app.dao.PersonDao;
import com.company.app.entities.Person;
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
	private ConsoleController consoleController;
	@Autowired
	private PersonDao personDao;

	@PostConstruct
	public void init() {
		this.set = new HashSet<>(personDao.getAll());
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
