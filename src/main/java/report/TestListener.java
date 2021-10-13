package report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.BrowserFactory;
//import pages.Module;
import helper.TestUtility;
import pages.Module;

public class TestListener extends BrowserFactory implements ITestListener {
	
	//Extent Report Declarations
		private static ExtentReports extent = ExtentManager.createInstance();
		public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
		
		public synchronized void onStart(ITestContext context) {
			System.out.println("Extent Reports Version 3 Test Suite started!");		
		}

		
		public synchronized void onFinish(ITestContext context) {
			System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
			extent.flush();
		}

		
		public synchronized void onTestStart(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " started!"));
			ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
			test.set(extentTest);
		}

		
		public synchronized void onTestSuccess(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " passed!"));
			test.get().pass(MarkupHelper.createLabel(result.getName()+ " - Test paased", ExtentColor.GREEN));
			//test.get().pass("Test passed");
		}

		///-----------my old code
		public synchronized void onTestFailure(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " failed!"));
			test.get().fail(MarkupHelper.createLabel(result.getName()+ " - Test failed due to below issue/error: ", ExtentColor.RED));
			test.get().fail(result.getThrowable());
			
			//Take screenshot and allow automatic saving of media files relative to the report
			//Extentreports log and screenshot operations for failed tests.
			try {
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
				String path=prop.getProperty("Screenshot_Folder")+System.currentTimeMillis()+".png";
				File destination=new File(path);
				FileUtils.copyFile(src, destination);
				
				test.get().fail("Below is Screen Shot of Error Page/Pop-up: ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				
			
				//test.get().fail("Below is Screen Shot of Error Page/Pop-up: ", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Screen-capture has been taken but not attached to Extent report");
			}

		}

		
		
		
		/// from conce parth
		/*public synchronized void onTestFailure(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " failed!"));
			test.get().fail(MarkupHelper.createLabel(result.getName()+ " - Test failed due to below issue/error: ", ExtentColor.RED));
			test.get().fail(result.getThrowable());
			
			//Take screenshot and allow automatic saving of media files relative to the report
			try {
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String path=prop.getProperty("Screenshot_Folder")+System.currentTimeMillis()+".png";
				File destination=new File(path);
				FileUtils.copyFile(src, destination);
				test.get().fail("Below is Screen Shot of Error Page/Pop-up: ", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				//assignCategory(result);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Screen-capture has been taken but not attached to Extent report");
				//assignCategory(result);
			}

		}*/
		
		
		////----------from the naveen
		/*public synchronized void onTestFailure(ITestResult result){

			if(result.getStatus()==ITestResult.FAILURE){
				test.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
				test.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report

				String screenshotPath = TestUtility.getScreenshot(driver);
				test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath)); //to add screenshot in extent report
				//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
			}
			else if(result.getStatus()==ITestResult.SKIP){
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS){
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

			}


			extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
			driver.quit();
		}
*/
		
		
		public synchronized void onTestSkipped(ITestResult result) {
			System.out.println((result.getMethod().getMethodName() + " skipped!"));
			test.get().skip(MarkupHelper.createLabel(result.getName()+ " - Test skipped due to below issue/error: ", ExtentColor.AMBER));
			test.get().skip(result.getThrowable());
		}

		
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
		}
		
	/*	private void assignCategory(ITestResult result) {
			if(result.getMethod().getMethodName().contains(Module.ORGANISATION.getName())) {
				categoryAssign(Module.ORGANISATION.getName());
			} else if(result.getMethod().getMethodName().contains(Module.PERSON.getName())) {
				categoryAssign(Module.PERSON.getName());
			} else if(result.getMethod().getMethodName().contains(Module.ACCOUNT.getName())) {
				categoryAssign(Module.ACCOUNT.getName());
			} else if(result.getMethod().getMethodName().contains(Module.MEMBERSHIPPRO.getName())) {
				categoryAssign(Module.MEMBERSHIPPRO.getName());
			} else if(result.getMethod().getMethodName().contains(Module.DONATIONPRO.getName())) {
				categoryAssign(Module.DONATIONPRO.getName());
			} else if(result.getMethod().getMethodName().contains(Module.PRODUCT.getName())) {
				categoryAssign(Module.PRODUCT.getName());
			} else if(result.getMethod().getMethodName().contains(Module.COURSE.getName())) {
				categoryAssign(Module.COURSE.getName());
			} else if(result.getMethod().getMethodName().contains(Module.MEMBERWIZARD.getName())) {
				categoryAssign(Module.MEMBERWIZARD.getName());
			} else if(result.getMethod().getMethodName().contains(Module.EVENT.getName())) {
				categoryAssign(Module.EVENT.getName());
			} else if(result.getMethod().getMethodName().contains(Module.BOOKING.getName())) {
				categoryAssign(Module.BOOKING.getName());
			} else if(result.getMethod().getMethodName().contains(Module.DONATIONWIZARD.getName())) {
				categoryAssign(Module.DONATIONWIZARD.getName());
			} else if(result.getMethod().getMethodName().contains(Module.OPPORTUNITY.getName())) {
				categoryAssign(Module.OPPORTUNITY.getName());
			} else if(result.getMethod().getMethodName().contains(Module.PLEDGE.getName())) {
				categoryAssign(Module.PLEDGE.getName());
			}  else if(result.getMethod().getMethodName().contains(Module.LEGACY.getName())) {
				categoryAssign(Module.LEGACY.getName());
			}else if(result.getMethod().getMethodName().contains(Module.GRANTAPPLICATION.getName())) {
				categoryAssign(Module.GRANTAPPLICATION.getName());
			}else if(result.getMethod().getMethodName().contains(Module.MAJORDONOR.getName())) {
				categoryAssign(Module.MAJORDONOR.getName());
			}else if(result.getMethod().getMethodName().contains(Module.REGULARDONATIONPRO.getName())) {
				categoryAssign(Module.REGULARDONATIONPRO.getName());
			}else if(result.getMethod().getMethodName().contains(Module.REGULARDONATIONWIZ.getName())) {
				categoryAssign(Module.REGULARDONATIONWIZ.getName());
			}else if(result.getMethod().getMethodName().contains(Module.ASSOCIATE.getName())) {
				categoryAssign(Module.ASSOCIATE.getName());
			}else if(result.getMethod().getMethodName().contains(Module.VOLUNTEER.getName())) {
				categoryAssign(Module.VOLUNTEER.getName());
			}	else if(result.getMethod().getMethodName().contains(Module.CERTIFICATE.getName())) {
				categoryAssign(Module.CERTIFICATE.getName());
			}else if(result.getMethod().getMethodName().contains(Module.ELEARNING.getName())) {
				categoryAssign(Module.ELEARNING.getName());
			}else if(result.getMethod().getMethodName().contains(Module.ELEARNINGPORTALLOGINUSER.getName())) {
				categoryAssign(Module.ELEARNINGPORTALLOGINUSER.getName());
					
			}else if(result.getMethod().getMethodName().contains(Module.BOOKINGTERM.getName())) {
				categoryAssign(Module.BOOKINGTERM.getName());
					
			}else if(result.getMethod().getMethodName().contains(Module.ADDBOOKINGTERM.getName())) {
				categoryAssign(Module.ADDBOOKINGTERM.getName());
					
			}else if(result.getMethod().getMethodName().contains(Module.VERIFYBT.getName())) {
				categoryAssign(Module.VERIFYBT.getName());
					
			}else if(result.getMethod().getMethodName().contains(Module.RATEMODIFIER.getName())) {
			categoryAssign(Module.RATEMODIFIER.getName());
				
		}
			else if(result.getMethod().getMethodName().contains(Module.CHARACTERISTIC.getName())) {
				categoryAssign(Module.CHARACTERISTIC.getName());
					
			}
			else if(result.getMethod().getMethodName().contains(Module.DATASET.getName())) {
				categoryAssign(Module.DATASET.getName());
					
			}
		
			
			else {
				categoryAssign("Suite");
			}
		}
*/
}
