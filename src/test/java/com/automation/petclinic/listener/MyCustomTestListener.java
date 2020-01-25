package com.automation.petclinic.listener;

import com.automation.petclinic.configuration.WebDriverHolder;
import com.google.common.io.Files;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alpa on 1/23/20
 */
public class MyCustomTestListener implements ISuiteListener, ITestListener {


    @Override
    public void onStart(ISuite suite) {
        System.out.println("Start Suite name: " + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Stop Suite name: " + suite.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        System.out.println("onTestStart: " + method.getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        System.out.println("onTestSuccess: " + method.getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        takeScreenshot(method.getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    private void takeScreenshot(String name) {
        File scrFile = ((TakesScreenshot) WebDriverHolder.getInstance())
                .getScreenshotAs(OutputType.FILE);
        try {
            saveScreenshot(Files.toByteArray(scrFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            FileUtils.copyFile(scrFile, new File(name +"_" +System.currentTimeMillis()+".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }


}
