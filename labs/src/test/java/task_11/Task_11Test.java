package task_11;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_11Test {
    WebDriver driver;
    @Test
    void uitest(){
        System.setProperty("webdriver.chrome.driver", "/Users/kristina/Projects/AT/labs/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        System.out.println(driver.getCurrentUrl());
    }

    @BeforeTest
    void setup(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
    }

}
