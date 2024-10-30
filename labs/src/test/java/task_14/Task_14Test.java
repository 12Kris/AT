package task_14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static task_14.Task_14DriverProvider.getDriver;

@Listeners({
        AllureListener.class
})

public class Task_14Test {
    @Test
    public void googleTest(){
        getDriver().get("https://www.google.com/");
        getDriver().findElement(By.xpath("//*[@title='Пошук']")).sendKeys("Cakes");
        getDriver().findElements(By.xpath("//*[@value='Пошук Google']")).get(1).click();
    }

    @Test
    public void googleFailTest(){
        getDriver().get("https://www.google.com/");
        getDriver().findElement(By.xpath("//*[@title='Пошук']")).sendKeys("Cakes");
        getDriver().findElements(By.xpath("//*[@value='Пошук Google']")).get(1).click();
        Assert.fail();
    }
}
