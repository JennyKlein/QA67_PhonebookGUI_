package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "jenny.klein001@mail.de");
        type(By.name("password"), "Aa12345!");
        click(By.name("login"));
    }

    @Test
    public void adContactPositiveTest(){
        //click on Add link
    click(By.cssSelector("[href='/add']"));
        //enter name
        type(By.xpath("//input[1]"), "Oliver");
        //enter lastname
        type(By.xpath("//input[2]"), "Koen");
        //enter phone
        type(By.xpath("//input[3]"), "12345567896");
        //enter email
        type(By.xpath("//input[4]"), "test@gmail.com");
        //enter address
        type(By.xpath("//input[5]"), "Hannover");
        //enter description
        type(By.xpath("//input[6]"), "QA");
        //click on Save button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //Assert -> by name
        Assert.assertTrue(isContactCreatedByText("Oliver"));


    }

    public boolean isContactCreatedByText(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for(WebElement element:contacts){
            if(element.getText().contains(text))
                return true;
        }
        return false;
    }

    @AfterMethod
    public void postConditions(){
        //click on card
        click(By.cssSelector(".contact-item_card__2SOIM"));

        //click on Remove button
        click(By.xpath("//button[.='Remove']"));
    }
}
