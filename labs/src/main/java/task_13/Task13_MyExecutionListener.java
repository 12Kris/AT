package task_13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class Task13_MyExecutionListener implements ISuiteListener, IExecutionListener, IInvokedMethodListener {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
    }

    @Override
    public void  onFinish(ISuite suite) {
        IExecutionListener.super.onExecutionFinish();
    }

}
