package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.clickOnLoginLink();
        app.fillLoginRegisterForm(new User()
                .setEmail("jenny.klein001@mail.de")
                .setPassword("Aa12345!"));
        app.clickOnLoginButton();

        app.clickOnAddLink();
        app.fillContactForm(new Contact()
                .setName("Oliver")
                .setLastname("Koen")
                .setPhone("234556789")
                .setEmail("test@gmail.com")
                .setAddress("Hannover")
                .setDescription("QA"));

        app.clickOnSaveButton();
    }

    @Test
    public void deleteContactTest(){
        int sizeBefor = app.sizeOfContacts();
        app.removeContact();
        app.pause(500);
            int sizeAfter = app.sizeOfContacts();
            Assert.assertEquals(sizeAfter,sizeBefor-1);
        }

}

