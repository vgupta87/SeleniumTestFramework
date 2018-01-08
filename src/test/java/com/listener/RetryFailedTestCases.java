package com.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryFailedTestCases implements IRetryAnalyzer{
	private int retryCnt = 0;
    //You could mentioned maxRetryCnt (Maximiun Retry Count) as per your requirement. Here I took 2, If any failed testcases then it runs two times
    private int maxRetryCnt = 2;
	final static Logger logger = Logger.getLogger(RetryFailedTestCases.class);
	
	@Override
	public boolean retry(ITestResult result) {
		if (retryCnt < maxRetryCnt) {
           logger.info("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
        return false;
	}
	

}
