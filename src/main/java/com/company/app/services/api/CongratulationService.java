package com.company.app.services.api;

import com.company.app.entities.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CongratulationService {

    void congratulate(List<Person> list);
}
