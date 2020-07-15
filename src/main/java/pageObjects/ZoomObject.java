package pageObjects;

import org.openqa.selenium.By;

public class ZoomObject {
	
	public By subProductSearch(String name) {
		return By.xpath("//span[. = '"+ name +"']");
	}
	
	public By subProductGKostenEditSearch(int element, String name) {
		return By.xpath("(//span[.= 'External service'])["+ element +"]/../../../../c-i-o-value-field["+ name +"]/div/div[2]//lightning-primitive-icon");
	}
	
	public By subProductMRatenEditSearch(String name) {
		return By.xpath("//span[. = '"+ name +"']/../../../../c-i-o-value-field[8]/div/div[2]//lightning-primitive-icon");
	}
	
	public By subProductEntfernungDropdownSearch(int element, String name) {
		return By.xpath("(//span[.= 'External service'])["+ element +"]/../../../../c-i-o-value-field["+ name +"]/div/div[2]//input");
	}
	
	public By subProductEntfernungDropdownElementSearch(int element, String name) {
		return By.xpath("(//span[.= 'External service'])["+ element +"]/../../../../c-i-o-value-field["+ name +"]/div/div[2]//input/../..//lightning-base-combobox-item[2]/span[2]/span");
	}
	
	public By subProductGKostenFokusSearch(int element, String name) {
		return By.xpath("(//span[.= 'External service'])["+ element +"]/../../../../c-i-o-value-field["+ name +"]/div");
	}
	
	public By AddCostSubsidySearch(String name) {
		return By.xpath("//span[@title='" +name+ "']/..");
	}
	
	public By AddCostSubsidySubSearch(String name) {
		return By.xpath("//span[contains(text(),'" +name+ "')]/../lightning-button-icon");
	}
	
	public By directCostEditSearch(String name) {
		return By.xpath("//c-i-o-value-field//span[contains(text(), '"+ name +"')]/../../div[2]//span/lightning-icon");
	}
	
	public By subServiceSearch(int element) {
		return By.xpath("(//span[.= 'External service'])["+ element +"]/../../../../c-i-o-value-field[1]/div/div/span");
	}
	
