package com.automation.petclinic.api;

import com.automation.petclinic.model.Pet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by alpa on 1/12/20
 */
public class PetTypeTest2 {

    private Pet pet;

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://139.59.149.247";
        RestAssured.port = 9966;
        RestAssured.basePath = "/petclinic/api";
    }

    @BeforeMethod
    public void createPet() {
        pet = postPetTypeTestWithObject();
    }

    @AfterMethod
    public void deletePet() {
        deletePetTypeByIdTest(pet.getId());
    }

    @Test
    public void getPetTypeByIdTest() {
        RestAssured.given()
                .get("/pettypes/{id}", pet.getId())
                .then()
                .statusCode(200)
                .body("id", equalTo(pet.getId()))
                .body("name", equalTo(pet.getName()))
                .log().all();
    }


    private Pet postPetTypeTestWithObject() {
        Pet squirrelPet = new Pet();
        squirrelPet.setName("squirrel");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(squirrelPet)
                .post("/pettypes")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Pet.class);
    }

    public void deletePetTypeByIdTest(int petId) {
        RestAssured.given()
                .log().all()
                .delete("/pettypes/{id}", petId)
                .then()
                .statusCode(204);
    }
}
