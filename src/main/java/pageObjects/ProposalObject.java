package pageObjects;

import org.openqa.selenium.By;

public class ProposalObject {
	
	public By lineSearch(String name) {
		return By.xpath("(//a[contains(@title, '"+ name +"') and contains(text(),'"+ name +"')])[1]");
	}
	
	public By lineItemSearch(String lineItem) {
		return By.xpath("//th/div/a[contains(text(),'"+ lineItem +"')]");
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
	
	public By tileSearch(String name) {
		//return By.xpath("//h2/a/span[contains(text(),'"+ name +"')]/../../../../div[3]/div/lightning-button-menu/button");
		return By.xpath("//h2/a/span[contains(text(),'"+ name +"')]");
	}
	
	public By addProductTypeSearch(String name) {
		return By.xpath("//button[. = '"+ name +"']");
	}
	
	public By addProductSearch(String name) {
		return By.xpath("//span[. = '"+ name +"']/..//button");
	}
	
	public By addSubProductSearch(String name) {
		return By.xpath("//span[. = '"+ name +"']/..//button");
	}
	
	public By AddSubGarantieSearch(String name) {
		return By.xpath("//a[. = '"+ name +"']");
	}
	
	public By KPIValueSearch(String name, String version) {
		return By.xpath("(//div[@title = '"+ name +"']/../../td[2]/div)["+version+"]");
	}
	
	public By SubGarantieLineSearch(String name, String name2) {
		return By.xpath("(//lightning-base-formatted-text[.= '"+ name +"']/../../../../../td[2]//lightning-base-formatted-text[.= '"+ name2 +"']/../../../../../th//lightning-primitive-cell-button)[1]");
	}
	
	public By VehicleUsageValueSearch(String L, String name) {
	    if (L.equals("E")) {
	                    return By.xpath("//label[.= 'Vehicle Usage']/../div/div/div/div//span[.= '"+name+"']");
	    } else {
	                    return By.xpath("//label[.= 'Vehicle Usage']/../div/div/div/div//span[.= '"+name+"']");
	    }
	}
	
	public By SplitinPercentEditSearch(String L, String element) {
		if (L.equals("E")) {
	        return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr["+element+"]/td[3]//button");
		} else {
			return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr["+element+"]/td[3]//button");
		}
	}
	
	public By AbsoluteAmountSearch(String L, String element, String alt) {
		if (L.equals("E")) {
	        return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr["+element+"]/td["+alt+"]//lightning-formatted-number");
		} else {
			return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr["+element+"]/td["+alt+"]//lightning-formatted-number");
		}
	}
	
	public By SplitinPercentSearch(String L, String alt) {
		if (L.equals("E")) {
	        return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr[1]/td["+alt+"]//lightning-formatted-number");
		} else {
			return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr[1]/td["+alt+"]//lightning-formatted-number");
		}
	}
	
	public By SplitinPercentHeaderSearch(String L, String alt) {
		if (L.equals("E")) {
	        return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//thead/tr/th["+alt+"]/lightning-primitive-header-factory/span/a/span[2]");
		} else {
			return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//thead/tr/th["+alt+"]/lightning-primitive-header-factory/span/a/span[2]");
		}
	}
	
	public By RoleSearch(String L, String alt) {
		if (L.equals("E")) {
	        return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr[1]/td["+alt+"]//lightning-formatted-text");
	        //return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr[1]/td["+alt+"]//lightning-base-formatted-text");
		} else {
			return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr[1]/td["+alt+"]//lightning-formatted-text");
			//return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr[1]/td["+alt+"]//lightning-base-formatted-text");
		}
	}
	
	public By ProposalName(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Proposal Name']/../../../lightning-input/div/input");
		} else {
			//return By.xpath("//span[ .= 'Angebotsname']/../../../lightning-input/div/input");
			return By.xpath("//span[ .= 'Proposal Name']/../../../lightning-input/div/input");
		}
	}
	
