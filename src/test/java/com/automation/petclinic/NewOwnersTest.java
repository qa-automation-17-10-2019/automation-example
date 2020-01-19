package com.automation.petclinic;

import com.automation.petclinic.model.Owner;
import com.automation.petclinic.page.object.NewOwnerPage;
import com.automation.petclinic.page.object.OwnersPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;


/**
 * Created by alpa on 12/29/19
 */
@Epic("Petclinic")
@Feature("Owner")
public class NewOwnersTest extends TestBase {

    @Story("Create Owner")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("1111")
    @Test(description = "Add new valid Owner test")
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

        ownersPage.ownerShouldExistInOwnerTable(owner);
    }

    @Story("Create Owner 2")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("2222")
    @Test(description = "Add new valid Owner test 2")
    public void addNewOwnerTest2() {
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.openPage();

        Owner owner = new Owner();
        owner.setFirstName("");
        owner.setLastName("");
        owner.setAddress("");
        owner.setCity("");
        owner.setTelephone("");

        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
        newOwnerPage.fillOwner(owner);
        ownersPage = newOwnerPage.clickAddOwnerButton();

        ownersPage.ownerShouldExistInOwnerTable(owner);
    }

    @Story("Create Owner 3")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("3333")
    @Issue("BUG-123")
    @Test(description = "Add new valid Owner test 3")
    public void addNewOwnerTest3() {
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

        ownersPage.ownerShouldExistInOwnerTable(new Owner());
    }

}
