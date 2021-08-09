package com.hz.test.persistence;

import com.hz.test.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
}
