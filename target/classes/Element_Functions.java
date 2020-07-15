package resources;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element_Functions {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Element_Functions(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		// TODO Auto-generated constructor stub
	}
	
	public WebElement get_Element(By path, int waittime) throws InterruptedException {
		Thread.sleep(waittime);				
		wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		wait.until(ExpectedConditions.elementToBeClickable(path));
		return driver.findElement(path);
	}
	
	public void get_JSClick(By path, int waittime) throws InterruptedException {
		Thread.sleep(waittime);				
		wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		//wait.until(ExpectedConditions.elementToBeClickable(path));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement element = driver.findElement(path);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		   try { Thread.sleep(1000); }
		   catch (InterruptedException ie) { ; /* ignore */ }
		//driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}
	
	public WebElement get_ListElement(By path, int waittime) throws InterruptedException {
		//Thread.sleep(waittime);
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		fwait.until(ExpectedConditions.stalenessOf(driver.findElement(path)));
		//wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		//wait.until(ExpectedConditions.elementToBeClickable(path));
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver.findElement(path);
	}
	
	public WebElement get_Element_woCl(By path, int waittime) throws InterruptedException {
		Thread.sleep(waittime);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver.findElement(path);
	}
	
	public WebElement get_DropDown_Value(String value, String name, int waittime) throws InterruptedException {
		Thread.sleep(waittime);
		By Land_List_Element = null;
		for(int i=7; i<16; i++) {
			if (driver.findElements(By.xpath("/html/body/div["+i+"]/div/ul/li["+value+"]/a")).size() > 0) {
				if (driver.findElement(By.xpath("/html/body/div["+i+"]/div/ul/li["+value+"]/a")).getText().equals(name)) {
					Land_List_Element = By.xpath("/html/body/div["+i+"]/div/ul/li["+value+"]/a");
					break;
				}
			}
		}
		return driver.findElement(Land_List_Element);
	}
	
	public WebElement get_Account_Dropdown(String AccountElements, String AccountName, int waittime) {
		By Account_List_Element = null;
		for (int i=1; i<driver.findElements(By.xpath(AccountElements)).size(); i++) {
			if (driver.findElement(By.xpath(AccountElements+"["+i+"]/a/div[2]/div[1]")).getText().equals(AccountName)) {
				Account_List_Element = By.xpath(AccountElements+"["+i+"]/a");
				break;
			}
		}
			
		return driver.findElement(Account_List_Element);
	}
	
	public boolean check_Element (By path, int waittime) throws InterruptedException {
		Thread.sleep(waittime);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		//wait.until(ExpectedConditions.elementToBeClickable(path));
		wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		boolean elemnt_Exist = false;
		if (driver.findElements(path).size() > 0) {
			elemnt_Exist = true;
		}
		return elemnt_Exist;
	}
	
	public boolean visible_Element (By path, int waittime) throws InterruptedException {
		Thread.sleep(waittime);
		boolean element_Visible = false;
		if (driver.findElement(path).isDisplayed()) {
			element_Visible = true;
		}
		return element_Visible;
	}
	
	public String C4SaddDate(String date) throws InterruptedException {
		Thread.sleep(1000);
		String[] arrOfStr = date.split("\\.");
		String day = arrOfStr[0];
		String month = arrOfStr[1];
		String year = arrOfStr[2];
		
		
		By Next = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/a[2]/span");
		By CalendarYear = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/div/span[2]");
		By CalendarMonth = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/div/span[1]");
		
		while (!year.equals(driver.findElement(CalendarYear).getText()) || !month.equals(driver.findElement(CalendarMonth).getText()) ) {
			//driver.findElement(Next).click();
			((JavascriptExecutor) driver).executeScript("return arguments[0].click();", driver.findElement(Next));
			Thread.sleep(100);
		}
		
		//for (int i=1; i<7; i++) {
		//	for (int j=1;j<8;j++) {
		//		if (driver.findElements(By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/table/tbody/tr["+i+"]/td["+j+"]/a")).size() > 0) {
		//			if (driver.findElement(By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/table/tbody/tr["+i+"]/td["+j+"]/a")).getText().equals(day)) {
		//				driver.findElement(By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/table/tbody/tr["+i+"]/td["+j+"]/a")).click();
		//				break;
		//			}
		//		}
		//	}
		//}
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", driver.findElement(By.xpath("//a[.='"+ day +"']")));
		//driver.findElement(By.xpath("//a[.='"+ day +"']")).click();
		return year + "--" + month + "--" + day;
	}
	
	public int frameElementCount(By path, String tagName) throws InterruptedException {
		Thread.sleep(8000);
		WebElement parentUL = driver.findElement(path);
		int count = parentUL.findElements(By.tagName(tagName)).size();
		
		return count;
	}
	
	public int elementCount(By path, String tagName) throws InterruptedException {
		Thread.sleep(2000);
		//WebElement parentUL = driver.findElement(path);
		int count = driver.findElements(By.tagName(tagName)).size();
		
		return count;		
	}
	
	public boolean elementExist(By path, int waittime) throws InterruptedException {
		Thread.sleep(waittime);
		boolean exist = false;
		int i = driver.findElements(path).size();
		if (i>0) {
			exist = true;
		}
		return exist;
	}
	
	public List<WebElement> get_List_Element(By path, String tagName) throws InterruptedException {
		Thread.sleep(500);
		WebElement parentUL = driver.findElement(path);
		List<WebElement> List_Type_Elements = parentUL.findElements(By.tagName(tagName));
		return List_Type_Elements;
	}
	
	public String cutting(String data, String direction, int size ) {
		
		String str = "";
		if (data != null && data.length() > 0 ) {
			if (direction.equals("R")) {
				str = data.substring(0, data.length() - size);
			}
			if (direction.equals("L")) {
				str = data.substring(size);
			}
			
		}
		return str;
	}
	
	public String rounding(String data) {
		data = data.replaceAll("[^\\d.,-]", "");
		int lenght = data.length();
		if (data.charAt(lenght-3) == '.') {
			data = data.replaceAll("[^\\d.-]", "");
		} else {
			data = data.replaceAll("[^\\d,-]", "");
			data = data.replace(",", ".");
		}
		
		//data = data.replace(",", ".");
		double dnum = Double.parseDouble(data);
		int inum = (int) Math.round(dnum);
		String str = String.valueOf(inum);		
		return str;
	}
	
	public String getCommaString(String data) {
		data = data.replaceAll("[^\\d.,-]", "");
		int lenght = data.length();
		if (data.charAt(lenght-3) == '.') {
			data = data.replaceAll("[^\\d.-]", "");
		} else {
			data = data.replaceAll("[^\\d,-]", "");
			data = data.replace(",", ".");
		}	
		return data;
	}
	/*
	public String roundingwithKomma(String data) {
		
		data = data.replaceAll("[^\\d,]", "");
		data = data.replace(",", ".");
		double dnum = Double.parseDouble(data);
		int inum = (int) Math.round(dnum);
		String str = String.valueOf(inum);		
		return str;
	}
	*/
	public WebElement get_Body(int waittime) throws InterruptedException {

		Thread.sleep(waittime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("html")));
		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("html")));
		return driver.findElement(By.tagName("html"));
	}
	
}
