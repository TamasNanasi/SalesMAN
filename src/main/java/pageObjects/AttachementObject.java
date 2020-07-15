package pageObjects;

import org.openqa.selenium.By;

public class AttachementObject {
	
	public By OfferLine(String L) {
		if (L.equals("E")) {
			//return By.xpath("//div/span[contains(@title, 'Offer 2020')]");
			return By.xpath("//div/span[(contains(@title, 'Offer 2020')) and (not(contains(@title, 'Merged')))]");
		} else {
			//return By.xpath("//div/span[contains(@title, 'Angebot 2020')]");
			return By.xpath("//div/span[(contains(@title, 'Angebot 2020')) and (not(contains(@title, 'Merged')))]");
		}
	}
	
	public By OfferLineMerged(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/span[(contains(@title, 'Offer 2020')) and (contains(@title, 'Merged'))]");
		} else {
			return By.xpath("//div/span[(contains(@title, 'Angebot 2020')) and (contains(@title, 'Merged'))]");
		}
	}
	
	public By OfferSize(String L) {
		if (L.equals("E")) {
			//return By.xpath("//div/span[contains(@title, 'Offer 2020')]/../p/span[2]");
			return By.xpath("//div/span[(contains(@title, 'Offer 2020')) and (not(contains(@title, 'Merged')))]/../p/span[2]");
		} else {
			//return By.xpath("//div/span[contains(@title, 'Angebot 2020')]/../p/span[2]");
			return By.xpath("//div/span[(contains(@title, 'Angebot 2020')) and (not(contains(@title, 'Merged')))]/../p/span[2]");
		}
	}
	
	public By OfferSizeMerged(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/span[(contains(@title, 'Offer 2020')) and (contains(@title, 'Merged'))]/../p/span[2]");
		} else {
			return By.xpath("//div/span[(contains(@title, 'Angebot 2020')) and (contains(@title, 'Merged'))]/../p/span[2]");
		}
	}
	
	public By OrderLine(String L) {
		if (L.equals("E")) {
			//return By.xpath("//div/span[contains(@title, 'Order 2020')]");
			return By.xpath("//div/span[(contains(@title, 'Order 2020')) and (not(contains(@title, 'Merged')))]");
		} else {
			//return By.xpath("//div/span[contains(@title, 'Auftrag 2020')]");
			return By.xpath("//div/span[(contains(@title, 'Auftrag 2020')) and (not(contains(@title, 'Merged')))]");
		}
	}
	
	public By OrderLineMerged(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/span[(contains(@title, 'Order 2020')) and (contains(@title, 'Merged'))]");
		} else {
			return By.xpath("//div/span[(contains(@title, 'Auftrag 2020')) and (contains(@title, 'Merged'))]");
		}
	}
	
	public By OrderSize(String L) {
		if (L.equals("E")) {
			//return By.xpath("//div/span[contains(@title, 'Order 2020')]/../p/span[2]");
			return By.xpath("//div/span[(contains(@title, 'Order 2020')) and (not(contains(@title, 'Merged')))]/../p/span[2]");
		} else {
			//return By.xpath("//div/span[contains(@title, 'Auftrag 2020')]/../p/span[2]");
			return By.xpath("//div/span[(contains(@title, 'Auftrag 2020')) and (not(contains(@title, 'Merged')))]/../p/span[2]");
		}
	}
	
	public By OrderSizeMerged(String L) {
		if (L.equals("E")) {
			//return By.xpath("//div/span[contains(@title, 'Order 2020')]/../p/span[2]");
			return By.xpath("//div/span[(contains(@title, 'Order 2020')) and (contains(@title, 'Merged'))]/../p/span[2]");
		} else {
			//return By.xpath("//div/span[contains(@title, 'Auftrag 2020')]/../p/span[2]");
			return By.xpath("//div/span[(contains(@title, 'Auftrag 2020')) and (contains(@title, 'Merged'))]/../p/span[2]");
		}
	}
	
	public By BuyBackOfferLine(String L) {
		if (L.equals("E")) {
			return By.xpath("(//div/span[contains(@title, 'BuyBack 2020')])[2]");
		} else {
			//return By.xpath("(//div/span[contains(@title, 'Buy Back 2020')])[2]");
			return By.xpath("(//div/span[contains(@title, 'Rückkauf 2020')])[2]");
		}
	}
	
	public By BuyBackOfferSize(String L) {
		if (L.equals("E")) {
			return By.xpath("(//div/span[contains(@title, 'BuyBack 2020')])[2]/../p/span[2]");
		} else {
			//return By.xpath("(//div/span[contains(@title, 'Buy Back 2020')])[2]/../p/span[2]");
			return By.xpath("(//div/span[contains(@title, 'Rückkauf 2020')])[2]/../p/span[2]");
		}
	}
	
	public By BuyBackOrderLine(String L) {
		if (L.equals("E")) {
			return By.xpath("(//div/span[contains(@title, 'BuyBack 2020')])[1]");
		} else {
			//return By.xpath("(//div/span[contains(@title, 'Buy Back 2020')])[1]");
			return By.xpath("(//div/span[contains(@title, 'Rückkauf 2020')])[1]");
		}
	}
	
	public By BuyBackOrderSize(String L) {
		if (L.equals("E")) {
			return By.xpath("(//div/span[contains(@title, 'BuyBack 2020')])[1]/../p/span[2]");
		} else {
			//return By.xpath("(//div/span[contains(@title, 'Buy Back 2020')])[1]/../p/span[2]");
			return By.xpath("(//div/span[contains(@title, 'Rückkauf 2020')])[1]/../p/span[2]");
		}
	}

}
