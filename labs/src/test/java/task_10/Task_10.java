package task_10;

/*1. Set up ChromeDriver using the driver file and properties.
2. Set up ChromeDriver using DriverManager.
3. Navigate to the page assigned to your variant.
4. Select any three different elements.
5. Interact with all the selected elements.
6. Verify the visibility of each element using assertions.
7. Wrap all these steps into a TestNG test case.

V10. https://demoqa.com (checkbox)*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_10 {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void task10Test() throws InterruptedException {
        driver.get("https://demoqa.com/checkbox");
        Thread.sleep(2000);

        WebElement expandAllIcon = driver.findElement(By.xpath("//button[@title='Expand all']"));
        WebElement documentsItemVeu = driver.findElement(By.id("tree-node-veu"));
        WebElement collapseAllIcon = driver.findElement(By.xpath("//button[@title='Collapse all']"));

        expandAllIcon.click();
        documentsItemVeu.click();
        collapseAllIcon.click();

        Assert.assertTrue(expandAllIcon.isDisplayed(), "Expand All button is not visible.");
        Assert.assertTrue(documentsItemVeu.isDisplayed(), "Item Veu is not visible");
        Assert.assertTrue(collapseAllIcon.isDisplayed(), "Collapse ALL button is not visible.");
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}