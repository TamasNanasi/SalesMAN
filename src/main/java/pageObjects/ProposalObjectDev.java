package pageObjects;

import org.openqa.selenium.By;

public class ProposalObjectDev {
	
	public By lineSearch(String name) {
		return By.xpath("//a[contains(@title, '"+ name +"') and contains(text(),'"+ name +"')]");
	}
	
	public By lineItemSearch(String lineItem) {
		//return By.xpath("//a[contains(text(),'"+ lineItem +"') and contains(@data-proxy-id, 'aura')]");
		return By.xpath("//a[contains(text(),'"+ lineItem +"')]");
	}
	
	public By productSearch(String product) {
		return By.xpath("//span[.='"+ product +"']/../lightning-button-icon/button");
	}
	
	public By showMoreActionSearch(String name) {
		return By.xpath("//lightning-formatted-text[contains(text(),'"+ name +"')]/../../../../../../div[4]/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/button");
	}
	
	public By BasicVehiclePriceSearch(String name) {
		return By.xpath("//span[contains(text(), '"+ name +"')]/../../../../../../div[2]/div/div/c-i-o-tile-section/div/div/c-i-o-tile-section-item/div/c-i-o-price-range/div/div/div[1]");
	}
	
	public By PLI_GultigBis(String L) {
		if (L.equals("E")) {
	        return By.xpath("//label[contains(text(),'Valid until')]/../div/input");
	} else {
	        return By.xpath("//label[contains(text(),'Gültig bis')]/../div/input");
	}
	}
	
	public By TruckLabel(String L) {
	    if (L.equals("E")) {
	                    return By.xpath("//a[@title = 'Truck']/..");
	    } else {
	                    return By.xpath("//a[@title = 'Truck']/..");
	    }
	}
	
