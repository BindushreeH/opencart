package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectClasses.HomepageAct;
import pageObjectClasses.LoginPage;
import pageObjectClasses.MyAccountPage;
import testBase.BaseClass;

import java.time.Duration;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class TC_002_AccountLoginTest  {
    public WebDriver driver;
    public Logger logger = (Logger) (Logger) LogManager.getLogger(this.getClass());
    public ResourceBundle rb;

    @BeforeClass()
    @Parameters({"browser"})
    void setup(String br) {

        logger=LogManager.getLogger(this.getClass());
        rb=ResourceBundle.getBundle("config");

        WebDriverManager.chromedriver().setup();
        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(rb.getString("url"));

    }
    @AfterClass()
    void tearDown(){
        driver.close();
    }
    @Test(groups = {"Master","Sanity"})
    void testAccountLogin(){
        try {
            logger.info("test started");
            HomepageAct hp = new HomepageAct(driver);
            hp.clkMyAccount();
            hp.clkLogin();
            //login page
             LoginPage lp = new LoginPage(driver);
            lp.setTxtEmail(rb.getString("email"));
            lp.setTxtPassword(rb.getString("password"));
            lp.setBtnLogin();

           // WebElement b = driver.findElement(By.xpath("//button[text()='Login']"));
           // b.click();
            logger.info("login completed");
            MyAccountPage mp = new MyAccountPage(driver);
            logger.info("myAccount started");
            boolean targetPage = mp.isPageHeaderDisplay();
            logger.info("target displayed");
            Assert.assertEquals(targetPage, true);
            logger.info("true");
           // logger.info("test finished");
        }
        catch (Exception e){
            Assert.fail();
        }
        logger.info("test finished");
    }
}