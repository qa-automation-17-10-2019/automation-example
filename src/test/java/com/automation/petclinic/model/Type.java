package com.automation.petclinic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alpa on 1/16/20
 */
public class Type {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;

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
}
