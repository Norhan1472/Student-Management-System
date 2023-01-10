package com.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "first Name cannot be null")
    @NotBlank(message= "first name cannot be empty")
    private String firstName;

    @NotNull(message = "first Name cannot be null")
    @NotBlank(message= "first name cannot be empty")
    private String lastName;

    @NotNull(message = "first Name cannot be null")
    @NotBlank(message= "first name cannot be empty")
    @Email(message = "email have to be in specific pattern")
    private String email;
}
