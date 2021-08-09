package com.hz.test.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    @Id
    private int personId;
    private String name;
    private LocalDate birthDate;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId && name.equals(person.name) && birthDate.equals(person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, birthDate);
    }
}
