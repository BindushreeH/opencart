package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
    public class HomepageAct extends BasePage {
        public HomepageAct(WebDriver driver) {
            super(driver);
        }
        //WebDriver driver;
        // Homepage(WebDriver driver){
        //   this.driver=driver;
        // PageFactory.initElements(driver,this);
        //Elements
       // @FindBy(className ="d-none d-md-inline")
        @FindBy(xpath="//span[normalize-space()='My Account']")
        WebElement lnkMyAccount;
       // @FindBy(linkText = "Register")
        @FindBy(xpath = "//a[normalize-space()='Register']")
        WebElement lnkRegister;
        @FindBy(xpath="//a[normalize-space()='Login']")
        WebElement lnkLogin;


        //Action methods
        public void clkMyAccount(){
            lnkMyAccount.click();
        }
        public void clkRegister(){
            lnkRegister.click();
        }
        public void clkLogin(){
            lnkLogin.click();
        }

    }




