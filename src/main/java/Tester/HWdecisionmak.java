package Tester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HWdecisionmak {
    WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");


    }

    public void Decisionstat1() {
        driver.findElement(By.xpath("//*[@id=\"user-message\"]")).sendKeys("anand test add");
        driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();
        WebElement display = driver.findElement(By.id("display"));
        String val2 = display.getText();

        if (display == display) {
            System.out.println("My input is displayed" +val2);
        } else {
            System.out.println("My input is not displayed" +display);
        }
    }

        public void Decisionstat2() {
            driver.findElement(By.xpath("//*[@id=\"sum1\"]")).sendKeys("10");
            driver.findElement(By.xpath("//*[@id=\"sum2\"]")).sendKeys("20");
            driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
            WebElement element = driver.findElement(By.xpath("//*[@id=\"displayvalue\"]\n"));
            String Val1 = element.getText();

            if (element == element) {
                System.out.println("Total Value" + Val1);
            } else {

                System.out.println("Incorrect Value" + Val1);

            }
        }
        public static void main(String[] args){
            HWdecisionmak testapp = new HWdecisionmak();
            testapp.setup();
            testapp.Decisionstat1();
            testapp.Decisionstat2();

        }
    }







