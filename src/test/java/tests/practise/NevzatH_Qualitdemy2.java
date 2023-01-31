package tests.practise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class NevzatH_Qualitdemy2 {

    Actions actions = new Actions(Driver.getDriver());
    QualitydemyPage qualitydemyPage = new QualitydemyPage();

    @Test
    public void test2() {

        //qualityDemy web sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        ReusableMethods.bekle(5);
        // cookies i kabul edin
        // login linkine tiklayin
        // email ve password bilgilerini girerek login butonuna tiklayin
        qualitydemyPage.loginMethodu();
        // anasayfadan java kursunu secelim

        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        qualitydemyPage.javaKursu.click();
        // acilan sayfada ders add to wishlist e eklenir
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        qualitydemyPage.addWishList.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.HOME).perform();
        ReusableMethods.bekle(2);
        actions.moveToElement(qualitydemyPage.wishListIcon).click(qualitydemyPage.goToWishListButton).perform();
        Assert.assertTrue(qualitydemyPage.javaKursu.isDisplayed());
        // eklenilen urun wishlistten cikarilir
        //cikarildigi test ediliri
        qualitydemyPage.wishListCikarma.click();
        ReusableMethods.bekle(2);
        qualitydemyPage.yesButton.click();
        Assert.assertFalse(qualitydemyPage.javaKursu.isDisplayed());


    }
    //qualityDemy web sayfasina gidin
    // cookies i kabul edin
    // login linkine tiklayin
    // email ve password bilgilerini girerek login butonuna tiklayin
    // anasayfadan java kursunu secelim
    // acilan sayfada ders add to wishlist e eklenir
    // urunun eklendigi test edilir
    // eklenilen urun wishlistten cikarilir
    //cikarildigi test ediliri
}