	public By Next(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.='Next']");
		} else {
			return By.xpath("//button[.='Weiter']");
		}
	}
	
	public By ShippingType(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Shipping Type']/../../../div/div/div[1]/div/div/a");
		} else {
			return By.xpath("//span[ .= 'Versandart']/../../../div/div/div[1]/div/div/a");
		}
	}
	
	public By Save(String L) {
		if (L.equals("E")) {
			//return By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]");
			return By.xpath("//button[@title = 'Save']");
		} else {
			//return By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]");
			return By.xpath("//button[@title = 'Speichern']");
		}
	}
	
	public By SaveProvision(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-primitive-datatable-status-bar//button[.='Save']");
		} else {
			return By.xpath("//lightning-primitive-datatable-status-bar//button[.='Speichern']");
		}
	}
	
	public By PricingTab(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[contains(@data-label, 'Pricing') ]");
		} else {
			return By.xpath("//a[contains(@data-label, 'Pricing') ]");
		}
	}
	
	public By AttacehmentTab(String L) {
		if (L.equals("E")) {
			//return By.xpath("//a[contains(@data-label, 'Attachments') ]");
			return By.xpath("//a[contains(@data-label, 'Anhänge') ]");
		} else {
			return By.xpath("//a[contains(@data-label, 'Anhänge') ]");
		}
	}
	
	public By AddNewTruck(String L) {
		if (L.equals("E")) {
			return By.xpath("//h1[.= 'Start by adding a new truck!']/../../..//button");

		} else {
			return By.xpath("//h1[.= 'Bitte LKW hinzufügen!']/../../..//button");

		}
	}
	
	public By SaveNewTruck(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[contains(@title, 'Update Proposal')]");
		} else {
			return By.xpath("//button[contains(@title, 'Angebot aktualisieren')]");
		}
	}
	
	public By TruckName(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'Truck']/span");
		} else {
			return By.xpath("//a[@title = 'Truck']/span");
		}
	}
	
	public By StockButton(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.= 'Stock']");
		} else {
			return By.xpath("//button[.= 'Stock']");
		}
	}
	
	public By StockMANCode(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[.='MAN Code']/..//input");
		} else {
			return By.xpath("//label[.='MAN Code']/..//input");
		}
	}
	
	public By StockSearch(String L) {
		if (L.equals("E")) {
			return By.xpath("//input[@placeholder='Search for vehicle...']");
		} else {
			return By.xpath("//input[@placeholder='Search for vehicle...']");
		}
	}
	
	public By StockSalesOffice(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[.='Sales Office']/..//input");
		} else {
			return By.xpath("//label[.='Sales Office']/..//input");
		}
	}
	
	public By StockAddLabel(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[@title= 'Add']");
		} else {
			return By.xpath("//span[@title= 'Add']");
		}
	}
	
	public By StockFirstLine(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[@title= 'Add']/../../../../../../../tbody/tr[1]");
		} else {
			return By.xpath("//span[@title= 'Add']/../../../../../../../tbody/tr[1]");
		}
	}
	
	public By StockLineReservedSearch(String L, String count) {
		if (L.equals("E")) {
			return By.xpath("//span[@title= 'Add']/../../../../../../../tbody/tr["+count+"]/td[2]//lightning-formatted-date-time");
		} else {
			return By.xpath("//span[@title= 'Add']/../../../../../../../tbody/tr["+count+"]/td[2]//lightning-formatted-date-time");
		}
	}
	
	public By StockLineAddButtonSearch(String L, String count) {
		if (L.equals("E")) {
			return By.xpath("//span[@title= 'Add']/../../../../../../../tbody/tr["+count+"]/th//lightning-primitive-cell-button");
		} else {
			return By.xpath("//span[@title= 'Add']/../../../../../../../tbody/tr["+count+"]/th//lightning-primitive-cell-button");
		}
	}
	
	public By AddStockVehicle(String L) {
		if (L.equals("E")) {
			return By.xpath("//tr[@data-row-key-value ='row-0']/th[@data-label = 'Add']//lightning-primitive-cell-button");
		} else {
			return By.xpath("//tr[@data-row-key-value ='row-0']/th[@data-label = 'Add']//lightning-primitive-cell-button");
		}
	}
	public By CurrenPriceValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[@class = 'price-range__currentvalue']");
		} else {
			return By.xpath("//div[@class = 'price-range__currentvalue']");
		}
	}
	
	public By C4SButton_Show(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'Truck']/../../..//button[contains(@title, 'Actions')]");
		} else {
			return By.xpath("//a[@title = 'Truck']/../../..//button[contains(@title, 'Aktionen')]");
		}
	}
	
	public By TradeInAction(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'Trade-In']/../../..//button[contains(@title, 'Actions')]");
		} else {
			return By.xpath("//a[@title = 'Trade-In']/../../..//button[contains(@title, 'Aktionen')]");
		}
	}
	
	public By ServiceAction(String L, String divNr) {
		if (L.equals("E")) {
			return By.xpath("//div["+divNr+"]//a[@title = 'Service']/../../../div[3]/div/lightning-button-menu/button");
		} else {
			return By.xpath("//div["+divNr+"]//a[@title = 'Service']/../../../div[3]/div/lightning-button-menu/button");
		}
	}
	
	public By FinanceAction(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'Financial']/../../..//button[contains(@title, 'Actions')]");
		} else {
			return By.xpath("//a[@title = 'Financial']/../../..//button[contains(@title, 'Aktionen')]");
		}
	}
	
	public By productAction(String L, String prod, String version) {
		if (L.equals("E")) {
			return By.xpath("(//a[@title = '"+prod+"']/../../../div[3]/div/lightning-button-menu/button)["+version+"]");
		} else {
			return By.xpath("(//a[@title = '"+prod+"']/../../../div[3]/div/lightning-button-menu/button)["+version+"]");
		}
	}
	
	public By deleteProduct(String L, String prod, String version) {
		if (L.equals("E")) {
			return By.xpath("(//a[@title = '"+prod+"']/../../../div[3]/div/lightning-button-menu/button)["+version+"]/..//span[.= 'Delete']");
		} else {
			return By.xpath("(//a[@title = '"+prod+"']/../../../div[3]/div/lightning-button-menu/button)["+version+"]/..//span[.= 'Delete']");
		}
	}
	
	public By Confirm(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.= 'Confirm']");
		} else {
			return By.xpath("//button[.= 'Confirm']");
		}
	}
	
	public By FinanceZoom(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'Financial']/../../..//lightning-button-icon/button");
		} else {
			return By.xpath("//a[@title = 'Financial']/../../..//lightning-button-icon/button");
		}
	}
	
	public By TruckZoom(String L, String version) {
		if (L.equals("E")) {
			//return By.xpath("(//a[@title = 'Truck']/../../..//lightning-button-icon/button)["+version+"]");
			return By.xpath("(//button[@title= 'Zoom'])["+version+"]");
		} else {
			//return By.xpath("(//a[@title = 'Truck']/../../..//lightning-button-icon/button)["+version+"]");
			return By.xpath("(//button[@title= 'Zoom'])["+version+"]");
		}
	}
	
	public By StandardDiscont(String L) {
		if (L.equals("E")) {
			return By.xpath("//c-i-o-modal-wrapper//span[ .= 'Standard Discount']/../../div[2]/div/div[2]//lightning-icon");
		} else {
			return By.xpath("//c-i-o-modal-wrapper//span[ .= 'Standardnachlass']/../../div[2]/div/div[2]//lightning-icon");
		}
	}
	
	public By StandardDiscontProcent(String L) {
		if (L.equals("E")) {
			return By.xpath("//c-i-o-modal-wrapper//span[ .= 'Standard Discount']/../../div[2]/div/div[1]//lightning-icon");
		} else {
			return By.xpath("//c-i-o-modal-wrapper//span[ .= 'Standardnachlass']/../../div[2]/div/div[1]//lightning-icon");
		}
	}
	
	public By ModalTitle(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[@slot ='modalTitle']");
		} else {
			return By.xpath("//span[@slot ='modalTitle']");
		}
	}
	
	public By FinanceZoomFinancialDatails(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.= 'Financial Details']");
		} else {
			return By.xpath("//button[.= 'Financial Details']");
		}
	}
	
	public By FinanceContractStartDate(String L) {
		if (L.equals("E")) {
			return By.xpath("//c-i-o-value-field//span[.= 'Contract Start Date']/../../div[2]//lightning-primitive-icon");
		} else {
			return By.xpath("//c-i-o-value-field//span[.= 'Contract Start Date']/../../div[2]//lightning-primitive-icon");
		}
	}
	
	public By FinancePaymentMethod(String L) {
		if (L.equals("E")) {
			return By.xpath("//c-i-o-value-field//span[.= 'Payment Method']/../../div[2]//lightning-primitive-icon");
		} else {
			return By.xpath("//c-i-o-value-field//span[.= 'Payment Method']/../../div[2]//lightning-primitive-icon");
		}
	}
	
	public By ServiceName(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'Service']");
		} else {
			return By.xpath("//a[@title = 'Service']");
		}
	}
	
	public By ServiceZoom(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'Service']/../../..//lightning-button-icon/button");
		} else {
			return By.xpath("//a[@title = 'Service']/../../..//lightning-button-icon/button");
		}
	}
	
	public By ServiceMileageEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Current Offer Base']/../../../..//c-i-o-value-field[5]//div[2]//span/lightning-icon");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../..//c-i-o-value-field[5]//div[2]//span/lightning-icon");
		}
	}
	
	public By ServiceRuntimeEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Current Offer Base']/../../../..//c-i-o-value-field[4]//div[2]//span/lightning-icon");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../..//c-i-o-value-field[4]//div[2]//span/lightning-icon");
		}
	}
	
	public By ServicePartnerLocator(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.= 'Service Partner Locator']");
		} else {
			//return By.xpath("//button[.= 'Servicepartner-Finder']");
			return By.xpath("//button[.= 'Auswahl Servicewerkstatt']");
		}
	}
	
	public By ServicePartnerLocatorSearch(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[.= 'Cost Responsible Office']/../../div[1]//input");
		} else {
			return By.xpath("//div[.= 'Cost Responsible Office']/../../div[1]//input");
		}
	}
	
	public By ServicePartnerLocatorElement(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[.= 'Cost Responsible Office']/../../div[1]//li[1]/span");
		} else {
			return By.xpath("//div[.= 'Cost Responsible Office']/../../div[1]//li[1]/span");
		}
	}
	
	public By ServiceWorkshopPartner(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-formatted-text[ .= 'MAN Servicebetrieb München']/../../../../../td[1]//lightning-primitive-cell-checkbox");
		} else {
			return By.xpath("//lightning-formatted-text[ .= 'MAN Servicebetrieb München']/../../../../../td[1]//lightning-primitive-cell-checkbox");
		}
	}
	
	public By ServicePaymentTermEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//c-i-o-value-field//span[ .= 'Payment Term']/../../div[2]//lightning-primitive-icon");
		} else {
			return By.xpath("//c-i-o-value-field//span[ .= 'Payment Term']/../../div[2]//lightning-primitive-icon");
		}
	}
	
	public By ServicePaymentTerm(String L) {
		if (L.equals("E")) {
			return By.xpath("//c-i-o-value-field//span[ .= 'Payment Term']/../../div[2]//lightning-combobox//input");
		} else {
			return By.xpath("//c-i-o-value-field//span[ .= 'Payment Term']/../../div[2]//lightning-combobox//input");
		}
	}
	public By ServicePaymentTerm10Day(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[@ title = 'Payable within 10 days w/o deduction']");
		} else {
			return By.xpath("//span[@ title = 'Payable within 10 days w/o deduction']");
		}
	}
	
	public By FinancialContractStartDate(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[3]/div/div[2]//lightning-icon");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[3]/div/div[2]//lightning-icon");
		}
	}
	
	public By FinancialContractStartDateInput(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[3]/div/div[2]/div/c-i-o-value-field-input/div/div/div/div/div/lightning-input");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[3]/div/div[2]/div/c-i-o-value-field-input/div/div/div/div/div/lightning-input");
		}
	}
	
	
	public By FinancialRuntimeEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Current offer basis']/../../../../c-i-o-value-field[4]/div/div[2]//lightning-icon");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[4]/div/div[2]//lightning-icon");
		}
	}
	
	public By FinancialMileageEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Current offer basis']/../../../../c-i-o-value-field[5]/div/div[2]//lightning-icon");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[5]/div/div[2]//lightning-icon");
		}
	}
	
	public By FinancialBuyBackTypeEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Current offer basis']/../../../../c-i-o-value-field[10]/div/div[2]//lightning-icon");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[10]/div/div[2]//lightning-icon");
		}
	}
	
	public By FinancialBuyBackTypeDropDown(String L) {
		if (L.equals("E")) {
			return By.xpath("//input[@placeholder ='Select an Option']");
		} else {
			return By.xpath("//input[@placeholder ='Option auswählen']");
		}
	}
	
	public By FinancialBuyBackTypeClosed(String L) {
		if (L.equals("E")) {
			return By.xpath("//input[@placeholder ='Select an Option']/../../div[2]/lightning-base-combobox-item[2]");
		} else {
			return By.xpath("//input[@placeholder ='Option auswählen']/../../div[2]/lightning-base-combobox-item[2]");
		}
	}
	
	public By FinancialDownPayment(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Current offer basis']/../../../../c-i-o-value-field[6]/div/div[2]//lightning-icon");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[6]/div/div[2]//lightning-icon");
		}
	}
	
	public By FinancialAktuelleAngebotsgrundlage(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Current offer basis']");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']");
		}
	}
	
	public By CurrentOfferBase(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Current Offer Base']");
		} else {
			return By.xpath("//span[.='Aktuelle Angebotsgrundlage']");
		}
	}
	
	public By Close(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@title = 'Close']");
		} else {
			return By.xpath("//button[@title = 'Schließen']");
		}
	}
	
	public By ServicePartnerLocatorClose(String L) {
		if (L.equals("E")) {
			return By.xpath("//c-i-o-locator-map//button[@title = 'Close']");
		} else {
			return By.xpath("//c-i-o-locator-map//button[@title = 'Schließen']");
		}
	}
	
	public By SelectTIV(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Select TIV']/..");
		} else {
			//return By.xpath("//span[.= 'TIV auswählen']/..");
			return By.xpath("//span[.= 'Trade-In Fahrzeug auswählen']/..");
		}
	}
	
	public By RequestMRC(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Request MRC']/..");
		} else {
			//return By.xpath("//span[.= 'Anfrage MRC']/..");
			return By.xpath("//span[.= 'MRC anfragen']/..");
		}
	}
	
	public By Abakus(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'ABAKUS']/..");
		} else {
			return By.xpath("//span[.= 'ABAKUS']/..");
		}
	}
	
	public By AbakusUpdate(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'ABAKUS Update']/..");
		} else {
			return By.xpath("//span[.= 'ABAKUS Update']/..");
		}
	}
	
	public By BuyBackZoom(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title = 'Service']/../../..//lightning-button-icon/button");
		} else {
			return By.xpath("//a[@title = 'Service']/../../..//lightning-button-icon/button");
		}
	}

	
	public By C4S(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[contains(@title, 'Actions')]/../div/div/slot/c-i-o-configurator/c-i-o-configurator-button-renderer[1]/lightning-menu-item/a");
		} else {
			return By.xpath("//button[contains(@title, 'Aktionen')]/../div/div/slot/c-i-o-configurator/c-i-o-configurator-button-renderer[1]/lightning-menu-item/a");
		}
	}
	
	public By RelatedTab(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[contains(@data-label, 'Related') and (@id = 'relatedListsTab__item')]");
		} else {
			return By.xpath("//a[contains(@data-label, 'Verwandt') and contains(@tabindex, '-1')]");
		}
	}
	
	public By DetailsTab(String L) {
		if (L.equals("E")) {
			return By.xpath("//li[3]/a[contains(@data-label, 'Details')]");
		} else {
			return By.xpath("//li[3]/a[contains(@data-label, 'Details')]");
		}
	}
	
	public By ResidualValuesTab(String L) {
		if (L.equals("E")) {
			//return By.xpath("//a[contains(@data-label, 'Residual Values')]");
			return By.xpath("//a[contains(@data-label, 'Restwerte')]");
		} else {
			return By.xpath("//a[contains(@data-label, 'Restwerte')]");
		}
	}
	
	public By PartnerrollenTab(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[contains(@data-label, 'Partnerrollen')]");
		} else {
			return By.xpath("//a[contains(@data-label, 'Partnerrollen')]");
		}
	}
	
	public By ResidualValuesTabwithTitle(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[contains(@title, 'Residual Values')]");
		} else {
			return By.xpath("//a[contains(@title, 'Restwerte')]");
		}
	}
	
	public By ConfigurationFirstRowMANCode(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='MAN Code']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='MAN-Code']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_bodyTypeEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Body Type']/../../div[2]/button");
		} else {
			return By.xpath("//span[.='Aufbautyp']/../../div[2]/button");
		}
	}
	
	public By PLI_shippingTypeEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Shipping Type']/../../div[2]/button");
		} else {
			return By.xpath("//span[.='Shipping Type']/../../div[2]/button");
		}
	}
	
	public By PLI_deploymentTypeEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Deployment Type']/../../div[2]/button");
		} else {
			return By.xpath("//span[.='Deployment Type']/../../div[2]/button");
		}
	}
	
	public By PLI_deploymentTypeDropdown(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Deployment Type')]/..//input");
		} else {
			return By.xpath("//label[contains(text(),'Implementierungsart')]/..//input");
		}
	}
	
	public By PLI_deploymentTypeElementFernverkehr(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Deployment Type')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
		} else {
			return By.xpath("//label[contains(text(),'Implementierungsart')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
		}
	}
	
	public By PLI_Save(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[contains(@title, 'Save')]");
		} else {
			return By.xpath("//button[contains(@title, 'Speichern')]");
		}
	}
	
	public By NewVariant(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[contains(text(),'New Variant')]");
		} else {
			return By.xpath("//button[contains(text(),'New Variant')]");
		}
	}
	
	public By NameTextField(String L) {
		if (L.equals("E")) {
			return By.xpath("//input[@name = 'Proposal_Name']");
		} else {
			return By.xpath("//input[@name = 'Proposal_Name']");
		}
	}
	
	public By NewVariantText(String L) {
		if (L.equals("E")) {
			return By.xpath("//h2[.='New Variant']");
		} else {
			return By.xpath("//h2[.='New Variant']");
		}
	}
	
	public By printProposal(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[contains(text(),'Print Proposal')]");
		} else {
			return By.xpath("//button[contains(text(),'Angebot drucken')]");
		}
	}
	
	public By print(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.='Print']");
		} else {
			return By.xpath("//button[.='Druck']");
		}
	}
	
	public By Continue(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[ .= 'Continue']");
		} else {
			return By.xpath("//button[ .= 'Continue']");
		}
	}
	
	public By Order(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[contains(text(),'Submit for')]");
		} else {
			return By.xpath("//button[contains(text(),'Bestellen')]");
		}
	}
	
	public By printOrder(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[contains(text(),'Print Order')]");
		} else {
			return By.xpath("//button[contains(text(),'Bestellung drucken')]");
		}
	}
	
	public By SelectOrderType(String L) {
		if (L.equals("E")) {
			return By.xpath("//p[.= 'Select order type']");
		} else {
			return By.xpath("//p[.= 'Select order type']");
		}
	}
	
	public By FertigStellen(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@title = 'Finish']");
		} else {
			return By.xpath("//button[@title = 'Fertig stellen']");
		}
	}
	
	public By approval_start(String L) {
		if (L.equals("E")) {
			return By.xpath("//a[@title='Approve']");
		} else {
			return By.xpath("//a[@title='Genehmigen']");
		}
	}
	
	public By approval(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Approve']");
		} else {
			return By.xpath("//span[.='Genehmigen']");
		}
	}
	
	public By addProduct(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]//div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js//button[.= 'Add Product']");
		} else {
			//return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]//div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js//button[.= 'Add Product']");
			return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]//div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js//button[.= 'Produkt hinzufügen']");
		}
	}
	
	public By addProductSommer(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[4]/div[1]/section/div/div[2]/div[2]//button[.= 'Add Product']");
		} else {
			//return By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]//div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js//button[.= 'Add Product']");
			return By.xpath("/html/body/div[4]/div[1]/section/div/div[2]/div[2]//button[.= 'Add Product']");
		}
	}
	
	public By TradeInVehicleName(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-input/label[contains(text(), 'Vehicle Name')]/..//input");
		} else {
			return By.xpath("//lightning-input/label[contains(text(), 'Fahrzeugname')]/..//input");
		}
	}
	
	public By TradeInTruck(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Truck')]/..//input");
		} else {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Truck')]/..//input");
		}
	}
	
	public By TradeInEmission(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Emission Class')]/..//input");
		} else {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Emissionsklasse')]/..//input");
		}
	}
	
	public By TradeInEmissionValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Emission Class')]/..//lightning-base-combobox-item[2]");
		} else {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Emissionsklasse')]/..//lightning-base-combobox-item[2]");
		}
	}
	
	public By TradeInFIN(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-input/label[contains(text(), 'Vehicle Identification Number')]/..//input");
		} else {
			return By.xpath("//lightning-input/label[contains(text(), 'Fahrzeug-Identifikationsnummer')]/..//input");
		}
	}
	
	public By TradeInRegistrationDate(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/label[contains(text(), 'Registration Date')]/..//input");
		} else {
			return By.xpath("//div/label[contains(text(), 'Erstzulassung')]/..//input");
		}
	}
	
	public By TradeInMileage(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-input/label[contains(text(), 'Mileage (km)')]/..//input");
		} else {
			return By.xpath("//lightning-input/label[contains(text(), 'Laufleistung (KM)')]/..//input");
		}
	}
	
	public By TradeInDate(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/label[contains(text(), 'Trade-In Date')]/..//input");
		} else {
			return By.xpath("//div/label[contains(text(), 'Datum Inzahlungnahme')]/..//input");
		}
	}
	
	public By TradeInIntakeValueCustomer(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-input/label[contains(text(), 'Intake Value Customer')]/..//input");
		} else {
			return By.xpath("//lightning-input/label[contains(text(), 'Einnahmewert Kunde')]/..//input");
		}
	}
	
	public By TradeInIntakeValueUsed(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-input/label[contains(text(), 'Intake Value Used')]/..//input");
		} else {
			return By.xpath("//lightning-input/label[contains(text(), 'Verwendeter Einnahmewert')]/..//input");
		}
	}
	
	public By MileageDateReturn(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-input/label[contains(text(), 'Mileage at Date of Return')]/..//input");
		} else {
			return By.xpath("//lightning-input/label[contains(text(), 'Kilometerstand zum Rückgabedatum')]/..//input");
		}
	}
	
	public By TradeInCategory(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Trade-In Category')]/..//input");
		} else {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Kategorie Inzahlungnahme')]/..//input");
		}
	}
	
	public By TradeInCategorySonstige(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Trade-In Category')]/..//lightning-base-combobox-item[4]/span[2]/span");
		} else {
			return By.xpath("//lightning-combobox/label[contains(text(), 'Kategorie Inzahlungnahme')]/..//lightning-base-combobox-item[4]/span[2]/span");
		}
	}
	
	public By TradeInCreateVehicle(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.= 'Create']");
		} else {
			//return By.xpath("//button[.= 'Einfügen']");
			return By.xpath("//button[.= 'Erstellen']");
		}
	}
	
	public By TradeInUpdate(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.= 'Update']");
		} else {
			//return By.xpath("//button[.= 'Aktualisieren']");
			return By.xpath("//button[.= 'Update']");
		}
	}
	
	public By TradeIn(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[.= 'Create Vehicle']");
		} else {
			return By.xpath("//button[.= 'Create Vehicle']");
		}
	}