	public By PaymentTermElementSearch(String element) {
			return By.xpath("//span[@title = '"+ element + "']");
	}
	
	
	public By ButtonVehicleDetail(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[ .= 'Details']");
		} else {
			return By.xpath("//button[ .= 'Details']");
		}
	}
	
	public By ButtonSpecialDirectCosts(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[ .= 'Special Direct Costs']");
		} else {
			return By.xpath("//button[ .= 'Special Direct Costs']");
		}
	}
	
	public By ButtonMainServiceDetails(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[ .= 'Details']");
		} else {
			return By.xpath("//button[ .= 'Details']");
		}
	}
	
	public By ButtonMainServiceZusatzservices(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[ .= 'Additional Services']");
		} else {
			return By.xpath("//button[ .= 'Zusatzservices']");
		}
	}
	
	public By ButtonMainServiceSubsidy(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[ .= 'Subsidy']");
		} else {
			return By.xpath("//button[ .= 'Subsidy']");
		}
	}
	
	public By Save1(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/div[1]/c-i-o-tile-section//button[@name = 'update']");
		} else {
			return By.xpath("//div/div[1]/c-i-o-tile-section//button[@name = 'update']");
		}
	}
	
	public By Save2(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/div[2]/c-i-o-tile-section//button[@name = 'update']");
		} else {
			return By.xpath("//div/div[2]/c-i-o-tile-section//button[@name = 'update']");
		}
	}
	
	public By Close(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@title = 'Close']");
		} else {
			return By.xpath("//button[@title = 'Schließen']");
		}
	}
	
	public By InflationaryPlannedCosts(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Current Offer Base']/../../../../c-i-o-value-field[6]/div/div[2]/div/c-i-o-value-field-input/div/div/span/div");
		} else {
			return By.xpath("//span[ .= 'Aktuelle Angebotsgrundlage']/../../../../c-i-o-value-field[6]/div/div[2]/div/c-i-o-value-field-input/div/div/span/div");
		}
	}
	
	public By PLI_bodyTypeDropdown(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Body Type')]/../div/lightning-base-combobox/div/div/input");
		} else {
			return By.xpath("//label[contains(text(),'Aufbautyp')]/../div/lightning-base-combobox/div/div/input");
		}
	}
	
	public By PLI_bodyTypeElementSonstiges(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Body Type')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[64]/span[2]/span");
		} else {
			return By.xpath("//label[contains(text(),'Aufbautyp')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[64]/span[2]/span");
		}
	}
	
	public By PLI_shippingTypeDropdown(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Shipping Type')]/../div/lightning-base-combobox/div/div/input");
		} else {
			return By.xpath("//label[contains(text(),'Versandart')]/../div/lightning-base-combobox/div/div/input");
		}
	}
	
	public By PaymentTermDropdown(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Payment Term')]/../div/lightning-base-combobox/div/div/input");
		} else {
			return By.xpath("//label[contains(text(),'Payment Term')]/../div/lightning-base-combobox/div/div/input");
		}
	}
	
	public By PLI_shippingTypeElementPickup(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Shipping Type')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
		} else {
			return By.xpath("//label[contains(text(),'Versandart')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
		}
	}
	
	public By RequestedDeliveryDateCountry(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Requested Delivery Date Country']/..//lightning-formatted-text");
		} else {
			return By.xpath("//span[.= 'Requested Delivery Date Country']/..//lightning-formatted-text");
		}
	}
	
	public By RequestedDeliveryDateCustomer(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[.= 'Requested Delivery Date Customer']/..//input");
		} else {
			return By.xpath("//label[.= 'Requested Delivery Date Customer']/..//input");
		}
	}
	
	public By AddSpecialDirectCost(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@value='Add SDC']");
		} else {
			return By.xpath("//button[@value='Add SDC']");
		}
	}
	
	public By TotalVehicleNet(String L) {
		if (L.equals("E")) {
			return By.xpath("(//span[.= 'Total vehicle (net)'])[2]/../../div[2]//span[.= 'Edit']/..");
		} else {
			return By.xpath("(//span[.= 'Gesamt Fahrzeug (netto)'])[2]/../../div[2]//span[.= 'Ändern']/..");
		}
	}
	
	public By TotalVehicleNetText(String L) {
		if (L.equals("E")) {
			return By.xpath("(//span[.= 'Total vehicle (net)'])[2]");
		} else {
			return By.xpath("(//span[.= 'Gesamt Fahrzeug (netto)'])[2]");
		}
	}
	
	public By OrderBurdenRateValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Order Burden Rate']/../../div[2]/div[1]/div[2]//span/div");
		} else {
			return By.xpath("//span[.= 'Order Burden Rate']/../../div[2]/div[1]/div[2]//span/div");
		}
	}
	
	public By ABLExternValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'ABL Extern']/../../div[2]//span/div");
		} else {
			return By.xpath("//span[.= 'ABL Extern']/../../div[2]//span/div");
		}
	}
	
	public By CM2Value(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'CM2']/../../div[2]/div[1]/div[2]//span/div");
		} else {
			return By.xpath("//span[.= 'CM2']/../../div[2]/div[1]/div[2]//span/div");
		}
	}
	
	public By VehicleCommission(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Vehicle Commission']/../../div[2]//span/div");
		} else {
			return By.xpath("//span[.= 'Vehicle Commission']/../../div[2]//span/div");
		}
	}
	
	public By BasePrice(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Base Price']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'Base Price']/../../div[2]/div//span/div");
		}
	}
	
	public By Topoptions(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Top options (gross) including price increase']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'Top options (gross) including price increase']/../../div[2]/div//span/div");
		}
	}
	
	public By BruttolistenpreisSumme(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Bruttolistenpreis (Summe)']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'Bruttolistenpreis (Summe)']/../../div[2]/div//span/div");
		}
	}
	
	public By TotalDiscount(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Total Discount']/../../div[2]/div/div[2]//span/div");
		} else {
			return By.xpath("//span[.= 'Total Discount']/../../div[2]/div/div[2]//span/div");
		}
	}
	
	public By TotalvehicleNetLeft(String L) {
		if (L.equals("E")) {
			return By.xpath("(//span[.= 'Total vehicle (net)'])[1]/../../div[2]/div//span/div");
		} else {
			return By.xpath("(//span[.= 'Total vehicle (net)'])[1]/../../div[2]/div//span/div");
		}
	}
	
	public By TotalvehicleNetRight(String L) {
		if (L.equals("E")) {
			return By.xpath("(//span[.= 'Total vehicle (net)'])[2]/../../div[2]/div//span/div");
		} else {
			return By.xpath("(//span[.= 'Total vehicle (net)'])[2]/../../div[2]/div//span/div");
		}
	}
	
	public By VCodesNet(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'V-Codes (Net)']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'V-Codes (Net)']/../../div[2]/div//span/div");
		}
	}
	
	public By VAT(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'VAT']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'VAT']/../../div[2]/div//span/div");
		}
	}
	
	public By TotalvehicleVAT(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Total vehicle (incl. VAT)']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'Total vehicle (incl. VAT)']/../../div[2]/div//span/div");
		}
	}
	
	public By LocalOptionalFeatures(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Local Optional Features']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'Local Optional Features']/../../div[2]/div//span/div");
		}
	}
	
	public By Subsidy(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Subsidy']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'Subsidy']/../../div[2]/div//span/div");
		}
	}
	
	public By SpecialDirectCosts(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Special Direct Costs (SUM)']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'Special Direct Costs (SUM)']/../../div[2]/div//span/div");
		}
	}
	
	public By ChargeTransportNet(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Charge / Transport (Net)']/../../div[2]/div//span/div");
		} else {
			return By.xpath("//span[.= 'Charge / Transport (Net)']/../../div[2]/div//span/div");
		}
	}
	
	public By TruckHeadlineText(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'Only for one truck headline']");
		} else {
			return By.xpath("//span[.= 'Only for one truck headline']");
		}
	}
	
	public By SalesSubsidyText(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Sales Subsidy']");
		} else {
			return By.xpath("//span[ .= 'Sales Subsidy']");
		}
	}
	
	public By ProdSalesSubsidyText(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Verkaufssubvention']");
		} else {
			return By.xpath("//span[ .= 'Verkaufssubvention']");
		}
	}
	
	public By SalesSubsidyEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Sales Subsidy']/../../div[2]//lightning-primitive-icon");
		} else {
			return By.xpath("//span[ .= 'Sales Subsidy']/../../div[2]//lightning-primitive-icon");
		}
	}
	
	public By ProdSalesSubsidyEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Verkaufssubvention']/../../div[2]//lightning-primitive-icon");
		} else {
			return By.xpath("//span[ .= 'Verkaufssubvention']/../../div[2]//lightning-primitive-icon");
		}
	}
	

}
