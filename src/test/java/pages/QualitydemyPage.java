package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualitydemyPage {

    Actions actions = new Actions(Driver.getDriver());

    public QualitydemyPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }
    public void loginMethodu() {
        if (cookieKabul.isDisplayed()) {
            cookieKabul.click();
            ilkLoginLinki.click();
            kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
            passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        } else {
            ilkLoginLinki.click();
            kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
            passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        }
        loginButonu.click();
    }

    @FindBy(xpath ="//*[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(id ="login-email")
    public WebElement kullaniciEmailKutusu;

    @FindBy(id="login-password")
    public WebElement passwordKutusu;

    @FindBy(xpath ="//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(linkText ="My courses")
    public WebElement basariliGirisCoursesLinki;

    @FindBy(xpath= "//*[text()='Accept']")
    public  WebElement cookieKabul;

    @FindBy(xpath = "//*=text()='Categories']")
    public WebElement categories;

    @FindBy(xpath = "(//*[text()='All courses'])[1]")
    public WebElement allCourses;

    @FindBy(xpath = "//*[text()='2']")
    public WebElement secondPage;

    @FindBy(xpath = "(//a[@class='course-title'])[5]")
    public WebElement english;

    @FindBy(xpath = "//div[@class='row payment-gateway stripe']")
    public WebElement stripButton;

    @FindBy (xpath = "//button[text()='Buy now']")
    public WebElement buyNowButton;

    @FindBy (xpath = "//button[text()='Checkout']")
    public WebElement checkoutButton;

    @FindBy (xpath = "//div[@class='col-12']")
    public WebElement stripeOptions;

    @FindBy (xpath = "//button[text()='Pay with stripe']")
    public WebElement payWithStripeButton;

    @FindBy (xpath = "//input[name()='email']")
    public WebElement payEmailBox;

    @FindBy (xpath = "//div[@class='SubmitButton-IconContainer']")
    public WebElement payButton;

    public void payWithCard(){
        actions.sendKeys(payEmailBox,"anevzatcelik@gmail.com")
                .sendKeys(Keys.TAB).sendKeys("4242424242424242").sendKeys(Keys.TAB).sendKeys("1124")
                .sendKeys(Keys.TAB).sendKeys("325")
                .sendKeys(Keys.TAB).sendKeys("ahmet")
                .sendKeys(Keys.TAB).sendKeys("Poland")
                .sendKeys(payButton).perform();
    }
    @FindBy(xpath = "//h5[text()=' Java Kursu']")
    public WebElement javaKursu;
    @FindBy(xpath = "//button[@class='btn btn-add-wishlist ']")
    public WebElement addWishList;
    @FindBy(xpath = "(//div[@class='icon'])[3]")
    public WebElement wishListIcon;
    @FindBy(xpath = "//a[text()='Go to wishlist']")
    public WebElement goToWishListButton;

    @FindBy(xpath = "//button[@onclick='handleWishList(this)']")
    public WebElement wishListCikarma;
    @FindBy(xpath = "//a[@class='btn btn-danger btn-yes']")
    public WebElement yesButton;


    public  void gonderilecekMailPassword(String gonderilecekMail, String gonderilecekPassword) {

        if (cookieKabul.isDisplayed()) {
            cookieKabul.click();
            ilkLoginLinki.click();
            kullaniciEmailKutusu.sendKeys(gonderilecekMail);
            passwordKutusu.sendKeys(gonderilecekPassword);
            ReusableMethods.bekle(3);
        } else {
            ilkLoginLinki.click();
            kullaniciEmailKutusu.sendKeys(gonderilecekMail);
            passwordKutusu.sendKeys(gonderilecekPassword);
            ReusableMethods.bekle(3);
        }
        loginButonu.click();
    }




}


