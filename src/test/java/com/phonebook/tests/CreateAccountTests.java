package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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

}
