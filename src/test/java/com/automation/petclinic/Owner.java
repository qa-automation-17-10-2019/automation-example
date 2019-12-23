package com.automation.petclinic;

/**
 * Created by alpa on 12/22/19
 */
public class Owner {

    private String name;
    private String address;
    private String city;
    private String telephone;
    private String pets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pets='" + pets + '\'' +
                '}';
    }
}
