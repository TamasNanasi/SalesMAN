package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetupPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public String setup = "/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/";
	//public String Setup_Frames = "/html/body/div[5]/div[1]/div[2]/div[2]/div/div[1]/div/section/div/div[2]/div/div/div/div[2]/div/force-aloha-page/div";
	
	public By Users = By.xpath("/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/li[3]/div/a");
	public By DEVUsers = By.xpath("/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/li[4]/div/a");
	public By ProdUsers = By.xpath("/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/li[6]/div/a");
	public By Users_Users = By.xpath("/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/li[3]/ul/li[7]/div/a");
	public By DEVUsers_Users = By.xpath("/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/li[4]/ul/li[8]/div/a");
	public By ProdUsers_Users = By.xpath("/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/li[6]/ul/li[8]/div/a");
	public By IFrame = By.xpath(setup+"li[3]/ul/li[6]/div/a");
	//public By UserTable = By.xpath("/html/body/div[5]/div/div/table"); /html/body/div[5]/form/div[2]
	public By UserTable = By.xpath("/html/body/div[5]/div/form/div[2]");
	public By UserLogin = By.xpath("/html/body/div[5]/div/form/div[2]/table");
	public By SetupFrames = By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div/div[1]/div/section/div/div[2]/div/div/div/div[2]/div/force-aloha-page/div");
	public By SettingsFrames = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div/force-aloha-page/div");
	public By TUsers = By.xpath("/html/body/div[4]/div/div/a[20]");
	public By SUsers = By.xpath("/html/body/div[4]/div/div/a[19]");
	public By VUsers = By.xpath("/html/body/div[4]/div/div/a[22]");
	public By AUsers = By.xpath("/html/body/div[4]/div/div/a[1]");
	
	//public By Verkaufsbeauftragter = By.xpath("//a[contains(text(), 'Verkaufsbeauftragter')]");
	
	public By userSearch(String name) {
		return By.xpath("//a[contains(text(), '"+ name +"')]");
	}
	
	public By userLoginSearch(String name) {
		return By.xpath("//a[contains(text(), '"+ name +"')]/../../td[1]/a[2]");
	}
	
	public By Admin = By.xpath("//a[contains(text(), 'Admin, System')]");
	//public By VerkaufsbeauftragterLogin = By.xpath("//a[contains(text(), 'Verkaufsbeauftragter')]/../../td[1]/a[2]");
	public By AdminLogin = By.xpath("//a[contains(text(), 'Admin, System')]/../../td[1]/a[2]");
	
	public By Language = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/div[2]/div[1]/div[2]/div/ul/li[1]/ul/li[9]/div/a");
	public By LanguageEnglish = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/div[2]/div[1]/div[2]/div/ul/li[1]/ul/li[6]/div/a");
	
	public By LanguageTableFind = By.xpath("/html/body/form/div/div/div/div[1]/div[2]");
	public By LanguageSelect = By.xpath("/html/body/form/div/div/div/div[1]/div[2]/table/tbody/tr[3]/td[2]/span/div/select");
	public By LanguageSave = By.xpath("/html/body/form/div/div/div/div[2]/table/tbody/tr/td[2]/input[1]");
	public By Verwalten = By.xpath("//a[.= 'C4S Mock Configuration']/../../td[1]/a[3]");
	//public By MockUserSearch = By.xpath("//a[.= 'SalesRep Test03']/../../td[1]/a[2]");
	public By MockUserSearch(String name) {
		return By.xpath("//a[.= '"+ name +"']/../../td[1]/a[2]");
	}
	public By MockMANCode = By.xpath("//label[.= 'Mock MAN Code']/../../td[1]/input");
	//public By Save = By.xpath("//input[@value= 'Speichern']");
	public By Save(String L) {
		if (L.equals("E")) {
	        return By.xpath("//input[@value= 'Save']");
		} else {
			return By.xpath("//input[@value= 'Speichern']");
		}
	}
	
	
}
