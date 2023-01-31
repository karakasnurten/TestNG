package tests.day15_SortAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegativeLoginTesti {

    // 3 test method'u olusturun
    // 1. yanlis email, dogru sifre
    // 2. dogru email, yanlis sifre
    // 3. yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin

    QualitydemyPage qualitiydemyPage = new QualitydemyPage();

    @Test
    public void yanlisEmailTesti() {
       qualitiydemyPage = new QualitydemyPage();
        ReusableMethods.bekle(3);

        Driver.getDriver().get("https://www.qualitydemy.com");
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        qualitiydemyPage.ilkLoginLinki.click();
        qualitiydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitiydemyPage.passwordKutusu.sendKeys("31488081");
        qualitiydemyPage.loginButonu.click();

        Assert.assertTrue(qualitiydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();

    }

    @Test
    public void yanlisPasswordTesti() {
        qualitiydemyPage= new QualitydemyPage();

        Driver.getDriver().get("https://www.qualitydemy.com");
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();

        qualitiydemyPage.ilkLoginLinki.click();
        qualitiydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        qualitiydemyPage.passwordKutusu.sendKeys("123456");
        qualitiydemyPage.loginButonu.click();

        Assert.assertTrue(qualitiydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void yanlisEmailYanlisPasswordTesti() {
        qualitiydemyPage= new QualitydemyPage();
        ReusableMethods.bekle(3);

        Driver.getDriver().get("https://www.qualitydemy.com");
        qualitiydemyPage.ilkLoginLinki.click();
        qualitiydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitiydemyPage.passwordKutusu.sendKeys("123456");
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
        ReusableMethods.bekle(3);
        qualitiydemyPage.loginButonu.click();

        Assert.assertTrue(qualitiydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();


    }
}

