package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class base {
	public static WebDriver driver;
	public static Properties prop;
	public static Properties prop_ddl;
	public static String ConfigFilePath = null;
	public static String Screenshot_Path = null;
	public static String runTime_Path = null;
	public static String Excel_Data_Path = null;
	public static String log4j = null;
	public static String pathToLog = null;
	public static String company = "cap";
	//public String company = "man";
	
	public WebDriver initializeDriver() throws IOException
	{
		FileInputStream fis = null, fisddl = null;
		String fis_Path = null, fisddl_Path = null, Profile_Path = null, cromeDriver_Path = null, firefoxDriver_Path = null;
			//ConfigFilePath = "D:\\Users\\tnanasi\\Downloads\\";
			fis_Path = "src/main/java/resources/data.properties";
			log4j = "src/main/java/resources/log4j.properties";
			fisddl_Path = "src/main/java/resources/dropDown.properties";
			Profile_Path = "folders/profile";
			cromeDriver_Path = "folders/chromedriver.exe";
			firefoxDriver_Path = "folders/geckodriver.exe";
			Screenshot_Path = "folders/screens";
			runTime_Path = "src/main/java/resources/run.properties";
			//Excel_Data_Path = "D:\\TA\\SalesForce\\Testdata.xlsx";
			Excel_Data_Path = "folders/Testdata.xlsx";
			//pathToLog = "D:\\TA\\SalesForce\\Testdaten\\";

		fis = new FileInputStream(fis_Path);
		fisddl = new FileInputStream(fisddl_Path);
		prop = new Properties();
		prop.load(fis);
		prop_ddl = new Properties();
		prop_ddl.load(fisddl);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			/* Storing the Chrome Profile Path in Chrome_Profile_Path variable. */
			String Chrome_Profile_Path = Profile_Path;

			/* Creating an instance of ChromeOptions (i.e objChrome_Profile) */
			ChromeOptions Chrome_Profile = new ChromeOptions();

			//int size = 4096;
			//Chrome_Profile.addArguments("disk-cache-size" + size);
			Chrome_Profile.addArguments("--disable-application-cache");
			/* Disabling the chrome browser extensions */
			Chrome_Profile.addArguments("chrome.switches","--disable-extensions"); 

			/* Adding Chrome profile by .addArguments to objChrome_Profile  */
			Chrome_Profile.addArguments("user-data-dir=" + Chrome_Profile_Path);
			
			//Chrome_Profile.addArguments("applicationCacheEnabled" + false);
			
			System.setProperty("webdriver.chrome.driver",cromeDriver_Path);
			driver = new ChromeDriver(Chrome_Profile);
		}

		if(browserName.equals("firefox")) {
			//System.setProperty("webdriver.firefox.marionette",firefoxDriver_Path);
			System.setProperty("webdriver.gecko.driver",firefoxDriver_Path);
			driver = new FirefoxDriver();
		}

		if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", firefoxDriver_Path);
			driver = new InternetExplorerDriver();
		}
		
		if(browserName.equals("BS_Chrome")) {
			
			DesiredCapabilities caps = new DesiredCapabilities();
			final String USERNAME = "tamsnnsi1";
			final String AUTOMATE_KEY = "zN4tpsrqgLvRtA5CrMet";
			final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "80");
			caps.setCapability("resolution", "1920x1080");
			caps.setCapability("name", "tamsnnsi1's First Test");
			driver = new RemoteWebDriver(new URL(URL), caps);
		}
		
		if(browserName.equals("BS_Firefox")) {
			
			DesiredCapabilities capsf = new DesiredCapabilities();
			final String USERNAME = "tamsnnsi1";
			final String AUTOMATE_KEY = "zN4tpsrqgLvRtA5CrMet";
			final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		    capsf.setCapability("browser", "Firefox");
		    capsf.setCapability("browser_version", "77.0");
		    capsf.setCapability("os", "Windows");
		    capsf.setCapability("os_version", "10");
		    capsf.setCapability("resolution", "1920x1080");
		    capsf.setCapability("name", "tamsnnsi1's First Test");
			driver = new RemoteWebDriver(new URL(URL), capsf);
		}
		
