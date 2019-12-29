package com.automation.petclinic;

import com.automation.petclinic.page.object.NewOwnerPage;
import com.automation.petclinic.page.object.OwnersPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 12/29/19
 */
public class NewOwnersTest extends TestBase {

    @Test
    public void addNewOwnerTest() {
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.openPage();

        Owner owner = new Owner();
        owner.setFirstName("Geralt");
        owner.setLastName("Witcher");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("1284927482");

        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        ownersPage = newOwnerPage.clickAddOwnerButton();

        List<Owner> ownersNames = ownersPage.getOwnersList();
        assertThat(ownersNames).contains(owner);
    }
}
