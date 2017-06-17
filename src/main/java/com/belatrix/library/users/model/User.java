package com.belatrix.library.users.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Kei Takayama
 * Created on 6/13/17.
 */
public class User {

    private Integer id;

    @NotNull
    @Size(max = 50, message = "The max length of name should be 50")
    private String name;

    @NotNull
    @Size(max = 50, message = "The max length of name should be 50")
    private String surname;

    @NotNull
    @Pattern(regexp = "([0-9]{8})")
    private String documentNumber;

    @NotNull
    private Integer age;

    @NotNull
    @Pattern(regexp = "M|F")
    private String gender;

    private Integer status;

    public User() {
    }

    public User(Integer id, String name, String surname, String documentNumber, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.documentNumber = documentNumber;
        this.age = age;
        this.gender = gender;
        this.status = 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
