package Homework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HWcheckbox {
    WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/radio.html");


    }

    public void screenshot() throws IOException {
        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String location = "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resoures\\screenshot";
        String name = scrfile.getName();
        File dest = new File(location +name +".png");
        FileUtils.copyFile(scrfile,dest);
    }



    public void radiobuttons() throws IOException {


        List <WebElement> radiobuttonele = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement radiovalue: radiobuttonele){
            System.out.println("Value is...."+radiovalue.getAttribute("value"));
            System.out.println("ID is...."+radiovalue.getAttribute("id"));
            radiovalue.click();
            screenshot();
        }

    }
    public void checkboxes() throws IOException {
        List <WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        int i=0;
        for (WebElement checkvalue: checkbox){
            System.out.println("Value is...."+checkvalue.getAttribute("value"));
            System.out.println("ID is...."+checkvalue.getAttribute("id"));
            if(i==1 || i==2){

                checkvalue.click();
                screenshot();
            }
            if(checkvalue.isSelected()){
                checkvalue.click();
                screenshot();

            }
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        HWcheckbox testapp = new HWcheckbox();
        testapp.setup();
        testapp.radiobuttons();
        testapp.checkboxes();

    }
}
