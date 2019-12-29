package com.automation.petclinic.page.object;

import com.automation.petclinic.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alpa on 12/29/19
 */
public class NewOwnerPage {

    private WebDriver driver;

    public NewOwnerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOwner(Owner owner) {
        setFirstName(owner.getFirstName());
        setLastName(owner.getLastName());
        setAddress(owner.getAddress());
        setCity(owner.getCity());
        setTelephone(owner.getTelephone());
    }

    public void setFirstName(String firstName) {
        WebElement name = driver.findElement(By.id("firstName"));
        name.clear();
        name.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setAddress(String address) {
        WebElement addressField = driver.findElement(By.id("address"));
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void setCity(String city) {
        WebElement cityField = driver.findElement(By.id("city"));
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void setTelephone(String telephone) {
        WebElement telephoneField = driver.findElement(By.id("telephone"));
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }

    public OwnersPage clickAddOwnerButton() {
        WebElement addOwnerBtn = driver.findElement(By.xpath("//*[text()='Add Owner']"));
        addOwnerBtn.click();
        return new OwnersPage(driver);
    }

}
