package com.company.app.services.impl;

import com.company.app.entities.Birthday;
import com.company.app.entities.Person;
import com.company.app.services.api.CongratulationService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CongratulationServiceImpl implements CongratulationService {

    private static final Integer DAYS_BEFORE = 6;

    @Override
    public void congratulate(List<Person> list) {
        List<Person> listForCongratulate = getListForCongratulate(list, LocalDate.now());

        System.out.println("ДР в ближайшие [" + DAYS_BEFORE + "] дней:");
        listForCongratulate.forEach(System.out::println);
    }

    public List<Person> getListForCongratulate(List<Person> list, LocalDate start) {
        return list.stream()
                .filter(person -> isBirthdayBetween(person, start, start.plusDays(DAYS_BEFORE)))
                .collect(Collectors.toList());
    }

    private boolean isBirthdayBetween(Person person, LocalDate start, LocalDate end) {
        boolean result;
        Birthday birthday = person.getBirthday();
        int year = start.getYear();
        LocalDate personDate = LocalDate.of(year, Integer.parseInt(birthday.getMonth()), Integer.parseInt(birthday.getDay()));
        result = personDate.isEqual(start) || personDate.isEqual(end) || (personDate.isAfter(start) && personDate.isBefore(end));
        return result;
    }
}
