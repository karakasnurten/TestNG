package tests.day15_SortAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_SoftAssert extends TestBaseRapor {

    @Override
    public void reportInformation() {
        reportName="Nurten";
        reportOwnerName="TC_3201";
        documentTitle="Title";
        reportPageHeader="Sayfa Header";

    }

    @Test (groups = "minireg2")
    public void test01(){

        extentTest= extentReports.createTest("TC_3201","Test Case Description");

        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");
        // amazon anasayfaya gittiginizi dogrulatin
        SoftAssert softAssert = new SoftAssert();
        String expectedUrlKelime ="amazon";

        String actualUrl =Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime),"Url amazon icermiyor");

        extentTest.info("basariyla giris yapildi");

        // Nutella aratin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // arama sonuclarinin nutella icerdigini dogrulayin
        String aramaSonucYazisi= amazonPage.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"),"Arama sonuclari Nutella icermiyor");

        extentTest.info("Basariyla Nutella aratildi");

        // Java aratin
        amazonPage.amazonAramaKutusu.clear();
        amazonPage.amazonAramaKutusu.sendKeys("Java" + Keys.ENTER);
        ReusableMethods.bekle(10);

        // arama sonuclarinin 1000'den fazla oldugunu dogrulayin
        System.out.println(amazonPage.aramaSonucuElementi.getText());
        // 1-48 of over 6,000 results for "Java"

        aramaSonucYazisi = amazonPage.aramaSonucuElementi.getText();

        String[] sonucArr = aramaSonucYazisi.split(" ");
        // [1-48, of, over, 6,000, results, for, "Java"]

        String javaSonucSayisiStr = sonucArr[3]; // 6,000

        javaSonucSayisiStr= javaSonucSayisiStr.replaceAll("\\W","");
        System.out.println(javaSonucSayisiStr);  // 6000

        int sonucSayisiInt = Integer.parseInt(javaSonucSayisiStr);

        softAssert.assertTrue(sonucSayisiInt>1000,"Java icin arama sayisi 1000'den cok degil");


       softAssert.assertAll();
       extentTest.info("Test PASSED");
        Driver.closeDriver();
    }


}
