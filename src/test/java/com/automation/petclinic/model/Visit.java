package com.automation.petclinic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alpa on 1/16/20
 */
public class Visit {

    @JsonProperty("date")
    private String date;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("pet")
    private Pet pet;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
