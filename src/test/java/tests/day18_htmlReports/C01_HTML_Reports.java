package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import javax.naming.NamingEnumeration;

public class C01_HTML_Reports extends TestBaseRapor {


    @Override
    public void reportInformation() {

        reportName="TC_2201";
        reportOwnerName="Nurten";
        documentTitle="Sayfa Basligi";
        reportPageHeader="Test Case 1801";
    }


    @Test
    public void test01(){

        extentTest = extentReports.createTest("Nutella testi", "Kullanici amazonda Nutella var");

        // amazon'a gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");
        // Nutella aratalim
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("Arama kutusuna Nutella yazip, arama yapildi");
        // sonuclarin Nutella icerdigini test edin
         String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();
         String expectedSonucYazisisi= "Nutella";
         extentTest.info("Arama sonuclari kaydedildi");

         Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisisi));
         extentTest.pass("Arama sonuclarinin Nutella icerdigi test edildi");

         Driver.closeDriver();
    }


}
