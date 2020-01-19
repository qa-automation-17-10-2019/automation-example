package com.automation.petclinic.page.object;

import com.automation.petclinic.model.Owner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by alpa on 12/29/19
 */
public class NewOwnerPage {

    private WebDriver driver;

    private By lastNameInputField = By.id("lastName");

    public NewOwnerPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill Owner information")
    public void fillOwner(Owner owner) {
        setFirstName(owner.getFirstName());
        setLastName(owner.getLastName());
        setAddress(owner.getAddress());
        setCity(owner.getCity());
        setTelephone(owner.getTelephone());
    }

    @Step
    public void setFirstName(String firstName) {
        WebElement name = firstNameField();
        name.clear();
        name.sendKeys(firstName);
    }

    public void clearFirstName() {
        WebElement name = firstNameField();
        name.clear();
    }

    @Step
    public void setLastName(String lastName) {
        WebElement lastNameField = driver.findElement(lastNameInputField);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void clearLastName() {
        WebElement lastNameField = driver.findElement(lastNameInputField);
        lastNameField.clear();
    }

    @Step
    public void setAddress(String address) {
        WebElement addressField = driver.findElement(By.id("address"));
        addressField.clear();
        addressField.sendKeys(address);
    }

    @Step
    public void setCity(String city) {
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.clear();
        cityField.sendKeys(city);
    }

    @Step
    public void setTelephone(String telephone) {
        WebElement telephoneField = driver.findElement(By.id("telephone"));
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }

    @Step("Add new Owner")
    public OwnersPage clickAddOwnerButton() {
        WebElement addOwnerBtn = driver.findElement(By.xpath("//*[text()='Add Owner']"));
        addOwnerBtn.click();
        return new OwnersPage(driver);
    }

    private WebElement firstNameField() {
        return driver.findElement(By.id("firstName"));
    }

}
