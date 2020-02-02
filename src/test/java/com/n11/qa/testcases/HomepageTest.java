
package com.n11.qa.testcases;

import java.io.IOException;

import com.n11.qa.pages.Favorites;
import com.n11.qa.pages.Products;
import com.thoughtworks.gauge.Step;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.n11.qa.base.TestBase;
import com.n11.qa.pages.Homepage;
import com.n11.qa.pages.Loginpage;


public class HomepageTest extends TestBase {

    Homepage homePage ;
    Loginpage loginPage ;
    Products products;
    Favorites favorites;

        public HomepageTest() {
        super();
    }

    @BeforeTest
    public void setUp() throws InterruptedException {

        initialization();
        homePage =new Homepage();
        loginPage = new Loginpage();
        products = new Products();
        favorites = new Favorites();
    }

    @Test
    public void getTitle() {
        String title = homePage.getHomePageTitle();
        String expectedTitle = "n11.com - Alışverişin Uğurlu Adresi";

        try {
            Assert.assertEquals(title, expectedTitle);
            System.out.println("Anasayfadasınız");
            System.out.println(title);

        } catch (Exception e) {
            System.out.println("Anasayfada değilsiniz");
            e.printStackTrace();
        }
    }
    @Test(priority = 1)
    public void goToLogin() throws InterruptedException{


        homePage.goLoginPage();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void enterSearch() throws InterruptedException
    {
        homePage.setSearchBar(prop.getProperty("searchText"));


    }

    @Test(priority = 3)
    public void checkResult()
    {
        products.checkResults();
    }

    @Test(priority = 4)
    public void clickSecondPage() throws InterruptedException
    {
        products.clickSecondPage();
        Thread.sleep(2000);
        String expectedURL = "https://www.n11.com/arama?q=Samsung&pg=2";
        String actualURL = driver.getCurrentUrl();
        try {
            Assert.assertEquals(actualURL, expectedURL);
            System.out.println("İkinci sayfadasınız");
            System.out.println("2.sayfa adresi: "+ actualURL);

        } catch (Exception e) {
            System.out.println("İkinci sayfada değilsiniz");
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void clickOnThirdProduct() throws InterruptedException
    {
        products.clickOnThirdProduct();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void goToFavorites()
    {
        favorites.goToFavorites();
    }

    @Test(priority = 7)
    public void deleteProduct() throws InterruptedException
    {
        favorites.deleteFavoriteProduct();
    }

    @AfterTest
    public void tearDown() {

        driver.close();
    }

}
