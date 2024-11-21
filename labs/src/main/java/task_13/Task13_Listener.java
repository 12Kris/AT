package task_13;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Task13_Listener implements ITestListener {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.warn("Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}

//V10. ITestListener method task (3, 6); ISuiteListener, IExecutionListener,IInvoke...(1, 2)
