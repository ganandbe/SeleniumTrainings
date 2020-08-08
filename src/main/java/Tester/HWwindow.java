package Tester;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import java.util.Set;
        import java.util.concurrent.TimeUnit;

public class HWwindow {
    WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");


    }
    public void Windowhand() throws InterruptedException {
        String Currentwindowhandle = driver.getWindowHandle();
        driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/a")).click();
        Set<String> handleid = driver.getWindowHandles();
        for (String eachwindow : handleid) {
            if (!eachwindow.equals(Currentwindowhandle)) {
                driver.switchTo().window(eachwindow);
                Thread.sleep(3000);
                driver.manage().window().maximize();
                String title = driver.getTitle();
                System.out.println("My input is displayed" + title);
                driver.close();
            }
        }

        driver.switchTo().window(Currentwindowhandle);

    }
    public void windowhandlemultiple() throws InterruptedException {
        String Currentwindowhandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"followall\"]")).click();
        Set<String> handleid = driver.getWindowHandles();
        for (String eachwindow : handleid) {
            if (!eachwindow.equals(Currentwindowhandle)) {
                driver.switchTo().window(eachwindow);
                Thread.sleep(3000);
                driver.manage().window().maximize();
                String title = driver.getTitle();
                System.out.println("titles" + title);
                if (driver.getTitle().contains("Selenium Easy - Home | Facebook")){
                    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("anand");
                }
                driver.close();

            }
            driver.switchTo().window(Currentwindowhandle);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        HWwindow testapp = new HWwindow();
        testapp.setup();
        testapp.Windowhand();
        testapp.windowhandlemultiple();

    }
}
