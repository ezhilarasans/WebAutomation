package base;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class MyListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Method started" + result.getName());

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed" + result.getName());

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed" + result.getName());
        try {
            BaseTest.screenShot(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
