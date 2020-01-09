package com.automation.petclinic.page.object;

import com.automation.petclinic.model.Pet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alpa on 1/9/20
 */
public class PetsAndVisitPageComponent extends BasePage {

    private WebElement petParentElement;

    public PetsAndVisitPageComponent(WebDriver driver, WebElement petParentElement) {
        super(driver);
        this.petParentElement = petParentElement;
    }

    public Pet getPet() {
        String name = getInfo("Name").getText();
        String birthDate = getInfo("Birth Date").getText();
        String type = getInfo("Type").getText();
        return new Pet(name, birthDate, type);
    }


    private WebElement getInfo(String name) {
        return petParentElement.findElement(By.xpath(".//dt[text()='"+name+"']/following-sibling::dd[1]"));
    }
}
