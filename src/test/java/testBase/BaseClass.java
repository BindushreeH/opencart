package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseClass {
 // public static WebDriver driver;
/*public Logger logger;
public ResourceBundle rb;
       //public WebDriver driver;
        @BeforeClass
      //  @Parameters("browser")
        void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            logger = LogManager.getLogger(this.getClass());
            rb = ResourceBundle.getBundle("config");

            /* if(br.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(br.equals("edge")){
            driver=new EdgeDriver();
        }
        else{
            driver=new SafariDriver();
      //  if(br.equals("chrome")) {
                driver = new ChromeDriver();
        //    }else {
        //        driver = new EdgeDriver();
          //  }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://demo.opencart.com/index.php");//remote run
            driver.manage().window().maximize();
        }*/

        @AfterClass
         public void teardown(){
       //     driver.close();
        }
        public String randomString(){//JAVA METHODS
            String generated_str= RandomStringUtils.randomAlphabetic(15);
            return generated_str;
        }
        public String randomNumber(){//no needed(for phone number)
            String generated_num=RandomStringUtils.randomAlphabetic(10);
            return generated_num;
        }
        public String randomStringAndNumber(){//combination of string,special char,number
            String gen_str=RandomStringUtils.randomAlphabetic(5);
            String gen_num=RandomStringUtils.randomAlphabetic(10);
            return gen_str+"@"+gen_num;
        }
   /* public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "//screenshots//" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;

    }*/


}



