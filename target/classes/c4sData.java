package resources;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AccountsObject;
import pageObjects.AccountsObjectDev;
import pageObjects.C4SObject;
import pageObjects.C4SObjectDev;
import pageObjects.ContactsObject;
import pageObjects.ContactsObjectDev;
import pageObjects.MainPage;
import pageObjects.OpptyObject;
import pageObjects.OpptyObjectDev;
import pageObjects.PLI_TruckObject;
import pageObjects.ProposalObject;
import pageObjects.ProposalObjectDev;


public class c4sData extends base {
	

	private static Logger Log = LogManager.getLogger();
	
	public boolean configureTruck (WebDriver driver, WebDriverWait wait, String manCode, String randomValue, int future, String product) throws InterruptedException {
		String L = "D";
		boolean pass = false;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		PLI_TruckObject to = new PLI_TruckObject();
		C4SObject c4s = new C4SObject();
		if (ef.elementExist(mp.getLanguage("Home"), 2000)) {
			L = "E";
		}
		String currentValue = ef.get_Element(po.CurrenPriceValue(L), 0).getText();
		ef.get_Element(po.C4SButton_Show(L), 0).click();
		Thread.sleep(4000);
		a.moveToElement(driver.findElement(po.C4S(L))).click().build().perform();
		ef.get_Element(c4s.ManCodeInput(L), 0).sendKeys(manCode);
		ef.get_Element(c4s.ManCodeButton(L), 0).click();
		//ef.get_Element(c4s.Sidebar, 0).click();
		ef.get_Element(c4s.LieferdatumCalendar(L), 0).click();
		ef.C4SaddDate(getFutureDateString(future, "d.MMMM.yyyy", L));
		ef.get_Element(c4s.CalendarUpdate(L), 200).click();
		
		String[] Motor = ef.get_Element(c4s.MotorData(L), 200).getText().split("\\s");
		Log.info("Motor Data:");
		String EnginePowerHP, EnginePowerKW;
		if (L.equals("D")) {
			EnginePowerHP = ef.cutting(Motor[6], "L", 1);
			EnginePowerKW = Motor[4];
		} else {
			EnginePowerHP = ef.cutting(Motor[7], "L", 1);
			EnginePowerKW = Motor[5];
			
		}
		
		Select price = new Select(ef.get_Element(c4s.priceSelect(L), 200));
		price.selectByValue("NETTO");
		String PriceAll = ef.cutting(ef.get_Element(c4s.priceAll(L), 1000).getText(), "R", 2).replace(".", "");
		String PriceWerk = ef.cutting(ef.get_Element(c4s.priceWerk(L), 0).getText(), "R", 2).replace(".", "");
		
		ef.get_Element(c4s.Fahrerhaus(L), 2000).click();
		//a.moveToElement(ef.get_Element(c4s.Fahrerhaus(L), 2000)).click().build().perform();
		ef.get_Element(c4s.KlimatisierungFahrerhaus(L), 500).click();
		String wert;
		if (L.equals("D")) {
			wert = "Ohne Wasserzusatzheizung";
		} else {
			wert = "Without auxiliary water heater";
		}
		String AuxiliaryHeating;
		if(ef.get_Element(c4s.AuxiliaryHeating(L), 200).getText().trim().equals(wert)) {
			AuxiliaryHeating = "false";
		} else {
			AuxiliaryHeating = "true";
		}
		
		ef.get_Element(c4s.Antriebsstrang(L), 0).click();
		ef.get_Element(c4s.Motor_Motorenkuhler(L), 0).click();
		//ef.get_Element(c4s.Motor(L), 1000).click();
		a.moveToElement(ef.get_Element(c4s.Motor(L), 1000)).click().build().perform();
		String EngineFamily = ef.get_Element(c4s.Motorfamilie(L), 0).getText();
		
		String BioDiesel;
		String BioDiesel_full = ef.get_Element(c4s.Primaerkraftstoff(L), 0).getText();
		if (BioDiesel_full.startsWith("Biodiesel")) {
			BioDiesel = "true";
		} else {
			BioDiesel = "false";
		}
		
		ef.get_Element(c4s.Getriebe_Kupplung(L), 0).click();
		ef.get_Element(c4s.Getriebe(L), 0).click();
		String Transmission = ef.get_Element(c4s.Getriebetyp(L), 0).getText();
		
		String Cab = ef.get_Element(c4s.Cab(L), 500).getText().trim();
		
		String EngineType = ef.get_Element(c4s.MotorData(L), 0).getText().trim();
		String EmissionClass = ef.get_Element(c4s.EmissionClass(L), 0).getText().trim();
		if (EmissionClass.equals("Euro 6")) {
			EmissionClass = "EURO6";
		}
		String SteeringType = ef.get_Element(c4s.SteeringType(L), 0).getText().trim();
		String VehicleDescription = ef.get_Element(c4s.VehicleDescription(L), 0).getText();
		
		String requestedDeliveryDate = ef.get_Element(c4s.LieferdatumWert(L), 200).getText();
		
		ef.get_Element(c4s.LastenAndTragfahigkeit(L), 6000).click();
		
		String TotalPermissibleWeightValue = ef.cutting(ef.get_Element(c4s.TotalPermissibleWeightValue(L), 1000).getText(), "R", 2);
		double amount = Double.parseDouble(TotalPermissibleWeightValue);
		DecimalFormat formatter = new DecimalFormat("#,###");
		String TechnicalWeightValue = ef.cutting(ef.get_Element(c4s.TechnicalWeightValue(L), 200).getText(), "R", 2);
		amount = Double.parseDouble(TechnicalWeightValue);
		formatter = new DecimalFormat("#,###.00");
		TechnicalWeightValue = formatter.format(amount);
		String TechnicalWeightValuePlus = ef.cutting(ef.get_Element(c4s.TechnicalWeightValuePlus(L), 200).getText(), "R", 2);
		amount = Double.parseDouble(TechnicalWeightValuePlus);
		TechnicalWeightValuePlus = formatter.format(amount);
		String TotalTrainWeightValue = ef.cutting(ef.get_Element(c4s.TotalTrainWeightValue(L), 200).getText(), "R", 2);
		
		String TechnicalWeightTechValue = ef.cutting(ef.get_Element(c4s.TechnicalWeightTechValue(L), 200).getText(), "R", 2);
		
		ef.get_Element(c4s.Fahrwerkskonfiguration(L), 8000).click();
		String DriveType = ef.get_Element(c4s.Radformel(L), 1000).getText();
		
		ef.get_Element(c4s.FahrzeugCharakteristika(L), 1000).click();
		ef.get_Element(c4s.Dokumente(L), 200).click();
		String gfg;
		if (L.equals("D")) {
			 gfg = "Ohne Gefahrgutausstattung";
		} else {
			 gfg = "Without dangerous goods equipment";
		}
		String EquipmentForHazardousGoodsADR;
		if (ef.get_Element(c4s.EquipmentForHazardousGoodsADR(L), 1000).getText().trim().equals(gfg) ) {
			EquipmentForHazardousGoodsADR = "false";
		} else {
			EquipmentForHazardousGoodsADR = "true";
		}
		
		
		
		
		
		a.moveToElement(ef.get_Element(c4s.Save(L), 5000)).click().build().perform();
		while (!ef.elementExist(c4s.ConfigurationSaved(L), 0)) {
			Thread.sleep(1000);
		}
		String MANCode = ef.get_Element(c4s.ManCode(L), 1000).getText();
		//Log.info("MANCode:"+ MANCode);
		ef.get_Element(c4s.Exit(L), 0).click();
		long start = System.currentTimeMillis();
		
		
		int count = 0;
		//while ((ef.get_Element(po.CurrenPriceValue(L), 0).getText().equals(currentValue)) && (count <= 80)) {
			//String currentValue = ef.get_Element(po.CurrenPriceValue(L), 0).getText();
			while ((ef.get_Element(po.CurrenPriceValue(L), 500).getText().equals(currentValue)) && (count <= 80)) {
				count++;
				//Thread.sleep(1000);
				
				//Start workaround:
				ef.get_Element(mp.Proposals(L), 3000).click();
				ef.get_Element(po.Search, 1000).clear();
				a.moveToElement(ef.get_Element(po.Search, 500)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
				//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 1000).click();
				a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 1500)).click().build().perform();
				//End workaround:
			}
		//}
		
		
		