public By OrderLineItem(String L) {
        if (L.equals("E")) {
                        return By.xpath("//span[@title = 'Orders']/../../../../../..//table/tbody/tr/th/div/a");
        } else {
                        return By.xpath("//span[@title = 'Aufträge']/../../../../../..//table/tbody/tr/th/div/a");
        }
	}

public By NotesAndAttachments(String L) {
    if (L.equals("E")) {
                    return By.xpath("//span[@title = 'Notes & Attachments']");
    } else {
                    return By.xpath("//span[@title = 'Notizen & Anhänge']");
    }
}

public By Add(String L) {
    if (L.equals("E")) {
                    return By.xpath("//div/lightning-button/button[. = 'Add']");
    } else {
                    return By.xpath("//div/lightning-button/button[. = 'Hinzufügen']");
    }
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

public By VehicleUsage(String L) {
    if (L.equals("E")) {
                    return By.xpath("//label[.= 'Vehicle Usage']/../div/div/div/div/input");
    } else {
                    return By.xpath("//label[.= 'Vehicle Usage']/../div/div/div/div/input");
    }
}

public By ApplyFilters(String L) {
    if (L.equals("E")) {
                    return By.xpath("//button[@title= 'Apply Filters']");
    } else {
                    return By.xpath("//button[@title= 'Apply Filters']");
    }
}

public By PLI_RequestedDeliveryDateCustomer(String L) {
	if (L.equals("E")) {
        return By.xpath("//label[contains(text(),'Requested Delivery Date Customer')]/../div/input");
	} else {
        return By.xpath("//label[contains(text(),'Requested Delivery Date Customer')]/../div/input");
	}
}

public By OfferValidUntil(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'Fixed Price Valid Until']/../..//input");
	} else {
        return By.xpath("//span[ .= 'Fixed Price Valid Until']/../..//input");
	}
}

