package analyzer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	
	private int counter = 0;
    private static int retryLimit = 1; //Run the failed test 2 times
 
	public boolean retry(ITestResult result){
		if(counter < retryLimit){							//Check if maxtry count is reached
			counter++;										//Increase the maxTry count by 1
			return true;
		}
		return false;
	}

}
