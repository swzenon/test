package com.hz.test.rest;

import com.hz.test.domain.Person;
import com.hz.test.persistence.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Supplier;

@RestController
public class PersonRestController {

    private final PersonRepository personRepository;

    public PersonRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(path = "/persons")
    public List<Person> getAllPersons(@RequestParam(required = false) Integer id ) {
        var persons = new ArrayList<Person>();

        Iterable<Person> i = personRepository.findAll();

        Iterable<Person> ii = personRepository.findAllById(Collections.singletonList(id));

        /*
        Supplier<Iterable<Person>> personSupplier =
                id == null ? personRepository::findAll :
                        () -> personRepository.findAllById(Arrays.asList(id));


        for (Person person : personRepository.findAll()) {
            persons.add(person);
        }
        */

        Iterable<Person> personIterable =
                id == null ? personRepository.findAll() :
                        personRepository.findAllById(Collections.singletonList(id));


        for(Person person: personIterable) {
            persons.add(person);
        }

        return persons;
    }

    @PostMapping(path = "/persons")
    public Person postPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @DeleteMapping(path = "/persons/{personId}")
    public void deletePerson(@PathVariable Integer personId) {
        personRepository.deleteById(personId);
    }

}