public By Zoom_PrePayment(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'Current basis for offer']/..//table//tr[6]//c-i-o-value-field-input/div/div/span/div");
	} else {
        //return By.xpath("//span[ .= 'Basis für Angebot']/..//table//tr[6]//c-i-o-value-field-input/div/div/span/div");
        return By.xpath("//span[ .= 'Aktuelle Angebotsgrundlage']/..//table//tr[6]//c-i-o-value-field-input/div/div/span/div");
	}
}

public By Zoom_Subsidy(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'Current basis for offer']/..//table//tr[7]//c-i-o-value-field-input/div/div/span/div");
	} else {
        //return By.xpath("//span[ .= 'Basis für Angebot']/..//table//tr[7]//c-i-o-value-field-input/div/div/span/div");
        return By.xpath("//span[ .= 'Aktuelle Angebotsgrundlage']/..//table//tr[7]//c-i-o-value-field-input/div/div/span/div");
	}
}

public By Zoom_CustomerFinanceRate(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'Current basis for offer']/..//table//tr[12]//c-i-o-value-field-input/div/div/span/div");
	} else {
        //return By.xpath("//span[ .= 'Basis für Angebot']/..//table//tr[13]//c-i-o-value-field-input/div/div/span/div");
        return By.xpath("//span[ .= 'Aktuelle Angebotsgrundlage']/..//table//tr[13]//c-i-o-value-field-input/div/div/span/div");
	}
}

