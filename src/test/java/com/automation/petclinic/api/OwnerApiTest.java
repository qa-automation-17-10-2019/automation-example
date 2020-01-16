package com.automation.petclinic.api;

import com.automation.petclinic.model.Owner;
import com.automation.petclinic.model.Pet;
import com.automation.petclinic.model.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by alpa on 1/16/20
 */
public class OwnerApiTest {


    private Owner owner;
    private Type type;

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://139.59.149.247";
        RestAssured.port = 9966;
        RestAssured.basePath = "/petclinic/api";
    }



    @AfterMethod
    public void cleanData() {
        if (owner != null) {
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete("/owners/" + owner.getId())
                    .then()
                    .statusCode(204);
        }

        if (type != null) {
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete("/pettypes/" + type.getId())
                    .then()
                    .statusCode(204);
        }
    }


    @Test
    public void postPetTypeTest() throws JsonProcessingException {
        owner = new Owner();
        owner.setFirstName("Pablo");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");

        owner = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Owner.class);

        type = new Type();
        type.setName("Piton");

        type = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(type)
                .post("/pettypes")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Type.class);


        Pet pet = new Pet();
        pet.setName("Bob");
        pet.setType(type);
        pet.setBirthDate("2020/01/09");
        pet.setOwner(owner);

        pet = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/pets")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Pet.class);


        System.out.println(owner);
    }


    @Test
    public void postPetTypeTest2() {
        owner = new Owner();
        owner.setFirstName("Pablo");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");

        owner = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Owner.class);

        List<Type> type = Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .get("/pettypes")
                .then()
                .statusCode(200)
                .extract().body()
                .as(Type[].class));

        Pet pet = new Pet();
        pet.setName("Bob");
        pet.setType(type.get(0));
        pet.setBirthDate("2020/01/09");
        pet.setOwner(owner);

        pet = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("/pets")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Pet.class);


        System.out.println(owner);
    }

    @Test
    public void createOwnerTest() {
        owner = new Owner();
        owner.setFirstName("Pablo");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");

        owner = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Owner.class);

        Owner actualOwner = RestAssured.given()
                .contentType(ContentType.JSON)
                .get("/owners/" + owner.getId())
                .then()
                .statusCode(200)
                .extract().body()
                .as(Owner.class);

        assertThat(actualOwner).isEqualTo(owner);
    }


}
