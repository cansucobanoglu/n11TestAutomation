package com.n11.qa.pages;

import org.openqa.selenium.WebElement;
import com.n11.qa.base.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage extends TestBase {

      public Homepage() {

          PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btnSignIn']")
    WebElement girisyap;

    @FindBy(id = "searchData")
    WebElement searchBar;

    @FindBy(xpath = "//span[@class='icon iconSearch']")
    WebElement searchClick;

    // Actions

    public String getHomePageTitle() {

        return driver.getTitle();
    }


    public Loginpage goLoginPage() {

        girisyap.click();
        return new Loginpage();
    }

    public Products setSearchBar(String search) throws InterruptedException
    {
        searchBar.sendKeys(search);
        searchClick.click();
        Thread.sleep(3000);

        return new Products();
    }



}