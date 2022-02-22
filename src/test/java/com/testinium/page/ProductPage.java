package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage {


    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    //Çıktı göndermek için kullanıldı.


    public ProductPage() {
        methods = new Methods();
    }

    public void scrollAndSelect() {
        methods.sendKeys(By.id("search-input"),"oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.scrollWithAction(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][5]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][6]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//div[@class='product-list']//div[@class='product-cr'][8]//i[@class='fa fa-heart']"));
        methods.waitBySeconds(1);

        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][5]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(1);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][6]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(1);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][7]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(1);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='product-list']//div[@class='product-cr'][8]//i[@class='fa fa-heart red']")));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//img[@title='kitapla buluşmanın en kolay yolu!']"));
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".logo-text"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//*[@id='mainNav']/div[1]/div/div[2]/a"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.cssSelector("#point-carousel-tab-title-952"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//*[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(2);
        methods.selectByText(By.cssSelector("#content>div>div>div.product-filter>div>div.sort>select"),
                "Yüksek Oylama");
        methods.waitBySeconds(2);
        methods.click(By.xpath("//span[@class='mn-strong common-sprite' and contains(text(),'Tüm Kitaplar')]"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@class='mn-icon icon-angleRight' and text()='Hobi']"));
        methods.waitBySeconds(2);
        clickRandomProduct();
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#button-cart > span"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath(("//a[@class = 'common-sprite' and contains(text(), 'Listelerim')]")));
        methods.click(By.xpath("//a[@class = 'common-sprite' and contains(text(), 'Listelerim')]"));
        methods.scrollWithAction(By.xpath(("//a[@class = 'common-sprite' and contains(text(), 'Listelerim')]")));
        methods.click(By.xpath("//a[@class = 'common-sprite' and contains(text(), 'Listelerim')]"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector("#header-top > div > div.top-menu.fr > ul > li:nth-child(1) > div > ul > li > div > ul > li:nth-child(1) > a"));
        methods.waitBySeconds(3);
        methods.scrollWithAction(By.xpath(("//h4[@class = 'common-sprite' and contains(text(), 'Sepetim')]")));
        methods.click(By.xpath("//h4[@class = 'common-sprite' and contains(text(), 'Sepetim')]"));
        methods.waitBySeconds(2);
        methods.click(By.id("js-cart"));
        methods.waitBySeconds(2);
        methods.findElement(By.xpath("//input[@name='quantity']")).clear(); //Ürün sayısı silindi
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@name='quantity']"), "3"); //artırma yaptı
        methods.waitBySeconds(3);
        methods.click(By.xpath("//i[@title='Güncelle']"));
        methods.waitBySeconds(3);
        List<WebElement> tumSecim= methods.findElements(By.cssSelector("a[class='button red']"));
        methods.click(tumSecim.get(1));
        methods.waitBySeconds(3);
        methods.sendKeys(By.id("credit-card-owner"),"Arzu");
        methods.sendKeys(By.id("credit_card_number_1"),"1234");
        methods.sendKeys(By.id("credit_card_number_2"),"1234");
        methods.sendKeys(By.id("credit_card_number_3"),"1234");
        methods.sendKeys(By.id("credit_card_number_4"),"1234");
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit-card-expire-date-month"),"04");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit-card-expire-date-year"),"2027");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit-card-security-code"),"123");
        methods.waitBySeconds(1);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
        //minik olmayan denemeler:)
        //methods.selectByText(By.cssSelector("select#common-sprite"),"Favorilerim");
        //  methods.click(By.xpath("a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        //methods.waitBySeconds(5);
        // String value=methods.getValue(By.xpath("//div[@class='padding']"));
        // Assert.assertFalse("Seçili etiketler için ürün bulunamadı!",true);


    }
    public void clickRandomProduct() {
        Random rnd = new Random();
        List<WebElement> Products = methods.findElements(By.cssSelector(".pr-img-link"));
        WebElement rndProduct = Products.get(rnd.nextInt(Products.size()));
        rndProduct.click();
        logger.info("Ürün seçildi");

        //rndProduct.click();

    }


}
