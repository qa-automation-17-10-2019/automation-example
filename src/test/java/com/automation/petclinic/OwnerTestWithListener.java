package com.automation.petclinic;

import com.automation.petclinic.listener.MyCustomTestListener;
import com.automation.petclinic.model.Owner;
import com.automation.petclinic.page.object.NewOwnerPage;
import com.automation.petclinic.page.object.OwnersPage;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by alpa on 1/23/20
 */
@Listeners({MyCustomTestListener.class})
public class OwnerTestWithListener extends TestBase {

    @Story("Create Owner")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("3333")
    @Issue("BUG-123")
    @Test(description = "Add new not valid Owner test")
    public void addNewNotValidOwnerTestPassed() {
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.openPage();

        Owner owner = new Owner();
        owner.setFirstName("Geralt");
        owner.setLastName("Witcher");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("1284927482");

        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        newOwnerPage.clickAddOwnerButton();
        newOwnerPage.addOwnerButtonShouldBe(false);
    }

    @Story("Create Owner")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("3333")
    @Issue("BUG-123")
    @Test(description = "Add new not valid Owner test")
    public void addNewNotValidOwnerTestFailed() {
        OwnersPage ownersPage = new OwnersPage(driver);
        ownersPage.openPage();

        Owner owner = new Owner();
        owner.setFirstName("Geralt");
        owner.setLastName("Witcher");
        owner.setAddress("street");
        owner.setCity("Rivia");
        owner.setTelephone("1284927482");

        NewOwnerPage newOwnerPage = ownersPage.clickAddOwnerBtn();
//        newOwnerPage.fillOwner(owner);
//        newOwnerPage.clickAddOwnerButton();
        newOwnerPage.addOwnerButtonShouldBe(true);
    }
}
