package com.exercise.tests;

import com.exercise.pages.HomePage;
import com.exercise.pages.LaptopsPage;
import com.exercise.pages.ProductSelectionPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestProductBuy {

    private WebDriver driver;
    private HomePage homePage;
    private LaptopsPage laptopsPage;
    private ProductSelectionPage productSelectionPage;

    @BeforeClass
    public void setup() {
        String driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chrome/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

        // Open app by default
        driver.get("https://www.demoblaze.com/");

        // Maximize window
        driver.manage().window().maximize();

        // Initialize pages and components
        homePage = new HomePage(driver);
        homePage.initializeComponents();

        laptopsPage = new LaptopsPage(driver);
        laptopsPage.initializeComponents();

        productSelectionPage = new ProductSelectionPage(driver);
        productSelectionPage.initializeComponents();
    }

    @AfterClass
    public void dispose() {
        if (driver != null) {
            driver.close();
        }
    }

    @Test
    public void testProductBuy() {

        homePage.waitUntilLaptopsLinkIsPresent(3);
        homePage.clickLaptopsLink();
        laptopsPage.waitUntilDellLinkIsPresent(3);
        laptopsPage.clickLaptopsSearchLink();
        productSelectionPage.waitUntilAddButtonIsPresent(3);
        productSelectionPage.clickOnAddToCart();
        productSelectionPage.waitUntilAlertIsPresent(3);
        productSelectionPage.confirmProductAdded();

    }

}
