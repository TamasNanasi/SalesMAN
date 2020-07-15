package pageObjects;

import org.openqa.selenium.By;

public class OrderObject {

	public By lineItemSearchSecond(String lineItem, String count) {
		return By.xpath("//tr[" + count +"]/th/div/a[contains(text(),'"+ lineItem +"')]");
	}
	
	public By lineItemSearch(String lineItem) {
		return By.xpath("//lightning-base-formatted-text[contains(text(),'"+ lineItem +"')]");
	}
	
	public By OrderNumberSearch(String L, String lineItem) {
		if (L.equals("E")) {
			return By.xpath("//lightning-base-formatted-text[contains(text(),'"+ lineItem +"')]/../../../../..//lightning-primitive-cell-factory[@data-label='Order Product Number']//a");	
		} else {	
			return By.xpath("//lightning-base-formatted-text[contains(text(),'"+ lineItem +"')]/../../../../..//lightning-primitive-cell-factory[@data-label='Auftragsproduktnummer']//a");
		}
	}
	
	public By OrderNumber(String L) {
		if (L.equals("E")) {
			return By.xpath("//tr[1]//lightning-primitive-cell-factory[@data-label = 'Order Product Number']//lightning-formatted-url/a");
		} else {
			return By.xpath("//tr[1]//lightning-primitive-cell-factory[@data-label = 'Order Product Number']//lightning-formatted-url/a");
		}
	}
	
	public By Related(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[. = 'Related']");
		} else {
			return By.xpath("//span[. = 'Verwandt']");
		}
	}
	/*
	public By OrderNumber(String L) {
		if (L.equals("E")) {
			return By.xpath("//lightning-primitive-cell-factory[@data-label='Auftragsproduktnummer']//a");
		} else {
			return By.xpath("//lightning-primitive-cell-factory[@data-label='Auftragsproduktnummer']//a");
	*/
	public By SAPOrderNummer(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.= 'SAP Order Number']/../../div[2]/span/span");
			
		} else {
			return By.xpath("//span[.= 'SAP-Auftragsnummer']/../../div[2]/span/span");
		}
	}
	
	
}
