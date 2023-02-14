import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GererIframe { // cliquer sur des elements presents dans differents frames(cadres)

    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();
            WebDriver driver= new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
          //  driver.switchTo().frame(2);
        //Ou bien
        WebElement Myframe = driver.findElement(By.name("packageListFrame"));
        //driver.switchTo().frame(Myframe);
        Thread.sleep(2000);
        //driver.findElement(By.linkText("org.openqa.selenium")).click();

        Thread.sleep(2000);


    //Il faut toujours revenir au Frame parent avant de changer de frame
    driver.switchTo().defaultContent();
    //il faut toujours revenir au frame default afin de changer de frame si pas imbrique
//si imbrique (Frame dans Frame)
     //   driver.switchTo().parentFrame();
     //Il faut toujours revenir au frame parent puis changer de frame   si imbriquer


        WebElement Myframe2 = driver.findElement(By.name("packageFrame"));
        driver.switchTo().frame(Myframe2);
        Thread.sleep(2000);
        driver.findElement(By.linkText("WebDriver")).click();
// Changer vers 3eme frame qui est en dehors
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        WebElement Myframe3 = driver.findElement(By.name("classFrame"));
        driver.switchTo().frame(Myframe3);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[text()='Help']")).click();
        Thread.sleep(4000);
        driver.close();

    }
    }

