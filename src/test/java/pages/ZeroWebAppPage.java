package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebAppPage {

    public  ZeroWebAppPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="signin_button")
    public WebElement signInButtonu;


    @FindBy(id="user_login")
    public WebElement userNameKutusu;

    @FindBy(id="user_password")
    public WebElement passwordKutusu;

    @FindBy(xpath="//input[@value='Sign in']")
    public WebElement signInSubmitButonu;

    @FindBy(xpath="//strong[text()='Online Banking']")
    public WebElement onlineBanking;


    @FindBy(id="pay_bills_link")
    public WebElement payBillLinki;


    @FindBy(xpath="//a[text()='Purchase Foreign Currency']")
    public WebElement puchaseFCButonu;

    @FindBy(id="pc_currency")
    public WebElement currecyDropdown;




}


