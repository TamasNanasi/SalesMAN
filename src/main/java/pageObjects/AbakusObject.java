package pageObjects;

import org.openqa.selenium.By;

public class AbakusObject {
	
	public By Anzahlung_1(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-3");
		} else {
			return By.id("mat-input-3");
		}
	}
	
	public By Restwert_1(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-6");
		} else {
			return By.id("mat-input-6");
		}
	}
	
	public By Subvention_1(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-9");
		} else {
			return By.id("mat-input-9");
		}
	}
	
	public By Anzahlung_2(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-10");
		} else {
			return By.id("mat-input-10");
		}
	}
	
	public By Restwert_2(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-21");
		} else {
			return By.id("mat-input-21");
		}
	}
	
	public By Subvention_2(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-24");
		} else {
			return By.id("mat-input-24");
		}
	}
	
	public By Anzahlung_3(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-17");
		} else {
			return By.id("mat-input-17");
		}
	}
	
	public By Restwert_3(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-36");
		} else {
			return By.id("mat-input-36");
		}
	}
	
	public By Subvention_3(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-39");
		} else {
			return By.id("mat-input-39");
		}
	}
	
	public By Kreditprufung_1(String L) {
		if (L.equals("E")) {
			return By.xpath("//app-calculation-head[1]//button[ .= ' Credit Application ']");
			//return By.xpath("//app-calculation-head[1]//button[ .= ' Kreditprüfung ']");
		} else {
			return By.xpath("//app-calculation-head[1]//button[ .= ' Kreditprüfung ']");
		}
	}
	
	public By Kreditprufung_2(String L) {
		if (L.equals("E")) {
			return By.xpath("//app-calculation-head[2]//button[ .= ' Credit Application ']");
			//return By.xpath("//app-calculation-head[2]//button[ .= ' Kreditprüfung ']");
		} else {
			return By.xpath("//app-calculation-head[2]//button[ .= ' Kreditprüfung ']");
		}
	}
	
	public By Kreditprufung_3(String L) {
		if (L.equals("E")) {
			return By.xpath("//app-calculation-head[2]//button[ .= ' Credit Application ']");
			//return By.xpath("//app-calculation-head[2]//button[ .= ' Kreditprüfung ']");
		} else {
			return By.xpath("//app-calculation-head[2]//button[ .= ' Kreditprüfung ']");
		}
	}
	
	public By WeitereKreditprufung(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= ' Additional credit request ']/..");
			//return By.xpath("//span[ .= ' Weitere Kreditprüfung ']/..");
		} else {
			return By.xpath("//span[ .= ' Weitere Kreditprüfung ']/..");
		}
	}
	
	public By KreditprufungBeantragen(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= ' Apply for credit request  ']/..");
			//return By.xpath("//span[ .= ' Kreditprüfung beantragen ']/..");
		} else {
			return By.xpath("//span[ .= ' Kreditprüfung beantragen ']/..");
		}
	}
	
	public By Auswahlen_1(String L) {
		if (L.equals("E")) {
			return By.xpath("//app-calculation-head[1]//span[ .= ' Select ']/..");
			//return By.xpath("//app-calculation-head[1]//span[ .= ' Auswählen ']/..");
		} else {
			return By.xpath("//app-calculation-head[1]//span[ .= ' Auswählen ']/..");
		}
	}
	
	public By Auswahlen_2(String L) {
		if (L.equals("E")) {
			return By.xpath("//app-calculation-head[2]//span[ .= ' Select ']/..");
			//return By.xpath("//app-calculation-head[2]//span[ .= ' Auswählen ']/..");
		} else {
			return By.xpath("//app-calculation-head[2]//span[ .= ' Auswählen ']/..");
		}
	}
	
	public By Auswahlen_3(String L) {
		if (L.equals("E")) {
			return By.xpath("//app-calculation-head[3]//span[ .= ' Select ']/..");
			//return By.xpath("//app-calculation-head[3]//span[ .= ' Auswählen ']/..");
		} else {
			return By.xpath("//app-calculation-head[3]//span[ .= ' Auswählen ']/..");
		}
	}
	
	public By ZuruckSalesForce(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Back to SalesMAN']/..");
			//return By.xpath("//span[ .= 'Zurück zu Salesforce']/..");
		} else {
			return By.xpath("//span[ .= 'Zurück zu Salesforce']/..");
		}
	}
	
	public By PrePayment(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-4");
		} else {
			return By.id("mat-input-4");
		}
	}
	
	public By Subsidy(String L) {
		if (L.equals("E")) {
			return By.id("mat-input-10");
		} else {
			return By.id("mat-input-10");
		}
	}
	
	public By CustomerFinanceRate(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@data-test ='select-target-button-rate-1']/../span/b");
		} else {
			return By.xpath("//button[@data-test ='select-target-button-rate-1']/../span/b");
		}
	}
	
	public By TotalRate(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@data-test ='select-target-button-rate-1']/../span/b");
		} else {
			return By.xpath("//button[@data-test ='select-target-button-rate-1']/../span/b");
		}
	}
	
	

}
