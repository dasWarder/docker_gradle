package com.example.docker_test.controller;

import com.example.docker_test.model.Person;
import com.example.docker_test.model.PersonDto;
import com.example.docker_test.repo.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/persons")
public class PersonController {

  @Autowired private PersonRepository personRepository;

  @GetMapping("/email")
  public ResponseEntity<PersonDto> getPersonByEmail(@RequestParam("email") String email) {

    log.info("Get a person by email = {}", email);
    Person person = personRepository.findByEmail(email).orElseThrow(NullPointerException::new);

    PersonDto dto = buildPersonDto(person);

    return ResponseEntity.ok(dto);
  }

  @GetMapping
  public ResponseEntity<List<PersonDto>> getPersons() {

    log.info("Get all persons");
    List<PersonDto> responsePersons = new ArrayList<>();
    personRepository.findAll().forEach(p -> {
      responsePersons.add(buildPersonDto(p));
    });

    return ResponseEntity.ok(responsePersons);
  }

  private PersonDto buildPersonDto(Person person) {

    PersonDto dto =
            PersonDto.builder()
                    .name(person.getName())
                    .surname(person.getSurname())
                    .email(person.getEmail())
                    .build();

    return dto;
  }
}
