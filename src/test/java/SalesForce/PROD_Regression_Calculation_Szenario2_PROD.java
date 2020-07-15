package SalesForce;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.base;
import resources.login;
import resources.login_new;
import resources.testBlocks;

public class PROD_Regression_Calculation_Szenario2_PROD extends base{
	public WebDriverWait wait;
	private static Logger Log = LogManager.getLogger();
	
	//String ConfigFilePath = prop.getProperty("ConfigFilePath_MAN");
	
	// Testuser
		public String environment = "PROD";
		public String testuser = "Verkaufsbeauftragter SCFI";
	
	// Account
		public String AccountName = "ESA Sales Testdebitor 02"; 
		//public String AccountName = "ZGP Aschbauer Fuhrpark";
	
	//public String contactName = "Interface";	
		public String contactName = "Sabine Meier";
	
	//Product:
		public String product = "TGL < 16t Non-Traction";
		//public String product = "TGM";
	
		//Customer End Price
				public String CustomerEndPrice ="150000";
				public String CustomerEndPrice_2 ="90000";
				public String CustomerEndPrice_3 ="300000";
				
				// ABL / DB2 / Provision
				public String logText_1 = "Fahrzeugkonfiguration";
				public String ABL_1 = "18721";
				public String DB2_1 = "125530";
				public String Provision_1 = "18721";
				
				public String logText_2 = "added Subvention Service-Vertrag";
				public String ABL_2 = "19601";
				public String DB2_2 = "124650";
				public String Provision_2 = "18601";
				
				public String logText_3 = "added Sondereinzelkosten";
				public String ABL_3 = "21111";
				public String DB2_3 = "123141";
				public String Provision_3 = "18396";
				/*
				public String logText_4 = "added all product with subventions";
				public String ABL_4 = "27107";
				public String DB2_4 = "110794";
				public String Provision_4 = "16642";
				*/ 
				//ohne BuyBack
				public String logText_4 = "added all product with subventions";
				public String ABL_4 = "27271";
				public String DB2_4 = "116981";
				public String Provision_4 = "17556";
				/*
				public String logText_5 = "changed customer end price to: "+CustomerEndPrice;
				public String ABL_5 = "92614";
				public String DB2_5 = "45286";
				public String Provision_5 = "7184";
				*/
				public String logText_5 = "changed customer end price to: "+CustomerEndPrice;
				public String ABL_5 = "100758";
				public String DB2_5 = "43493";
				public String Provision_5 = "6946";
				
				public String logText_6 = "new Proposal version and deleted Warranty";
				public String ABL_6 = "100758";
				public String DB2_6 = "43493";
				public String Provision_6 = "6946";
				
				public String logText_7 = "changed customer end price to: "+CustomerEndPrice_2;
				public String ABL_7 = "154407";
				public String DB2_7 = "10156";
				public String Provision_7 = "595";
				
				public String logText_8 = "adding +1 Truck and changed customer end price to: "+CustomerEndPrice_3;
				public String ABL_8 = "201516";
				public String DB2_8 = "86986";
				public String Provision_8 = "13892";
				
				public String logText_9 = "adding Service Partner roles 2 x 1000 EUR";
				public String ABL_9 = "102758";
				public String DB2_9 = "41493";
				public String Provision_9 = "6946";
				
			//Special Direct Cost:
				public String SpecialDirectCost = "ZK47,ZKO7,ZKW4,ZK46,ZKW3";
				public String SpecialDirectCostPrice = "705,303,202,101,404";
			
			// Service Product:
				public String SProduct = "Comfort Super";
				public String subSProduct = "";
				
			// Service Subsidy:
						public String subsidy = "1000";
				
			// Garantie Product:
				public String GProduct = "Antriebsstrang";
				public String subGProduct = "62B-TGS";
					
			// Finance Product:	
				public String FProduct = "Kilometerleasing";
				public String subFProduct = ""; //nicht nötig
					
			// Buy Back Product:
					
				public String BProduct = "Buy Back";
				public String subBProduct = ""; //nicht nötig
				public String customer = "40000";
				public String used = "35000";
					
			// Inzahlungsname Product:
					
				public String IProduct = "Inzahlungnahme";
				public String subIProduct = ""; //nicht nötig
				public String tradeCustomer = "50000";
				public String tradeUsed = "48000";
			
	//MANCode:
		//public String MANCode = "MG7H4DTD";
		public String MANCode = "KNNCP6SI";
	
	
	@BeforeMethod
	
public void initialize() throws IOException, InterruptedException {
		
		testBlocks test = new testBlocks();
		driver = initializeDriver();
		driver.get("https://salesman.lightning.force.com/lightning/page/home");
		wait = new WebDriverWait(driver,30);	
		login login = new login();
		
		driver = login.prod_Login(driver, wait, true, "");
		test.changeMock(driver, wait, MANCode, "E", "SCFI Verkaufsbeauftragter");
		driver.quit();
		driver = initializeDriver();
		driver.get("https://salesman.lightning.force.com/lightning/page/home");
		wait = new WebDriverWait(driver,30);
		
		driver = login.prod_Login(driver, wait, false, "Verkaufsbeauftragter, SCFI");
	}
	
	@Test

