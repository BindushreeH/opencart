package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjectClasses.AccountRegistrationPage;
import pageObjectClasses.ConfirmPage;
import pageObjectClasses.HomepageAct;
import testBase.BaseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class TC_001_AccountRegistrationTest extends BaseClass {
   public Logger logger;
   WebDriver driver;
public ResourceBundle rb;
 //public static WebDriver driver;
    @BeforeClass()
   @Parameters({"browser"})
    void setup(String br) throws IOException {

        logger = LogManager.getLogger(this.getClass());
        // rb= ResourceBundle.getBundle("config");//extension noneed APPROACH1 must store in resources folder only
        FileReader file = new FileReader(System.getProperty("user.dir") + "//src/test/resources/config.properties");
        Properties p = new Properties();//need to mention FULLPATH ,can store anywhere in project
        p.load(file);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.get(rb.getString("url"));//APPROACH1
        driver.get(p.getProperty("url"));//APPROACH2
        // driver.get("https://demo.opencart.com/");//COMMON APPROACH
        driver.manage().window().maximize();
    }
    @AfterClass()
    void tearDown(){
        driver.close();
    }
   public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination =".//screenshots//" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }
    @Test(groups = {"Master","Regression"})
    public void test_account_registration() {
        logger.info("starting TC");
        logger.trace("trace all information of this TC");
        try{
            logger.debug("the tc stats its execution");
            logger.info("home page starts");
            HomepageAct hp = new HomepageAct(driver);
        hp.clkMyAccount();
        hp.clkRegister();
        logger.info("done");
        logger.info("accountPage starts");
        AccountRegistrationPage ap = new AccountRegistrationPage(driver);
        ap.setTxtFirstName(randomString().toUpperCase());//generating dynamically using randomString();
        ap.setTxtLastName(randomString().toUpperCase());
        ap.setTxtEmail(randomString() + "@gmail.com");//dynamic identical email i
            ap.setTxtTelepnone(randomNumber());
         String password=randomStringAndNumber();
        ap.setTxtPassword(password);
        ap.setTxtConfirmPassword(password);// for password
        //as per oid version password and confirm password should be same so
       /* String randomNumeric=randomStringAndNumber();
        ap.setTxtPassword(randomNumeric);
        ap.setconfirmpassword(randomNumeric);*/
        ap.clkChkInput();
        ap.clkBtnPrimary();

        ConfirmPage cp = new ConfirmPage(driver);
        String confirmMsg = cp.getConfirmMsg();
        SoftAssert st = new SoftAssert();
        st.assertEquals(confirmMsg, "Your Account Has Been Created!");
        cp.clickBnt();
    }
        catch (Exception e) {
            logger.error("error due to unsuccessful registration");
           Assert.assertFalse(true);
        }
    }

}
