package com.automation.petclinic;

import com.automation.petclinic.model.Owner;
import com.automation.petclinic.page.object.OwnerInformationPage;
import com.automation.petclinic.page.object.OwnersPage;
import com.automation.petclinic.model.Pet;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by alpa on 1/9/20
 */
public class OwnersInformationTest extends TestBase {

    private PetClinicNavigation navigation;

    @BeforeMethod
    public void setUpBeforeClass() {
        navigation = new PetClinicNavigation(driver);
    }


    @Test
    public void checkOwnerInfoTest() {
        OwnersPage ownersPage = navigation.openOwnerPage();
        OwnerInformationPage ownerInformationPage = ownersPage.openOwnerInfo("Eduardo Rodriquez");

        Owner ownerInfo = ownerInformationPage.getOwnerInfo();
        System.out.println(ownerInfo);

        List<Pet> pets = ownerInformationPage.getPets();
        System.out.println(pets);

        Pet jewel = ownerInformationPage.getPetByName("Jewel");
        System.out.println(jewel);
        Pet rosy = ownerInformationPage.getPetByName("Rosy");
        System.out.println(rosy);


    }


}
