package com.n11.qa.pages;

import com.n11.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Favorites extends TestBase {

    public Favorites() { PageFactory.initElements(driver, this);}

    @FindBy (xpath = "//a[@class='menuTitle']")
    WebElement hesabim;

    @FindBy(xpath = "//a[@href='https://www.n11.com/hesabim/istek-listelerim']")
    WebElement favorilerim;

    @FindBy(xpath = "//h4[contains(text(),'Favorilerim')]")
    WebElement getFavorilerim;

    @FindBy(xpath = "//span[@class='btn btnBlack confirm']")
    WebElement okButton;

    public Favorites goToFavorites()
    {
        hesabim.click();
        favorilerim.click();
        getFavorilerim.click();

        return new Favorites();
    }

    public Favorites deleteFavoriteProduct() throws InterruptedException

    {
        List<WebElement> favoriteList = driver.findElements(By.xpath("//li[@class='column wishListColumn ']//div//div[1]//h3"));
        System.out.println("Favoriler menüsündeki toplam ürün sayısı: "+favoriteList.size());

        String getName = favoriteList.get(0).getText();

        System.out.println("Favorilerim menüsündeki ürün:" + getName);

        List<WebElement> deleteList = driver.findElements(By.xpath("//div//span[@class='deleteProFromFavorites'][contains(text(),'Sil')]"));
        deleteList.get(0).click();
        okButton.click();
        Thread.sleep(2000);

        //Ürün silindikten sonra tekrar toplam favorilenen ürün sayısı alınıyor.
        List<WebElement> favoriteList1 = driver.findElements(By.xpath("//li[@class='column wishListColumn ']//div//div[1]//h3"));
        int number = favoriteList1.size();

        if(number >0) {
            String getName2 = favoriteList1.get(0).getText();

            if (getName2 == getName) {
                System.out.println("Ürün hala listededir.");
            } else {
                System.out.println("Ürün listeden silinmiştir.");
            }
        }
        else {
            System.out.println("Ürün listeden silinmiştir.");
        }

        return new Favorites();
    }
}
