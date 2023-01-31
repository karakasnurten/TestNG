package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class Odev {

    static  WebDriver driver;

    @Test
    public void test01() {
        // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin

        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        // 2. “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframe);
        WebElement ourProducts = driver.findElement(By.linkText("Our Products"));
        ourProducts.click();
        // 3. “Cameras product”i tiklayin
        WebElement camerasProduct = driver.findElement(By.xpath("//*[text()='Cameras']"));
        camerasProduct.click();
        ReusableMethods.bekle(3);
        // 4. Popup mesajini yazdirin
        WebElement htmlAlert = driver.findElement(By.xpath("//*[@class='modal-body']"));
        System.out.println("Alert mesaji : " +htmlAlert.getText());
        ReusableMethods.bekle(3);
        // 5. “close” butonuna basin
        WebElement closeButonu = driver.findElement(By.xpath("//*[text()='Close']"));
        closeButonu.click();
        ReusableMethods.bekle(3);
        // 6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        WebElement webdriverUniversity = driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']"));
        webdriverUniversity.click();
        // 7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        WebElement webdriverUniversityIndex = driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (New Approach To Learning)']"));
        Assert.assertTrue(webdriverUniversityIndex.isDisplayed());

        
    }
}
