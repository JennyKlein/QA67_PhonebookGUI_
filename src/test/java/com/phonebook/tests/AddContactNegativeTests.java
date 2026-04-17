package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactNegativeTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("jenny.klein001@mail.de")
                .setPassword("Aa12345!"));
        clickOnLoginButton();
    }

    @Test
    public void addContactWithInvalidPhoneTest(){
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Oliver")
                .setLastname("Koen")
                .setPhone("234556789")
                .setEmail("test@gmail.com")
                .setAddress("Hannover")
                .setDescription("QA"));
        clickOnSaveButton();
        Assert.assertTrue(isAlertPresent());
    }
}