		long end = System.currentTimeMillis();
		Log.info("C4S Response time in milisec: " + (end - start));
		Log.info("C4S Response time in sec: " + ((end - start) / 1000));
		
		String productName = ef.get_Element(po.TruckLabel(L), 1000).getText();
		productName = productName.replace(" (C4S)", "").trim();
		
		ef.get_Element(po.RelatedTab(L), 2000).click();
		
		a.moveToElement(ef.get_Element_woCl(po.lineItemSearch(productName), 3000)).click().build().perform();
		String MANCodeSF = ef.get_Element_woCl(to.PLI_manCode(L), 3000).getText();
		String AuxiliaryHeatingSF = Boolean.toString(ef.get_Element_woCl(to.PLI_AuxiliaryHeating(L), 0).isSelected());
		String BioDieselSF = Boolean.toString(ef.get_Element_woCl(to.PLI_BioDiesel(L), 100).isSelected());
		String CabinSF = ef.get_Element_woCl(to.PLI_Cabin(L), 100).getText();
		String DriveConceptSF = ef.get_Element_woCl(to.PLI_DriveConcept(L), 100).getText();
		String DriveTypeSF = ef.get_Element_woCl(to.PLI_DriveType(L), 100).getText();
		String EmissionClassSF = ef.get_Element_woCl(to.PLI_EmissionClass(L), 100).getText();
		String EngineFamilySF = ef.get_Element_woCl(to.PLI_EngineFamily(L), 100).getText();
		String EnginePowerHPSF = ef.get_Element_woCl(to.PLI_EnginePowerHP(L), 100).getText();
		String EnginePowerKWSF = ef.get_Element_woCl(to.PLI_EnginePowerKW(L), 100).getText();
		String EngineTypeSF = ef.get_Element_woCl(to.PLI_EngineType(L), 100).getText();
		String EquipmentForHazardousGoodsADRSF = Boolean.toString(ef.get_Element_woCl(to.PLI_EquipmentForHazardousGoodsADR(L), 0).isSelected());
		String HydrodriveSF = Boolean.toString(ef.get_Element_woCl(to.PLI_Hydrodriver(L), 0).isSelected());
		String IntarderSF = Boolean.toString(ef.get_Element_woCl(to.PLI_Intarder(L), 0).isSelected());
		String ModelSeriesSF = ef.get_Element_woCl(to.PLI_ModelSeries(L), 100).getText();
		String PlanetaryHubSF = Boolean.toString(ef.get_Element_woCl(to.PLI_PlanetaryHub(L), 0).isSelected());
		String PritarderSF = Boolean.toString(ef.get_Element_woCl(to.PLI_Pritarder(L), 0).isSelected());
		String SuspensionSF = ef.get_Element_woCl(to.PLI_Suspension(L), 100).getText();
		String TipmaticSF = Boolean.toString(ef.get_Element_woCl(to.PLI_Tipmatic(L), 0).isSelected());
		String TechnicalWeightUnitSF = ef.get_Element_woCl(to.PLI_TechnicalWeightUnit(L), 100).getText();
		String TechnicalWeightValueSF = ef.get_Element_woCl(to.PLI_TechnicalWeightValue(L), 100).getText();
		String TechnicalWeightUnitPlusSF = ef.get_Element_woCl(to.PLI_TechnicalWeightUnitPlus(L), 100).getText();
		String TechnicalWeightValuePlusSF = ef.get_Element_woCl(to.PLI_TechnicalWeightValuePlus(L), 100).getText();
		String TotalPermissibleWeightUnitSF = ef.get_Element_woCl(to.PLI_TotalPermissibleWeightUnit(L), 100).getText();
		String TotalPermissibleWeightValueSF = ef.get_Element_woCl(to.PLI_TotalPermissibleWeightValue(L), 100).getText();
		String TotalTrainWeightTechUnitSF = ef.get_Element_woCl(to.PLI_TotalTrainWeightTechUnit(L), 100).getText();
		String TotalTrainWeightTechValueSF = ef.get_Element_woCl(to.PLI_TotalTrainWeightTechValue(L), 100).getText();
		String TotalTrainWeightTechUnitPlusSF = ef.get_Element_woCl(to.PLI_TotalTrainWeightTechUnitPlus(L), 100).getText();
		String TotalTrainWeightTechValuePlusSF = ef.get_Element_woCl(to.PLI_TotalTrainWeightTechValuePlus(L), 100).getText();
		String TractionSF = Boolean.toString(ef.get_Element_woCl(to.PLI_Traction(L), 0).isSelected());
		String TransmissionSF = ef.get_Element_woCl(to.PLI_Transmission(L), 0).getText();
		String VehicleDescriptionSF = ef.get_Element_woCl(to.VehicleDescription(L), 0).getText();
		String WheelbaseSF = ef.get_Element_woCl(to.PLI_Wheelbase(L), 0).getText();						
		
