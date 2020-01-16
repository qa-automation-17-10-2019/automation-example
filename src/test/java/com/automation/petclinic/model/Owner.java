package com.automation.petclinic.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

/**
 * Created by alpa on 12/22/19
 */
public class Owner {

    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("id")
    private int id;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("pets")
    private List<Pet> pets = null;
    @JsonProperty("telephone")
    private String telephone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    @Override
    public String toString() {
        return "Owner{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", pets=" + pets +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;
        Owner owner = (Owner) o;
        return  Objects.equals(getAddress(), owner.getAddress()) &&
                Objects.equals(getCity(), owner.getCity()) &&
                Objects.equals(getFirstName(), owner.getFirstName()) &&
                Objects.equals(getLastName(), owner.getLastName()) &&
                Objects.equals(getPets(), owner.getPets()) &&
                Objects.equals(getTelephone(), owner.getTelephone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAddress(), getCity(), getTelephone(), getPets());
    }
}
