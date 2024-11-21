package task_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_10Manager {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void task10Test() {
        driver.get("https://demoqa.com/checkbox");

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
