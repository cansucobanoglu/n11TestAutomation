package com.n11.qa.pages;

import com.n11.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


public class Products extends TestBase {

    public Products(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'resultText')]")
     WebElement resultText;

    @FindBy(xpath = "//div[@class='pagination']//a[contains(text(),'2')]")
    WebElement secondPage;

    @FindBy (xpath = "//div[@id='view']//ul[@class='clearfix']")
    WebElement listView;

    @FindBy (xpath = "//div[@id='view']//ul[@class='clearfix']//li[3]//h3")
    WebElement getFavoriteName;

    public Products checkResults() {
        boolean present = resultText.isEnabled();
           if (present){
            System.out.println("Sonuçlar listelendi");
        } else{
            System.out.println("Sonuç bulunamadı..");
        }

        return this;
    }

    public Products clickSecondPage()
    {
        secondPage.click();
        System.out.println("2. Sayfaya tıklandı.");

        return this;
    }

    public Products clickOnThirdProduct()
    {
        List<WebElement> favorilereEkle = listView.findElements(By.xpath("//span[@title='Favorilere ekle']"));
        int size = favorilereEkle.size();
        System.out.println("Listelenen toplam ürün sayısı: " + size);
        favorilereEkle.get(2).click();
        String name = getFavoriteName.getText();
        System.out.println("Favorilenen ürün: " +name);

        return this;
    }

}

