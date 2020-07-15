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


public class login_new {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public String parentid;
	public String childid;

	private static Logger Log = LogManager.getLogger();

	public WebDriver get_Login(WebDriver driver, WebDriverWait wait, String user, String pass, String language, String environment, String testuser) throws InterruptedException {
			this.driver = driver;
			this.wait = wait;
			Boolean DEV = false;
			//String testuser = "salesrep.test01@man.eu.esmuat";
			if (environment.equals("DEV")) {
				DEV = true;
				//testuser = "test2.salesrep@man-esm.eu.esmdev";
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
			
			this.parentid = driver.getWindowHandle();
			
			switch (testuser) {
				case "Test01Salesrep": {
					ef.get_Element(lp.Test01Salesrep, 6000).click();
					break;
				}
				case "Test02Salesrep": {
					ef.get_Element(lp.Test02Salesrep, 6000).click();
					break;
				}
				case "Test03Salesrep": {
					ef.get_Element(lp.Test03Salesrep, 6000).click();
					break;
				}
				case "Test05Salesrep": {
					ef.get_Element(lp.Test05Salesrep, 6000).click();
					break;
				}
				case "Test01Admin": {
					ef.get_Element(lp.Test01SalesAdmin, 6000).click();
					break;
				}
				case "Tiemann Test01": {
					ef.get_Element(lp.TiemannTest01, 6000).click();
					break;
				}
			}

			/*
			Set<String>ids=driver.getWindowHandles();
			Iterator<String> it=ids.iterator();
			this.parentid=it.next();
			//it.next();
			this.childid=it.next();
			driver.switchTo().window(this.childid);
			*/
			
						
			for (String childWindowHandle : driver.getWindowHandles()) {
				  //If window handle is not main window handle then close it 
				  if(!childWindowHandle.equals(this.parentid)){
					  this.childid = childWindowHandle;
					  driver.switchTo().window(this.childid);
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
	
	public WebDriver changeLogin(WebDriver driver, WebDriverWait wait, String testuser) throws InterruptedException {
		
		this.driver = driver;
		this.wait = wait;
		
		Actions a= new Actions(driver);
		MainPage mp = new MainPage();
		LandingPage lp = new LandingPage();
		Element_Functions ef = new Element_Functions(driver, wait);
		
		//ef.get_Element(mp.Logout, 3000).click();
		a.moveToElement(ef.get_Element(mp.LogOutAs("E"), 5000)).click().build().perform();
		Thread.sleep(8000);
		driver.close();
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		this.parentid=it.next();
		
		driver.switchTo().window(this.parentid);
		
		//if (!ef.elementExist(lp.Test01Salesrep, 6000)) {
			
		//	a.moveToElement(ef.get_Element(mp.Home("D"), 3000)).click().build().perform();
		//}

		
		switch (testuser) {
		case "Test01Salesrep" :
			ef.get_Element(lp.Test01Salesrep, 6000).click();
			break;
		case "Test03Salesrep": {
			ef.get_Element(lp.Test03Salesrep, 6000).click();
			break;
		}
		case "Test05Salesrep" :
			ef.get_Element(lp.Test05Salesrep, 6000).click();
			break;
		case "Test01SalesSupport" :
			ef.get_Element(lp.Test01SalesSupport, 6000).click();
			break;
		case "Test01SalesAdmin" :
			ef.get_Element(lp.Test01SalesAdmin, 6000).click();
			break;
		case "Test01SalesManager" :
			ef.get_Element(lp.Test01SalesManager, 6000).click();
			break;
		case "Test05SalesManager" :
			ef.get_Element(lp.Test05SalesManager, 6000).click();
			break;
		}
		
		
		ids=driver.getWindowHandles();
		it=ids.iterator();
		this.parentid=it.next();
		//it.next();
		this.childid=it.next();
		driver.switchTo().window(this.childid);
		
		return driver;
	}
	
	public WebDriver logOut(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		
		this.driver = driver;
		this.wait = wait;
		
		Actions a= new Actions(driver);
		MainPage mp = new MainPage();
		LandingPage lp = new LandingPage();
		Element_Functions ef = new Element_Functions(driver, wait);
		
		//ef.get_Element(mp.Logout, 3000).click();
		a.moveToElement(ef.get_Element(mp.LogOutAs("E"), 3000)).click().build().perform();
		driver.close();
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		//it.next();
		this.parentid=it.next();
		driver.switchTo().window(this.parentid);
		return driver;
	}
	
public WebDriver logOutOldWay(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		
		this.driver = driver;
		this.wait = wait;
		
		Actions a= new Actions(driver);
		MainPage mp = new MainPage();
		LandingPage lp = new LandingPage();
		Element_Functions ef = new Element_Functions(driver, wait);
		
		ef.get_JSClick(mp.User("E"), 0);
		ef.get_JSClick(mp.Logout, 0);

		return driver;
	}
	
	public WebDriver simple_Login(WebDriver driver, WebDriverWait wait, String user, String pass) throws InterruptedException {
		this.driver = driver;
		this.wait = wait;
		Boolean DEV = false;
		
		Actions a= new Actions(driver);
		LandingPage lp = new LandingPage();
		MainPage mp = new MainPage();
		SetupPage sp = new SetupPage();
		Element_Functions ef = new Element_Functions(driver, wait);
		ef.get_Element(lp.username, 200).click();
		ef.get_Element(lp.username, 200).sendKeys(user);
		ef.get_Element(lp.password, 200).click();
		ef.get_Element(lp.password, 200).sendKeys(pass);
		ef.get_Element(lp.login, 200).click();
		return driver;
}
	
}
