package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        clickOnLoginButton();
        Assert.assertTrue(isSignButtonPresent());

    }

    @Test
    public void loginNegativeWithoutEmailTest(){

        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword(UserData.password));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());

    }

}