public By Zoom_TotalRate(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'Current basis for offer']/..//table//tr[13]//c-i-o-value-field-input/div/div/span/div");
	} else {
        //return By.xpath("//span[ .= 'Basis für Angebot']/..//table//tr[14]//c-i-o-value-field-input/div/div/span/div");
        return By.xpath("//span[ .= 'Aktuelle Angebotsgrundlage']/..//table//tr[14]//c-i-o-value-field-input/div/div/span/div");
	}
}

public By RuntimeMileage(String L, String runtime, String mileage) {
	if (L.equals("E")) {
        return By.xpath("//td[ .= '"+runtime+"']/../td["+mileage+"]//label");
	} else {
		return By.xpath("//td[ .= '"+runtime+"']/../td["+mileage+"]//label");
	}
}

public By AddResidualValue(String L) {
	if (L.equals("E")) {
        return By.xpath("//button[ .= 'Add Residual Value']");
	} else {
		return By.xpath("//button[ .= 'Restwert hinzufügen']");
	}
}

public By ResidualValue120000_36(String L) {
	if (L.equals("E")) {
        return By.xpath("//input[@name = '120000-36']/../label");
	} else {
		return By.xpath("//input[@name = '120000-36']/../label");
	}
}

public By ResidualValueCustomerField(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Residual Value Customer']/span");
	} else {
		return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Kunde Restwert']/span");
	}
}

