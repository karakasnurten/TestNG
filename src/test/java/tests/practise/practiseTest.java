package tests.practise;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class practiseTest {
    // Amazona anasayfaya gidip, search textboxta
    // elma, armut, portakal aratin

    @Test (dataProvider = "arancakKelimeler")
    public void a_anasayfayaGidis(String abc){
        ReusableMethods.bekle(3);
        // amazon anasayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");
        // nutella icin arama yapin
        //WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        AmazonPage amazonPage= new AmazonPage();

        amazonPage.amazonAramaKutusu.sendKeys(abc + Keys.ENTER);
    }

    @DataProvider
    public Object[][] login(){

        Object[][] usernamePassword = new Object[3][2];

        usernamePassword[0][0]="gecerli username";
        usernamePassword[0][1]="gecersiz password";
        usernamePassword[1][0]="gecersiz username";
        usernamePassword[1][1]="gecerli password";
        usernamePassword[2][0]="gecersiz username";
        usernamePassword[2][1]="gecersiz password";

        return usernamePassword;
    }

}
