package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        //click on Login link
        click(By.cssSelector("[href='/login']"));

        //enter email
        type(By.name("email"), "jenny.klein001@mail.de");

        //enter password
        type(By.name("password"), "Aa12345!");

        //click on Login button
        click(By.name("login"));

        //assert alert appears
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }
}