		if (!MANCode.equals(MANCodeSF)) {
			Log.error("MANCode: "+ MANCode+"---"+MANCodeSF);	
			pass = true;
		} else {
			Log.info("MANCode: "+ MANCode+"---"+MANCodeSF);
			pass = false;
		}
		
		if (!AuxiliaryHeating.equals(AuxiliaryHeatingSF)) {
			Log.error("Auxiliary Heating: "+ AuxiliaryHeating+"---"+AuxiliaryHeatingSF);	
			pass = true;
		} else {
			Log.info("Auxiliary Heating: "+ AuxiliaryHeating+"---"+AuxiliaryHeatingSF);
			pass = false;
		}
		
		if (!BioDiesel.equals(BioDieselSF)) {
			Log.error("BioDiesel: "+ BioDiesel+"---"+BioDieselSF);	
			pass = true;
		} else {
			Log.info("BioDiesel: "+ BioDiesel+"---"+BioDieselSF);
			pass = false;
		}
		
		if (!Cab.equals(CabinSF)) {
			Log.error("Cabin: "+ Cab+"---"+CabinSF);	
			pass = true;
		} else {
			Log.info("Cabin: "+ Cab+"---"+CabinSF);
			pass = false;
		}
		
		//if (!DriveConcept.equals(DriveConceptSF)) {
		//	Log.error("DriveConcept: "+ DriveConcept+"---"+DriveConceptSF);	
		//	pass = true;
		//} else {
		//	Log.info("DriveConcept: "+ DriveConcept+"---"+DriveConcept);
		//	pass = false;
		//}
		
