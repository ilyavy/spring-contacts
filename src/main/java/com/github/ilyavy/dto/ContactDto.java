package com.github.ilyavy.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ContactDto {

    private Long id;

    @NotNull
    private String name;

    private String surname;

    private String phone;

    @Email
    @NotNull
    private String email;

    private LocalDate birthDate;

    public Long getId() {
        return id;
    }

    public ContactDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ContactDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public ContactDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ContactDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public ContactDto setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
