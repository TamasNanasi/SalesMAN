package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsObject {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public By lineSearch(String name) {
		return By.xpath("//a[.='"+ name +"']");
	}
	
	public By accountListSearch(String name) {
		return By.xpath("//a[(contains(text(),'"+ name +"')) and (contains(@title, '"+ name +"'))]");
	}
	//a[(.='Interface') and (contains(@class,'slds-truncate textUnderline'))]
	public By contactListSearch(String name) {
		return By.xpath("//span/a[.='"+ name +"']");
	}
	
	public By contactListSearchDev(String name) {
		return By.xpath("//a[(.='"+ name +"') and (contains(@class,'slds-truncate textUnderline'))]");
	}
	
	public By New(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'New']");
		} else {
			return By.xpath("//a[@title = 'Neu']");
		}
	}
	
	public By NewAccountName(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='Account Name']/../../input");
		} else {
			return By.xpath("//label/span[.='Accountname']/../../input");
		}
	}
	
	public By NewLand(String L) {
		if (L.equals("E")) {
			return By.xpath("//span/span[.='Country']/../../div/div[1]/div/div/a");
		} else {
			return By.xpath("//span/span[.='Land']/../../div/div[1]/div/div/a");
		}
	}
	
	public By NewStrasse(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='Street']/../../textarea");
		} else {
			return By.xpath("//label/span[.='Straße']/../../textarea");
		}
	}
	
	public By NewPLZ(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='Zip/Postal Code']/../../input");
		} else {
			return By.xpath("//label/span[.='PLZ']/../../input");
		}
	}
	
	public By NewStadt(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='City']/../../input");
		} else {
			return By.xpath("//label/span[.='Stadt']/../../input");
		}
	}
	
	public By NewBundesLand(String L) {
		if (L.equals("E")) {
			return By.xpath("//span/span[.='State/Province']/../../div/div[1]/div/div/a");
		} else {
			return By.xpath("//span/span[.='Bundesland']/../../div/div[1]/div/div/a");
		}
	}
	
	public By NewSAPStrasse1(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='SAP Street 1']/../../input");
		} else {
			return By.xpath("//label/span[.='SAP Strasse 1']/../../input");
		}
	}
	
	public By NewSAPHausnummer(String L) {
		if (L.equals("E")) {
			return By.xpath("//label/span[.='SAP House No.']/../../input");
		} else {
			return By.xpath("//label/span[.='SAP Hausnummer']/../../input");
		}
	}
	
	public By NewFuhrparkgroesseTruck(String L) {
		if (L.equals("E")) {
			return By.xpath("//span/span[.='Fleet Size Truck']/../../div/div[1]/div/div/a");
		} else {
			return By.xpath("//span/span[.='Fuhrparkgröße Truck']/../../div/div[1]/div/div/a");
		}
	}
	
	public By Save(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@title='Save']");
		} else {
			return By.xpath("//*[@title='Speichern']");
		}
	}
	
	public By HLPanel_AccountText(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[.='Account']/../slot/slot/sfa-output-name-with-hierarchy-icon-account/sfa-output-name-with-hierarchy-icon-wrapper/force-aura-action-wrapper/div/div/span[1]");
		} else {
			return By.xpath("//div[.='Account']/../slot/slot/sfa-output-name-with-hierarchy-icon-account/sfa-output-name-with-hierarchy-icon-wrapper/force-aura-action-wrapper/div/div/span[1]");
		}
	}
	
	public By HLPanel_Button_NeuerKontakt(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[contains(@title, 'New Contact')]");
		} else {
			return By.xpath("//a[contains(@title, 'Neuer Kontakt')]");
		}
	}
	
	public By Account_ContactTab(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div[2]/div[2]/div[1]//li[@title = 'Kontakte']/a");
			//return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]//li[@title = 'Kontakte']/a");
		} else {
			//return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]//li[@title = 'Kontakte']/a");
			return By.xpath("/html/body/div[4]/div[1]/section/div/div[2]/div[2]/div[1]//li[@title = 'Kontakte']/a");
		}
	}
	
	public By Account_ContactTabNew(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.= 'Kontakte']");
		} else {
			return By.xpath("//a[.= 'Kontakte']");
		}
	}
	
	public By Account_ContactTabReserve(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]//li[@title = 'Kontakte']/a");
			//return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]//li[@title = 'Contacts']/a");
		} else {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]//li[@title = 'Kontakte']/a");
		}
	}
	//public By New = By.xpath("//a[contains(@title, 'Neu')]");
	
	
	public By NewWeiter = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/button[2]");
	//public By NewAccountName = By.xpath("//label/span[.=\'Accountname\']/../../div/div/div/div[1]/input");
	public By NewTelefon = By.xpath("//label/span[.='Telefon']/../../input");
	public By NewAccountName2 = By.xpath("//label/span[.='Accountname 2']/../../input");
	public By NewFax = By.xpath("//label/span[.='Fax']/../../input");
	public By NewAccountName3 = By.xpath("//label/span[.='Accountname 3']/../../input");
	public By NewFirmenEmailAdresse = By.xpath("//label/span[.='Firmen Email Adresse']/../../input");
	public By NewPartnertyp = By.xpath("//span[.='Partnertyp']/../div/div[1]/div/div/a");
	public By NewWebsite = By.xpath("//label/span[.='Website']/../../input");
	public By NewUnternehmensgruppe = By.xpath("//label/span[.='Unternehmensgruppe']/../../div/div/div[1]/div/input");
	public By NewUmsatzsteueridentifikationsnummer = By.xpath("//label/span[.='Umsatzsteueridentifikationsnummer']/../../input");
	public By NewWeitereSteuernummer = By.xpath("//label/span[.='Weitere Steuernummer']/../../input");
	public By NewBeschreibung = By.xpath("//label/span[.='Beschreibung']/../../textarea");
	
	//public By NewLand = By.xpath("//span/span[.='Land']/../../div/div[1]/div/div/a");
	//public By NewStrasse = By.xpath("//label/span[.='Straße']/../../textarea");
	//public By NewPLZ = By.xpath("//label/span[.='PLZ']/../../input");
	//public By NewStadt = By.xpath("//label/span[.='Stadt']/../../input");
	//public By NewBundesLand = By.xpath("//span/span[.='Bundesland']/../../div/div[1]/div/div/a");
	//public By NewSAPStrasse1 = By.xpath("//label/span[.='SAP Strasse 1']/../../input");
	//public By NewSAPHausnummer = By.xpath("//label/span[.='SAP Hausnummer']/../../input");
	
	public By NewPrimaereBranche = By.xpath("//span/span[.='Primäre Branche']/../../div/div[1]/div/div/a");
	public By NewSekundaereBranche = By.xpath("//span/span[.='Sekundäre Branche']/../../div/div[1]/div/div/a");
	public By NewPrimaereSubbranche = By.xpath("//span/span[.='Primäre Subbranche']/../../div/div[1]/div/div/a");
	public By NewSekundaereSubbranche = By.xpath("//span/span[.='Sekundäre Subbranche']/../../div/div[1]/div/div/a");
	//public By NewFuhrparkgroesseTruck = By.xpath("//span/span[.='Fuhrparkgröße Truck']/../../div/div[1]/div/div/a");
	
	public By NewDatenspeicherung = By.xpath("//span/span[.='Datenspeicherung']/../../div/div[1]/div/div/a");
	public By NewDatenweitergabe = By.xpath("//span/span[.='Datenweitergabe']/../../div/div[1]/div/div/a");
	public By NewMarketing = By.xpath("//span/span[.='Marketingeinwilligung']/../../div/div[1]/div/div/a");
	
	//public By NewErrorInfo = By.xpath(AccountNewErrorInfo+"div/span");
	//public By NewErrorInfo2 = By.xpath(AccountNewErrorInfo+"ul/li");
	
	
	//public By Save = By.xpath("//*[@title='Speichern']");
	
	//public By HLPanel_AccountText = By.xpath("//div[.='Account']/../slot/slot/sfa-output-name-with-hierarchy-icon-account/sfa-output-name-with-hierarchy-icon-wrapper/force-aura-action-wrapper/div/div/span[1]");
	public By HLPanel_AccountText2 = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[1]/div[1]/div/div[1]/div/div/header/div[2]/div/div[1]/div[2]/h1/div[2]/div/span");
	public By HLPanel_AccountText3 = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[4]/div[1]/div/div[1]/div/div/header/div[2]/div/div[1]/div[2]/h1/div[2]/div/span");
	
	public By HLPanel_Address_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[1]/div/span");
	public By HLPanel_Street = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[1]/div/div/div/div/div[1]");
	public By HLPanel_City = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[1]/div/div/div/div/div[2]");
	public By HLPanel_Land = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[1]/div/div/div/div/div[3]");
	
	public By HLPanel_KeyAccountType_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[2]/div/span");
	public By HLPanel_KeyAccountType = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[2]/div/div/div/span");
	
	public By HLPanel_KundenTyp_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[3]/div/span");
	public By HLPanel_KundenTyp = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[3]/div/div/div/span");
	
	public By HLPanel_FleetSizeTruck_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[4]/div/span");
	public By HLPanel_FleetSizeTruck = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[4]/div/div/div/span");
	
	public By HLPanel_AccountOwner_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[5]/div/span");
	public By HLPanel_AccountOwner = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[5]/div/div/div/div/div/div/a");
	
	public By HLPanel_DatenqualitaetBewertung_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[6]/div/span");
	public By HLPanel_DatenqualitaetBewertung = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div[1]/div/div[1]/div/div/header/div[2]/ul/li[6]/div/div/div/span/img");
	
	public By HLPanel_Button_Folgen = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___0121w0000005fhvaam___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]//div/span/button");
	public By HLPanel_Button_Bearbeiten = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___0121w0000005fhvaam___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[1]/a/div");
	public By HLPanel_NeueOpportunity = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___0121w0000005fhvaam___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[2]/a/div");
	public By HLPanel_Button_ZurGenehmigungSenden = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___0121w0000005fhvaam___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[3]/a/div");

	//public By HLPanel_Button_NeuerKontakt = By.xpath("//a[contains(@title, 'Neuer Kontakt')]");
	public By HLPanel_Button_NewOpportunity = By.xpath("//a[contains(@title, 'New Opportunity')]");
	public By HLPanel_Button_FahrzeugHinzufugen = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___0121w0000005fhvaam___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[5]/a/div");
	public By HLPanel_Button_NSCSupportVorganganlegen = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___0121w0000005fhvaam___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[6]/a/div");
	
	//public By Account_ContactTab = By.xpath("//li[contains(@title, 'Contacts')]/a");
	public By Account_ContactFirst = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/div/a");
	public By Account_Contact_BeziehungenHinzufugen  = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/section[2]/div/div/div/div[2]/lst-list-view-manager-header/div/div[1]/div[3]/ul/li[2]/a");
	public By Account_Contact_BeziehungenHinzufugen_cancel  = By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/button[1]/span");
	
	
	//Choose Account list view and all list viewtype:
	public By AccountShow = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div/h1/div/div/a");
	
	public By Account_List_Type = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div/ul");
	public By AllAccount = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div/ul/li[2]/a");
	public By StandardAccountListView = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div/ul/li[7]/a");
	public By CompetitorAccount = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div/ul/li[4]/a");
	public By ClientAccount = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div/ul/li[3]/a");
	public By GroupAccount = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div/ul/li[5]/a");
	public By MyAccount = By.xpath("/html/body/div[5]/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div/ul/li[8]/a");
	
	public By AccountSearch = By.xpath("//input[@name = 'Account-search-input']");
	
	public By closeEdit = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[1]/button");

}
