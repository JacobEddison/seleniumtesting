package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
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
        Thread.sleep(1000);
        WebElement selectFirstPicture = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[3]/div[2]/div/div[2]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/a[1]/img"));
        selectFirstPicture.click();
        Thread.sleep(1000);
    }

    @Test
    public void seleniumStuff() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        WebElement textBox = driver.findElementById("user-message");
        textBox.sendKeys("nuyce box");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElementById("get-input").findElement(By.className("btn"));
        submitButton.click();
        Thread.sleep(2000);
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scroll(0,200)");

        WebElement int1 = driver.findElementById("sum1");
        int1.sendKeys("5");
        Thread.sleep(500);
        WebElement int2 = driver.findElementById("sum2");
        int2.sendKeys("6");
        Thread.sleep(500);
        WebElement addButton = driver.findElementById("gettotal").findElement(By.className("btn"));
        addButton.click();
        Thread.sleep(2000);
    }

    @Test
    public void checkboxTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkbox = driver.findElementById("isAgeSelected");
        checkbox.click();
        Thread.sleep(2000);
        WebElement select = driver.findElementById("check1");
        select.click();
        Thread.sleep(1000);
        assertEquals(select.getAttribute("value"), "Uncheck All");
        WebElement unselect = driver.findElementById("check1");
        unselect.click();
        Thread.sleep(1000);
        assertEquals(unselect.getAttribute("value"), "Check All");

    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        List<WebElement> genders = driver.findElementsByName("optradio");
        for (WebElement i:genders){
           i.click();
           Thread.sleep(200);
           WebElement select = driver.findElementById("buttoncheck");
           select.click();
           Thread.sleep(200);
           WebElement message = driver.findElement(By.className("radiobutton"));
           assertEquals(message.getText(), "Radio button '"+i.getAttribute("value")+"' is checked");
           Thread.sleep(500);
        }
        Thread.sleep(100);
        List<WebElement> genders2 = driver.findElementsByName("gender");
        List<WebElement> ageGroup = driver.findElementsByName("ageGroup");
        for (WebElement i:genders2){
            for (WebElement j:ageGroup){
                i.click();
                j.click();

            }
        }
    }
}