package pageObjects;

import org.openqa.selenium.By;

public class OpptyObject {

	public By lineSearchEdit(String name) {
		return By.xpath("//a[.='"+ name +"']/../../../../tr/td[4]/div/a");
	}
	
	public By productSearch(String product) {
		return By.xpath("//span[.='"+ product +"']/../lightning-button-icon/button");
	}
	
	public By HLPanel_OpptyTextSearch(String name) {
		return By.xpath("//h1/slot/slot/lightning-formatted-text[.= '"+ name +"']");
	}
	public By contactSearch(String name) {
		return By.xpath("//a[.='"+ name +"']");
	}
	public By proposalSearch(String name) {
		return By.xpath("//th/div/a[.='"+ name +"']");
	}
	
	public By OpportunityName(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-formatted-rich-text/span[.='Opportunity Name']/../../../lightning-input/div/input");
		} else {
			return By.xpath("//lightning-formatted-rich-text/span[.='Opportunity Name']/../../../lightning-input/div/input");
		}
	}
	
	public By Schlusstermin(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-formatted-rich-text/span[.='Close date']/../../../lightning-input/lightning-datepicker/div[1]/div/input");
		} else {
			return By.xpath("//lightning-formatted-rich-text/span[.='Abschlussdatum']/../../../lightning-input/lightning-datepicker/div[1]/div/input");
		}
	}
	
	public By Probability(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[(.='Opportunity Probability') and (@dir ='ltr')]/../../../../div[2]/select");
		} else {
			return By.xpath("//div[(.='Erfolgswahrscheinlichkeit') and (@dir ='ltr')]/../../../../div[2]/select");
		}
	}
	
	public By Next(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.='Next']");
		} else {
			return By.xpath("//button[.='Weiter']");
		}
	}
	
	public By Cancel(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@title = 'Cancel']");
		} else {
			return By.xpath("//button[@title = 'Abbrechen']");
		}
	}
	
	public By RL_ContactRoles(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.='Contact Roles']");
		} else {
			return By.xpath("//a[.='Contact Roles']");
		}
	}
	
	public By Edit(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[@role='menu']/ul/li/a[@title='Edit']");
		} else {
			return By.xpath("//div[@role='menu']/ul/li/a[@title='Bearbeiten']");
		}
	}
	
	public By Primary(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Primary']/../../div/input");
		} else {
			return By.xpath("//span[.='Primär']/../../div/input");
		}
	}
	
	public By Save(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]");
		} else {
			return By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]");
		}
	}
	
	public By Angebotsphase(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]//div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[1]/div[1]/div/div/ul/li[2]/a/span[2]");
		} else {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]//div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[1]/div[1]/div/div/ul/li[2]/a/span[2]");
		}
	}
	
	public By PhaseAktuell(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]//div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[2]/button/span");
		} else {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]//div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[2]/button/span");
		}
	}
	
	public By New_Proposal(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[@title = 'Create Proposal']/..");
			//return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___0121w0000006i8paau___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[1]/a/div");
		} else {
			return By.xpath("//div[@title = 'Angebot erstellen']/..");
			//return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___0121w0000006i8paau___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[1]/a/div");
		}
	}
	
	public By Oppty_Proposals(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[contains(@data-label, 'Angebote')]");
		} else {
			return By.xpath("//a[contains(@data-label, 'Angebote')]");
		}
	}
	
	public By Oppty_ProposalsNew(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[.= 'Angebote']");
		} else {
			return By.xpath("//a[.= 'Angebote']");
		}
	}
	
	public By NoPrimaryContactDetected(String L) {
		if (L.equals("E")) {
			return By.xpath("//b[.= 'No Primary Contact detected!']");
		} else {
			return By.xpath("//b[.= 'No Primary Contact detected!']");
		}
	}
	
	public String setup = "/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/";
	//public String Setup_Frames = "/html/body/div[5]/div[1]/div[2]/div[2]/div/div[1]/div/section/div/div[2]/div/div/div/div[2]/div/force-aloha-page/div";
	//public By New_Proposal = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_opportunity___0121w0000006i8paau___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[4]/ul/li[1]/a/div");
	
	//public By Oppty_Proposals = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div/div/div[1]/div/div[3]/div[1]/div/div/div/ul/li[4]/a/span[2]");
	//public By Oppty_Proposals = By.xpath("//a[contains(@data-label, 'Proposals')]");
	
	public By Oppty_ProposalsFirst = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[4]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a");
	
	public By Oppty_ContactFirst = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[2]/div/div/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr[1]/th/div/a");
	public By Oppty_ContactFirst_Primary = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[2]/div/div/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr[1]/td[3]/span/img");
	public By Oppty_ContactSecond = By.xpath("/html/body/div[5]/div[4]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[2]/div/div/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr[2]/th/div/a");
	public By Oppty_ContactSecond_Primary = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[2]/div/div/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr[2]/td[3]/span/img");
	public By Oppty_ContactFirst_MoreOptions = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[2]/div/div/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr[1]/td[4]/div/a/lightning-icon/lightning-primitive-icon");
	
	public By EditContactRoles = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[2]/div/div/article/div[2]/div/div/ul/li[2]/a");
	public By AddContactRoles = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[2]/div/div/article/div[2]/div/div/ul/li[1]/a");
	public By AddContactRolesMO = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/a");
	public By SearchContact = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/label/div/div/div[1]/div/input");
	public By SearchContactPath = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/label/div/div/div[1]/div/");
	public By ContactRoles = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[2]/span/span[2]/button");
	public By ContactRolesSecondClick = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[2]/div/div/div[1]/div/div/div/div/div[1]/div/div/a");
	public By ContactRolesSave = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[2]");
	public By ContactRolesSaveMO = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]");
	public By ContactRolesCancel = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[1]");
	
	//public By OpportunityName = By.xpath("//lightning-formatted-rich-text/span[.='Opportunity Name']/../../../lightning-input/div/input");
	//public By Schlusstermin = By.xpath("//lightning-formatted-rich-text/span[.='Close date']/../../../lightning-input/lightning-datepicker/div[1]/div/input");
	public By CloseDate = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]/span");
	//public By Probability = By.xpath("//div[(.='Opportunity Probability') and (@dir ='ltr')]/../../../../div[2]/select");
	//public By Save = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]");
	//public By Next = By.xpath("//button[.='Weiter']");
	public By addProduct = By.xpath("//span[.='TGL < 16t Non-Traction']/../lightning-button-icon/button");
	public By Update = By.xpath("//button[.='Opportunity aktualisieren']");
	//public By Cancel = By.xpath("//button[@title = 'Abbrechen']");
	public By LineEdit = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[3]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/td[4]/div/a");
	
	//public By RL_ContactRoles = By.xpath("//a[.='Contact Roles']");
	//public By Edit = By.xpath("//div[@role='menu']/ul/li/a[@title='Bearbeiten']");
	//public By Primary = By.xpath("//span[.='Primär']/../../div/input");
	public By RL_ProductAndVehicle = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]/a");
	public By AddContactRole = By.xpath("//a[@title = 'Kontaktrollen hinzufügen']");
	
	//public By Angebotsphase = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[1]/div[1]/div/div/ul/li[2]/a/span[2]");
	public By Entscheidungssphase = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[1]/div[1]/div/div/ul/li[3]/a/span[2]");
	//public By PhaseAktuell = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[2]/button/span");
	
	public By PanVPreisbuchAuswahlen = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[3]/div[1]/div/div/div[2]/lst-list-view-manager-header/div/div[1]/div[3]/ul/li[2]/a/div");
	public By PanVPreisbuchAuswahlen_Save = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[2]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/article/div/div[2]/footer/div[2]/button");
	
	
}
