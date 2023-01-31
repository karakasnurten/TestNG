package tests.day16_SmokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PozitifLoginTest {

    @Test
    public void pozitifLoginTest(){

        // qualitiydemy anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        ReusableMethods.bekle(5);

        WebElement cookieKabul = Driver.getDriver().findElement(By.xpath("//*[text()='Accept']"));
        cookieKabul.click();

        QualitydemyPage qualitiydemyPage = new QualitydemyPage();
        qualitiydemyPage.ilkLoginLinki.click();

        qualitiydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitiydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qualitiydemyPage.loginButonu.click();

        ReusableMethods.bekle(5);

       // Driver driver = new Driver(); itiraz eder

        Assert.assertTrue(qualitiydemyPage.basariliGirisCoursesLinki.isDisplayed());
        Driver.closeDriver();
    }
}