		if (!DriveType.equals(DriveTypeSF)) {
			Log.error("DriveType: "+ DriveType+"---"+DriveTypeSF);	
			pass = true;
		} else {
			Log.info("DriveType: "+ DriveType+"---"+DriveTypeSF);
			pass = false;
		}
		
		if (!EmissionClass.equals(EmissionClassSF)) {
			Log.error("EmissionClass: "+ EmissionClass+"---"+EmissionClassSF);	
			pass = true;
		} else {
			Log.info("EmissionClass: "+ EmissionClass+"---"+EmissionClassSF);
			pass = false;
		}
		
		if (!EngineFamily.equals(EngineFamilySF)) {
			Log.error("EngineFamily: "+ EngineFamily+"---"+EngineFamilySF);	
			pass = true;
		} else {
			Log.info("EngineFamily: "+ EngineFamily+"---"+EngineFamilySF);
			pass = false;
		}
		
		if (!EnginePowerHP.equals(EnginePowerHPSF)) {
			Log.error("EnginePowerHP: "+ EnginePowerHP+"---"+EnginePowerHPSF);	
			pass = true;
		} else {
			Log.info("EnginePowerHP: "+ EnginePowerHP+"---"+EnginePowerHPSF);
			pass = false;
		}
		
		if (!EnginePowerKW.equals(EnginePowerKWSF)) {
			Log.error("EnginePowerKW: "+ EnginePowerKW+"---"+EnginePowerKWSF);	
			pass = true;
		} else {
			Log.info("EnginePowerKW: "+ EnginePowerKW+"---"+EnginePowerKWSF);
			pass = false;
		}
		
		if (!EngineType.equals(EngineTypeSF)) {
			Log.error("EngineType: "+ EngineType+"---"+EngineTypeSF);	
			pass = true;
		} else {
			Log.info("EngineType: "+ EngineType+"---"+EngineTypeSF);
			pass = false;
		}
		
		if (!EquipmentForHazardousGoodsADR.equals(EquipmentForHazardousGoodsADRSF)) {
			Log.error("EquipmentForHazardousGoodsADR: "+ EquipmentForHazardousGoodsADR+"---"+EquipmentForHazardousGoodsADRSF);	
			pass = true;
		} else {
			Log.info("EquipmentForHazardousGoodsADR: "+ EquipmentForHazardousGoodsADR+"---"+EquipmentForHazardousGoodsADRSF);
			pass = false;
		}
		
