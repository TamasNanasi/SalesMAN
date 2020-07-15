package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public By getLanguage(String name) {
		//return By.xpath("//a[.='"+name+"']/span");
		return By.xpath("//one-app-nav-bar-item-root/a/span[.='"+name+"']");
	}
	
	public By notificationSearch(String name) {
		//span[contains(text(),'NSHPFQDS')]
		return By.xpath("//span[contains(text(),'"+ name +"')]");
	}
	
	public By searchElementSearch(String id, String name, String element) {
		//span[contains(text(),'NSHPFQDS')]
		return By.xpath("(//span[(contains(text(),'"+ id +"')) and (contains(text(),'"+ name +"'))]/../../../th/span/a)["+ element +"]");
	}
	
	public By Accounts(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.='Accounts']/..");
		} else {
			return By.xpath("//a[.='Accounts']/..");
		}
	}
	
	public By AccountsNew(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.='Accounts']");
		} else {
			return By.xpath("//a[.='Accounts']");
		}
	}
	
	public By Contacts(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.='Contacts']/..");
		} else {
			return By.xpath("//a[.='Kontakte']/..");
		}
	}
	
	public By Home(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.='Home']/..");
		} else {
			return By.xpath("//a[.='Startseite']/..");
		}
	}
	
	public By Proposals(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.='Proposals']/..");
		} else {
			return By.xpath("//a[.='Angebotes']/..");
		}
	}
	
	public By ProposalsNew(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.='Proposals']");
		} else {
			return By.xpath("//a[.='Angebotes']");
		}
	}
	
	public By ProposalNumber(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-formatted-text[contains(text(), 'V002')]");
		} else {
			return By.xpath("//lightning-formatted-text[contains(text(), 'V002')]");
		}
	}
	
	public By Close(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@title ='Close']");
		} else {
			return By.xpath("//button[@title ='Close']");
		}
	}
	
	public By User(String L) {
		if (L.equals("E")) {
			return By.xpath("//img[@title = 'User']/../../../../..");
		} else {
			return By.xpath("//img[@title = 'User']/../../../../..");
		}
	}
	
	public By LogOut(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[ .= 'Log Out']");
		} else {
			return By.xpath("//a[ .= 'Abmelden']");
		}
	}
	
	public By LogOutAs(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[contains(text(),'Log out as')]");
		} else {
			return By.xpath("//a[contains(text(),'Log out as')]");
		}
	}
	
	public By SetupTab(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[@title = 'Setup']");
		} else {
			return By.xpath("//span[@title = 'Setup']");
		}
	}
	
	public By SchnellSuche(String L) {
		if (L.equals("E")) {
			return By.xpath("//input[@placeholder='Quick Find']");
		} else {
			return By.xpath("//input[@placeholder='Schnellsuche']");
		}
	}
	
	public By BenutzerdefinierteEinstellungen(String L) {
		if (L.equals("E")) {
			return By.xpath("//mark[.='Custom Settings']");
		} else {
			return By.xpath("//mark[.='Benutzerdefinierte Einstellungen']");
		}
	}
	
	public By DialogButton(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@aria-haspopup = 'dialog']");
		} else {
			return By.xpath("//button[@aria-haspopup = 'dialog']");
		}
	}
	
	public By DialogButtonProd(String L) {
		if (L.equals("E")) {
			return By.xpath("//one-app-launcher-header/button[@class = 'slds-button']");
		} else {
			return By.xpath("//one-app-launcher-header/button[@class = 'slds-button']");
		}
	}
	
	public By AlleAnzeigen(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[ .= 'View All']");
		} else {
			return By.xpath("//button[ .= 'Alle anzeigen']");
		}
	}
	
	public By LogMessages(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@data-label= 'Log Messages']");
		} else {
			return By.xpath("//a[@data-label= 'Log Messages']");
		}
	}
	
	public By SelectListView(String L) {
		if (L.equals("E")) {
			return By.xpath("(//a[@title= 'Select List View'])[2]");
		} else {
			return By.xpath("(//a[@title= 'Select List View'])[2]");
		}
	}
	
	public By SelectListViewProd(String L) {
		if (L.equals("E")) {
			return By.xpath("(//a[@title= 'Select List View'])[1]");
		} else {
			return By.xpath("(//a[@title= 'Select List View'])[1]");
		}
	}
	
	public By PrintingLogMessagesToday(String L) {
		if (L.equals("E")) {
			return By.xpath("(//span[ .= 'Printing Log Messages Today'])[1]");
			//return By.xpath("(//span[ .= 'All Log Messages'])[1]");
		} else {
			return By.xpath("(//span[ .= 'Printing Log Messages Today'])[1]");
		}
	}
	
	public By LogSearchField(String L) {
		if (L.equals("E")) {
			return By.xpath("//input[@name='LogMessage__c-search-input']");
		} else {
			return By.xpath("//input[@name='LogMessage__c-search-input']");
		}
	}
	
	public By LogDetails(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Log Message']/../../..//force-record-layout-row[2]//lightning-formatted-text");
		} else {
			return By.xpath("//span[ .= 'Log Message']/../../..//force-record-layout-row[2]//lightning-formatted-text");
		}
	}
	
	public By Finish() {
		//if (L.equals("E")) {
			return By.xpath("//input[@value = 'Finish']");
		//} else {
		//	return By.xpath("//input[@value = 'Finish']");
		//}
	}
	
	//public By Accounts = By.xpath("//a[.='Accounts']/..");
	//public By Accounts = By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[text()='Accounts']]]");
	//public By Home = By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[text()='Startseite']]]");
	//public By Home = By.xpath("/html/body/div[5]/div[1]/section/header/div[3]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[1]/a/span");
	//public By Contacts = By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[text()='Kontakte']]]");
	//public By Contacts = By.xpath("//a[.='Kontakte']/..");
	public By ContactsDev = By.xpath("//a[.='Contacts']/..");
	//public By Proposals = By.xpath(".//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'][a[span[text()='Proposals']]]");
	//public By Proposals = By.xpath("//a[@title ='Proposals']");
	public By Setup = By.xpath("/html/body/div[4]/div[1]/section/header/div[2]/span/div[2]/ul/li[7]");
	public By SetupNew = By.xpath("(//a[@role = 'button'])[2]");
	public By Profil = By.xpath("/html/body/div[5]/div[1]/section/header/div[2]/span/div[2]/ul/li[8]/span/button");
	public By Notification = By.xpath("/html/body/div[4]/div[1]/section/header/div[2]/span/div[2]/ul/li[8]/button");
	public By Setup_in = By.xpath("//li[@id= 'all_setup_home']");
	public By Setup_inNew = By.xpath("//a[@data-id = 'all_setup_home']");
	
	public By Profil_Setup = By.xpath("/html/body/div[5]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/a[1]");
	
	public By Logout = By.xpath("/html/body/div[4]/div[1]/section/header/div[1]/div/a");
	
	public By MANLoginText = By.xpath("//div[ .= 'Sign in']");
	public By MANLoginInput = By.xpath("//input[@name = 'loginfmt']");
	public By MANLoginNext = By.xpath("//input[@value = 'Next']");
	public By MANLoginMessage = By.xpath("//div[@id = 'loginMessage']");
	public By MANLoginPassword = By.xpath("//input[@name = 'Password']");
	public By MANLoginSignIn = By.xpath("//span[@id = 'submitButton']");
	public By MANKmsiDescription = By.xpath("//div[@id='KmsiDescription']");
	public By MANYes = By.xpath("//input[@value='Yes']");
	public By MANPickanaccount = By.xpath("//div[ .= 'Pick an account']");
	public By MANEmail = By.xpath("//div[ .= 'tamas.nanasi-ext@man.eu']");
}	
