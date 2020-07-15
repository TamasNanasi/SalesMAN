package pageObjects;

import org.openqa.selenium.By;

public class PLI_TruckObject {
	
	public By PLI_manCode(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='MAN Code']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='MAN-Code']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_BioDiesel(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Bio Diesel']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='Bio-Diesel']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_Cabin(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Cabin']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Kabine']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_DriveConcept(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Drive Concept']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Antriebskonzept']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_DriveType(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Drive Type']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Antriebsart']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_EmissionClass(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Emission Class']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Emissionsklasse']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_EngineFamily(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Engine Family']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Motorenfamilie']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_EnginePowerHP(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Engine Power in HP']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		} else {
			return By.xpath("//span[.='Motorleistung in PS']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		}
	}
	
	public By PLI_EnginePowerKW(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Engine Power in KW']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		} else {
			return By.xpath("//span[.='Motorleistung in kW']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		}
	}
	
	public By PLI_EngineType(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Engine Type']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Motortyp']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_EquipmentForHazardousGoodsADR(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Equipment For Hazardous Goods ADR']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='Ausstattung für Gefahrguttransport ADR']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_Hydrodriver(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Hydrodrive']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='Hydrodrive']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_Intarder(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Intarder Retarder']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='Intarder/Retarder']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_ModelSeries(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Model Series']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Baureihe']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_PlanetaryHub(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Planetary Hub Reduction Axle']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='Außenplanetenachse']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_Pritarder(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Pritarder']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='PriTarder']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_Suspension(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Suspension']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Federung']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_TechnicalWeightUnit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Technical Weight Unit']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Technische Gewichtseinheit']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_TechnicalWeightValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Technical Weight Value']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		} else {
			return By.xpath("//span[.='Technischer Gewichtswert']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		}
	}
	
	public By PLI_TechnicalWeightUnitPlus(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Technical Weight Unit Plus']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Technische Gewichtseinheit Plus']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_TechnicalWeightValuePlus(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Technical Weight Value Plus']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		} else {
			return By.xpath("//span[.='Technischer Gewichtswert Plus']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		}
	}
	
	public By PLI_Tipmatic(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Tipmatic']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='TipMatic']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_TotalPermissibleWeightUnit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Total permissible Weight (Unit)']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Zulässiges Gesamtgewicht (Einheit)']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_TotalPermissibleWeightValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Total permissible Weight']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		} else {
			return By.xpath("//span[.='Zulässiges Gesamtgewicht']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		}
	}
	
	public By PLI_TotalTrainWeightTechUnit(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Total Train Weight Tech Unit']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Techn. Einheit Gesamtzuggewicht']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_TotalTrainWeightTechValue(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Total Train Weight Tech Value']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		} else {
			return By.xpath("//span[.='Techn. Wert Gesamtzuggewicht']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		}
	}
	
	public By PLI_TotalTrainWeightTechUnitPlus(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Total Train Weight Tech Unit Plus']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Techn. Einheit Gesamtzuggewicht Plus']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_TotalTrainWeightTechValuePlus(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Total Train Weight Value Plus']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		} else {
			return By.xpath("//span[.='Wert Gesamtzuggewicht Plus']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		}
	}
	
	public By PLI_Traction(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Traction']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='Bau und Traktion']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_Transmission(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Transmission']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Getriebe']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By VehicleDescription(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Variant Description']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		} else {
			return By.xpath("//span[.='Beschreibung Variante']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
		}
	}
	
	public By PLI_Wheelbase(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Wheelbase (mm)']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		} else {
			return By.xpath("//span[.='Radstand (mm)']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
		}
	}
	
	public By PLI_AuxiliaryHeating(String L) {
		if (L.equals("E")) {
			return By.xpath("//span[.='Auxiliary Heating']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		} else {
			return By.xpath("//span[.='Zusatzheizung']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
		}
	}
	
	public By PLI_GultigBis(String L) {
		if (L.equals("E")) {
	        return By.xpath("//label[contains(text(),'Valid until')]/../div/input");
		} else {
	        return By.xpath("//label[contains(text(),'Gültig bis')]/../div/input");
		}
	}
	
	
	public By PLI_VehicleDescription_Label = By.xpath("//span[.='Beschreibung Variante']");
	//public By PLI_VehicleDescription = By.xpath("//span[.='Beschreibung Variante']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_gearType_Label = By.xpath("//span[.='Getriebe']");
	//public By PLI_gearType = By.xpath("//span[.='Getriebe']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_engineFamily_Label = By.xpath("//span[.='Motorenfamilie']");
	//public By PLI_engineFamily = By.xpath("//span[.='Motorenfamilie']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	
	public By PLI_TotalPermissibleWeightValue_Label = By.xpath("//span[.='Zulässiges Gesamtgewicht']");
	//public By PLI_TotalPermissibleWeightValue = By.xpath("//span[.='Zulässiges Gesamtgewicht']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By PLI_TotalPermissibleWeightUnit_Label = By.xpath("//span[.='Technical Weight Unit']");
	//public By PLI_TotalPermissibleWeightUnit = By.xpath("//span[.='Technical Weight Unit']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_TechnicalWeightValue_Label = By.xpath("//span[.='Technical Weight Value']");
	//public By PLI_TechnicalWeightValue = By.xpath("//span[.='Technical Weight Value']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By TotalTrainWeightValue_Label = By.xpath("//span[.='Total Train Weight Value']");
	public By TotalTrainWeightValue = By.xpath("//span[.='Total Train Weight Value']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By TotalTrainWeightTechValue_Label = By.xpath("//span[.='Total Train Weight Tech Value']");
	//public By PLI_TotalTrainWeightTechValue = By.xpath("//span[.='Total Train Weight Tech Value']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");

	
	
	public By PLI_EnginePowerHP_Label = By.xpath("//span[.='Motorleistung in PS']");
	//public By PLI_EnginePowerHP = By.xpath("//span[.='Motorleistung in PS']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By PLI_EnginePowerKW_Label = By.xpath("//span[.='Motorleistung in kW']");
	//public By PLI_EnginePowerKW = By.xpath("//span[.='Motorleistung in kW']/../../div[2]/span/slot[1]/slot/lightning-formatted-number");
	public By PLI_RequestedDeliveryDateCountry_Label = By.xpath("//span[.='Angefragtes Lieferdatum Land']");
	public By PLI_RequestedDeliveryDateCountry = By.xpath("//span[.='Angefragtes Lieferdatum Land']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_AuxiliaryHeating_Label = By.xpath("//span[.='Zusatzheizung']");
	//public By PLI_AuxiliaryHeating = By.xpath("//span[.='Zusatzheizung']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
	public By PLI_EquipmentForHazardousGoodsADR_Label = By.xpath("//span[.='Ausstattung für Gefahrguttransport ADR']");
	//public By PLI_EquipmentForHazardousGoodsADR = By.xpath("//span[.='Ausstattung für Gefahrguttransport ADR']/../../div[2]/span/slot[1]/slot/lightning-input/div/span/input");
	public By PLI_bodyType_Label = By.xpath("//span[.='Aufbautyp']");
	public By PLI_bodyType = By.xpath("//span[.='Aufbautyp']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_EngineType_Label = By.xpath("//span[.='Motortyp']");
	//public By PLI_EngineType = By.xpath("//span[.='Motortyp']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	public By PLI_manCode_Label = By.xpath("//span[.='MAN Code']");
	//public By PLI_manCode = By.xpath("//span[.='MAN Code']/../../div[2]/span/slot[1]/slot/lightning-formatted-text");
	
	//public By PLI_bodyTypeEdit = By.xpath("//span[.='Aufbautyp']/../../div[2]/button");
	//public By PLI_bodyTypeDropdown = By.xpath("//label[contains(text(),'Aufbautyp')]/../div/lightning-base-combobox/div/div/input");
	//public By PLI_bodyTypeElementSonstiges = By.xpath("//label[contains(text(),'Aufbautyp')]/../div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[73]/span[2]/span");
	public By PLI_AngefragtesLieferdatumKunde = By.xpath("//label[.='Angefragtes Lieferdatum Kunde']/../div/input");
	public By PLI_AngefragtesLieferdatumLand = By.xpath("//label[.='Angefragtes Lieferdatum Land']/../div/input");
	//public By PLI_GultigBis = By.xpath("//label[contains(text(),'Gültig bis')]/../div/input");
	//public By PLI_Save = By.xpath("//button[contains(@title, 'Speichern')]");

}
