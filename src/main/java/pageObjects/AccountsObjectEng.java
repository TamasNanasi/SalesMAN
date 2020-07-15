package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsObjectEng {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public By lineSearch(String name) {
		return By.xpath("//a[.='"+ name +"']");
	}
	
	public By accountListSearch(String name) {
		//a[(contains(text(),'Nicos Interface II - Don')) and (contains(@title, 'Nicos Interface II - Don'))]
		return By.xpath("//a[(contains(text(),'"+ name +"')) and (contains(@title, '"+ name +"'))]");
	}
	
	public By New = By.xpath("//a[contains(@title, 'New')]");
	public By NewWeiter = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/button[2]");
	public By NewAccountName = By.xpath("//label/span[.='Account Name']/../../div/div/div/div[1]/input");
	public By NewTelefon = By.xpath("//label/span[.='Phone']/../../input");
	public By NewAccountName2 = By.xpath("//label/span[.='Account Name 2']/../../input");
	public By NewFax = By.xpath("//label/span[.='Fax']/../../input");
	public By NewAccountName3 = By.xpath("//label/span[.='Account Name 3']/../../input");
	public By NewFirmenEmailAdresse = By.xpath("//label/span[.='Company Email Address']/../../input");
	public By NewPartnertyp = By.xpath("//span[.='Partner Type']/../div/div[1]/div/div/a");
	public By NewWebsite = By.xpath("//label/span[.='Company Website']/../../input");
	public By NewUnternehmensgruppe = By.xpath("//label/span[.='Group Account']/../../div/div/div[1]/div/input");
	public By NewUmsatzsteueridentifikationsnummer = By.xpath("//label/span[.='VAT Reg. No.']/../../input");
	public By NewWeitereSteuernummer = By.xpath("//label/span[.='Additional Fiscal Code']/../../input");
	public By NewBeschreibung = By.xpath("//label/span[.='Description']/../../textarea");
	
	public By NewLand = By.xpath("//span/span[.='Country']/../../div/div[1]/div/div/a");
	public By NewStrasse = By.xpath("//label/span[.='Street']/../../textarea");
	public By NewPLZ = By.xpath("//label/span[.='Zip/Postal Code']/../../input");
	public By NewStadt = By.xpath("//label/span[.='City']/../../input");
	public By NewBundesLand = By.xpath("//span/span[.='State/Province']/../../div/div[1]/div/div/a");
	public By NewSAPStrasse1 = By.xpath("//label/span[.='SAP Street 1']/../../input");
	public By NewSAPHausnummer = By.xpath("//label/span[.='SAP House No.']/../../input");
	
	//public By NewPrimaereBranche = By.xpath("//span/span[.='Primäre Branche']/../../div/div[1]/div/div/a");
	//public By NewSekundaereBranche = By.xpath("//span/span[.='Sekundäre Branche']/../../div/div[1]/div/div/a");
	//public By NewPrimaereSubbranche = By.xpath("//span/span[.='Primäre Subbranche']/../../div/div[1]/div/div/a");
	//public By NewSekundaereSubbranche = By.xpath("//span/span[.='Sekundäre Subbranche']/../../div/div[1]/div/div/a");
	public By NewFuhrparkgroesseTruck = By.xpath("//span/span[.='Fleet Size Truck']/../../div/div[1]/div/div/a");
	
	//public By NewDatenspeicherung = By.xpath("//span/span[.='Datenspeicherung']/../../div/div[1]/div/div/a");
	//public By NewDatenweitergabe = By.xpath("//span/span[.='Datenweitergabe']/../../div/div[1]/div/div/a");
	//public By NewMarketing = By.xpath("//span/span[.='Marketingeinwilligung']/../../div/div[1]/div/div/a");
	
	//public By NewErrorInfo = By.xpath(AccountNewErrorInfo+"div/span");
	//public By NewErrorInfo2 = By.xpath(AccountNewErrorInfo+"ul/li");
	
	
	public By Save = By.xpath("//*[@title='Save']");
	
	public By HLPanel_AccountText = By.xpath("//div[.='Account']/../slot/slot/sfa-output-name-with-hierarchy-icon-account/sfa-output-name-with-hierarchy-icon-wrapper/force-aura-action-wrapper/div/div/span[1]");
	
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

	public By HLPanel_Button_NeuerKontakt = By.xpath("//a[contains(@title, 'Neuer Kontakt')]");
	public By HLPanel_Button_FahrzeugHinzufugen = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___0121w0000005fhvaam___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[5]/a/div");
	public By HLPanel_Button_NSCSupportVorganganlegen = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_account___0121w0000005fhvaam___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[6]/a/div");
	
	public By Account_ContactTab = By.xpath("//li[contains(@title, 'Contacts')]/a");
	public By Account_ContactFirst = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_accountclient_record_page_account__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/div/div/div/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/div/a");
	public By Account_Contact_BeziehungenHinzufugen  = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/section[2]/div/div/div/div[2]/lst-list-view-manager-header/div/div[1]/div[3]/ul/li[2]/a");
	public By Account_Contact_BeziehungenHinzufugen_cancel  = By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div/button[1]/span");
	
	public By AccountSearch = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[2]/div/div/div[1]/div[2]/div[2]/force-list-view-manager-search-bar/div/lightning-input/div/input");
	
}
