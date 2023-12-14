package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_PageClassKullanimi {

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfasına gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // phone için arama yapın

        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        ReusableMethods.bekle(1);

        // buşunan sonuc sayisinin 1'den çok olduğunu test edin

        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElemenleriList.size()>1);

        // arama sonuç sayısını yazdırın
        System.out.println(testOtomasyonuPage.sonucYaziElementi.getText());



    }



}
