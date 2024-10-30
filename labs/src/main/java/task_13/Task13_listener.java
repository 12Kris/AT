package task_13;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Task13_listener implements ITestListener {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.warn("Skipped");
    }

}
