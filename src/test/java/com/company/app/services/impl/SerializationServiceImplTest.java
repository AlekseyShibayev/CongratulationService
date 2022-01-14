package com.company.app.services.impl;

import com.company.app.entities.Birthday;
import com.company.app.entities.Person;
import com.company.app.services.api.SerializationService;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SerializationServiceImplTest {

	private static final String FILE_NAME = "src/test/resources/person_test.json";
	private SerializationService<Person> serializationService;

	@Before
	public void init() {
		serializationService = new SerializationServiceImpl<>();
	}

	@Test
	public void saveAndLoadTest() {
		List<Person> list = ImmutableList.<Person>builder()
				.add(new Person("1", Birthday.of("02.05")))
				.add(new Person("2", Birthday.of("03.05")))
				.build();

		serializationService.save(list, FILE_NAME);

		List<Person> load = serializationService.load(FILE_NAME, Person[].class);
		Assert.assertEquals(load.size(), 2);
	}
}