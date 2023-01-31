package tests.practise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NevzatH_Qualitydemy1 {

    String url2="https://www.google.com";
    Actions actions=new Actions(Driver.getDriver());
    QualitydemyPage qualitydemyPage = new QualitydemyPage();



    @Test
    public void qualitydemyTest (){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // cookies i kabul edin
        qualitydemyPage.cookieKabul.click();
        ReusableMethods.bekle(2);
        // login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();
        // email ve password bilgilerini girerek login butonuna tiklayin
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        ReusableMethods.bekle(2);
        qualitydemyPage.loginButonu.click();

        // categories dropdown dan all courses secenegine tiklayin

        actions.moveToElement(qualitydemyPage.categories).clickAndHold(qualitydemyPage.categories).
                moveToElement(qualitydemyPage.allCourses).click(qualitydemyPage.allCourses).perform();
        // acilan sayfada olan derslerden The English Master Course dersine tiklayin
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(3);
        qualitydemyPage.secondPage.click();

        actions.scrollToElement(qualitydemyPage.english).perform();
        ReusableMethods.bekle(3);
        qualitydemyPage.english.click();

        // dersi satin almak icin Buy now secenegine ve checkout butonuna tiklayin
        qualitydemyPage.buyNowButton.click();
        qualitydemyPage.checkoutButton.click();

        // stripe secenegini secerek pay with stripe e tiklayin
       qualitydemyPage.stripButton.click();
       qualitydemyPage.payWithStripeButton.click();

        // Email,card information gun ay yil cvc ve name on card bilgilerini doldurarak pay a tiklayin
      qualitydemyPage.payWithCard();

    }
    //qualityDemy web sayfasina gidin
    // cookies i kabul edin
    // login linkine tiklayin
    // email ve password bilgilerini girerek login butonuna tiklayin
    // categories dropdown dan all courses secenegine tiklayin
    // acilan sayfada olan derslerden The English Master Course dersine tiklayin
    // dersi satin almak icin Buy now secenegine ve checkout butonuna tiklayin
    // stripe secenegini secerek pay with stripe e tiklayin
    // Email,card information gun ay yil cvc ve name on card bilgilerini doldurarak pay a tiklayin
}
