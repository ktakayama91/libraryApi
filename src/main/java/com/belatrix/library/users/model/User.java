package com.belatrix.library.users.model;

/**
 * @author Kei Takayama
 * Created on 6/13/17.
 */
public class User {

    private Integer id;
    private String name;
    private String lastname;
    private String documentNumber;
    private Integer age;
    private String gender;
    private Integer status;

    public User() {
    }

    public User(Integer id, String name, String lastname, String documentNumber, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
