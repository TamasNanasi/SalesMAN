package resources;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LandingPage;
import pageObjects.MainPage;
import pageObjects.SetupPage;


public class login {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public String parentid;
	public String childid;
	private static Logger Log = LogManager.getLogger();

	public WebDriver get_Login(WebDriver driver, WebDriverWait wait, String user, String pass, String language, String environment) throws InterruptedException {
			this.driver = driver;
			this.wait = wait;
			Boolean DEV = false;
			String testuser = "salesrep.test01@man.eu.esmuat";
			if (environment.equals("DEV")) {
				DEV = true;
				testuser = "test4.salesrep@man-esm.eu.esmdev";
			}
			
			Actions a= new Actions(driver);
			LandingPage lp = new LandingPage();
			MainPage mp = new MainPage();
			SetupPage sp = new SetupPage();
			//SetupPage sp = new SetupPage(driver, wait);
			Element_Functions ef = new Element_Functions(driver, wait);
			ef.get_Element(lp.username, 200).click();
			ef.get_Element(lp.username, 200).sendKeys(user);
			ef.get_Element(lp.password, 200).click();
			ef.get_Element(lp.password, 200).sendKeys(pass);
			ef.get_Element(lp.login, 200).click();
			ef.get_Element(mp.Setup, 6000).click();
			//mp.get_Element(mp.Setup, 6000).click();
			a.moveToElement(ef.get_Element(mp.Setup_in, 500)).click().build().perform();
			Set<String>ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
			//String parentid=it.next();
			it.next();
			String childid=it.next();
			driver.switchTo().window(childid);
			if (DEV) {
				ef.get_Element(sp.DEVUsers, 3000).click();
				//sp.get_Element(sp.DEVUsers_Users, 2000).click();
				ef.get_Element(sp.DEVUsers_Users, 3000).click();
				//sp.get_Element(sp.DEVUsers_Users, 2000).click();
			} else {
				ef.get_Element(sp.Users, 3000).click();
				//sp.get_Element(sp.Users_Users, 2000).click();
				ef.get_Element(sp.Users_Users, 3000).click();
				//sp.get_Element(sp.Users_Users, 2000).click();
			}
			int frameCount = ef.frameElementCount(sp.SetupFrames, "iframe");
			//Log.info("Framecount: "+frameCount);
			for(int i=0;i<frameCount;i++) {
				//Log.info("Switch to Frame: "+i);
				driver.switchTo().frame(i);
				if (DEV) {
					ef.get_Element(sp.SUsers, 2000).click();
				} else {
					ef.get_Element(sp.TUsers, 2000).click();
				}
				Thread.sleep(2000);
				driver.switchTo().frame(i);
				int k = ef.elementCount(sp.UserTable, "table");
				//Log.info("Count of Table: "+k);
				
				if (k > 0) {
					//Log.info("Count of Table: "+k);
					List<WebElement> User_List = ef.get_List_Element(sp.UserTable, "tr");
					//List<WebElement> User_List = sp.get_List_Element();
					//Log.info("Count of Users: "+User_List.size());
					By by;
					for (int j = 2; j <= User_List.size(); j++) {
						by = By.xpath("/html/body/div[5]/div/form/div[2]/table/tbody/tr["+j+"]/td[3]/a");
						//Log.info("User: "+sp.get_Element(by, 0).getText());
						if (ef.get_Element(by, 0).getText().equals(testuser)) {
							//Log.info("User finded: "+j);
							ef.get_Element(By.xpath("/html/body/div[5]/div/form/div[2]/table/tbody/tr["+j+"]/td[1]/a[2]"), 0).click();
							break;
						} else {
							//Log.info("User NOT finded: "+j);
						}
					}
					//break;
				}
			}
			if (!language.equals("")) {
				ef.get_Element(mp.Profil, 3000).click();
				a.moveToElement(ef.get_Element(mp.Profil_Setup, 100)).click().build().perform();
				Log.info("Feldname: "+ef.get_Element(sp.Language, 1000).getText());
				if (ef.get_Element(sp.Language, 1000).getText().equals("Reset My Security Token")) {
					ef.get_Element(sp.LanguageEnglish, 100).click();
				} else {
					ef.get_Element(sp.Language, 100).click();
				}
				int frameCount1 = ef.frameElementCount(sp.SettingsFrames, "iframe");
				Log.info("Framecount: "+frameCount1);
				for(int i=0;i<frameCount1;i++) {
					Log.info("Switch to Frame: "+i);
					driver.switchTo().frame(i+1);
					ef.get_Element(sp.LanguageTableFind, 500).click();
					int k = ef.elementCount(sp.LanguageTableFind, "table");
					Log.info("Count of Table: "+k);
					if (k > 0) {
						Select lang = new Select(ef.get_Element(sp.LanguageSelect, 500));
						if (language.equals("deutsch")) {
							lang.selectByIndex(1);
						} else {
							lang.selectByIndex(0);
						}
						ef.get_Element(sp.LanguageSave, 100).click();
						driver.switchTo().defaultContent();
					}
				}
			}
		return driver;
	}
	
