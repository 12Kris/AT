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
    WebDriver webDriver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Test
    public void task10Test() {
        webDriver.get("https://demoqa.com/checkbox");

        WebElement expandAllToggleIcon = webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        WebElement checkboxItemDocumentsToggleIcon = webDriver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
        WebElement documentsItemVeu = webDriver.findElement(By.id("tree-node-veu"));

        expandAllToggleIcon.click();
        checkboxItemDocumentsToggleIcon.click();
        documentsItemVeu.click();

        Assert.assertTrue(expandAllToggleIcon.isDisplayed(), "Expand All button is not visible.");
        Assert.assertTrue(checkboxItemDocumentsToggleIcon.isDisplayed(), "Documents is not visible.");
        Assert.assertTrue(documentsItemVeu.isDisplayed(), "Item Veu is not visible");
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.close();
        webDriver.quit();
    }
}