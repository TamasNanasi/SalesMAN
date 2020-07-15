package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Properties;

public class calculation {
	
public String roundingwithKomma(String data) {
		
		data = data.replaceAll("[^\\d.]", "");
		//data = data.replace(",", ".");
		double dnum = Double.parseDouble(data);
		int inum = (int) Math.round(dnum);
		String str = String.valueOf(inum);		
		return str;
	}
	
	public double getDoubleSimple(String data) {
		
		data = data.replaceAll("[^\\d.]", "");
		//data = data.replace(",", ".");
		double dnum = Double.parseDouble(data);	
		return dnum;
		
	}

	public double getDouble(String data) {
		data = data.replaceAll("[^\\d.,-]", "");
		int lenght = data.length();
		if (data.charAt(lenght-3) == '.') {
			data = data.replaceAll("[^\\d.-]", "");
		} else {
			data = data.replaceAll("[^\\d,-]", "");
			data = data.replace(",", ".");
		}
		//data = data.replaceAll("[^\\d.]", "");
		//data = data.replace(",", ".");
		double dnum = Double.parseDouble(data);	
		return dnum;
	}
	
	public String getRoundedString(double dnum) {
		
		int inum = (int) Math.round(dnum);
		String str = String.valueOf(inum);		
		return str;
	}
	
