package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase{
    @Test (enabled = false)
    public void newUserRegisterPositiveTest(){
       // int i = (int) ((System.currentTimeMillis()/1000)%3600); for HW

        //click on Login link
        click(By.cssSelector("[href='/login']"));


        //enter email
        type(By.name("email"), "jenny.klein001@mail.de");
        // driver.findElement(By.name("email")).sendKeys("jenny.klein001" + i + "@mail.de"); HW

        //enter password
        type(By.name("password"), "Aa12345!");

        //click on Register button
        click(By.name("registration"));
        //assert SigOut button is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    @Test
    public void existedUserRegisterNegativeTest(){
        //click on Login link
        click(By.cssSelector("[href='/login']"));


        //enter email
        type(By.name("email"), "jenny.klein001@mail.de");

        //enter password
        type(By.name("password"), "Aa12345!");

        //click on Register button
        click(By.name("registration"));

        //assert alert appears
        Assert.assertTrue(isAlertPresent());

    }

        public boolean isAlertPresent(){
            Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.alertIsPresent());
            if (alert == null){
                return false;
            }else {
                return true;
            }

        }
}