if(browserName.equals("PL_Firefox")) {
			
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(
		new URL("http://selenium-hub-core:4444/wd/hub"), capability);
    	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(Screenshot_Path+result+"screenshot.png"));
	}
	
	public static String getDateString() {
		
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");  
        String strDate = dateFormat.format(date);  
		return strDate;
	}
	
	public static String getFutureDateString(int sleep, String dateform, String L) {
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat;
		cal.add(Calendar.DATE, sleep);
		Date date = cal.getTime();
		if (L.equals("D")) {
			dateFormat = new SimpleDateFormat(dateform, Locale.GERMANY);
		} else {
			dateFormat = new SimpleDateFormat(dateform, Locale.ENGLISH);
		}
        
		String strDate = dateFormat.format(date);
		return strDate;
	}
	/*
	public static class DateUtil
	{
	    public static Date addDays(Date date, int days)
	    {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, days); //minus number would decrement the days
	        return cal.getTime();
	    }
	}
	*/
	public static String getSomeFutureDateString(int sleep, String dateform, String date, String L) throws ParseException {
		
		DateFormat format;
		if (L.equals("D")) {
			format = new SimpleDateFormat(dateform, Locale.GERMANY);
		} else {
			format = new SimpleDateFormat(dateform, Locale.ENGLISH);
		}
		Date myDate = format.parse(date);
		myDate = DateUtils.addDays(myDate, sleep);
		String strDate = format.format(myDate);
		return strDate;
	}
	
	public static String getRunTime(String date) {
		String runtime= "";
		try (InputStream input = new FileInputStream(runTime_Path)) {
			
			Properties prop = new Properties();
			prop.load(input);
			if (date.equals(prop.getProperty("Date"))) {
				int newRunInt = Integer.parseInt(prop.getProperty("Runtime"));
				newRunInt++;
				prop.setProperty("Runtime", String.valueOf(newRunInt));
				runtime = String.valueOf(newRunInt);
				
			} else {
				runtime = "0";
				prop.setProperty("Date", date);
				prop.setProperty("Runtime", "1");
			}
			input.close();
			OutputStream output = new FileOutputStream(runTime_Path);
			prop.store(output, null);
			output.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return runtime;
	}
	
	public static String changeLogFilePath(String filename) {

		try (InputStream input = new FileInputStream(log4j)) {
			
			Properties prop = new Properties();
			prop.load(input);
			prop.setProperty("log4j.appender.file.File","${basePath}/prints_2.log");	
			input.close();
			OutputStream output = new FileOutputStream(log4j);
			prop.store(output, null);
			output.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK";
	}
	
	public static String getRandomText() {
		final String DATA_FOR_RANDOM_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
		}
		return sb.toString();
	}
	
	public static FileInputStream openXlsfile(String link) throws FileNotFoundException {
		FileInputStream file = null;
		file = new FileInputStream(new File(link));
		return file;
	}
	
	public static XSSFWorkbook openWorkbook(FileInputStream file) throws IOException {
		XSSFWorkbook workbook = null;
		workbook = new XSSFWorkbook(file);
		return workbook;
	}
	
	public static XSSFSheet openSheet(XSSFWorkbook workbook, int sheet) throws FileNotFoundException {
		XSSFSheet worksheet = null;
		worksheet = workbook.getSheetAt(sheet);
		return worksheet;
    }
	public static String getStringvalue(XSSFSheet sheet, int grow, int gcell) {
		XSSFCell cell = null;
	    cell = sheet.getRow(grow).getCell(gcell);
	    if (cell != null) {
	    	return cell.getStringCellValue();
	    } else {
	    	return null;
	    }
		
	}
	public static void openXlsfiletoWrite(String link, XSSFWorkbook workbook) throws IOException {
		OutputStream fileOut = new FileOutputStream(link);
		workbook.write(fileOut);
	}
	
	public void closeExcel(FileInputStream file, XSSFWorkbook workbook) throws IOException {
		workbook.close();
		file.close();
	}
}
