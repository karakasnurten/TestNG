package tests.practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class dataProvider {
     QualitydemyPage qualitydemyPage= new QualitydemyPage();
    @DataProvider
    public static Object[][] gonderilecekLogin(){
        Object[][] gonderilecekMailPassword =
                {{ConfigReader.getProperty("yanlisMail1"),ConfigReader.getProperty("yanlisPass1")}
                ,{ConfigReader.getProperty("yanlisMail2"),ConfigReader.getProperty("yanlisPass2")}
                ,{ConfigReader.getProperty("yanlisMail3"),ConfigReader.getProperty("yanlisPass3")}
                ,{ConfigReader.getProperty("qdGecerliUsername"),ConfigReader.getProperty("qdGecerliPassword")}};

        return gonderilecekMailPassword;
    }
    @Test(dataProvider = "gonderilecekLogin")

    public void qualityTest(String gonderilecekMail, String gonderilecekPassword){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.gonderilecekMailPassword(gonderilecekMail, gonderilecekPassword);




    }

}
