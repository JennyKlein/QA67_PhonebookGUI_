package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("jenny.klein001@mail.de")
                .setPassword("Aa12345!"));
        clickOnLoginButton();
    }

    @Test
    public void adContactPositiveTest(){
        //click on Add link
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Oliver")
                .setLastname("Koen")
                .setPhone("12345567896")
                .setEmail("test@gmail.com")
                .setAddress("Hannover")
                .setDescription("QA"));
        clickOnSaveButton();
        //Assert -> by name
        Assert.assertTrue(isContactCreatedByText("Oliver"));
    }

    @AfterMethod
    public void postConditions(){
        removeContact();
    }

}
