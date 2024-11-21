package task_13;

import org.testng.IExecutionListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.IInvokedMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task13_MyExecutionListener implements ISuiteListener, IExecutionListener, IInvokedMethodListener {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void onExecutionStart() {
        LOGGER.info("Execution of test has started");
    }

    @Override
    public void onExecutionFinish() {
        LOGGER.info("Execution of test has finished");
    }

    @Override
    public void onStart(ISuite iSuite) {
        LOGGER.info("Suite started: " + iSuite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        LOGGER.info("Suite finished: " + suite.getName());
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        LOGGER.info("Before method invocation: " + iInvokedMethod.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        LOGGER.info("After method invocation: " + iInvokedMethod.getTestMethod().getMethodName());
    }
}
