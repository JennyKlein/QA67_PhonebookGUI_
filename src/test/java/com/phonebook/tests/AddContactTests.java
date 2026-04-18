package com.phonebook.tests;

import com.phonebook.core.TestBase;
import com.phonebook.data.ContactData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if (app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("jenny.klein001@mail.de")
                .setPassword("Aa12345!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void adContactPositiveTest(){
        //click on Add link
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.name)
                .setLastname(ContactData.lastName)
                .setPhone(ContactData.phone)
                .setEmail(ContactData.email)
                .setAddress(ContactData.address)
                .setDescription(ContactData.description));
        app.getContact().clickOnSaveButton();
        //Assert -> by name
        Assert.assertTrue(app.getContact().isContactCreatedByText(ContactData.name));
    }

    @AfterMethod
    public void postConditions(){
        app.getContact().removeContact();
    }

}
