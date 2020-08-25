package com.exercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsPage extends GenericPage {

    @FindBy(linkText = "Dell i7 8gb")
    private WebElement dellSearchLink;

    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    public void initializeComponents() {
        PageFactory.initElements(driver, this);
    }

    public void waitUntilDellLinkIsPresent(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(dellSearchLink));
    }

    public void clickLaptopsSearchLink() {
        dellSearchLink.click();
    }
}