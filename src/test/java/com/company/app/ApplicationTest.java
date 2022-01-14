package com.company.app;

import com.company.app.entities.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {

	@Test
	public void run() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("Test1", "1мая"));
		System.out.println(list);
	}
}