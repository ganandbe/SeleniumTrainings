package Tester;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class HWdragdrop {
    WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://way2automation.com/way2auto_jquery/droppable.php");


    }

    public void dragdrop() throws IOException {

        File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resoures\\screenshot\\result.jpg");
        FileUtils.copyFile(scrfile,dest);

        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement destination = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,destination).perform();


    }


public static void main(String[] args) throws InterruptedException, IOException {
        HWdragdrop testapp = new HWdragdrop();
        testapp.setup();
        testapp.dragdrop();

        }
        }

