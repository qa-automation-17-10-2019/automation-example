package com.automation.petclinic.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by alpa on 1/9/20
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Pet {

    private int id;
    private String name;
    private String birthDate;
    private String type;

    public Pet() {
    }

    public Pet(String name, String birthDate, String type) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
    }

    public Pet(int id, String name, String birthDate, String type) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
