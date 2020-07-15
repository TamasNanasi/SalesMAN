package pageObjects;

import org.openqa.selenium.By;

public class PLI_ServiceObject {
	
	public By linkToProposal(String L, String proposal) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Proposal']/../../div[2]/../../../../../../force-record-layout-row[1]//a[ .= '" + proposal + "']");
		} else {
			return By.xpath("//span[ .= 'Proposal']/../../div[2]/../../../../../../force-record-layout-row[1]//a[ .= '" + proposal + "']");
		}
	}
	
	public By priceTypeEdit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Price Type']/../../div[2]/button");
		} else {
			return By.xpath("//span[ .= 'Zahlungsart']/../../div[2]/button");
		}
	}
	
	public By priceType(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[ .= 'Price Type']/..//input");
		} else {
			return By.xpath("//label[ .= 'Preistyp']/..//input");
		}
	}
	
	public By priceTypeValueFestprice(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[ .= 'Price Type']/..//lightning-base-combobox-item[2]/span[2]/span");
		} else {
			return By.xpath("//label[ .= 'Preistyp']/..//lightning-base-combobox-item[2]/span[2]/span");
		}
	}
	
	public By priceDate(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[ .= 'Price Date']/..//input");
		} else {
			return By.xpath("//label[ .= 'Preisdatum']/..//input");
		}
	}
	
	public By CostResponsibleWorkshopDropdown(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[ .= 'Cost Responsible Workshop']/..//input");
		} else {
			return By.xpath("//label[ .= 'Cost Responsible Workshop']/..//input");
		}
	}
	
	public By CostResponsibleWorkshopElementDV12(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[ .= 'Cost Responsible Workshop']/../div/div/lightning-base-combobox/div/div[2]/ul/li[2]/lightning-base-combobox-item");
		} else {
			return By.xpath("//label[ .= 'Cost Responsible Workshop']/../div/div/lightning-base-combobox/div/div[2]/ul/li[2]/lightning-base-combobox-item");
		}
	}
	
	public By PLI_deploymentTypeDropdown(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Deployment Type')]/..//input");
		} else {
			return By.xpath("//label[contains(text(),'Einsatzart')]/..//input");
		}
	}
	
	public By PLI_deploymentTypeElementFernverkehr(String L) {
		if (L.equals("E")) {
			return By.xpath("//label[contains(text(),'Deployment Type')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
		} else {
			return By.xpath("//label[contains(text(),'Einsatzart')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span");
		}
	}
	
	public By Save(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@title = 'Save']");
		} else {
			return By.xpath("//button[@title = 'Speichern']");
		}
	}
	
	public By ContributionMarginWithSubsidy(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Contribution Margin With Subsidy']/../../div[2]//lightning-formatted-text");
		} else {
			return By.xpath("//span[ .= 'Contribution Margin With Subsidy']/../../div[2]//lightning-formatted-text");
		}
	}
	
	public By ManualPlannedCost(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Manual Planned Cost']/../../div[2]//lightning-formatted-number");
		} else {
			return By.xpath("//span[ .= 'Manual Planned Cost']/../../div[2]//lightning-formatted-number");
		}
	}
	
	public By SubsidyAmount(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Subsidy Amount']/../../div[2]//lightning-formatted-text");
		} else {
			return By.xpath("//span[ .= 'Subsidy Amount']/../../div[2]//lightning-formatted-text");
		}
	}
	
	public By SubsidyOpen(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Subsidy Open']/../../div[2]//lightning-formatted-text");
		} else {
			return By.xpath("//span[ .= 'Subsidy Open']/../../div[2]//lightning-formatted-text");
		}
	}
	

}