public By ResidualValueCustomerEdit(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Residual Value Customer']/span/button");
	} else {
		return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Kunde Restwert']/span/button");
	}
}

public By ResidualValueDateField(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Expires']/span");
	} else {
		return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Läuft ab']/span");
	}
}

public By ResidualValueDateEdit(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Expires']/span/button");
	} else {
		return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Läuft ab']/span/button");
	}
}

public By ResidualValueUsedField(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Residual Value Used']/span");
	} else {
		return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Verwendeter Restwert']/span");
	}
}

public By ResidualValueUsedEdit(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Residual Value Used']/span/button");
	} else {
		return By.xpath("//lightning-primitive-cell-factory[ @data-label = 'Verwendeter Restwert']/span/button");
	}
}

public By ResidualRestwerttabelle(String L) {
	if (L.equals("E")) {
		return By.xpath("//h2/span[.= 'Residual Value List']");
		//return By.xpath("//h2/span[.= 'Restwerte']");
	} else {
		return By.xpath("//h2/span[.= 'Restwerte']");
	}
}


public By CalculateRV(String L) {
	if (L.equals("E")) {
        return By.xpath("//button[ .= 'Calculate RV']");
	} else {
		return By.xpath("//button[ .= 'Restwert berechnen']");
	}
}

public By SetActive(String L) {
	if (L.equals("E")) {
        return By.xpath("//button[ .= 'Set Active']");
	} else {
		//return By.xpath("//button[ .= 'Auf aktiv setzen']");
		return By.xpath("//button[ .= 'Aktivieren']");
	}
}

public By ResidualValueSave(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-primitive-datatable-status-bar//button[.= 'Save']");
	} else {
		return By.xpath("//lightning-primitive-datatable-status-bar//button[.= 'Speichern']");
	}
}

public By ResidualValueRadio(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-primitive-cell-checkbox/span[.= 'Select Item 1']");
	} else {
		return By.xpath("//lightning-primitive-cell-checkbox/span[.= 'Element auswählen 1']");
	}
}

public By C4SUpdatedSuccessfullyMessage(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'The vehicle configuration has been updated successfully.']");
        //return By.xpath("//span[ .= 'The vehicle configuration is updating.']");
	} else {
		//return By.xpath("//span[ .= 'The vehicle configuration has been updated successfully.']");
		return By.xpath("//span[ .= 'Die Fahrzeugkonfiguration wurde erfolgreich aktualisiert.']");
	}
}

public By ProposalUpdatingMessage(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'The proposal is updating']");
        //return By.xpath("//span[ .= 'The vehicle configuration is updating.']");
	} else {
		//return By.xpath("//span[ .= 'The vehicle configuration has been updated successfully.']");
		return By.xpath("//span[ .= 'The proposal is updating']");
	}
}

public By AbakusUpdatedSuccessfullyMessage(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'Data updated successfully.']");
	} else {
		//return By.xpath("//span[ .= 'Daten erfolgreich aktualisiert']");
		return By.xpath("//span[ .= 'Daten wurden erfolgreich aktualisiert.']");
	}
}

public By TruckAddedMessage(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= 'Current selection has been added.']");
	} else {
		return By.xpath("//span[ .= 'Ihre Auswahl wurde hinzugefügt']");
	}
}

public By Validator(String L, String i) {
	if (L.equals("E")) {
        return By.xpath("//span[@title = 'Validator ("+i+")']");
	} else {
		return By.xpath("//span[@title = 'Gültigkeitsprüfung ("+i+")']");
	}
}

public By Validator(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[contains(text(), 'Validator')]");
	} else {
		return By.xpath("//span[contains(text(), 'Validator')]");
	}
}

public By ValidatorAbakus(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[contains(text(), 'Validator')]/../../../..//p[contains(text(), 'ABAKUS')]");
	} else {
		return By.xpath("//span[contains(text(), 'Validator')]/../../../..//p[contains(text(), 'ABAKUS')]");
	}
}

public By AbakusOpenError(String L) {
	if (L.equals("E")) {
        return By.xpath("//div/b[contains(text(), 'In diesem Flow ist ein nicht bearbeiteter Fehler aufgetreten')]");
	} else {
		return By.xpath("//div/b[contains(text(), 'In diesem Flow ist ein nicht bearbeiteter Fehler aufgetreten')]");
	}
}

public By AbakusOpenErrorClose(String L) {
	if (L.equals("E")) {
        return By.xpath("//button[@class = 'slds-button slds-button_icon slds-modal__close slds-button_icon-border']");
	} else {
		return By.xpath("//button[@class = 'slds-button slds-button_icon slds-modal__close slds-button_icon-border']");
	}
}

public By CustomerEndPriceValue(String L, String version) {
	if (L.equals("E")) {
        return By.xpath("(//span[.= 'Customer End Price']/../../div[2]//span/div)["+version+"]");
	} else {
		return By.xpath("(//span[.= 'Kundenendpreis']/../../div[2]//span/div)[1]");
	}
}

public By Commission(String L, String version) {
	if (L.equals("E")) {
        return By.xpath("(//span[@title = 'Commission'])["+version+"]");
	} else {
		return By.xpath("(//span[@title = 'Commission'])["+version+"]");
	}
}

public By Fahrzeugprovision(String L, String version) {
	if (L.equals("E")) {
        return By.xpath("(//span[ .= 'Fahrzeugprovision']/../../div[2]/span)["+version+"]");
	} else {
		return By.xpath("(//span[ .= 'Fahrzeugprovision']/../../div[2]/span)["+version+"]");
	}
}

public By FahrzeugprovisionShowText(String L) {
	if (L.equals("E")) {
        return By.xpath("//div[contains(text(),'NV large order')]");
	} else {
		return By.xpath("//div[contains(text(),'NV large order')]");
	}
}

public By EnterProvisions(String L) {
	if (L.equals("E")) {
        return By.xpath("//h2[ .= 'Enter Provisions']");
	} else {
		return By.xpath("//h2[ .= 'Provisionen erfassen']");
	}
}

public By SplitinPercentEdit(String L) {
	if (L.equals("E")) {
        return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr[1]/td[3]//button");
	} else {
		return By.xpath("//h2[ .= 'Enter Provisions']/../../c-i-o-data-table/div//tbody/tr[1]/td[3]//button");
	}
}

