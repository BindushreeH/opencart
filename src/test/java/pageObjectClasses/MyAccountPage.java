package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement pageHeader;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btnLogout;

    public boolean isPageHeaderDisplay() {
       try {
            return (pageHeader.isDisplayed());
        } catch (Exception e) {
           return (false);
       }
    }
   public void clkLogout(){
        btnLogout.click();
       // Actions act=new Actions(driver);  //TO CLICK LOGOUT
      //  act.moveToElement(btnLogout).click().perform();
    }
}