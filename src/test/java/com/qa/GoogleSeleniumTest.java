package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\IdeaProjects\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void searchTest() throws InterruptedException {
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement searchField = driver.findElement(By.name("q"));
        assertTrue(searchField.isDisplayed());
        searchField.sendKeys("funny cat pictures");
        WebElement submitButton = driver.findElement(By.name("btnK"));
        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(1000);
        WebElement linkToBiggerPictures = driver.findElementByLinkText("Images for funny cat");
        linkToBiggerPictures.click();
        Thread.sleep(5000);
    }
}
