package tests.day19_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C02_WisequarterTest extends TestBaseCross {

    @Test
    public void test01(){

        // Wisequarter anasayfaya gidelim
        driver.get("https://www.wisequarter.com");

        // wisequrter sitesine gittigimizi test edelim
        String actualUrl = driver.getCurrentUrl();
        String expecteKelime = "wisequarter";

        Assert.assertTrue(actualUrl.contains(expecteKelime));
    }

}