	public By PLI_shippingTypeDropdown(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Shipping Type')]/../div/lightning-base-combobox/div/div/input");
		} else {
			return By.xpath("//label[contains(text(),'Shipping Type')]/../div/lightning-base-combobox/div/div/input");
		}
	}
	
	public By PLI_shippingTypeElementPickup(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Shipping Type')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
		} else {
			return By.xpath("//label[contains(text(),'Aufbautyp')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
		}
	}
	
	public By CurrenPriceValue = By.xpath("//div[@class = 'price-range__currentvalue']");
	public By lineItemTruck = By.xpath("//span[contains(@title, 'Angebotspositionen')]/../../../../../../div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr[1]/th/div/a");
	
	public By ProposalName = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/flowruntime-flow-screen-input/flowruntime-input-wrapper2/div/lightning-input/div/input");
	public By Next = By.xpath("//button[@title = 'Next']");
	public By Continue = By.xpath("//button[ .= 'Continue']");
	public By FertigStellen = By.xpath("//button[@title = 'Fertig stellen']");
	public By ShippingType = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[3]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div/a");
	public By OrderReason = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/a");
	public By ApplicationBasedSegmentTruck = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[3]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/a");
	public By OfferValidUntil = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[2]/div/div/div[1]/div[1]/div/div/div/div/input");
	public By Save = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]");
	
	public By AddProduct = By.xpath("//button[contains(@title, 'Produkt hinzuf�gen')]");
	
	public By addTruck = By.xpath("//button[contains(text(),'Truck')]");
	public By addStock = By.xpath("//button[contains(text(),'Lagerfahrzeug')]");
	public By addService = By.xpath("//button[contains(text(),'Service Vertrag')]");
	public By addWarranty = By.xpath("//button[contains(text(),'Garantieverl�ngerung')]");
	public By addFinance = By.xpath("//button[contains(text(),'Finance')]");
	public By addBuyBack = By.xpath("//button[contains(text(),'Buy Back')]");
	public By addTradeIn = By.xpath("//button[contains(text(),'Inzahlungnahme')]");
	
	public By TGL = By.xpath("//a[contains(@data-label, 'TGL')]");
	public By TGM = By.xpath("//a[contains(@data-label, 'TGM')]");
	public By TGS = By.xpath("//a[contains(@data-label, 'TGS')]");
	public By TGX = By.xpath("//a[contains(@data-label, 'TGX')]");
	
	
	public By AddNewTruck = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[2]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/c-i-o-proposal-pricing/div/div[1]/div/div/div/c-i-o-product-add-tile/div/div[2]/div/button");
	public By addTGL = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/c-i-o-proposal-pricing/div/div[1]/div/div/div/c-i-o-product-add-tile/div[2]/c-i-o-item-selector/div/c-i-o-modal-wrapper/div/div/div/section/div/div/slot/div/div/div[1]/div/c-i-o-item-selector-product-view/div/div/div[2]/div/div[2]/lightning-button-icon/button");
	//public By SaveNewTruck = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c/flexipage-record-page-decorator/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/c-i-o-proposal-pricing/lightning-card/article/div/slot/div/div[1]/div[1]/div/div/c-i-o-product-add-tile/div[2]/c-i-o-item-selector/div/c-i-o-modal-wrapper/div/div/div/section/div/footer/slot/div/span/lightning-button/button");
	public By SaveNewTruck = By.xpath("//button[contains(@title, 'Update Proposal')]");

	public By printProposal = By.xpath("//span[contains(text(),'Angebot drucken')]");
	public By printOrder = By.xpath("//span[contains(text(),'Auftrag drucken')]");
	public By Order = By.xpath("//runtime_platform_actions-ribbon-menu-item/a/span[contains(text(),'Bestellen')]");
	public By print = By.xpath("//button[.='Print']");
	public By approval_start = By.xpath("//a[@title='Approve']");
	public By approval = By.xpath("//span[.='Approve']");
	
	public By flowOrder = By.xpath("//li/a[(@data-tab-name='Order') and (@aria-selected='true')]");
	public By orderNummer = By.xpath("//span[@title='Aufträge']/../../../../../../div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a");
	
	public By PricingTab = By.xpath("//a[contains(@data-label, 'Pricing') ]");
	public By DetailsTab = By.xpath("//li[contains(@title, 'Verwandt') ]/following-sibling::li[contains(@title, 'Details') ]/a");
	public By RelatedTab = By.xpath("//a[contains(@data-label, 'Related') and contains(@tabindex, '-1')]");
	
	
	public By RelatedTabTemp = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_configuration__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[1]/a");
	
	public By DetailsTabAfterC4S = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[1]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[3]/a");
	//public By RelatedTabAfterC4S = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[1]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]/a");

	
	public By Details_OfferValidUntil = By.xpath("//span[contains(text(),'Angebot g�ltig bis')]/..//following-sibling::div/span/slot/slot/lightning-formatted-text");
	public By Details_DistributionChannel = By.xpath("//span[contains(text(),'Vertriebsweg')]/..//following-sibling::div/span/slot/slot/lightning-formatted-text");
	
	//public By BasicVehiclePrice = By.xpath("//span[contains(text(),'Basic Vehicle Price')]/../../div[2]/div/c-i-o-value-field-input/div/div/span/div");
	
	public By C4SButton_Show = By.xpath("//button[contains(@title, 'Actions')]");
	//public By C4S = By.xpath("//button[contains(@title, 'Aktionen')]/../div/div/slot/c-i-o-configurator/c-i-o-configurator-button-renderer[1]/div/lightning-menu-item/a/span");
	public By C4S = By.xpath("//button[contains(@title, 'Actions')]/../div/div/slot/c-i-o-configurator/c-i-o-configurator-button-renderer[1]/lightning-menu-item/a");
	public By C4S_Reopen = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c/flexipage-record-page-decorator/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/c-i-o-proposal-pricing/lightning-card/article/div/slot/div/div[1]/div[2]/div/c-i-o-tile-row/div/div/c-i-o-tile/div[1]/article/div[1]/header/div[3]/div/c-i-o-configurator/div/c-i-o-configurator-button-renderer/button");
	
	public By Search = By.xpath("//input[contains(@name, 'Proposal__c')]");
	//public By SearchReopen = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[5]/div/div/div[1]/div[2]/div[2]/force-list-view-manager-search-bar/div/lightning-input/div/input");
	public By FirstRow = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a");
	public By FirstRowReopen = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[5]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/th/span/a");
	
	public By RelatedFirstRow = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[2]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/div/div[1]/article/div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a");
	public By RelatedFirstRowAfterC4S = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[2]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/div/div[1]/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a");
	
	public By PLIRelated = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[4]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_proposallineitem__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[1]/a");
	
	public By LineItemRelatedRefresh = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_proposallineitem__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[1]/a");
	
	public By LineItemRelated = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_proposallineitem__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[1]/a");
	public By LineItemDetail = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_proposallineitem__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]/a");
	
	public By ConfigurationFirstRow = By.xpath("//th[contains(@title, 'Configuration Id')]/../../../tbody/tr/th/div/a");
	//public By ConfigurationFirstRowRefresh = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[1]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_proposallineitem__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/div/div[3]/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a");
	public By ConfigurationFirstRowMANCode = By.xpath("//span[.='MAN Code']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	//public By ConfigurationFirstRowMANCodeRefresh = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[1]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_proposallineitem__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/div/div[3]/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr/td[2]/span");
	
	public By Configuration = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[4]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_proposallineitem__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-aura-wrapper/div/div/div/div[3]/article/div[3]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a");
	public By ConfigurationRelated = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_configuration__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[1]/a");
	public By ConfigurationShowAll = By.xpath("//span[contains(text(),'Produktattribute') and contains(@class, 'assistiveText')]/..");

	public By FileLink = By.xpath("//span[contains(@title, 'VehicleConfig.json')]");
	public By DownloadButton = By.xpath("//button[contains(@title, 'Herunterladen') and contains(@data-aura-class, 'uiButton--default')]");
	public By Close = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div/div/button");
	
	public By HidroDrive_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a");
	public By HidroDrive = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[2]/span/span");
	public By BioDiesel_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[2]/th/span/a");
	public By BioDiesel = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[2]/td[2]/span/span");
	public By ModelSeries_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[3]/th/span/a");
	public By ModelSeries = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[3]/td[2]/span/span");
	public By EmissionClass_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[4]/th/span/a");
	public By EmissionClass = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[4]/td[2]/span/span");
	public By SteeringType_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[5]/th/span/a");
	public By SteeringType = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[5]/td[2]/span/span");
	public By Transmission_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[6]/th/span/a");
	public By Transmission = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[6]/td[2]/span/span");
	public By Cab_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[7]/th/span/a");
	public By Cab = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[7]/td[2]/span/span");
	public By PlanetaryHubReductionAxle_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[8]/th/span/a");
	public By PlanetaryHubReductionAxle = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[8]/td[2]/span/span");
	public By DriveType_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[9]/th/span/a");
	public By DriveType = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[9]/td[2]/span/span");
	public By Tipmatic_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[10]/th/span/a");
	public By Tipmatic = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[10]/td[2]/span/span");
	public By ChassisType_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[11]/th/span/a");
	public By ChassisType = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[11]/td[2]/span/span");
	public By DriveConcept_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[12]/th/span/a");
	public By DriveConcept = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[12]/td[2]/span/span");
	public By EngineType_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[13]/th/span/a");
	public By EngineType = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[13]/td[2]/span/span");
	public By Traction_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[14]/th/span/a");
	public By Traction = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[14]/td[2]/span/span");
	public By Pritarder_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[15]/th/span/a");
	public By Pritarder = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[15]/td[2]/span/span");
	public By ChassisClass_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[16]/th/span/a");
	public By ChassisClass = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[16]/td[2]/span/span");
	public By IntarderRetarder_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[17]/th/span/a");
	public By IntarderRetarder = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[17]/td[2]/span/span");
	public By VehicleDescription_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[18]/th/span/a");
	public By VehicleDescription = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[18]/td[2]/span/span");
	public By AuxiliaryHeating_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[19]/th/span/a");
	public By AuxiliaryHeating = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[19]/td[2]/span/span");
	public By Suspension_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[20]/th/span/a");
	public By Suspension = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[20]/td[2]/span/span");
	public By EquipmentForHazardousGoodsADR_Label = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[21]/th/span/a");
	public By EquipmentForHazardousGoodsADR = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[21]/td[2]/span/span");
	
	
	//public By AngefragtesLieferdatumLand = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_proposallineitem__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[2]/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-detail-panel/div/div/div/records-record-layout-event-broker/slot/records-lwc-record-layout/records-record-layout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[4]/slot/force-record-layout-item[2]/div/div[2]/span/slot[1]/slot/lightning-formatted-text");
	
	public By PLI_VehicleDescription_Label = By.xpath("//span[.='Beschreibung Variante']");
	public By PLI_VehicleDescription = By.xpath("//span[.='Beschreibung Variante']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_gearType_Label = By.xpath("//span[.='Getriebe']");
	public By PLI_gearType = By.xpath("//span[.='Getriebe']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_engineFamily_Label = By.xpath("//span[.='Motorenfamilie']");
	public By PLI_engineFamily = By.xpath("//span[.='Motorenfamilie']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	
	public By PLI_TotalPermissibleWeightValue_Label = By.xpath("//span[.='Zulässiges Gesamtgewicht']");
	public By PLI_TotalPermissibleWeightValue = By.xpath("//span[.='Zulässiges Gesamtgewicht']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By PLI_TotalPermissibleWeightUnit_Label = By.xpath("//span[.='Technical Weight Unit']");
	public By PLI_TotalPermissibleWeightUnit = By.xpath("//span[.='Technical Weight Unit']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_TechnicalWeightValue_Label = By.xpath("//span[.='Technical Weight Value']");
	public By PLI_TechnicalWeightValue = By.xpath("//span[.='Technical Weight Value']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By TotalTrainWeightValue_Label = By.xpath("//span[.='Total Train Weight Value']");
	public By TotalTrainWeightValue = By.xpath("//span[.='Total Train Weight Value']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By TotalTrainWeightTechValue_Label = By.xpath("//span[.='Total Train Weight Tech Value']");
	public By TotalTrainWeightTechValue = By.xpath("//span[.='Total Train Weight Tech Value']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");

	
	
	public By PLI_EnginePowerHP_Label = By.xpath("//span[.='Motorleistung in PS']");
	public By PLI_EnginePowerHP = By.xpath("//span[.='Motorleistung in PS']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By PLI_EnginePowerKW_Label = By.xpath("//span[.='Motorleistung in kW']");
	public By PLI_EnginePowerKW = By.xpath("//span[.='Motorleistung in kW']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By PLI_RequestedDeliveryDateCountry_Label = By.xpath("//span[.='Angefragtes Lieferdatum Land']");
	public By PLI_RequestedDeliveryDateCountry = By.xpath("//span[.='Angefragtes Lieferdatum Land']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_AuxiliaryHeating_Label = By.xpath("//span[.='Zusatzheizung']");
	public By PLI_AuxiliaryHeating = By.xpath("//span[.='Zusatzheizung']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
	public By PLI_EquipmentForHazardousGoodsADR_Label = By.xpath("//span[.='Ausstattung für Gefahrguttransport ADR']");
	public By PLI_EquipmentForHazardousGoodsADR = By.xpath("//span[.='Ausstattung für Gefahrguttransport ADR']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
	public By PLI_bodyType_Label = By.xpath("//span[.='Aufbautyp']");
	public By PLI_bodyType = By.xpath("//span[.='Aufbautyp']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_EngineType_Label = By.xpath("//span[.='Motortyp']");
	public By PLI_EngineType = By.xpath("//span[.='Motortyp']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_manCode_Label = By.xpath("//span[.='MAN Code']");
	public By PLI_manCode = By.xpath("//span[.='MAN Code']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	
	public By PLI_bodyTypeEdit = By.xpath("//span[.='Body Type']/../../div[2]/button");
	public By PLI_bodyTypeDropdown = By.xpath("//label[contains(text(),'Body Type')]/../div/lightning-base-combobox/div/div/input");
	public By PLI_ApplicationBasedSegmentTruckDropdown = By.xpath("//label[contains(text(),'ApplicationBasedSegmentTruck')]/../div/lightning-base-combobox/div/div/input");
	public By PLI_ApplicationBasedSegmentTruckElementSonstiges = By.xpath("//label[contains(text(),'ApplicationBasedSegmentTruck')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
	public By PLI_bodyTypeElementSonstiges = By.xpath("//label[contains(text(),'Body Type')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[73]/span[2]/span");
	public By PLI_AngefragtesLieferdatumKunde = By.xpath("//label[.='Requested Delivery Date Customer']/../div/input");
	public By PLI_AngefragtesLieferdatumLand = By.xpath("//label[.='Requested Delivery Date Country']/../div/input");
	public By PLI_GultigBis = By.xpath("//label[contains(text(),'Gültig bis')]/../div/input");
	public By PLI_Save = By.xpath("//button[contains(@title, 'Save')]");

	
	public By closeWindow = By.xpath("//button[contains(@title, 'Dieses Fenster schließen')]");
	
	public By Blank = By.xpath("");

}
