package task_20;

import org.testng.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Task20 {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "emulator-5554");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", "com.android.calculator2.Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        try {
            driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
            driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_3")).click();
            driver.findElement(AppiumBy.accessibilityId("minus")).click();
            driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_4")).click();
            driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_7")).click();
            driver.findElement(AppiumBy.accessibilityId("equals")).click();

            String actualResult = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
            String expectedResult = "46"; 

            Assert.assertEquals(actualResult, expectedResult, "Calculation result is incorrect!");
            System.out.println("Test Passed: The result is correct: " + actualResult);

        } finally {
            driver.quit();
        }
    }
}