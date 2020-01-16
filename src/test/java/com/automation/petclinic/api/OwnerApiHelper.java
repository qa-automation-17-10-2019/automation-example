package com.automation.petclinic.api;

import com.automation.petclinic.model.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Created by alpa on 1/16/20
 */
public class OwnerApiHelper {

    public Response createOwner(Owner owner) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners");
    }

    public Owner createDefaultOwner() {
        Owner owner = new Owner();
        owner.setFirstName("Pablo");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");
        return createOwner(owner).then().statusCode(201)
                .extract().body().as(Owner.class);
    }

    public void deleteOwner(Owner owner) {
        if (owner != null) {
            deleteOwner(owner.getId());
        }
    }

    public void deleteOwner(int id) {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .delete("/owners" + id)
                .then().statusCode(200);

    }
}
