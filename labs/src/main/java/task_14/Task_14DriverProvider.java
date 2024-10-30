package task_14;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_14DriverProvider {
    static WebDriver driver;
    static WebDriver getDriver(){
        if (driver == null){
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
