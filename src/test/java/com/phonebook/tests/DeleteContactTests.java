package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User("jenny.klein001@mail.de", "Aa12345!"));
        clickOnLoginButton();

        clickOnAddLink();
        fillContactForm("Oliver", "Koen", "12345567896", "test@gmail.com", "Hannover", "QA");
        clickOnSaveButton();
    }

    @Test
    public void deleteContactTest(){
        int sizeBefor = sizeOfContacts();
        removeContact();
        pause(500);
            int sizeAfter = sizeOfContacts();
            Assert.assertEquals(sizeAfter,sizeBefor-1);
        }

}

