package com.example.docker_test.repo;

import com.example.docker_test.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {

    Optional<Person> findByEmail(String email);

    List<Person> findAllBySurname(String surname);
}