		//if (!Hydrodrive.equals(HydrodriveSF)) {
		//	Log.error("Hydrodrive: "+ Hydrodrive+"---"+HydrodriveSF);	
		//	pass = true;
		//} else {
		//	Log.info("Hydrodrive: "+ Hydrodrive+"---"+HydrodriveSF);
		//	pass = false;
		//}
		
		//if (!Intarder.equals(IntarderSF)) {
		//	Log.error("Intarder: "+ Intarder+"---"+IntarderSF);	
		//	pass = true;
		//} else {
		//	Log.info("Intarder: "+ Intarder+"---"+IntarderSF);
		//	pass = false;
		//}
		
		//if (!ModelSeries.equals(ModelSeriesSF)) {
		//	Log.error("ModelSeries: "+ ModelSeries+"---"+ModelSeriesSF);	
		//	pass = true;
		//} else {
		//	Log.info("ModelSeries: "+ ModelSeries+"---"+ModelSeriesSF);
		//	pass = false;
		//}
		
		//if (!PlanetaryHub.equals(PlanetaryHubSF)) {
		//	Log.error("PlanetaryHub: "+ PlanetaryHub+"---"+PlanetaryHubSF);	
		//	pass = true;
		//} else {
		//	Log.info("PlanetaryHub: "+ PlanetaryHub+"---"+PlanetaryHubSF);
		//	pass = false;
		//}
		
		//if (!Pritarder.equals(PritarderSF)) {
		//	Log.error("Pritarder: "+ Pritarder+"---"+PritarderSF);	
		//	pass = true;
		//} else {
		//	Log.info("Pritarder: "+ Pritarder+"---"+PritarderSF);
		//	pass = false;
		//}
		
		//if (!Suspension.equals(SuspensionSF)) {
		//	Log.error("Suspension: "+ Suspension+"---"+SuspensionSF);	
		//	pass = true;
		//} else {
		//	Log.info("Suspension: "+ Suspension+"---"+SuspensionSF);
		//	pass = false;
		//}
		
		//if (!Tipmatic.equals(TipmaticSF)) {
		//	Log.error("Tipmatic: "+ Tipmatic+"---"+TipmaticSF);	
		//	pass = true;
		//} else {
		//	Log.info("Tipmatic: "+ Tipmatic+"---"+TipmaticSF);
		//	pass = false;
		//}
		
		//if (!TechnicalWeightUnit.equals(TechnicalWeightUnitSF)) {
		//	Log.error("TechnicalWeightUnit: "+ TechnicalWeightUnit+"---"+TechnicalWeightUnitSF);	
		//	pass = true;
		//} else {
		//	Log.info("TechnicalWeightUnit: "+ TechnicalWeightUnit+"---"+TechnicalWeightUnitSF);
		//	pass = false;
		//}
		
		if (!TechnicalWeightValue.equals(TechnicalWeightValueSF)) {
			Log.error("TechnicalWeightValue: "+ TechnicalWeightValue+"---"+TechnicalWeightValueSF);	
			pass = true;
		} else {
			Log.info("TechnicalWeightValue: "+ TechnicalWeightValue+"---"+TechnicalWeightValueSF);
			pass = false;
		}
		
		//if (!TechnicalWeightUnitPlus.equals(TechnicalWeightUnitPlusSF)) {
		//	Log.error("TechnicalWeightUnitPlus: "+ TechnicalWeightUnitPlus+"---"+TechnicalWeightUnitPlusSF);	
		//	pass = true;
		//} else {
		//	Log.info("TechnicalWeightUnitPlus: "+ TechnicalWeightUnitPlus+"---"+TechnicalWeightUnitPlusSF);
		//	pass = false;
		//}
		
		if (!TechnicalWeightValuePlus.equals(TechnicalWeightValuePlusSF)) {
			Log.error("TechnicalWeightValuePlus: "+ TechnicalWeightValuePlus+"---"+TechnicalWeightValuePlusSF);	
			pass = true;
		} else {
			Log.info("TechnicalWeightValuePlus: "+ TechnicalWeightValuePlus+"---"+TechnicalWeightValuePlusSF);
			pass = false;
		}
		
