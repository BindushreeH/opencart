package pageObjectClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends BasePage {
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

   // @FindBy(name = "firstname")
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstName;
    //@FindBy(name = "lastname")
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastName;
   // @FindBy(name = "email")
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;

   @FindBy(xpath = "//input[@name='telephone']")
   WebElement txtTelepnone;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;
   @FindBy(xpath="//input[@name='confirm']")
   WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")//input[@name='agree']
    WebElement chkInput;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnPrimary;
    @FindBy(xpath = "//h1[contains(.,'Your Account Has Been Created!')]")
    WebElement msgConfirmation;
    //OR (h1[text()='Your Account Has Been Created!')WebElement msgConfirmation;

    public void setTxtFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
    }

    public void setTxtLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void setTxtEmail(String email) {
        txtEmail.sendKeys(email);
    }
    public void setTxtTelepnone(String telepnone){
        txtTelepnone.sendKeys(telepnone);
    }

    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }
    public void setTxtConfirmPassword(String confirmPassword){
        txtConfirmPassword.sendKeys(confirmPassword);
    }

    public void clkChkInput() {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",chkInput);
    }

    public void clkBtnPrimary() {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",btnPrimary);
      //  btnPrimary.click();//solution 1(interview question)
        // btnPrimary.submit();                  ( solution 2)
       /* Actions act=new Actions(driver);      ( solution 3 mouseover command)
        act.moveToElement(btnPrimary).click().perform();*/
      /*  JavascriptExecutor js=(JavascriptExecutor) driver;  (solution 4)
        js.executeScript("arguments[0].click();",btnPrimary)*/
        //btnPrimary.sendKeys(Keys.RETURN);SOLUTION 5 keyboard command
        // btnPrimary.sendKeys(Keys.ENTER);SOLUTION 6
      /*  WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(10));
        wt.until(ExpectedConditions.elementToBeClickable(btnPrimary)).click();//or submit*/ //(solution 7)
    }
   /* public String getConfirmMsg(){
        try{
            return (msgConfirmation.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }*/
}
