package tests.day14_testNG;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {


    @Test(dependsOnMethods = "testOtomasyonuTesti")
    public void amazonTesti(){
        System.out.println("Amazon Testi PASSED");
    }

    @Test
    public void testOtomasyonuTesti(){
        System.out.println("Test Otomasyonu Testi PASSED");
    }

    @Test
    public void wiseQuarterTesti(){
        System.out.println("Wise Quarter Testi PASSED");
    }



}
