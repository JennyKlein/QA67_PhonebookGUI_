package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @Test (enabled = false)
    public void newUserRegisterPositiveTest(){
       // int i = (int) ((System.currentTimeMillis()/1000)%3600); for HW
        clickOnLoginLink();
        fillLoginRegisterForm("jenny.klein001@mail.de", "Aa12345!");
        clickOnRegistrationButton();
        Assert.assertTrue(isSignButtonPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest(){
        clickOnLoginLink();
        fillLoginRegisterForm("jenny.klein001@mail.de", "Aa12345!");
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());
    }

}
