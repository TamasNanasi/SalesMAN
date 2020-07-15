 package pageObjects;

import org.openqa.selenium.By;

public class C4SObject {
	
	public By ManCodeInput(String L) {
		if (L.equals("E")) {
			return By.id("cockpitForm:manCodeInput");
		} else {
			return By.id("cockpitForm:manCodeInput");
		}
	}
	
	public By ManCodeButton(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[@id = 'mancodeButton']/..");
		} else {
			return By.xpath("//div[@id = 'mancodeButton']/..");
		}
	}
	
	public By LieferdatumCalendar(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table[2]/tbody/tr[1]/td[3]/a");
		} else {
			return By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table[2]/tbody/tr[1]/td[3]/a");
		}
	}
	
	public By CalendarUpdate(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@id = 'slr_dialog_form:confirmSlrDate']");
		} else {
			return By.xpath("//button[@id = 'slr_dialog_form:confirmSlrDate']");
		}
	}
	
	public By Save(String L) {
		if (L.equals("E")) {
			return By.id("toolbarForm:toolbarSaveButton");
		} else {
			return By.id("toolbarForm:toolbarSaveButton");
		}
	}
	
	public By ManCode(String L) {
		if (L.equals("E")) {
			return By.id("headerToolbarManCodeId");
		} else {
			return By.id("headerToolbarManCodeId");
		}
	}
	
	public By Exit(String L) {
		if (L.equals("E")) {
			return By.id("headerForm:exitApplicationButton");
		} else {
			return By.id("headerForm:exitApplicationButton");
		}
	}
	
	public By priceAll(String L) {
		if (L.equals("E")) {
			return By.xpath("//tr[@id = 'vehicleData_totalPrice']/td[2]/span");
		} else {
			return By.xpath("//tr[@id = 'vehicleData_totalPrice']/td[2]/span");
		}
	}
	
	public By priceWerk(String L) {
		if (L.equals("E")) {
			return By.xpath("//tr[@id = 'vehicleData_customerEndPrice']/td[2]/span");
		} else {
			return By.xpath("//tr[@id = 'vehicleData_customerEndPrice']/td[2]/span");
		}
	}
	
	public By priceSelect(String L) {
		if (L.equals("E")) {
			return By.xpath("//h5[contains(text(),'Price & delivery')]/following-sibling::select");
		} else {
			return By.xpath("//h5[contains(text(),'Preis & Lieferung')]/following-sibling::select");
		}
	}
	
	public By Fahrerhaus(String L) {
		if (L.equals("E")) {
			return By.id("viewSelectionTabView:7:tabname");
		} else {
			return By.id("viewSelectionTabView:7:tabname");
		}
	}
	
	public By Fahrwerkskonfiguration(String L) {
		if (L.equals("E")) {
			return By.id("viewSelectionTabView:1:tabname");
		} else {
			return By.id("viewSelectionTabView:1:tabname");
		}
	}
	
	public By LastenAndTragfahigkeit(String L) {
		if (L.equals("E")) {
			return By.id("viewSelectionTabView:2:tabname");
		} else {
			return By.id("viewSelectionTabView:2:tabname");
		}
	}
	
	public By FahrzeugCharakteristika(String L) {
		if (L.equals("E")) {
			return By.id("viewSelectionTabView:4:tabname");
		} else {
			return By.id("viewSelectionTabView:4:tabname");
		}
	}
	
	public By Antriebsstrang(String L) {
		if (L.equals("E")) {
			return By.id("viewSelectionTabView:6:tabname");
		} else {
			return By.id("viewSelectionTabView:6:tabname");
		}
	}
	
	public By KlimatisierungFahrerhaus(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='viewSelectionTabView:7:sidebar_item_details']/div/div/table/tbody/tr[6]/td[2]/span");
		} else {
			return By.xpath("//*[@id='viewSelectionTabView:7:sidebar_item_details']/div/div/table/tbody/tr[6]/td[2]/span");
		}
	}
	
	public By AuxiliaryHeating(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[@title = 'Auxiliary heater (water)']/div[2]");
		} else {
			return By.xpath("//div[@title = 'Wasser-Zusatzheizung']/div[2]");
		}
	}
	
	public By Motor_Motorenkuhler(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='viewSelectionTabView:6:sidebar_item_details']/div/div/table/tbody/tr[1]/td[2]/span");
		} else {
			return By.xpath("//*[@id='viewSelectionTabView:6:sidebar_item_details']/div/div/table/tbody/tr[1]/td[2]/span");
		}
	}
	
	public By Motor(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[@title = 'Engine']/div[2]");
		} else {
			return By.xpath("//div[@title = 'Motor']/div[2]");
		}
	}
	
	public By Motorfamilie(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.=' Engine family ']/../div/div[1]/div[1]/label");
		} else {
			return By.xpath("//span[.=' Motorfamilie ']/../div/div[1]/div[1]/label");
		}
	}
	
	public By Primaerkraftstoff(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.=' Primary fuel ']/../div/div[1]/div[1]/label");
		} else {
			return By.xpath("//span[.=' Primärkraftstoff ']/../div/div[1]/div[1]/label");
		}
	}
	
	public By Getriebe_Kupplung(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='viewSelectionTabView:6:sidebar_item_details']/div/div/table/tbody/tr[2]/td[2]/span");
		} else {
			return By.xpath("//*[@id='viewSelectionTabView:6:sidebar_item_details']/div/div/table/tbody/tr[2]/td[2]/span");
		}
	}
	
	public By Getriebe(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[@title = 'Gearbox']/div[2]");
		} else {
			return By.xpath("//div[@title = 'Getriebe']/div[2]");
		}
	}
	
	public By Getriebetyp(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.=' Gearbox type ']/../div/div[1]/div[1]/label");
		} else {
			return By.xpath("//span[.=' Getriebetyp ']/../div/div[1]/div[1]/label");
		}
	}
	
	public By Cab(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[1]//td[2]");
		} else {
			return By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[1]//td[2]");
		}
	}
	
	public By MotorData(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table/tbody/tr[3]/td[2]");
		} else {
			return By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table/tbody/tr[3]/td[2]");
		}
	}
	
	public By EmissionClass(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[4]//td[2]");
		} else {
			return By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[4]//td[2]");
		}
	}
	
	public By SteeringType(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[5]//td[2]");
		} else {
			return By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[5]//td[2]");
		}
	}
	
	public By VehicleDescription(String L) {
		if (L.equals("E")) {
			return By.id("suDescriptionHeader");
		} else {
			return By.id("suDescriptionHeader");
		}
	}
	
	public By LieferdatumWert(String L) {
		if (L.equals("E")) {
			return By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table[2]/tbody/tr[1]/td[2]");
		} else {
			return By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table[2]/tbody/tr[1]/td[2]");
		}
	}
	
	public By TotalPermissibleWeightValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/span[contains(text(),'Vertical loads')]/../div/div[2]/div[1]/div[5]/div[1]/div/label");
		} else {
			return By.xpath("//div/span[contains(text(),'Vertikale Lasten und Tragfähigkeit')]/../div/div[2]/div[1]/div[5]/div[1]/div/label");
		}
	}
	
	public By TechnicalWeightValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/span[contains(text(),'Vertical loads')]/../div/div[2]/div[2]/div[5]/div[1]/div/label");
		} else {
			return By.xpath("//div/span[contains(text(),'Vertikale Lasten und Tragfähigkeit')]/../div/div[2]/div[2]/div[5]/div[1]/div/label");
		}
	}
	
	public By TechnicalWeightValuePlus(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/span[contains(text(),'Vertical loads')]/../div/div[2]/div[3]/div[5]/div[1]/div/label");
		} else {
			return By.xpath("//div/span[contains(text(),'Vertikale Lasten und Tragfähigkeit')]/../div/div[2]/div[3]/div[5]/div[1]/div/label");
		}
	}
	
	public By TotalTrainWeightValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/span[contains(text(),'Horizontal loads')]/../div[1]/div[2]/div[1]/div[3]/div[1]/div/label");
		} else {
			return By.xpath("//div/span[contains(text(),'Horizontale Lasten')]/../div[1]/div[2]/div[1]/div[3]/div[1]/div/label");
		}
	}
	
	public By TechnicalWeightTechValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//div/span[contains(text(),'Horizontal loads')]/../div[1]/div[2]/div[2]/div[3]/div[1]/div/label");
		} else {
			return By.xpath("//div/span[contains(text(),'Horizontale Lasten')]/../div[1]/div[2]/div[2]/div[3]/div[1]/div/label");
		}
	}
	
	public By Radformel(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='wheelFormulaFilter_wheelFormula']/ul/li[contains(@class, 'active')]");
		} else {
			return By.xpath("//*[@id='wheelFormulaFilter_wheelFormula']/ul/li[contains(@class, 'active')]");
		}
	}
	
	public By Dokumente(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[3]/td[2]/span");
		} else {
			return By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[3]/td[2]/span");
		}
	}
	
	public By EquipmentForHazardousGoodsADR(String L) {
		if (L.equals("E")) {
			return By.xpath("//div[contains(@title, 'Dangerous goods equipment as per ADR')]/div[2]");
		} else {
			return By.xpath("//div[contains(@title, 'Gefahrgut-Ausstattung nach ADR')]/div[2]");
		}
	}
	
	public By Anwendungsbereich(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[4]/td[2]/span");
		} else {
			return By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[4]/td[2]/span");
		}
	}
	
	public By BasisCharakteristika(String L) {
		if (L.equals("E")) {
			return By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[1]/td[2]/span");
		} else {
			return By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[1]/td[2]/span");
		}
	}
	
	public By ConfigurationUpdated(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Configuration updated.']");
		} else {
			return By.xpath("//span[ .= 'Configuration updated.']");
		}
	}
	
	public By ConfigurationSaved(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[ .= 'Your configuration has been successfully saved.']");
		} else {
			return By.xpath("//span[ .= 'Your configuration has been successfully saved.']");
		}
	}
	
	public By OKButton(String L) {
		if (L.equals("E")) {
			return By.xpath("//button[@id = 'manCodeRepairDialog:confirmButton']");
		} else {
			return By.xpath("//button[@id = 'manCodeRepairDialog:confirmButton']");
		}
	}
	
	//public By ManCodeInput = By.id("cockpitForm:manCodeInput");
	//public By ManCodeButton = By.id("mancodeButton");
	public By RepairOKButton = By.xpath("//button[@id='manCodeRepairDialog:confirmButton']");
	
	
	//public By Fahrwerkskonfiguration = By.id("viewSelectionTabView:1:tabname");
	//public By LastenAndTragfahigkeit = By.id("viewSelectionTabView:2:tabname");
	//public By FahrzeugCharakteristika = By.id("viewSelectionTabView:4:tabname");
	//public By Fahrerhaus = By.id("viewSelectionTabView:7:tabname");
	//public By Antriebsstrang = By.id("viewSelectionTabView:6:tabname");
	
	//public By BasisCharakteristika = By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[1]/td[2]/span");
	
	//public By Anwendungsbereich = By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[4]/td[2]/span");
	//public By Dokumente = By.xpath("//*[@id='viewSelectionTabView:4:sidebar_item_details']/div/div/table/tbody/tr[3]/td[2]/span");
	public By Sitze = By.xpath("//*[@id='viewSelectionTabView:7:sidebar_item_details']/div/div/table/tbody/tr[4]/td[2]/span");
	//public By KlimatisierungFahrerhaus = By.xpath("//*[@id='viewSelectionTabView:7:sidebar_item_details']/div/div/table/tbody/tr[6]/td[2]/span");
	//public By Motor_Motorenkuhler = By.xpath("//*[@id='viewSelectionTabView:6:sidebar_item_details']/div/div/table/tbody/tr[1]/td[2]/span");
	//public By Getriebe_Kupplung = By.xpath("//*[@id='viewSelectionTabView:6:sidebar_item_details']/div/div/table/tbody/tr[2]/td[2]/span");
	
	
	//public By TotalPermissibleWeight = By.xpath("//div/span[contains(text(),'Vertikale Lasten und Tragfähigkeit')]/../div/div[2]/div[1]/div[4]/div[1]/div/label");
	//public By TechnicalWeightValue = By.xpath("//div/span[contains(text(),'Vertikale Lasten und Tragfähigkeit')]/../div/div[2]/div[2]/div[4]/div[1]/div/label");
	//public By TotalTrainWeightValue = By.xpath("//div/span[contains(text(),'Horizontale Lasten')]/../div[1]/div[2]/div[1]/div[3]/div[1]/div/label");
	//public By TechnicalWeightTechValue = By.xpath("//div/span[contains(text(),'Horizontale Lasten')]/../div[1]/div[2]/div[2]/div[3]/div[1]/div/label");

	
	public By Sidebar = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[2]/div");
	
	//public By MotorData = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table/tbody/tr[3]/td[2]");
	
	//public By priceSelect = By.xpath("//h5[contains(text(),'Preis & Lieferung')]/following-sibling::select");
	//public By priceAll = By.xpath("//td[contains(text(),'Preis gesamt (exkl. Fremdwährung)')]/../td/span");
	
	public By HidroDrive = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[2]/div[1]/div/div/div/span/form/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td/div/div[2]/span");
	public By OhneAntrieb = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[2]/div[1]/div/div/div/span/form/div/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[3]/table/tbody/tr[4]/td/div/div[2]/span");
	
	//public By Radformel = By.xpath("//*[@id='wheelFormulaFilter_wheelFormula']//ul");
	//public By Cab = By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[1]//td[2]");
	//public By EmissionClass = By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[4]//td[2]");
	//public By SteeringType = By.xpath("//*[@id='configurationPreviewVehicleDataTable']//tbody//tr[5]//td[2]");
	//public By VehicleDescription = By.id("suDescriptionHeader");
	
	public By bodyType = By.xpath("//div[contains(@title, 'Anwendungssegment')]/div[2]");
	//public By EquipmentForHazardousGoodsADR = By.xpath("//div[contains(@title, 'Gefahrgut-Ausstattung nach ADR')]/div[2]");
	//public By AuxiliaryHeating = By.xpath("//div[@title = 'Wasser-Zusatzheizung']/div[2]");
	//public By Motor = By.xpath("//div[@title = 'Motor']/div[2]");
	//public By Motorfamilie = By.xpath("//span[.=' Motorfamilie ']/../div/div[1]/div[1]/label");
	//public By Primaerkraftstoff = By.xpath("//span[.=' Primärkraftstoff ']/../div/div[1]/div[1]/label");
	
	//public By Getriebe = By.xpath("//div[@title = 'Getriebe']/div[2]");
	//public By Getriebetyp = By.xpath("//span[.=' Getriebetyp ']/../div/div[1]/div[1]/label");
	
	
	//public By LieferdatumCalendar = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table[2]/tbody/tr[1]/td[3]/a");
	//public By LieferdatumWert = By.xpath("/html/body/div[5]/div/div[3]/div[3]/div[1]/div[1]/div/form/div/div[2]/div/div[1]/div/table[2]/tbody/tr[1]/td[2]");
	
	public By CalendarInput = By.id("slr_dialog_form:slrChangeInput_input");
	//public By CalendarUpdate = By.id("slr_dialog_form:confirmSlrDate");
	public By CalendarNext = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/a[2]/span");
	public By CalendarMonth = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/div/span[1]");
	public By CalendarYear = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/div/div/span[2]");
	public By CaledarDays = By.xpath("/html/body/div[5]/div/form[2]/div/div[2]/span[2]/div/div/table/tbody");
	//public By Save = By.id("toolbarForm:toolbarSaveButton");
	//public By ManCode = By.id("headerToolbarManCodeId");
	//public By Exit = By.id("headerForm:exitApplicationButton");
	
}
