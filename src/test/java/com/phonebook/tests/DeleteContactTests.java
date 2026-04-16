package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        clickOnLoginLink();
        fillLoginRegisterForm("jenny.klein001@mail.de", "Aa12345!");
        clickOnLoginButton();

        clickOnAddLink();
        fillContactForm("Oliver", "Koen", "12345567896", "test@gmail.com", "Hannover", "QA");
        clickOnSaveButton();
    }

    public void clickOnAddLink() {
        super.clickOnAddLink();
    }

    @Test
    public void deleteContactTest(){
        int sizeBefor = sizeOfContacts();
        removeContact();
        pause(500);
            int sizeAfter = sizeOfContacts();
            Assert.assertEquals(sizeAfter,sizeBefor-1);
        }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

