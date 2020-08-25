package com.exercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSelectionPage extends GenericPage {

    @FindBy(linkText = "Add to cart")
    private WebElement addToCartButton;

    public ProductSelectionPage(WebDriver driver) {
        super(driver);
    }

    public void initializeComponents() {
        PageFactory.initElements(driver, this);
    }

    public void waitUntilAddButtonIsPresent(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
    }

    public void waitUntilAlertIsPresent(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void clickOnAddToCart() {
        addToCartButton.click();
    }

    public void confirmProductAdded() {
        driver.switchTo().alert().accept();
    }
}
