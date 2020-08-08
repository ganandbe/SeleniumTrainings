package Tester;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HWhandling {

    WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");


    }

    public void AlertException() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[2]/button\n")).click();

        Alert alerts = driver.switchTo().alert();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alerts.accept();

        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/button\n")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alerts.accept();

        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button")).click();

        alerts.sendKeys("Welcome");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alerts.accept();

    }

    public static void main(String[] args) {
        HWhandling testapp = new HWhandling();
        testapp.setup();
        testapp.AlertException();

    }
}
