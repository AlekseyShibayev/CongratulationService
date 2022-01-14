package com.company.app.dao;

import com.company.app.entities.Birthday;
import com.company.app.entities.Person;
import com.company.app.services.api.SerializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class PersonDao {

	private static final String FILE_NAME = "src/test/resources/person.json";

	@Autowired
	private SerializationService<Person> serializationService;

	public void create(String inputString, Set<Person> set) {
		String[] s = inputString.split(" ");
		set.add(new Person(s[1], Birthday.of(s[2])));
		serializationService.save(new ArrayList<>(set), FILE_NAME);
	}

	public void read(Set<Person> set) {
		if (CollectionUtils.isEmpty(set)) {
			System.out.println("Список пуст.");
		} else {
			set.forEach(System.out::println);
		}
	}

	public void update(String inputString, Set<Person> set) {
		String[] s = inputString.split(" ");
		Person person = new Person(s[1], Birthday.of(s[2]));
		if (set.contains(person)) {
			set.remove(person);
			set.add(new Person(s[4], Birthday.of(s[5])));
		}
		serializationService.save(new ArrayList<>(set), FILE_NAME);
	}

	public void delete(String inputString, Set<Person> set) {
		String[] s = inputString.split(" ");
		Person person = new Person(s[1], Birthday.of(s[2]));
		set.remove(person);
		serializationService.save(new ArrayList<>(set), FILE_NAME);
	}

	public List<Person> getAll() {
		return serializationService.load(FILE_NAME, Person[].class);
	}
}
