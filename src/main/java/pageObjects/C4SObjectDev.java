 package pageObjects;

import org.openqa.selenium.By;

public class C4SObjectDev {
	
	public By ManCodeInput = By.id("cockpitForm:manCodeInput");
	public By ManCodeButton = By.id("mancodeButton");
	public By RepairOKButton = By.xpath("//button[@id='manCodeRepairDialog:confirmButton']");
	
	
	public By Fahrwerkskonfiguration = By.id("viewSelectionTabView:1:tabname");
	public By LastenAndTragfahigkeit = By.id("viewSelectionTabView:2:tabname");
	public By FahrzeugCharakteristika = By.id("viewSelectionTabView:4:tabname");
	public By Fahrerhaus = By.id("viewSelectionTabView:7:tabname");
	public By Antriebsstrang = By.id("viewSelectionTabView:6:tabname");
	
	public By BasisCharakteristika = By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[1]/td[2]/span");
	
	public By Anwendungsbereich = By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[4]/td[2]/span");
	public By Dokumente = By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[3]/td[2]/span");
	public By Sitze = By.xpath("//*[@id='viewSelectionTabView:7:sidebar_item_details']/div/div/table/tbody/tr[4]/td[2]/span");
	public By KlimatisierungFahrerhaus = By.xpath("//*[@id='viewSelectionTabView:7:sidebar_item_details']/div/div/table/tbody/tr[6]/td[2]/span");
	public By Motor_Motorenkuhler = By.xpath("//*[@id='viewSelectionTabView:6:sidebar_item_details']/div/div/table/tbody/tr[1]/td[2]/span");
	public By Getriebe_Kupplung = By.xpath("//*[@id='viewSelectionTabView:6:sidebar_item_details']/div/div/table/tbody/tr[2]/td[2]/span");
	
	
	public By TotalPermissibleWeight = By.xpath("//div/span[contains(text(),'Vertikale Lasten und Tragfähigkeit')]/../div/div[2]/div[1]/div[4]/div[1]/div/label");
	public By TechnicalWeightValue = By.xpath("//div/span[contains(text(),'Vertikale Lasten und Tragfähigkeit')]/../div/div[2]/div[2]/div[4]/div[1]/div/label");
	public By TotalTrainWeightValue = By.xpath("//div/span[contains(text(),'Horizontale Lasten')]/../div[1]/div[2]/div[1]/div[3]/div[1]/div/label");
	public By TechnicalWeightTechValue = By.xpath("//div/span[contains(text(),'Horizontale Lasten')]/../div[1]/div[2]/div[2]/div[3]/div[1]/div/label");

	
	public By Sidebar = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[2]/div");
	
	public By MotorData = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table/tbody/tr[3]/td[2]");
	
	public By priceSelect = By.xpath("//h5[contains(text(),'Preis & Lieferung')]/following-sibling::select");
	public By priceAll = By.xpath("//td[contains(text(),'Preis gesamt (exkl. Fremdwährung)')]/../td/span");
	
	public By HidroDrive = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[2]/div[1]/div/div/div/span/form/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td/div/div[2]/span");
	public By OhneAntrieb = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[2]/div[1]/div/div/div/span/form/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[3]/table/tbody/tr[4]/td/div/div[2]/span");
	
	public By Radformel = By.xpath("//*[@id='wheelFormulaFilter_wheelFormula']//ul");
	public By Cab = By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[1]//td[2]");
	public By EmissionClass = By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[4]//td[2]");
	public By SteeringType = By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[5]//td[2]");
	public By VehicleDescription = By.id("suDescriptionHeader");
	
	public By bodyType = By.xpath("//div[contains(@title, 'Anwendungssegment')]/div[2]");
	public By EquipmentForHazardousGoodsADR = By.xpath("//div[contains(@title, 'Gefahrgut-Ausstattung nach ADR')]/div[2]");
	public By AuxiliaryHeating = By.xpath("//div[@title = 'Wasser-Zusatzheizung']/div[2]");
	public By Motor = By.xpath("//div[@title = 'Motor']/div[2]");
	public By Motorfamilie = By.xpath("//span[.=' Motorfamilie ']/../div/div[1]/div[1]/label");
	public By Primaerkraftstoff = By.xpath("//span[.=' Primärkraftstoff ']/../div/div[1]/div[1]/label");
	
	public By Getriebe = By.xpath("//div[@title = 'Getriebe']/div[2]");
	public By Getriebetyp = By.xpath("//span[.=' Getriebetyp ']/../div/div[1]/div[1]/label");
	
	
	public By LieferdatumCalendar = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table[2]/tbody/tr[1]/td[3]/a");
	public By LieferdatumWert = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table[2]/tbody/tr[1]/td[2]");
	
	public By CalendarInput = By.id("slr_dialog_form:slrChangeInput_input");
	public By CalendarUpdate = By.id("slr_dialog_form:confirmSlrDate");
	public By CalendarNext = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/a[2]/span");
	public By CalendarMonth = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/div/span[1]");
	public By CalendarYear = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/div/span[2]");
	public By CaledarDays = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/table/tbody");
	public By Save = By.id("toolbarForm:toolbarSaveButton");
	public By ManCode = By.id("headerToolbarManCodeId");
	public By Exit = By.id("headerForm:exitApplicationButton");
	
}
