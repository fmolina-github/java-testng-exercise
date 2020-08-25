package com.exercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends GenericPage {

    @FindBy(linkText = "Laptops")
    private WebElement laptopsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void initializeComponents() {
        PageFactory.initElements(driver, this);
    }

    public void waitUntilLaptopsLinkIsPresent(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(laptopsLink));
    }

    public void clickLaptopsLink() {
        laptopsLink.click();
    }
}
