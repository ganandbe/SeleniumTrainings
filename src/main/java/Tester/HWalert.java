package Tester;

        import org.openqa.selenium.Alert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.concurrent.TimeUnit;

public class HWalert {

    WebDriver driver;

    public void setup()

    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\IdeaProjects\\Trainings\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/delete_customer.php");


    }

    public void AlertException()

    {
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("001");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String text = alert.getText();
        System.out.println("Alert Message"+text);
        alert.accept();

    }
    public static void main(String[] args) {
        HWalert testapp = new HWalert();
        testapp.setup();
        testapp.AlertException();

    }
}