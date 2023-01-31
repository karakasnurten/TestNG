package tests.day15_SortAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C03_PozitifLoginTesti {

    @Test (groups = "smoke")
    public void test01(){

       // 1- https://www.qualitydemy.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();
       // 2- login linkine basin
        QualitydemyPage qualitiydemyPage = new QualitydemyPage();
        qualitiydemyPage.ilkLoginLinki.click();

       // 3- Kullanici email’i olarak valid email girin
        qualitiydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
       // 4- Kullanici sifresi olarak valid sifre girin
        qualitiydemyPage.passwordKutusu.sendKeys("31488081");
       // 5- Login butonuna basarak login olun
        qualitiydemyPage.loginButonu.click();
        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(qualitiydemyPage.basariliGirisCoursesLinki.isDisplayed());

        Driver.closeDriver();


    }
}
