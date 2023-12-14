package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringListOlustur(List<WebElement> elementlerListesi){
        List<String> stringListesi = new ArrayList<>();

        for (WebElement each : elementlerListesi){
            stringListesi.add(each.getText());
        }
        return stringListesi;
    }

    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static WebDriver titleIleSayfaDegistir(WebDriver driver , String hedefSayfaTitle){

        Set<String> tumWhdSeti = driver.getWindowHandles();

        for (String each : tumWhdSeti
        ) {

            String eachTitle = driver.switchTo().window(each).getTitle();
            if (eachTitle.equals(hedefSayfaTitle)){
                return driver;
            }
        }

        return driver;
    }

    public static String ilkSayfaWhdIleIkinciSayfaWhdBul(WebDriver driver, String ilkSayfaWhd) {

        Set<String > tumWhdSeti = driver.getWindowHandles();

        tumWhdSeti.remove(ilkSayfaWhd);

        for (String each:tumWhdSeti
        ) {
            return each;
        }

        return null; // bu satirin hic calismayacagini biliyoruz
        // sadece javanin endiselerini gidermek icin yazdik
    }

    public static void tumSayfaTakeScreenshot(WebDriver driver){
        //1.adım tss objesini oluştur
        TakesScreenshot tss = (TakesScreenshot) driver;
        //2.adim fotoğrafı kaydedeceğimiz dosya yolu ile bir file oluşturalım
        // her yeni kaydedilen resmin öncekinin üstüne kaydedilmemesi için
        // kaydedilecek dosya yolunu dinamik yapabiliriz
        // dinamik yapmak için dosya yoluna tarih etiketi ekleyelim

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHss");
        String dinamikDosyaYolu = "target/screenshots/tumSayfaScreenshot" +
                                    localDateTime.format(istenenFormat) +
                                    ".jpg";

        File tumSayfaScreenshot = new File(dinamikDosyaYolu);

        //3.adim tss objesini kullanarak fotografı çekip geçici bir doyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4.adım geçici dosyayı asıl dosyaya kopyalayalım

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }







}