	public HashMap<String, String> getValue(String calcType, String VehicleUsage, String truckType, String truckTypeShort, String BasePrice, String Topoptions, String TotalDiscount, String ChargeTransportNet, String VCodesNet, String LocalOptionalFeatures, String Stutzung, String ExtraStutzung, String ZKE1, String ProvisionsrelevanteSondereinzelkosten, String truckAmount, String Juniorverkaufer, String ServiceVertragspartner, boolean kommunal, boolean Tiemann) throws IOException {
		
		HashMap<String, String> valuemap = new HashMap<String, String>();
		FileInputStream fis_GFZ = null, fis_SA = null, fis_NEUFAHRZEUG = null, fis_VORFUHRFAHRZEUG = null;
		String TRP_RABATT_GFZ_Path, TRP_RABATT_SA_Path, NEUFAHRZEUG_Path, VORFUHRFAHRZEUG_Path;
		TRP_RABATT_GFZ_Path = "src/main/java/resources/TRP_RABATT_GFZ.properties";
		TRP_RABATT_SA_Path = "src/main/java/resources/TRP_RABATT_SA.properties";
		NEUFAHRZEUG_Path = "src/main/java/resources/NEUFAHRZEUG.properties";
		VORFUHRFAHRZEUG_Path = "src/main/java/resources/VORFUHRFAHRZEUG.properties";
		Properties prop_GFZ, prop_SA, prop_NEUFAHRZEUG, prop_VORFUHRFAHRZEUG;
		DecimalFormat df = new DecimalFormat("0.00");
		
		fis_GFZ = new FileInputStream(TRP_RABATT_GFZ_Path);
		fis_SA = new FileInputStream(TRP_RABATT_SA_Path);
		fis_NEUFAHRZEUG = new FileInputStream(NEUFAHRZEUG_Path);
		fis_VORFUHRFAHRZEUG = new FileInputStream(VORFUHRFAHRZEUG_Path);
		//fisddl = new FileInputStream(fisddl_Path);
		prop_GFZ = new Properties();
		prop_SA = new Properties();
		prop_NEUFAHRZEUG = new Properties();
		prop_VORFUHRFAHRZEUG = new Properties();
		prop_GFZ.load(fis_GFZ);
		prop_SA.load(fis_SA);
		prop_NEUFAHRZEUG.load(fis_NEUFAHRZEUG);
		prop_VORFUHRFAHRZEUG.load(fis_VORFUHRFAHRZEUG);
		
		String TRP_RABATT_GFZ_Sting = prop_GFZ.getProperty(truckType);
		String TRP_RABATT_SA_Sting = prop_SA.getProperty(truckType);
		String NEUFAHRZEUG_Sting = prop_NEUFAHRZEUG.getProperty(truckTypeShort);
		String VORFUHRFAHRZEUG_Sting = prop_VORFUHRFAHRZEUG.getProperty(truckTypeShort);
		double TRP_RABATT_GFZ = Double.parseDouble(TRP_RABATT_GFZ_Sting);
		double TRP_RABATT_SA = Double.parseDouble(TRP_RABATT_SA_Sting);
		double NEUFAHRZEUG = Double.parseDouble(NEUFAHRZEUG_Sting);
		double VORFUHRFAHRZEUG = Double.parseDouble(VORFUHRFAHRZEUG_Sting);
		
		double BasePrice_D = getDouble(BasePrice);
		double Topoptions_D = getDouble(Topoptions);
		double TotalDiscount_D = getDouble(TotalDiscount);
		double ChargeTransportNet_D = getDouble(ChargeTransportNet);
		double VCodesNet_D = getDouble(VCodesNet);
		double LocalOptionalFeatures_D = getDouble(LocalOptionalFeatures);
		
		double Stutzung_D = getDouble(Stutzung);
		double ExtraStutzung_D = getDouble(ExtraStutzung);
		double ZKE1_D = getDouble(ZKE1);
		Stutzung_D = Stutzung_D + ExtraStutzung_D;
		
		double Juniorverkaufer_D = getDouble(Juniorverkaufer);
		double ServiceVertragspartner_D = getDouble(ServiceVertragspartner);
		
		double ProvisionsrelevanteSondereinzelkosten_D = getDouble(ProvisionsrelevanteSondereinzelkosten);
		double truckAmount_D = getDoubleSimple(truckAmount);
		
		//------------------------------
		//Calculation Nettoverkaufspreis des Werklieferumfangs (ehem. Street Price) - Provisionsbasis SALE Zeile 17;
		double BruttolistenpreisSumme_D = BasePrice_D + Topoptions_D - TotalDiscount_D;
		
		String BruttolistenpreisSumme = getRoundedString(BruttolistenpreisSumme_D);
		
		//System.out.println(BruttolistenpreisSumme_D);
		//System.out.println("BruttolistenpreisSumme"+BruttolistenpreisSumme);
		//------------------------------
		//Calculation Umsatz (Kundenendpreis) Zeile 18;
		double TotalvehicleNetRight_D = BruttolistenpreisSumme_D + ChargeTransportNet_D + VCodesNet_D + LocalOptionalFeatures_D;
		
		String TotalvehicleNetRight = getRoundedString(TotalvehicleNetRight_D);
		
		//System.out.println(TotalvehicleNetRight_D);
		//System.out.println(TotalvehicleNetRight);
		//------------------------------
		//Calculation Transferpreis TRP Kategorie Fahrzeug Zeile 19;
		double TransferpreisTRPKategorieFahrzeug_D = BasePrice_D*(1-TRP_RABATT_GFZ);
		
		String TransferpreisTRPKategorieFahrzeug = getRoundedString(TransferpreisTRPKategorieFahrzeug_D);
		
		//System.out.println(TransferpreisTRPKategorieFahrzeug_D);
		//System.out.println(TransferpreisTRPKategorieFahrzeug);
		//------------------------------
		//Calculation Transferpreis TRP Kategorie Sonderausstattungen Zeile 20;
		double TransferpreisTRPKategorieSonderausstattungen_D = Topoptions_D*(1-TRP_RABATT_SA);
		
		String TransferpreisTRPKategorieSonderausstattungen = getRoundedString(TransferpreisTRPKategorieSonderausstattungen_D);
		
		//System.out.println(TransferpreisTRPKategorieSonderausstattungen_D);
		//System.out.println(TransferpreisTRPKategorieSonderausstattungen);
		//------------------------------
		//Calculation Marge (ehem. DB2 Zeile 21);
		double Marge_D = TotalvehicleNetRight_D - TransferpreisTRPKategorieFahrzeug_D - TransferpreisTRPKategorieSonderausstattungen_D - Stutzung_D - ProvisionsrelevanteSondereinzelkosten_D - VCodesNet_D - ChargeTransportNet_D - LocalOptionalFeatures_D + ZKE1_D;
		
		String Marge = getRoundedString(Marge_D);
		
		//System.out.println(Marge_D);
		//System.out.println(Marge);
		//------------------------------
		//Calculation Provision auf Nettoverkaufspreis des Werkslieferumfangs Zeile 23;
		String ProvisionNettoverkaufspreis = "";
		double ProvisionNettoverkaufspreis_D = 0.00;
		if(calcType.equals("Neufahrzeug")) {
			ProvisionNettoverkaufspreis_D = BruttolistenpreisSumme_D * NEUFAHRZEUG;
			
			ProvisionNettoverkaufspreis = getRoundedString(ProvisionNettoverkaufspreis_D);
		} else if(calcType.equals("Vorfuhrfahrzeug")) {
			ProvisionNettoverkaufspreis_D = BruttolistenpreisSumme_D * VORFUHRFAHRZEUG;
			
			ProvisionNettoverkaufspreis = df.format(ProvisionNettoverkaufspreis_D);
			ProvisionNettoverkaufspreis_D = getDouble(ProvisionNettoverkaufspreis);
			ProvisionNettoverkaufspreis = getRoundedString(ProvisionNettoverkaufspreis_D);
		}
		//------------------------------
		//Calculation Basis Margenprovision (ehem. DB2 Provision) - Provisionsbasis MORE Zeile 24;
		double BasisMargenprovision_D =  Marge_D - ProvisionNettoverkaufspreis_D;
		
		String BasisMargenprovision = df.format(BasisMargenprovision_D);
		BasisMargenprovision_D = getDouble(BasisMargenprovision);
		
		BasisMargenprovision = getRoundedString(BasisMargenprovision_D);
		
		//System.out.println(BasisMargenprovision_D);
		//System.out.println("BasisMargenprovision: "+BasisMargenprovision);
		//------------------------------
		//Calculation Provision auf Marge (ehem. Provision auf DB2) Zeile 25;
		double ProvisionaufMarge_D =  0.00;
		if ((BasisMargenprovision_D > 0.00) & (calcType.equals("Neufahrzeug"))) {
			ProvisionaufMarge_D = BasisMargenprovision_D * 0.12;
		} else if ((BasisMargenprovision_D > 0) & (calcType.equals("Vorfuhrfahrzeug") & !VehicleUsage.equals("Demo"))) {
			ProvisionaufMarge_D = BasisMargenprovision_D * 0.12;
		} else {
			ProvisionaufMarge_D = 0.00;
		}
		String ProvisionaufMarge;
		ProvisionaufMarge = df.format(ProvisionaufMarge_D);
		ProvisionaufMarge_D = getDouble(ProvisionaufMarge);
		
		ProvisionaufMarge = getRoundedString(ProvisionaufMarge_D);
		
		//System.out.println(ProvisionaufMarge_D);
		//System.out.println(ProvisionaufMarge);
		//------------------------------
		//Calculation Gesamtprovision Zeile 26;
		double Gesamtprovision_D = ProvisionNettoverkaufspreis_D + ProvisionaufMarge_D;
		if (kommunal) {
			Gesamtprovision_D = Gesamtprovision_D + truckAmount_D * 300;
		}
		
		String Gesamtprovision = getRoundedString(Gesamtprovision_D);
		valuemap.put("Gesamtprovision", Gesamtprovision);
		
		//System.out.println(Gesamtprovision_D);
		//System.out.println(Gesamtprovision);
		//------------------------------
		//Calculation DB2 Zeile 28;
		double DB2_D = BasisMargenprovision_D - ProvisionaufMarge_D - Juniorverkaufer_D - ServiceVertragspartner_D - ZKE1_D;
		if (kommunal) {
			DB2_D = DB2_D - truckAmount_D * 300;
		}
		String DB2 = getRoundedString(DB2_D);
		valuemap.put("DB2", DB2);
		
		//System.out.println(DB2_D);
		//System.out.println(DB2);
		//------------------------------
		//Calculation ABL (mit Provision) Zeile 29;
		double ABL_D = TotalDiscount_D  + ProvisionsrelevanteSondereinzelkosten_D + Gesamtprovision_D + Juniorverkaufer_D + ServiceVertragspartner_D + Stutzung_D;
		//ABL_D = ABL_D + truckAmount_D * 300;
		String ABL = null;
		//ABL = df.format(ABL_D);
		//ABL_D = getDouble(ABL);

		if (Tiemann) {
			ABL = getRoundedString(ABL_D-Gesamtprovision_D);
			
		} else {			
			ABL = getRoundedString(ABL_D);		
		}
		valuemap.put("ABL", ABL);
		
		//System.out.println(ABL_D);
		//System.out.println(ABL);
		return valuemap;
		
		
	}
	

}
