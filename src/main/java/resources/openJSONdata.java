package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class openJSONdata {
	
	
	public HashMap<String, String> getJSONdata (String link) {
		
		HashMap<String, String> jsonmap = new HashMap<String, String>();
		
		JSONParser parser = new JSONParser();
		try (Reader reader = new FileReader(link)) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
            ////System.out.println(jsonObject);
			
			//Begin Proposal Line Item
			long enginePowerPS = (long) jsonObject.get("enginePowerPS");
			jsonmap.put("enginePowerPS", String.format("%d",enginePowerPS));
			//System.out.println(enginePowerPS);
			
			long enginePowerKW = (long) jsonObject.get("enginePowerKW");
			jsonmap.put("enginePowerKW", String.format("%d",enginePowerKW));
			//System.out.println(enginePowerKW);
			
			JSONObject totalWeightTech = (JSONObject) jsonObject.get("totalWeightTech");
			Double TotalPermissibleWeightValue = (Double) totalWeightTech.get("value");
			jsonmap.put("TotalPermissibleWeightValue", String.format("%d",TotalPermissibleWeightValue.longValue()));
			//System.out.println(String.format("%d",TotalPermissibleWeightValue.longValue()));
			
			JSONObject grossListPrice = (JSONObject) jsonObject.get("grossListPrice");
			Double BasicVehiclePriceValue = (Double) grossListPrice.get("amount");
			String BasicVehiclePriceCurrencyCode = (String) grossListPrice.get("currencyCode");
			jsonmap.put("BasicVehiclePriceValue", String.format("%d",BasicVehiclePriceValue.longValue())+"0");
			jsonmap.put("BasicVehiclePriceCurrencyCode", BasicVehiclePriceCurrencyCode);
			
			String TotalPermissibleWeightUnit = (String) totalWeightTech.get("unit");
			jsonmap.put("TotalPermissibleWeightUnit", TotalPermissibleWeightUnit);
			//System.out.println(TotalPermissibleWeightUnit);
			
			String RequestedDeliveryDateCountry = (String) jsonObject.get("requestedDeliveryDate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date d;
			try {
				d = sdf.parse(RequestedDeliveryDateCountry);
				sdf.applyPattern("dd.MM.yyyy");
				jsonmap.put("RequestedDeliveryDateCountry", sdf.format(d));
				//System.out.println(RequestedDeliveryDateCountry);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String cabColor = (String) jsonObject.get("cabColor");
			jsonmap.put("cabColor", cabColor);
			//System.out.println(cabColor);
			
			String wheelBase = (String) jsonObject.get("wheelBase");
			jsonmap.put("wheelBase", wheelBase);
			//System.out.println(wheelBase);
			
			String manCode = (String) jsonObject.get("manCode");
			jsonmap.put("manCode", manCode);
			//System.out.println(manCode);
			
			
			// End Proposal Line Item
			// Begin Configuration
			Boolean Traction = (Boolean) jsonObject.get("traction");
			jsonmap.put("Traction", Boolean.toString(Traction));
			//System.out.println(Boolean.toString(Traction));
			
			Boolean bioDiesel = (Boolean) jsonObject.get("bioDiesel");
			jsonmap.put("BioDiesel", Boolean.toString(bioDiesel));
			//System.out.println(Boolean.toString(bioDiesel));
			
			Boolean auxiliaryHeating = (Boolean) jsonObject.get("auxiliaryHeating");
			jsonmap.put("AuxiliaryHeating", Boolean.toString(auxiliaryHeating));
			//System.out.println(Boolean.toString(auxiliaryHeating));
			
			Boolean hydroDrive = (Boolean) jsonObject.get("hydroDrive");
			jsonmap.put("HydroDrive", Boolean.toString(hydroDrive));
			//System.out.println(Boolean.toString(hydroDrive));
			
			Boolean pitarder = (Boolean) jsonObject.get("pitarder");
			jsonmap.put("Pritarder", Boolean.toString(pitarder));
			//System.out.println(Boolean.toString(pitarder));
			
			String vehicleDescription = (String) jsonObject.get("vehicleDescription");
			jsonmap.put("VehicleDescription", vehicleDescription);
			//System.out.println(vehicleDescription);
			
			Boolean intarderRetarder = (Boolean) jsonObject.get("intarderRetarder");
			jsonmap.put("IntarderRetarder", Boolean.toString(intarderRetarder));
			//System.out.println(Boolean.toString(intarderRetarder));
			
			String gearType = (String) jsonObject.get("gearType");
			jsonmap.put("Transmission", gearType);
			//System.out.println(gearType);
			
			String engineFamily = (String) jsonObject.get("engineFamily");
			jsonmap.put("engineFamily", engineFamily);
			//System.out.println(engineFamily);
			
			String emissionClass = (String) jsonObject.get("emissionClass");
			jsonmap.put("EmissionClass", emissionClass);
			//System.out.println(emissionClass);
			
			String engineType = (String) jsonObject.get("engineType");
			jsonmap.put("EngineType", engineType);
			//System.out.println(engineType);
			
			Boolean hazardousGoods = (Boolean) jsonObject.get("hazardousGoods");
			jsonmap.put("EquipmentForHazardousGoodsADR", Boolean.toString(hazardousGoods));
			//System.out.println(Boolean.toString(hazardousGoods));
			
			Boolean tipMatic = (Boolean) jsonObject.get("tipMatic");
			jsonmap.put("Tipmatic", Boolean.toString(tipMatic));
			//System.out.println(Boolean.toString(tipMatic));
			
			String chassisType = (String) jsonObject.get("chassisType");
			jsonmap.put("ChassisType", chassisType);
			//System.out.println(chassisType);
			
			String chassisClass = (String) jsonObject.get("chassisClass");
			jsonmap.put("ChassisClass", chassisClass);
			//System.out.println(chassisClass);
			
			String driveType = (String) jsonObject.get("driveType");
			jsonmap.put("DriveType", driveType);
			//System.out.println(driveType);
			
			String DriveConcept = (String) jsonObject.get("driveConcept");
			jsonmap.put("DriveConcept", DriveConcept);
			//System.out.println(DriveConcept);
			
			Boolean planetaryHubReductionAxle = (Boolean) jsonObject.get("planetaryHubReductionAxle");
			jsonmap.put("PlanetaryHubReductionAxle ", Boolean.toString(planetaryHubReductionAxle));
			//System.out.println(Boolean.toString(planetaryHubReductionAxle));
			
			String modelSeries = (String) jsonObject.get("modelSeries");
			jsonmap.put("ModelSeries", modelSeries);
			//System.out.println(modelSeries);
			
			String cab = (String) jsonObject.get("cab");
			jsonmap.put("Cab", cab);
			//System.out.println(cab);
			
			String bodyType = (String) jsonObject.get("bodyType");
			jsonmap.put("BodyType", bodyType);
			//System.out.println(bodyType);
			
			String steering = (String) jsonObject.get("steering");
			jsonmap.put("SteeringType", steering);
			//System.out.println(steering);
			
			String suspension = (String) jsonObject.get("suspension");
			jsonmap.put("Suspension", suspension);
			//System.out.println(suspension);
			
			
			// End Configuration

        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		
		
		
		
		return jsonmap;
	}
	

	

}
