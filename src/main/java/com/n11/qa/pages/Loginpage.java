package com.n11.qa.pages;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.n11.qa.base.TestBase;

public class Loginpage extends TestBase {

    Homepage homepage = new Homepage();

    // initializing the page objects
    public Loginpage()  {


        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "loginButton")
    WebElement giris;

    // Actions

    public Homepage login(String un, String pwd) 	 {


        email.sendKeys(un);
        password.sendKeys(pwd);
        giris.click();

        return new Homepage();

    }
}

