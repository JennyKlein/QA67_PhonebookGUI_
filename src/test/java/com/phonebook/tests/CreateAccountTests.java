package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @Test (enabled = false)
    public void newUserRegisterPositiveTest(){
       // int i = (int) ((System.currentTimeMillis()/1000)%3600); for HW
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignButtonPresent());
    }

    @Test
    public void existedUserRegisterNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