public By PartnerRole(String L) {
	if (L.equals("E")) {
        return By.xpath("//label[ .= 'Partner Role']/..//input");
	} else {
		return By.xpath("//label[ .= 'Partner Role']/..//input");
	}
}

public By ProdPartnerRole(String L) {
	if (L.equals("E")) {
        return By.xpath("//label[ .= 'Role']/..//input");
	} else {
		return By.xpath("//label[ .= 'Role']/..//input");
	}
}

public By PRSaleRep2(String L) {
	if (L.equals("E")) {
        return By.xpath("//lightning-base-combobox-item[5]/span[2]/span");
	} else {
		return By.xpath("//lightning-base-combobox-item[5]/span[2]/span");
	}
}

public By PRelement(String L, String name) {
	if (L.equals("E")) {
        return By.xpath("//lightning-base-combobox-item/span[2]/span[.='"+name+"']");
	} else {
		return By.xpath("//lightning-base-combobox-item/span[2]/span[.='"+name+"']");
	}
}

public By PRContact(String L) {
	if (L.equals("E")) {
        return By.xpath("//label[ .= 'Contact']/../div//input");
	} else {
		return By.xpath("//label[ .= 'Contact']/../div//input");
	}
}

public By PRAccount(String L) {
	if (L.equals("E")) {
        return By.xpath("//label[ .= 'Account']/../div//input");
	} else {
		return By.xpath("//label[ .= 'Account']/../div//input");
	}
}

public By PRContactName(String L, String name) {
	if (L.equals("E")) {
        return By.xpath("//span[ .= '"+name+"']");
	} else {
		return By.xpath("//span[ .= '"+name+"']");
	}
}

public By PRCommissionEdit(String L, String name) {
	if (L.equals("E")) {
        return By.xpath("//a[ .= '"+name+"']/../../../../../../td[4]//lightning-primitive-icon");
	} else {
		return By.xpath("//a[ .= '"+name+"']/../../../../../../td[4]//lightning-primitive-icon");
	}
}

public By QuantityEdit(String L, String version) {
	if (L.equals("E")) {
        return By.xpath("(//span[.= 'Unit']/../../div[2]//lightning-primitive-icon)["+version+"]");
        //return By.xpath("(//span[.= 'Quantity']/../../div[2]//lightning-primitive-icon)["+version+"]");
	} else {
		return By.xpath("(//span[.= 'Unit']/../../div[2]//lightning-primitive-icon)["+version+"]");
		//return By.xpath("(//span[.= 'Quantity']/../../div[2]//lightning-primitive-icon)["+version+"]");
	}
}

public By QuantityField(String L, String version) {
	if (L.equals("E")) {
		return By.xpath("(//span[.= 'Unit']/../../div[2]/div/c-i-o-value-field-input/div/div/span/div)["+version+"]");
        //return By.xpath("(//span[.= 'Quantity']/../../div[2]/div/c-i-o-value-field-input/div/div/span/div)["+version+"]");
	} else {
		return By.xpath("(//span[.= 'Unit']/../../div[2]/div/c-i-o-value-field-input/div/div/span/div)["+version+"]");
		//return By.xpath("(//span[.= 'Quantity']/../../div[2]/div/c-i-o-value-field-input/div/div/span/div)["+version+"]");
	}
}

public By QuantityText(String L, String version) {
	if (L.equals("E")) {
        return By.xpath("(//span[.= 'Unit'])["+version+"]");
        //return By.xpath("(//span[.= 'Quantity'])["+version+"]");
	} else {
		return By.xpath("(//span[.= 'Unit'])["+version+"]");
		//return By.xpath("(//span[.= 'Quantity'])["+version+"]");
	}
}

public By EditOrderReason(String L) {
	if (L.equals("E")) {
        return By.xpath("//button[@title = 'Edit Order Reason']");
	} else {
		return By.xpath("//button[@title = 'Edit Order Reason']");
	}
}

public By OrderReasonDropdown(String L) {
	if (L.equals("E")) {
        return By.xpath("//label[contains(text(),'Order Reason')]/..//input");
	} else {
		return By.xpath("//label[contains(text(),'Order Reason')]/..//input");
	}
}

public By MunicipalOrder(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[@title = 'Municipal Order']/../..");
	} else {
		return By.xpath("//span[@title = 'Municipal Order']/../..");
	}
}

public By CustomerTypeDropdown(String L) {
	if (L.equals("E")) {
        return By.xpath("//label[contains(text(),'Customer Type')]/..//input");
	} else {
		return By.xpath("//label[contains(text(),'Customer Type')]/..//input");
	}
}

public By MunicipalCustomer(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[@title = 'Municipal']/../..");
	} else {
		return By.xpath("//span[@title = 'Municipal']/../..");
	}
}

public By OrderReasonText(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[.= 'Order Reason']/../../div[2]//lightning-formatted-text");
	} else {
		return By.xpath("//span[.= 'Order Reason']/../../div[2]//lightning-formatted-text");
	}
}

public By ThermometerPrice(String L, String version) {
	if (L.equals("E")) {
        return By.xpath("(//div[@class='price-range__currentvalue'])["+version+"]");
	} else {
		return By.xpath("(//div[@class='price-range__currentvalue'])["+version+"]");
	}
}

public By GeneralProposalData(String L) {
	if (L.equals("E")) {
        return By.xpath("//span[.= 'General Proposal Data']");
	} else {
		return By.xpath("//span[.= 'General Proposal Data']");
	}
}

public By PrintMenuTemplate(String L) {
	if (L.equals("E")) {
        return By.xpath("//div[(.= 'Print Menu Template') and (@class = 'richTextLabel')]");
	} else {
		return By.xpath("//div[(.= 'Print Menu Template') and (@class = 'richTextLabel')]");
	}
}

public By PrintGeneral(String L) {
	if (L.equals("E")) {
        return By.xpath("//a[.= 'General']");
	} else {
		return By.xpath("//a[.= 'General']");
	}
}

public By YourDocument(String L) {
	if (L.equals("E")) {
        return By.xpath("//p[contains(text(),'Your document')]");
	} else {
		return By.xpath("//p[contains(text(),'Your document')]");
	}
}

