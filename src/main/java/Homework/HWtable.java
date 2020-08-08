package Homework;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class HWtable {

    WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/web-table-element.php#");


    }

    public void tables() throws IOException, ParseException {

        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resoures\\screenshot\\result.jpg");
        FileUtils.copyFile(scrfile,dest);

        List<WebElement> headers = driver.findElements(By.xpath("//table//th"));
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr" ));
        List<WebElement> companyname = driver.findElements(By.xpath("//table//tbody//td[1]"));
        int i=0;
        for (WebElement headername:headers) {
             i++;
            System.out.println("Header name++++++"+i+headername.getText());

        }
        System.out.println("Number of column++++++"+i);

        int J=0;

        for (WebElement rowno: rows) {
            J++;
            
        }
        System.out.println("Number of rows++++++"+J);

        for (WebElement company: companyname) {

            String comparetext = company.getText();

            if (comparetext.startsWith("C" )) {

                System.out.println("Company name that start with c+++" + comparetext);
            }
        }

            List<WebElement> pricevalues = driver.findElements(By.xpath("//table//tbody//td[4]"));
                float intval1=0;
            for (WebElement pricet:pricevalues) {

                String text = pricet.getText();

                //float intval = Float.parseFloat(text);
                //float inval1 =intval;

               /* if(intval>intval1){

                    intval=intval1;

                }*/
                System.out.println("price value c+++" +text);

            }

            }

    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
        HWtable testapp = new HWtable();
        testapp.setup();
        testapp.tables();

    }
}


