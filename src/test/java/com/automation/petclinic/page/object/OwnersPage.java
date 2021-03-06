package com.automation.petclinic.page.object;

import com.automation.petclinic.model.Owner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by alpa on 12/29/19
 */
public class OwnersPage extends BasePage {

    public OwnersPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open '/owners' url")
    public OwnersPage openPage() {
        goToUrl("/owners", "Owners");
        return this;
    }

    public List<String> getOwnersNames() {
        List<String> owners = new ArrayList<>();

        List<WebElement> elements = driver.findElements(By.cssSelector(".ownerFullName>a"));
        for (WebElement fullName : elements) {
            owners.add(fullName.getText());
        }

        return owners;
    }

    public List<Owner> getOwnersList() {
        List<Owner> owners = new ArrayList<>();
        WebElement ownersTable = driver.findElement(By.xpath("//*[@class='table-responsive']"));

        List<WebElement> ownersList = ownersTable.findElements(By.xpath(".//tbody/tr"));
        for (WebElement userRow : ownersList) {
            owners.add(createOwner(userRow));
        }

        return owners;
    }

    @Step("Open Add Owner form")
    public NewOwnerPage clickAddOwnerBtn() {
        WebElement addOwnerBtn = driver.findElement(By.xpath("//*[text()='Add Owner']"));
        addOwnerBtn.click();
        return new NewOwnerPage(driver);
    }

    private Owner createOwner(WebElement userRow) {
        Owner owner = new Owner();
        String fullName = userRow.findElement(By.xpath("./td/a")).getText();
        String[] fullNameArray = fullName.split(" ");
        if (fullNameArray.length > 1) {
            owner.setFirstName(fullNameArray[0]);
            owner.setLastName(fullNameArray[1]);
        } else {
            owner.setFirstName(fullNameArray[0]);
        }
        owner.setAddress(userRow.findElement(By.xpath("./td[2]")).getText());
        owner.setCity(userRow.findElement(By.xpath("./td[3]")).getText());
        owner.setTelephone(userRow.findElement(By.xpath("./td[4]")).getText());

        String pets = userRow.findElement(By.xpath("./td[5]")).getText();
        if(!pets.isEmpty()) {
            owner.setPets(null);
        }

        return owner;
    }

    public OwnerInformationPage openOwnerInfo(String fullName) {
        WebElement owner = driver.findElement(By.xpath("//a[text()='"+fullName+"']"));
        owner.click();
        return new OwnerInformationPage(driver);
    }

    @Step("Owner should be added to Owners table")
    public void ownerShouldExistInOwnerTable(Owner owner) {
        List<Owner> ownersNames = getOwnersList();
        assertThat(ownersNames).contains(owner);
    }


}

