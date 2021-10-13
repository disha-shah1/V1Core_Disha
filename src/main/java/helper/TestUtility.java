package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BrowserFactory;



	
	public class TestUtility extends BrowserFactory {

		static Workbook book;
		static Sheet sheet;

		//To read data from Excel sheet
		public static Object[][] getTestData(String sheetName) {
			FileInputStream file = null;
			try {
				file = new FileInputStream(".//TestData//Data.xlsx");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
		
			return data;
		}

		//To take screenshot
		public static String getScreenshot(WebDriver driver)
		{

			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);

			String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";

			File destination=new File(path);

			try 
			{
				FileUtils.copyFile(src, destination);
			} catch (IOException e) 
			{
				System.out.println("Capture Failed "+e.getMessage());
			}

			return path;

		}


		//To get date-time
		public static String getDateTime() {

			// Create object of SimpleDateFormat class and decide the format
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");

			// get current date time with Date()
			Date date = new Date();

			// Now format the date
			String currentDate = dateFormat.format(date);

			//String newDate = currentDate.replace('/', '_');
			//String newCurrentDate = newDate.replace(':', '.');
			return currentDate;

		}


		//To send report in email
		public static void sendEmail() throws EmailException

		{
			try {
				//Create Zip Folder
				CreateZipFileFromMultipleFilesWithZipOutputStream();
				System.out.println("Creating Zip Folder");

				// Create the attachment
				System.out.println("Doing EMail Configuration");
				EmailAttachment attachment = new EmailAttachment();
				attachment.setPath(prop.getProperty("ZipFolders")+"TestOutcomes.zip");
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				attachment.setDescription("Smoke Test Report");
				attachment.setName("TestOutcomes.zip");

				// Create the email message
				MultiPartEmail email = new MultiPartEmail();		
				email.setHostName(prop.getProperty("HostName"));
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator(prop.getProperty("EmailAddress"), prop.getProperty("EmailPassword")));
				email.setSSLOnConnect(true);
				email.addTo(prop.getProperty("EmailToPerson1"));
				email.addTo(prop.getProperty("EmailToPerson2"));
				email.addTo(prop.getProperty("EmailToPerson3"));
				email.addTo(prop.getProperty("EmailToPerson4"));
				email.addTo(prop.getProperty("EmailToPerson5"));
				email.setFrom(prop.getProperty("EmailFrom"),prop.getProperty("Sender"));
				email.setSubject("V1 Core (Smart Portal) Smoke Test Report");
				email.setMsg("V1 Core (Smart Portal) Smoke Test Report is attached with this email");

				// add the attachment
				email.attach(attachment);

				// send the email
				email.send();

				System.out.println("Email sent");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		//Create Zip Folder of report and screenshot for attachment
		public static void CreateZipFileFromMultipleFilesWithZipOutputStream() {
			String zipFile = prop.getProperty("ZipFolders")+"TestOutcomes.zip";
			String srcDir = prop.getProperty("ExtentReport_Folder");

			try {
				FileOutputStream fos = new FileOutputStream(zipFile);
				ZipOutputStream zos = new ZipOutputStream(fos);
				File srcFile = new File(srcDir);
				addDirToArchive(zos, srcFile);

				// close the ZipOutputStream
				zos.close();
			}
			catch (IOException ioe) {
				System.out.println("Error creating zip file: " + ioe);
			}
		}

		private static void addDirToArchive(ZipOutputStream zos, File srcFile) {
			File[] files = srcFile.listFiles();
			System.out.println("Adding directory: " + srcFile.getName());
			for (int i = 0; i < files.length; i++) {
				// if the file is directory, use recursion
				if (files[i].isDirectory()) {
					addDirToArchive(zos, files[i]);
					continue;
				}
				try {
					System.out.println("Adding file: " + files[i].getName());
					// create byte buffer
					byte[] buffer = new byte[1024];
					FileInputStream fis = new FileInputStream(files[i]);
					zos.putNextEntry(new ZipEntry(files[i].getName()));
					int length;
					while ((length = fis.read(buffer)) > 0) {
						zos.write(buffer, 0, length);
					}
					zos.closeEntry();

					// close the InputStream
					fis.close();
				} catch (IOException ioe) {
					System.out.println("IOException :" + ioe);
				}
			}
		}


		//Delete files and sub-folder but not the Directory
		public static void deleteFilesAndSubFoldersNotTheDirectory() {
			File zipDir = new File(prop.getProperty("ZipFolders"));
			File srcDir = new File(prop.getProperty("ExtentReport_Folder"));
			if(zipDir.exists() && srcDir.exists()) {
				try {
					FileUtils.cleanDirectory(zipDir); 
					FileUtils.cleanDirectory(srcDir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Files and Subfolder has been deleted");
			}
			else
			{
				System.out.println("Directory is empty");
			}
		}


		//Create Screen-shot Directory
		public static void createScreenShotsDirectory() {

			File file = new File(prop.getProperty("Screenshot_Folder"));
			if (!file.exists()) {
				if (file.mkdir()) {
					System.out.println("Screenshot Directory has been created!");
				} else {
					System.out.println("Failed to create Screenshot directory!");
				}
			}
		}



		//Separate value from String which has digits and return digits
		public static String getNumericValueOfString(String string)
		{
			String str = string.trim();
			String RecordID="";
			for (int i = 0; i < str.length(); i++) {
				char chrs = str.charAt(i);              
				if (Character.isDigit(chrs))
					RecordID = RecordID+chrs;
			}
			return RecordID;
		}


		//Separate value of ID from String
		public static String getRecordID(String string){
			String subString = string.substring(string.length()-10,string.length());
			System.out.println("Substring value is: "+subString);
			String[] str = subString.split("\\?id=");
			String IDstr = str[str.length - 1];
			return getNumericValueOfString(IDstr);
		}

		
	
}
