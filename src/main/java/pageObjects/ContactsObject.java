package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsObject {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public By contactNameSearch(String name, String L) {
		if (L.equals("E")) {
			//return By.xpath("//h1/div[.= 'Contact']/..//span[(contains(text(), '"+ name +"'))]");
			return By.xpath("(//h1/div[.= 'Contact']/..//force-aura-action-wrapper/div/div/span[1])[(contains(text(), '"+ name +"'))]");
		} else {
			//return By.xpath("//h1/div[.= 'Kontakt']/..//span[(contains(text(), '"+ name +"'))]");
			return By.xpath("(//h1/div[.= 'Kontakt']/..//force-aura-action-wrapper/div/div/span[1])[(contains(text(), '"+ name +"'))]");
		}
	}
	
	public By New(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[contains(@title, 'Neu')]");
		} else {
			return By.xpath("//a[contains(@title, 'New')]");
		}
	}
	
	public By Next(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Next']");
		} else {
			return By.xpath("//span[.='Weiter']");
		}
	}
	
	public By Salutation(String L) {
		if (L.equals("E")) {
			return By.xpath("//span/span[.='Salutation']/../../div/div[1]/div/div/a");
		} else {
			return By.xpath("//span/span[.='Anrede']/../../div/div[1]/div/div/a");
		}
	}
	
	public By LastName(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='Last Name']/../../input");
		} else {
			return By.xpath("//label/span[.='Nachname']/../../input");
		}
	}
	
	public By Telefon(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='Phone']/../../input");
		} else {
			return By.xpath("//label/span[.='Telefon']/../../input");
		}
	}
	
	public By JobFunction(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Job Function']/../../div/div[1]/div/div/a");
		} else {
			return By.xpath("//span[.='Job Funktion']/../../div/div[1]/div/div/a");
		}
	}
	
	public By MainSalesContact(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='Main Sales Contact']/../../input");
		} else {
			return By.xpath("//label/span[.='Hauptansprechpartner Vertrieb']/../../input");
		}
	}
	
	public By Save(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]/span");
		} else {
			return By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]/span");
		}
	}
	
	public By NewOpportunity(String L) {
		if (L.equals("E")) {
			//return By.xpath("//div/one-record-home-flexipage2/forcegenerated-adgrollup_component___forcegenerated__flexipage_recordpage___contact_record_page___contact___view/forcegenerated-flexipage_contact_record_page_contact__view_js/record_flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout//a[@title = 'New Opportunity']");
			return By.xpath("//a[@title = 'New Opportunity']");
		} else {
			//return By.xpath("//div/one-record-home-flexipage2/forcegenerated-adgrollup_component___forcegenerated__flexipage_recordpage___contact_record_page___contact___view/forcegenerated-flexipage_contact_record_page_contact__view_js/record_flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout//a[@title = 'Neue Opportunity']");
			return By.xpath("//a[@title = 'New Opportunity']");
		}
	}
	
	
	public By NewOpportunityProd(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/one-record-home-flexipage2/forcegenerated-flexipage_contact_record_page_contact__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout//a[@title = 'New Opportunity']");
			//return By.xpath("//a[@title = 'New Opportunity']");
		} else {
			return By.xpath("//div/one-record-home-flexipage2/forcegenerated-flexipage_contact_record_page_contact__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout//a[@title = 'Neue Opportunity']");
			//return By.xpath("//a[@title = 'New Opportunity']");
		}
	}

	
	//public By New = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/ul/li[1]/a");
	//public By NewOpportunity = By.xpath("//a[contains(@title, 'New Opportunity')]/div");
	//public By Salutation = By.xpath("//span/span[.='Anrede']/../../div/div[1]/div/div/a");
	
	public By NACB_Salutation = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/fieldset/div/div[1]/div/div[1]/div/div/a");
	public By SalutationError = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/fieldset/div/ul/li");
	public By FirstName = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/fieldset/div/div[2]/input");
	//public By LastName = By.xpath("//label/span[.='Nachname']/../../input");
	public By NACB_LastName = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/fieldset/div/div[3]/input");
	//public By MainSalesContact = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/section/div/section/div/div/div/div/div/div[5]/div[1]/div/div/div/input");
	//public By MainSalesContact = By.xpath("//label/span[.='Hauptansprechpartner Vertrieb']/../../input");
	
	public By NACB_MainSalesContact = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/article/div[3]/div/div[1]/div/div/div[5]/div[1]/div/div/div/input");
	public By LastNameError = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/fieldset/div/ul/li");
	//public By Telefon = By.xpath("//label/span[.='Telefon']/../../input");
	
	public By NACB_Telefon = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/article/div[3]/div/div[1]/div/div/div[1]/div[2]/div/div/div/input");
	public By AccountName = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[4]/div[1]/div/div/div/div/div/div/div/input");
	public By NACB_AccountName = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/article/div[3]/div/div[1]/div/div/div[4]/div[1]/div/div/div/div/div/div[1]/div/input");
	
	public String NACB_AccountElements = "/html/body/div[4]/div[2]/div[2]/div[2]/div/div[2]/div/article/div[3]/div/div[1]/div/div/div[4]/div[1]/div/div/div/div/div/div[1]/div/div/div[2]/ul/li";
	
	public By Status = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/a");
	public By StatusError = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div/ul/li");
	
	public By PersonForTruck = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[3]/div/div/div/div/div/div/div/input");
	
	//public By Next = By.xpath("//span[.='Weiter']");
	
	public By StatusOhne = By.xpath("/html/body/div[11]/div/ul/li[1]/a");
	//public By Save = By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div/div[3]/button[2]/span");
	//public By Save = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]/span");
	public By NACB_Save = By.xpath("/html/body/div[4]/div[2]/div[2]/div[2]/div/div[3]/div/button[3]");
	
	public By ContactVisible = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div[1]/div/div[2]/nav/ol/li/span");
	public By ContactText = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div[1]/div[1]/div/header/div[2]/div/div[1]/div[2]/h1/div[1]/div/span");
	public By ErrorMessage = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[2]/div/div/span");
	public By ErrorMessage2 = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[2]/div/ul/li");
	
	public By NACB_Contact = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/input");
	public By NACB_Contact_Create = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[1]/div/div/div[3]/div");
	
	public By Contact_OpportunityTab = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/one-record-home-flexipage2/forcegenerated-flexipage_contact_record_page_contact__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]/a");
	public By Contact_OpportunityFirst = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/one-record-home-flexipage2/forcegenerated-flexipage_contact_record_page_contact__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/div/a");
	public WebElement get_ChooseAccount(String Account) throws InterruptedException {
	By ChooseAccount = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[4]/div[1]/div/div/div/div/div/div[1]/div/div/div[2]/ul/li[1]/a/div[2]/div[1][contains(@title,'"+Account+"')]");
	//	/html/body/div[5]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[4]/div[1]/div/div/div/div/div/div[1]/div/div/div[2]/ul/li/a/div[2]
		wait.until(ExpectedConditions.elementToBeClickable(ChooseAccount));
		return driver.findElement(ChooseAccount);
	}
	
	

}
