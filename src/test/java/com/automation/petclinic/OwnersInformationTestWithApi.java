package com.automation.petclinic;

import com.automation.petclinic.model.Owner;
import com.automation.petclinic.model.Pet;
import com.automation.petclinic.page.object.OwnerInformationPage;
import com.automation.petclinic.page.object.OwnersPage;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 1/16/20
 */
public class OwnersInformationTestWithApi extends TestBase {

    private PetClinicNavigation navigation;
    private Owner owner;

    @BeforeClass
    public void setUpRestApi() {
        RestAssured.baseURI = "http://139.59.149.247";
        RestAssured.port = 9966;
        RestAssured.basePath = "/petclinic/api";
    }

    @BeforeMethod
    public void setUpBeforeMethod() {
        navigation = new PetClinicNavigation(driver);
        owner = createOwner();
    }

    @AfterMethod
    private void setUpAfterMethod() {
        deleteOwner(owner);
    }


    @Test
    public void checkOwnerInfoTest() {
        OwnersPage ownersPage = navigation.openOwnerPage();
        OwnerInformationPage ownerInformationPage = ownersPage
                .openOwnerInfo(owner.getFirstName() + " " + owner.getLastName());

        Owner ownerActual = ownerInformationPage.getOwnerInfo();
        assertThat(ownerActual).isEqualTo(owner);
    }


    private Owner createOwner() {
        Owner owner = new Owner();
        owner.setFirstName("Pablo");
        owner.setLastName("Esscobar");
        owner.setAddress("Columbia, st 45");
        owner.setCity("Medelin");
        owner.setTelephone("1234567890");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("/owners")
                .then()
                .statusCode(201)
                .extract().body()
                .as(Owner.class);

    }

    private void deleteOwner(Owner owner) {
        if (owner != null) {
            RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete("/owners/" + owner.getId())
                    .then()
                    .statusCode(204);
        }
    }
}