public By TheCurrentCustomer (String L) {
	if (L.equals("E")) {
        return By.xpath("//p[contains(text(),'The current Customer ')]");
	} else {
		return By.xpath("//p[contains(text(),'The current Customer ')]");
	}
}
	
	//public By CurrenPriceValue = By.xpath("//div[@class = 'price-range__currentvalue']");
	//public By lineItemTruck = By.xpath("//span[contains(@title, 'Angebotspositionen')]/../../../../../../div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr[1]/th/div/a");
	
	//public By ProposalName = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/article/div/div[2]/div/div/flowruntime-flow-screen-input/flowruntime-input-wrapper2/div/lightning-input/div/input");
	//public By Next = By.xpath("//button[@title = 'Weiter']");
	//public By Continue = By.xpath("//button[ .= 'Continue']");
	//public By FertigStellen = By.xpath("//button[@title = 'Fertig stellen']");
	//public By ShippingType = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[3]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div/a");
	public By OrderReason = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/a");
	public By ApplicationBasedSegmentTruck = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[3]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/a");
	//public By OfferValidUntil = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/article/div[3]/div/div[2]/div/div/div[3]/div[1]/div/div/div/div/input");
	//public By Save = By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/div/button[3]");
	
	//public By AddProduct = By.xpath("//button[contains(@title, 'Produkt hinzuf�gen')]");
	
	public By TradeInTruckValue= By.xpath("//lightning-base-combobox-item[2]/span[2]");
	
	public By SubGarantieSecondLine = By.xpath("//lightning-formatted-text[.= '61A']/../../../../../td[2]//lightning-formatted-text[.= 'TGX']/../../../../../th//lightning-primitive-cell-button");
	public By SubGarantieSecondLineKombi = By.xpath("(//lightning-formatted-text[.= '4A2']/../../../../../td[2]//lightning-formatted-text[.= 'TGX']/../../../../../th//lightning-primitive-cell-button)[1]");
	public By addWarranty = By.xpath("//button[contains(text(),'Garantieverlängerung')]");
	public By addFinance = By.xpath("//button[contains(text(),'Finance')]");
	public By addBuyBack = By.xpath("//button[contains(text(),'Buy Back')]");
	public By addTradeIn = By.xpath("//button[contains(text(),'Inzahlungnahme')]");
	
	public By TGL = By.xpath("//a[contains(@data-label, 'TGL')]");
	public By TGM = By.xpath("//a[contains(@data-label, 'TGM')]");
	public By TGS = By.xpath("//a[contains(@data-label, 'TGS')]");
	public By TGX = By.xpath("//a[contains(@data-label, 'TGX')]");
	
	
	//public By AddNewTruck = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/c-i-o-proposal-pricing/div/div[1]/div/div/div/c-i-o-product-add-tile/div/div[2]/div/button");
	public By addTGL = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/c-i-o-proposal-pricing/div/div[1]/div/div/div/c-i-o-product-add-tile/div[2]/c-i-o-item-selector/div/c-i-o-modal-wrapper/div/div/div/section/div/div/slot/div/div/div[1]/div/c-i-o-item-selector-product-view/div/div/div[2]/div/div[2]/lightning-button-icon/button");
	//public By SaveNewTruck = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c/flexipage-record-page-decorator/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2[1]/force-progressive-renderer/slot/slot/c-i-o-proposal-pricing/lightning-card/article/div/slot/div/div[1]/div[1]/div/div/c-i-o-product-add-tile/div[2]/c-i-o-item-selector/div/c-i-o-modal-wrapper/div/div/div/section/div/footer/slot/div/span/lightning-button/button");
	//public By SaveNewTruck = By.xpath("//button[contains(@title, 'Proposal aktualisieren')]");

	//public By printProposal = By.xpath("//span[contains(text(),'Angebot drucken')]");
	//public By printOrder = By.xpath("//span[contains(text(),'Auftrag drucken')]");
	public By Order = By.xpath("//runtime_platform_actions-ribbon-menu-item/a/span[contains(text(),'Bestellen')]");
	//public By print = By.xpath("//button[.='Print']");
	//public By approval_start = By.xpath("//a[@title='Approve']");
	//public By approval = By.xpath("//span[.='Approve']");
	
	public By flowOrder = By.xpath("//li/a[(@data-tab-name='Order') and (@aria-selected='true')]");
	public By orderNummer = By.xpath("//span[@title='Aufträge']/../../../../../../div[2]/div/div/div/div/div[3]/div/div/table/tbody/tr/th/div/a");
	
	//public By PricingTab = By.xpath("//a[contains(@data-label, 'Pricing') ]");
	public By DetailsTab = By.xpath("//li[contains(@title, 'Verwandt') ]/following-sibling::li[contains(@title, 'Details') ]/a");
	//public By RelatedTab = By.xpath("//a[contains(@data-label, 'Verwandt') and contains(@tabindex, '-1')]");
	
	
	public By RelatedTabTemp = By.xpath("/html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/one-record-home-flexipage2/forcegenerated-flexipage_default_rec_l_configuration__c/flexipage-record-page-decorator/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[1]/a");
	
	public By DetailsTabAfterC4S = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[1]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[3]/a");
	//public By RelatedTabAfterC4S = By.xpath("/html/body/div[4]/div[1]/section/div/div/div[1]/div[1]/div/one-record-home-flexipage2/forcegenerated-flexipage_proposal_record_record_page_clone_proposal__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-single-col-template-desktop2/div/div[2]/div/slot/slot/flexipage-component2[3]/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]/a");

	
	public By Details_OfferValidUntil = By.xpath("//span[contains(text(),'Angebot g�ltig bis')]/..//following-sibling::div/span/slot/slot/lightning-formatted-text");
	public By Details_DistributionChannel = By.xpath("//span[contains(text(),'Vertriebsweg')]/..//following-sibling::div/span/slot/slot/lightning-formatted-text");
	
	//public By BasicVehiclePrice = By.xpath("//span[contains(text(),'Basic Vehicle Price')]/../../div[2]/div/c-i-o-value-field-input/div/div/span/div");
	
	//public By C4SButton_Show = By.xpath("//button[contains(@title, 'Aktionen')]");
	//public By C4S = By.xpath("//button[contains(@title, 'Aktionen')]/../div/div/slot/c-i-o-configurator/c-i-o-configurator-button-renderer[1]/div/lightning-menu-item/a/span");
	//public By C4S = By.xpath("//button[contains(@title, 'Aktionen')]/../div/div/slot/c-i-o-configurator/c-i-o-configurator-button-renderer[1]/lightning-menu-item/a");
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
	//public By ConfigurationFirstRowMANCode = By.xpath("//span[.='MAN Code']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
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
	
	
	
	public By closeWindow = By.xpath("//button[contains(@title, 'Dieses Fenster schließen')]");
	
	public By Blank = By.xpath("");

}
