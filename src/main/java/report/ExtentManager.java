package report;

import java.io.File;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BrowserFactory;

public class ExtentManager extends BrowserFactory {
	
	private static ExtentReports extent;
	private static Platform platform;
	String reportDir = prop.getProperty("AutomationReport_Folder");
	private String reportFileName = "ExtentReportResults.html";
	private String macPath = reportDir + "/ExtentReports";
	private String windowsPath = reportDir + "\\ExtentReports";
	private String macReportFileLoc = macPath + "/" + reportFileName;
	private String winReportFileLoc = windowsPath + "\\" + reportFileName;

	static String UserName = System.getProperty("user.name");
	static String OSName = System.getProperty("os.name");
	static String OSArch = System.getProperty("os.arch");
	static String OSVersion = System.getProperty("os.version");	
	static String JavaVersion = System.getProperty("java.version");
	
	public ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	//Create an extent report instance
	public static ExtentReports createInstance() {

		platform = getCurrentPlatform();
		ExtentManager em = new ExtentManager();
		String fileName = em.getReportFileLocation(platform);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("V1 Core (Smart Portal) Smoke Test Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("V1 Core (Smart Portal) Smoke Test Report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS Name", OSName);
		extent.setSystemInfo("OS Arch", OSArch);
		extent.setSystemInfo("OS Version", OSVersion);
		extent.setSystemInfo("Environment", "V1 Core (Smart Portal) QA Environment");
		extent.setSystemInfo("User Name", UserName);
		//extent.setSystemInfo("Browser Name", "Chrome");
		extent.setSystemInfo("Browser Name", prop.getProperty("Browser"));
		extent.setSystemInfo("Java Version",JavaVersion);		
		return extent;
	}

	//Select the extent report file location based on platform
	private String getReportFileLocation (Platform platform) {
		String reportFileLocation = null;
		switch (platform) {
		case MAC:
			reportFileLocation = macReportFileLoc;
			createReportPath(macPath);
			System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
			break;
		case WINDOWS:
			reportFileLocation = winReportFileLoc;
			createReportPath(windowsPath);
			System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
			break;
		default:
			System.out.println("ExtentReport path has not been set! There is a problem!\n");
			break;
		}
		return reportFileLocation;
	}

	//Create the report path if it does not exist
	private void createReportPath (String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!" );
			} else {
				System.out.println("Failed to create directory: " + path);
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
	}

	//Get current platform
	private static Platform getCurrentPlatform () {
		if (platform == null) {
			String operSys = System.getProperty("os.name").toLowerCase();
			if (operSys.contains("win")) {
				platform = Platform.WINDOWS;
			} else if (operSys.contains("nix") || operSys.contains("nux")
					|| operSys.contains("aix")) {
				platform = Platform.LINUX;
			} else if (operSys.contains("mac")) {
				platform = Platform.MAC;
			}
		}
		return platform;
	}


}