	public WebDriver prod_Login(WebDriver driver, WebDriverWait wait, boolean admin, String user) throws InterruptedException {
		this.driver = driver;
		this.wait = wait;
		Boolean DEV = false;
		String testuser = "salesrep.test01@man.eu.esmuat";
		
		Actions a= new Actions(driver);
		LandingPage lp = new LandingPage();
		MainPage mp = new MainPage();
		SetupPage sp = new SetupPage();
		//SetupPage sp = new SetupPage(driver, wait);
		Element_Functions ef = new Element_Functions(driver, wait);
		if (ef.elementExist(mp.Finish(), 4000)) {
			ef.get_Element(mp.Finish(), 200).click();
		}
		if (ef.elementExist(mp.MANLoginText, 5000)) {
			ef.get_Element(mp.MANLoginInput, 200).sendKeys("tamas.nanasi-ext@man.eu");
			ef.get_Element(mp.MANLoginNext, 200).click();
			int count = 0;
			while ((!ef.elementExist(mp.MANLoginMessage, 0) & count < 20)) {
				count++;
				Thread.sleep(500);
			}
			ef.get_Element(mp.MANLoginPassword, 200).sendKeys("64Tomika09");
			ef.get_Element(mp.MANLoginSignIn, 200).click();
			while ((!ef.elementExist(mp.MANKmsiDescription, 0) & count < 20)) {
				count++;
				Thread.sleep(2000);
			}
			ef.get_Element(mp.MANYes, 200).click();
		}
		if (ef.elementExist(mp.MANPickanaccount, 5000)) {
			ef.get_Element(mp.MANEmail, 200).click();
			int count = 0;
			while ((!ef.elementExist(mp.MANLoginMessage, 0) & count < 20)) {
				count++;
				Thread.sleep(500);
			}
			ef.get_Element(mp.MANLoginPassword, 200).sendKeys("64Tomika09");
			ef.get_Element(mp.MANLoginSignIn, 200).click();
			while ((!ef.elementExist(mp.MANKmsiDescription, 0) & count < 20)) {
				count++;
				Thread.sleep(2000);
			}
			ef.get_Element(mp.MANYes, 200).click();
		}
		
		//ef.get_Element(mp.Setup, 10000).click();
		ef.get_JSClick(mp.SetupNew, 3000);
		//a.moveToElement(ef.get_Element(mp.Setup_in, 500)).click().build().perform();
		ef.get_JSClick(mp.Setup_inNew, 0);
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		//String parentid=it.next();
		it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
	
		ef.get_Element(sp.ProdUsers, 3000).click();
		ef.get_Element(sp.ProdUsers_Users, 2000).click();

		int frameCount = ef.frameElementCount(sp.SetupFrames, "iframe");
		//Log.info("Framecount: "+frameCount);
		for(int i=0;i<frameCount;i++) {
			//Log.info("Switch to Frame: "+i);
			driver.switchTo().frame(i);
			if (admin) {
				ef.get_Element(sp.AUsers, 1000).click();
			} else {
				ef.get_Element(sp.VUsers, 1000).click();
			}
			//Thread.sleep(2000);
			driver.switchTo().defaultContent();
			int frameCountnew = ef.frameElementCount(sp.SetupFrames, "iframe");
			for(int k=0;k<frameCountnew;k++) {
				//System.out.println("Frame: "+k);
				driver.switchTo().frame(k);
			//Log.info("Count of Table: "+k);
			if (admin) {
				if (ef.elementExist(sp.Admin, 2000)) {
					//Log.info("Count of Table: "+k);
					ef.get_Element(sp.AdminLogin, 200).click();
					driver.switchTo().defaultContent();
				}
			} else {
				if (ef.elementExist(sp.userSearch(user), 2000)) {
					//Log.info("Count of Table: "+k);
					ef.get_Element(sp.userLoginSearch(user), 200).click();
					driver.switchTo().defaultContent();
				}
			}
			}
		}
		return driver;
}
	
