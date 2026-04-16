package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        clickOnLoginLink();
        fillLoginRegisterForm("jenny.klein001@mail.de", "Aa12345!");
        clickOnLoginButton();
        Assert.assertTrue(isSignButtonPresent());

    }

}
