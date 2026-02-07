package extentListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListenersAdapter implements ITestListener {
    
    @Override
    public void onStart(ITestContext context) {
        ExtentListeners.initExtent();
    }
    
    @Override
    public void onTestStart(ITestResult result) {
        ExtentListeners.createTest(result.getMethod().getMethodName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentListeners.getExtent().pass("Test Passed: " + result.getMethod().getMethodName());
        ExtentListeners.removeTest();
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentListeners.getExtent().fail("Test Failed: " + result.getMethod().getMethodName());
        ExtentListeners.removeTest();
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentListeners.getExtent().skip("Test Skipped: " + result.getMethod().getMethodName());
        ExtentListeners.removeTest();
    }
    
    @Override
    public void onFinish(ITestContext context) {
        ExtentListeners.endTest();
    }
}