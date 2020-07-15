package pageObjects;

import org.openqa.selenium.By;

public class OpptyObjectDev {

	public By lineSearchPrimary(String name) {
		return By.xpath("//th/div/a[.='"+ name +"']//../../../td[3]/span");
	}
	public By lineSearchEdit(String name) {
		return By.xpath("//th/div/a[.='"+ name +"']//../../../td[4]/div/a");
	}
	public By HL_OpptySearch(String name) {
		return By.xpath("//h1/slot/slot/lightning-formatted-text[.='"+ name +"']");
	}
	
	public By Edit = By.xpath("//div[@role='menu']/ul/li/a[@title='Edit']");
	public By Primary = By.xpath("//span[.='Primary']/../../div/input");
	public String setup = "/html/body/div[4]/div[1]/div[2]/div[1]/div/div/div/ul/";
	//public String Setup_Frames = "/html/body/div[5]/div[1]/div[2]/div[2]/div/div[1]/div/section/div/div[2]/div/div/div/div[2]/div/force-aloha-page/div";
	public By New_Proposal = By.xpath("//div[@title = 'Create Proposal']");
	
	//public By Oppty_Proposals = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div/div/div[1]/div/div[3]/div[1]/div/div/div/ul/li[4]/a/span[2]");
	//public By Oppty_Proposals = By.xpath("//a[contains(@data-label, 'Proposals')]");
	public By Oppty_Proposals = By.xpath("//a[contains(@data-label, 'Angebote')]");
	
	//public By Oppty_ProposalsFirst = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[4]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a");
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
	
	public By OpportunityName = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/flowruntime-flow-screen-input[1]/flowruntime-input-wrapper2/div/lightning-input/div[1]/input");
	public By Schlusstermin = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/flowruntime-flow-screen-input[2]/flowruntime-input-wrapper2/div/lightning-input/lightning-datepicker/div[1]/div/input");
	public By Probability = By.xpath("//div[(.='Opportunity Probability') and (@dir = 'ltr')]/../../../../div[2]/select");
	public By Next = By.xpath("//button[.='Next']");
	public By addProduct = By.xpath("//span[.='TGL < 16t Non-Traction']/../lightning-button-icon/button");
	public By Update = By.xpath("//button[.='Update Opportunity']");
	public By Cancel = By.xpath("//button[@title = 'Cancel']");
	public By Save = By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div/div[3]/div/button[3]");
	
	//public By RL_ContactRoles = By.xpath("//a[.='Contact Roles']");
	public By RL_ContactRoles = By.xpath("//a[.='Kontaktrollen']");
	public By RL_ProductAndVehicle = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]/a");
	
	public By Angebotsphase = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[1]/div[1]/div/div/ul/li[2]/a/span[2]");
	public By Entscheidungssphase = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[1]/div[1]/div/div/ul/li[3]/a/span[2]");
	public By PhaseAktuell = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[2]/slot/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/article/div/div/div/div[1]/div[2]/button/span");
	
	public By PanVPreisbuchAuswahlen = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[3]/div[1]/div/div/section[3]/div[1]/div/div/div[2]/lst-list-view-manager-header/div/div[1]/div[3]/ul/li[2]/a/div");
	public By PanVPreisbuchAuswahlen_Save = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_opportunity_record_page_opportunity__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[2]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/article/div/div[2]/footer/div[2]/button");
	
	
}
