package com.company.app.services.impl;

import com.company.app.entities.Birthday;
import com.company.app.entities.Person;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class CongratulationServiceImplTest {

    private CongratulationServiceImpl congratulationService;

    @Before
    public void init() {
        congratulationService = new CongratulationServiceImpl();
    }

    @Test
    public void getListForCongratulateTest() {
        List<Person> list = ImmutableList.<Person>builder()
                .add(new Person("1", Birthday.of("01.05")))
                .add(new Person("2", Birthday.of("02.05")))
                .add(new Person("3", Birthday.of("03.05")))
                .add(new Person("4", Birthday.of("04.05")))
                .add(new Person("5", Birthday.of("05.05")))
                .add(new Person("6", Birthday.of("06.05")))
                .add(new Person("7", Birthday.of("07.05")))
                .add(new Person("8", Birthday.of("08.05")))
                .add(new Person("9", Birthday.of("09.05")))
                .build();

        LocalDate start = LocalDate.of( 2000 , 5 , 1);

        List<Person> congratulate = congratulationService.getListForCongratulate(list, start);
        Assert.assertEquals(congratulate.size(), 7);
    }

    @Test
    public void getListForCongratulateTestWhenEndOfTheYear() {
        List<Person> list = ImmutableList.<Person>builder()
                .add(new Person("1", Birthday.of("31.12")))
                .add(new Person("2", Birthday.of("01.01")))
                .add(new Person("3", Birthday.of("06.01")))
                .build();

        LocalDate start = LocalDate.of( 2000 , 12 , 30);

        List<Person> congratulate = congratulationService.getListForCongratulate(list, start);
        Assert.assertEquals(congratulate.size(), 2);
    }
}