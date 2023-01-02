package pageObjectClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;
    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void setBtnLogin(){
        //btnLogin.click();

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",btnLogin);


    }
}
