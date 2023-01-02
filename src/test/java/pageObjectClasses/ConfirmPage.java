package pageObjectClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmPage extends BasePage {
    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement btnContinue;

    public String getConfirmMsg() {//boolean confirmHeader()
        try {
            return (msgConfirmation.getText());//return(msgConfirmation.isDisplayed();
        } catch (Exception e) {
            return (e.getMessage());//false
        }
    }
    public void clickBnt(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",btnContinue);
    }

    }


