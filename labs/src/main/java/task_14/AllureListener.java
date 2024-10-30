package task_14;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITest;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static task_14.Task_14DriverProvider.getDriver;

public class AllureListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("onTestFailure");
        makeScreenShot();
    }

    @Attachment(value="Page screen", type="image/png")
    private byte[] makeScreenShot(){
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
