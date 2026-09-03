package com.orange.listeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_RETRIES = 2;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < MAX_RETRIES) {
            retryCount++;

            System.out.println(
                "Retrying test: " +
                result.getMethod().getMethodName() +
                " | Retry: " + retryCount
            );

            return true;
        }

        return false;
    }
}

