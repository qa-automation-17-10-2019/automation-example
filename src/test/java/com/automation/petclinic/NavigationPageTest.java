package com.automation.petclinic;

import org.testng.annotations.Test;

/**
 * Created by alpa on 12/26/19
 */
public class NavigationPageTest extends TestBase {

    @Test
    public void navigationTest() {
        goToOwnersPage();
        goToPetTypesPage();
        goToVetsPage();
        goToSpecialtiesPage();
    }
}
