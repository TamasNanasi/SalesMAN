package pageObjects;

import org.openqa.selenium.By;

public class PerformanceObject {

	
	public By Environment() {
			return By.xpath("//div[.= 'Environment']");
	}
	
	public By ElementSearch(int a, int b) {
			return By.xpath("//tr["+ a +"]/td["+ b +"]");
	}
	
	public By NextPage() {
		return By.xpath("//a[.= 'Next page']");
}
	
	
}
