package com.automation.petclinic.page.object;

import com.automation.petclinic.model.Owner;
import com.automation.petclinic.model.Pet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpa on 1/9/20
 */
public class OwnerInformationPage extends BasePage {

    private By ownerInformationTable = By.xpath("//h2[text()='Owner Information']/following-sibling::table[1]");
    private By petInformationTable = By.xpath("//h2[text()='Pets and Visits']/following-sibling::table[1]");

    public OwnerInformationPage(WebDriver driver) {
        super(driver);
    }

    public Owner getOwnerInfo() {
        WebElement ownerInfo = driver.findElement(ownerInformationTable);
        Owner owner = new Owner();

        String[] fullNameArray = getInfoByName(ownerInfo, "Name").getText().split(" ");
        if (fullNameArray.length > 1) {
            owner.setFirstName(fullNameArray[0]);
            owner.setLastName(fullNameArray[1]);
        } else {
            owner.setFirstName(fullNameArray[0]);
        }

        owner.setAddress(getInfoByName(ownerInfo, "Address").getText());
        owner.setCity(getInfoByName(ownerInfo, "City").getText());
        owner.setTelephone(getInfoByName(ownerInfo, "Telephone").getText());
        return owner;

    }

    public List<Pet> getPets() {
        List<WebElement> pets = driver.findElements(By.xpath("//app-pet-list"));
        List<Pet> petList = new ArrayList<>();

        for (WebElement pet : pets) {
            PetsAndVisitPageComponent petsAndVisitPageComponent = new PetsAndVisitPageComponent(driver, pet);
            petList.add(petsAndVisitPageComponent.getPet());
        }

        return petList;
    }

    public Pet getPetByName(String name) {
        WebElement pet = driver.findElement(petInformationTable)
                .findElement(By.xpath(".//dd[text()='"+name+"']/../../../../.."));
        PetsAndVisitPageComponent petsAndVisitPageComponent = new PetsAndVisitPageComponent(driver, pet);
        return petsAndVisitPageComponent.getPet();
    }

    private WebElement getInfoByName(WebElement ownerInfo, String name) {
        return ownerInfo.findElement(By.xpath(".//th[text()='"+name+"']/following-sibling::td"));
    }

    private WebElement getPetInfoByName(WebElement ownerInfo, String name) {
        return ownerInfo.findElement(By.xpath(".//th[text()='"+name+"']/following-sibling::td"));
    }
}
