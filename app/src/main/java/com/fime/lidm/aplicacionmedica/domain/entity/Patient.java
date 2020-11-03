package com.fime.lidm.aplicacionmedica.domain.entity;

import java.io.Serializable;

/**
 * Clase para pacientes.
 *
 * @author Julian Tovar
 * @since 2020-11-02
 */
public class Patient implements Serializable {

    private String name;
    private String lastname;
    private String height;
    private String weight;
    private Integer age;
    private String genre;

    public Patient() {

    }

    public Patient(String name, String lastname, String height, String weight, Integer age,
                   String genre) {
        this.name = name;
        this.lastname = lastname;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.genre = genre;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAllName() {
        return this.name + " " + this.lastname;
    }
}
