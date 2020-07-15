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


public class openJSONstring {
	
	
	public HashMap<String, String> getJSONdata (String link) throws ParseException {
		
		HashMap<String, String> jsonmap = new HashMap<String, String>();
		
		JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(link);
	
			
			JSONObject lineItem = (JSONObject) jsonObject.get("lineItem");
			JSONArray vehicleItems = (JSONArray) lineItem.get("vehicleItems");
			JSONObject vehicleItem = (JSONObject) vehicleItems.get(0);
            Double calculatedDiscountPrice = (Double) vehicleItem.get("calculatedDiscountPrice");
            Double totalCustomerEndPriceGross = (Double) vehicleItem.get("totalCustomerEndPriceGross");
            Double localAdditionalEquipmTotalPrice = (Double) vehicleItem.get("localAdditionalEquipmTotalPrice");
            Double customerEndPrice = (Double) vehicleItem.get("customerEndPrice");
            Double fixedPricePositionsTotalPrice = (Double) vehicleItem.get("fixedPricePositionsTotalPrice");
            Double discountableFeaturesTotalPrice = (Double) vehicleItem.get("discountableFeaturesTotalPrice");
            Double grossListPrice = (Double) vehicleItem.get("grossListPrice");
            Double totalCustomerEndPrice = (Double) vehicleItem.get("totalCustomerEndPrice");
            Double specialDiscountPrice = (Double) vehicleItem.get("specialDiscountPrice");
            Double valueAddedTaxPrice = (Double) vehicleItem.get("valueAddedTaxPrice");
            Double basicVehiclePrice = (Double) vehicleItem.get("basicVehiclePrice");
            Double specialOfferDiscountPrice = (Double) vehicleItem.get("specialOfferDiscountPrice");
            Double discountTotalPrice = (Double) vehicleItem.get("discountTotalPrice");            
             
            jsonmap.put("calculatedDiscountPrice", String.valueOf(calculatedDiscountPrice)+"0");
            jsonmap.put("totalCustomerEndPriceGross", String.valueOf(totalCustomerEndPriceGross)+"0");
            jsonmap.put("localAdditionalEquipmTotalPrice", String.valueOf(localAdditionalEquipmTotalPrice)+"0");
            jsonmap.put("customerEndPrice", String.valueOf(customerEndPrice)+"0");
            jsonmap.put("fixedPricePositionsTotalPrice", String.valueOf(fixedPricePositionsTotalPrice)+"0");
            jsonmap.put("discountableFeaturesTotalPrice", String.valueOf(discountableFeaturesTotalPrice)+"0");
            jsonmap.put("grossListPrice", String.valueOf(grossListPrice)+"0");
            jsonmap.put("totalCustomerEndPrice", String.valueOf(totalCustomerEndPrice)+"0");
            jsonmap.put("specialDiscountPrice", String.valueOf(specialDiscountPrice)+"0");
            jsonmap.put("valueAddedTaxPrice", String.valueOf(valueAddedTaxPrice)+"0");
            jsonmap.put("basicVehiclePrice", String.valueOf(basicVehiclePrice)+"0");
            jsonmap.put("specialOfferDiscountPrice", String.valueOf(specialOfferDiscountPrice)+"0");
            jsonmap.put("discountTotalPrice", String.valueOf(discountTotalPrice)+"0");
			
		return jsonmap;
	}
	

	

}
