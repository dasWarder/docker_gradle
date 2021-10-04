package com.example.docker_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "Person")
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "surname")
    private String surname;

    @Indexed(unique = true)
    @Field(value = "email")
    private String email;

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