	public WebDriver simple_Login(WebDriver driver, WebDriverWait wait, String user, String pass, String language, String environment) throws InterruptedException {
		this.driver = driver;
		this.wait = wait;
		
		LandingPage lp = new LandingPage();
		//SetupPage sp = new SetupPage(driver, wait);
		Element_Functions ef = new Element_Functions(driver, wait);
		ef.get_Element(lp.username, 200).click();
		ef.get_Element(lp.username, 200).sendKeys(user);
		ef.get_Element(lp.password, 200).click();
		ef.get_Element(lp.password, 200).sendKeys(pass);
		ef.get_Element(lp.login, 200).click();
		
		return driver;
	}
	
public WebDriver reLogin(WebDriver driver, WebDriverWait wait, String testuser, String language, String environment) throws InterruptedException {
		
		this.driver = driver;
		this.wait = wait;
		
		Actions a= new Actions(driver);
		LandingPage lp = new LandingPage();
		MainPage mp = new MainPage();
		SetupPage sp = new SetupPage();
		Element_Functions ef = new Element_Functions(driver, wait);
		
		ef.get_Element(mp.Logout, 3000).click();
		driver.close();
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		this.parentid=it.next();		
		driver.switchTo().window(this.parentid);
		
		ef.get_Element(mp.Setup, 3000).click();
		a.moveToElement(ef.get_Element(mp.Setup_in, 500)).click().build().perform();
		
		ids=driver.getWindowHandles();
		it=ids.iterator();
		this.parentid=it.next();
		//it.next();
		this.childid=it.next();
		driver.switchTo().window(this.childid);

		
			ef.get_Element(sp.DEVUsers, 3000).click();
			//sp.get_Element(sp.DEVUsers_Users, 2000).click();
			ef.get_Element(sp.DEVUsers_Users, 3000).click();
			//sp.get_Element(sp.DEVUsers_Users, 2000).click();
		int frameCount = ef.frameElementCount(sp.SetupFrames, "iframe");
		//Log.info("Framecount: "+frameCount);
		for(int i=0;i<frameCount;i++) {
			//Log.info("Switch to Frame: "+i);
			driver.switchTo().frame(i);

			ef.get_Element(sp.SUsers, 2000).click();

			Thread.sleep(2000);
			driver.switchTo().frame(i);
			int k = ef.elementCount(sp.UserTable, "table");
			//Log.info("Count of Table: "+k);
			
			if (k > 0) {
				//Log.info("Count of Table: "+k);
				List<WebElement> User_List = ef.get_List_Element(sp.UserTable, "tr");
				//List<WebElement> User_List = sp.get_List_Element();
				//Log.info("Count of Users: "+User_List.size());
				By by;
				for (int j = 2; j <= User_List.size(); j++) {
					by = By.xpath("/html/body/div[5]/div/form/div[2]/table/tbody/tr["+j+"]/td[3]/a");
					//Log.info("User: "+sp.get_Element(by, 0).getText());
					if (ef.get_Element(by, 0).getText().equals(testuser)) {
						//Log.info("User finded: "+j);
						ef.get_Element(By.xpath("/html/body/div[5]/div/form/div[2]/table/tbody/tr["+j+"]/td[1]/a[2]"), 0).click();
						break;
					} else {
						//Log.info("User NOT finded: "+j);
					}
				}
				//break;
			}
		}
		
		
		ids=driver.getWindowHandles();
		it=ids.iterator();
		this.parentid=it.next();
		//it.next();
		this.childid=it.next();
		driver.switchTo().window(this.childid);
		
		return driver;
	}
	
}
