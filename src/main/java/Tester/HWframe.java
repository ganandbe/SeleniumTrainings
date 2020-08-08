package Tester;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.concurrent.TimeUnit;

public class HWframe {
    WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Frames.html");


    }

    public void framehandle() {
        WebElement frame0 = driver.findElement(By.id("singleframe"));
        driver.switchTo().frame(frame0);
        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("First Frame");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();
        /*WebElement frame1 = driver.findElement(By.xpath("(//iframe)[1]"));*/
        WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
        driver.switchTo().frame(frame1);
        WebElement frame2 = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Second Frame");
        driver.switchTo().defaultContent();
    }
    public static void main(String[] args){
        HWframe testapp = new HWframe();
        testapp.setup();
        testapp.framehandle();

    }
}
