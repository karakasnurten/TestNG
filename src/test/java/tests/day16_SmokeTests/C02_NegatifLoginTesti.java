package tests.day16_SmokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegatifLoginTesti {

    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin

    QualitydemyPage qualitiydemyPage = new QualitydemyPage();

    @Test
    public void yanlisEmailTesti(){

        qualitiydemyPage = new QualitydemyPage();
        ReusableMethods.bekle(3);

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
       qualitiydemyPage.cookieKabul.click();
        qualitiydemyPage.ilkLoginLinki.click();
        qualitiydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitiydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitiydemyPage.loginButonu.click();
        Assert.assertTrue(qualitiydemyPage.kullaniciEmailKutusu.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }
    @Test
    public void yanlisPasswordTesti(){
        qualitiydemyPage= new QualitydemyPage();
        ReusableMethods.bekle(3);
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitiydemyPage.ilkLoginLinki.click();
        qualitiydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitiydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitiydemyPage.cookieKabul.click();
        ReusableMethods.bekle(2);
        qualitiydemyPage.loginButonu.click();

        Assert.assertTrue(qualitiydemyPage.kullaniciEmailKutusu.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();

    }
    @Test
    public void yanlisUsernameYanlisPasswordTesti(){

        qualitiydemyPage= new QualitydemyPage();
        ReusableMethods.bekle(3);
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitiydemyPage.ilkLoginLinki.click();
        qualitiydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitiydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qualitiydemyPage.cookieKabul.click();
        ReusableMethods.bekle(2);
        qualitiydemyPage.loginButonu.click();

        Assert.assertTrue(qualitiydemyPage.kullaniciEmailKutusu.isDisplayed());

        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }

}
