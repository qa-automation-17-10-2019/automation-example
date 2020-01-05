package com.automation.petclinic;

import com.automation.petclinic.page.object.NewOwnerPage;
import com.automation.petclinic.page.object.OwnersPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by alpa on 12/26/19
 */
public class NavigationPageTest extends TestBase {

    private PetClinicNavigation navigation;

    @BeforeMethod
    public void setUpBeforeClass() {
        navigation = new PetClinicNavigation(driver);
    }

    @Test
    public void navigationTest() {
        goToOwnersPage();
        goToPetTypesPage();
        goToVetsPage();
        goToSpecialtiesPage();
    }

    @Test
    public void navigationNewOwnersPageTest() {
        NewOwnerPage newOwnerPage = navigation.openNewOwnerPage();
        OwnersPage ownersPage = navigation.openOwnerPage();
    }
}
