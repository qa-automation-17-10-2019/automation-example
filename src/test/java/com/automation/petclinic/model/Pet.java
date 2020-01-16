package com.automation.petclinic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by alpa on 1/9/20
 */
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Pet {

    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("visits")
    private List<Visit> visits = null;

    public Pet() {
    }

    public Pet(String name, String birthDate, String type) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Pet(int id, String name, String birthDate, String type) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
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