	public void PROD_Regression_Calculation_Szenario2() throws InterruptedException, IOException, ParseException {
		boolean pass, testpass = true;
		testBlocks test = new testBlocks();
		String randomValue = "Prodtest_"+getRandomText();
		//String AccountName = getDateString()+"_"+getRunTime(getDateString())+" "+randomValue;
		Log.info("Start PROD_Regression_Calculation_Szenario2");
		Log.info("TestUser: " +testuser);
		Log.info("Account: " +AccountName);
		pass = test.openAccount(driver, wait, AccountName, contactName);
		//AssertJUnit.assertTrue(pass);
		Log.info("Create new Opportunity");
		pass = test.createOpptyFromContact(driver, wait, randomValue, contactName);
		if (!pass) {
			testpass = false;
		}
		Log.info("Create new Proposal");
		pass = test.createProposalFromOppty(driver, wait, randomValue);
		if (!pass) {
			testpass = false;
		}
		Log.info("Add new Truck");
		pass = test.createNewTruck(driver, wait, product);
		//AssertJUnit.assertTrue(pass);
		Log.info("Go to C4S");
		Log.info("Used MAN Code: "+MANCode);
		pass = test.configureTruckMock(driver, wait, MANCode, randomValue, 160, product);
		if (!pass) {
			testpass = false;
		}
		Log.info("C4S OK");
		pass = test.updateProposalAfterC4S(driver, wait, randomValue, 121, product, "1");
		if (!pass) {
			testpass = false;
		}
		Log.info("Update Proposal after C4s OK");
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_1, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00",false);
		if (!pass) {
			testpass = false;
		}
		pass = test.addProduct(driver, wait, randomValue, "Service Vertrag", SProduct, subSProduct);
		Log.info("Product added: "+ SProduct);
		pass = test.configureService(driver, wait, randomValue, subSProduct, subsidy);
		Log.info("Config Product: " + SProduct);
		pass = test.checkServiceAfterMRC(driver, wait, randomValue);
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_2, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		Log.info("Add Special Direct Cost");
		pass = test.specialDirectCost(driver, wait, randomValue, SpecialDirectCost, SpecialDirectCostPrice, "1");
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_3, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		pass = test.addProduct(driver, wait, randomValue, "Buy Back", BProduct, subBProduct);
		pass = test.configureResidual(driver, wait, customer, used);
		pass = test.addProduct(driver, wait, randomValue, "Inzahlungnahme", IProduct, subIProduct);
		pass = test.configureTradeIn(driver, wait, randomValue, "29.05.2020", tradeCustomer, tradeUsed);
		//pass = test.addProduct(driver, wait, randomValue, "Garantieverl�ngerung", GProduct, subGProduct);
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_4, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		Log.info("Change Customer End Price");
		pass = test.changeCustomerEndPrice(driver, wait, randomValue, CustomerEndPrice, "1");
		if (!pass) {
			testpass = false;
		}
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_5, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		Log.info("Create new proposal version");
		pass = test.createVariant(driver, wait, randomValue);
		randomValue = randomValue+"_2";
		Log.info("New proposal version created");
		pass = test.sendMRC(driver, wait, randomValue);
		//Log.info("Delete product: Warranty");
		//pass = test.deleteProduct(driver, wait, randomValue, "Warranty", "1");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_6, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		Log.info("Change Customer End Price");
		pass = test.changeCustomerEndPrice(driver, wait, randomValue, CustomerEndPrice_2, "1");
		if (!pass) {
			testpass = false;
		}
		Log.info("Customer End Price changed to: "+CustomerEndPrice_2);
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_7, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		pass = test.modifyQuantity(driver, wait, randomValue, "2", "1");
		Log.info("Vehicle quantity changed to 2");
		pass = test.changeCustomerEndPrice(driver, wait, randomValue, CustomerEndPrice_3, "1");
		if (!pass) {
			testpass = false;
		}
		Log.info("Customer End Price changed");
		Log.info("Check calculations");		
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_8, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "2000", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		pass = test.modifyQuantity(driver, wait, randomValue, "1", "1");
		Log.info("Vehicle quantity changet to 1");
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_5, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		Log.info("Add Service Partners");
		pass = test.addServicePartner(driver, wait, randomValue);
		Log.info("Check calculations");		
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_9, "1", false, "", "Neufahrzeug", "", "2000", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		//pass = test.checkPartnerRoles(driver, wait, randomValue, "57294", "37224", "6257");
		//pass = test.checkPartnerRoles(driver, wait, randomValue, "Neufahrzeug", "0.00", "2000", false);
		//AssertJUnit.assertTrue(pass);
		pass = test.printProposal(driver, wait, randomValue);
		if (!pass) {
			testpass = false;
			Log.error("Print Proposal NOK");
		} else {
			Log.info("Print Proposal OK");
		}		
		pass = test.printOrder(driver, wait, randomValue);
		if (!pass) {
			testpass = false;
			Log.error("Print Order NOK");
		} else {
			Log.info("Print Order OK");
		}
		Thread.sleep(30000);
		pass = test.checkPDF(driver, wait, randomValue, 195, false, false);
		if (!pass) {
			testpass = false;
		}
		pass = test.checkPrintDocument(driver, wait, randomValue, "1");
		if (!pass) {
			testpass = false;
		}
		if (pass) {
			Log.info("Test OK");
		} else {
			Log.error("Test NOK");
		}
		AssertJUnit.assertTrue(testpass);
		pass = test.finish(driver, wait);
		////////
	}
}