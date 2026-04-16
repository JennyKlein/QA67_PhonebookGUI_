package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "jenny.klein001@mail.de");
        type(By.name("password"), "Aa12345!");
        click(By.name("login"));


        click(By.cssSelector("[href='/add']"));
        type(By.xpath("//input[1]"), "Oliver");
        type(By.xpath("//input[2]"), "Koen");
        type(By.xpath("//input[3]"), "12345567896");
        type(By.xpath("//input[4]"), "test@gmail.com");
        type(By.xpath("//input[5]"), "Hannover");
        type(By.xpath("//input[6]"), "QA");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

        @Test
    public void deleteContactTest(){
        int sizeBefor = sizeOfContacts();
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[.='Remove']"));
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

