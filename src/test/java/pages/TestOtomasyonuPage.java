package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestOtomasyonuPage {

   public TestOtomasyonuPage(){
       PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="global-search")
    public WebElement aramaKutusu;

    @FindBy(className = "product-count-text")
    public WebElement sonucYaziElementi;

    @FindBy(xpath = "//[@class='product-box my-2 py-1']")
    public List<WebElement> bulunanUrunElemenleriList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement urunSayfasindakiUrunIsimElementi;




}
