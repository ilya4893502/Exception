package com.example.springapp81.services;

import com.example.springapp81.models.Person;
import com.example.springapp81.repositories.PeopleRepository;
import com.example.springapp81.util.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> allPeople() {
        return peopleRepository.findAll();
    }

    public Person person(int id) {

        // Вместо null выбрасываем собственное исключение.
        return peopleRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }
}