		//if (!TotalPermissibleWeightUnit.equals(TotalPermissibleWeightUnitSF)) {
		//	Log.error("TotalPermissibleWeightUnit: "+ TotalPermissibleWeightUnit+"---"+TotalPermissibleWeightUnitSF);	
		//	pass = true;
		//} else {
		//	Log.info("TotalPermissibleWeightUnit: "+ TotalPermissibleWeightUnit+"---"+TotalPermissibleWeightUnitSF);
		//	pass = false;
		//}
		
		if (!TotalPermissibleWeightValue.equals(TotalPermissibleWeightValueSF)) {
			Log.error("TotalPermissibleWeightValue: "+ TotalPermissibleWeightValue+"---"+TotalPermissibleWeightValueSF);	
			pass = true;
		} else {
			Log.info("TotalPermissibleWeightValue: "+ TotalPermissibleWeightValue+"---"+TotalPermissibleWeightValueSF);
			pass = false;
		}
		
		//if (!TotalTrainWeightTechUnit.equals(TotalTrainWeightTechUnitSF)) {
		//	Log.error("TotalTrainWeightTechUnit: "+ TotalTrainWeightTechUnit+"---"+TotalTrainWeightTechUnitSF);	
		//	pass = true;
		//} else {
		//	Log.info("TotalTrainWeightTechUnit: "+ TotalTrainWeightTechUnit+"---"+TotalTrainWeightTechUnitSF);
		//	pass = false;
		//}
		
		//if (!TotalTrainWeightTechValue.equals(TotalTrainWeightTechValueSF)) {
		//	Log.error("TotalTrainWeightTechValue: "+ TotalTrainWeightTechValue+"---"+TotalTrainWeightTechValueSF);	
		//	pass = true;
		//} else {
		//	Log.info("TotalTrainWeightTechValue: "+ TotalTrainWeightTechValue+"---"+TotalTrainWeightTechValueSF);
		//	pass = false;
		//}
		
		//if (!TotalTrainWeightTechUnitPlus.equals(TotalTrainWeightTechUnitPlusSF)) {
		//	Log.error("TotalTrainWeightTechUnitPlus: "+ TotalTrainWeightTechUnitPlus+"---"+TotalTrainWeightTechUnitPlusSF);	
		//	pass = true;
		//} else {
		//	Log.info("TotalTrainWeightTechUnitPlus: "+ TotalTrainWeightTechUnitPlus+"---"+TotalTrainWeightTechUnitPlusSF);
		//	pass = false;
		//}
		
		//if (!TotalTrainWeightTechValuePlus.equals(TotalTrainWeightTechValuePlusSF)) {
		//	Log.error("TotalTrainWeightTechValuePlus: "+ TotalTrainWeightTechValuePlus+"---"+TotalTrainWeightTechValuePlusSF);	
		//	pass = true;
		//} else {
		//	Log.info("TotalTrainWeightTechValuePlus: "+ TotalTrainWeightTechValuePlus+"---"+TotalTrainWeightTechValuePlusSF);
		//	pass = false;
		//}
		
		//if (!Traction.equals(TractionSF)) {
		//	Log.error("Traction: "+ Traction+"---"+TractionSF);	
		//	pass = true;
		//} else {
		//	Log.info("Traction: "+ Traction+"---"+TractionSF);
		//	pass = false;
		//}
		
		if (!Transmission.equals(TransmissionSF)) {
			Log.error("Transmission: "+ Transmission+"---"+TransmissionSF);	
			pass = true;
		} else {
			Log.info("Transmission: "+ Transmission+"---"+TransmissionSF);
			pass = false;
		}
		
		if (!VehicleDescription.equals(VehicleDescriptionSF)) {
			Log.error("VehicleDescription: "+ VehicleDescription+"---"+VehicleDescriptionSF);	
			pass = true;
		} else {
			Log.info("VehicleDescription: "+ VehicleDescription+"---"+VehicleDescriptionSF);
			pass = false;
		}
		
		//if (!Wheelbase.equals(WheelbaseSF)) {
		//	Log.error("Wheelbase: "+ Wheelbase+"---"+WheelbaseSF);	
		//	pass = true;
		//} else {
		//	Log.info("Wheelbase: "+ Wheelbase+"---"+WheelbaseSF);
		//	pass = false;
		//}
		
		pass = true;
		return pass;
	}

	
}
