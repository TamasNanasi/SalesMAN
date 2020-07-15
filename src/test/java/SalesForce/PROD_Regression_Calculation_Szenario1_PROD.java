package SalesForce;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.base;
import resources.login;
import resources.login_new;
import resources.testBlocks;

public class PROD_Regression_Calculation_Szenario1_PROD extends base{
	public WebDriverWait wait;
	private static Logger Log = LogManager.getLogger();
	
	//String ConfigFilePath = prop.getProperty("ConfigFilePath_MAN");
	
	// Testuser
		public String environment = "PROD";
		public String testuser = "Verkaufsbeauftragter, SCFI";
	
	// Account
		public String AccountName = "ESA Sales Testdebitor 02"; 
		//public String AccountName = "ZGP Aschbauer Fuhrpark";
	
	//public String contactName = "Interface";	
		public String contactName = "Sabine Meier";
	
	//Product:
		public String product = "TGL < 16t Non-Traction";
		//public String product = "TGM";
	
	//Customer End Price
		public String CustomerEndPrice ="120000";
		
	// ABL / DB2 / Provision
		public String logText_1 = "Fahrzeugkonfiguration";
		public String ABL_1 = "44882";
		public String DB2_1 = "42163";
		public String Provision_1 = "6924";
		
		public String logText_2 = "added Subvention Service-Vertrag";
		public String ABL_2 = "45322";
		public String DB2_2 = "41723";
		public String Provision_2 = "6864";
		
		public String logText_3 = "added Sondereinzelkosten";
		public String ABL_3 = "46655";
		public String DB2_3 = "40389";
		public String Provision_3 = "6682";
		//Provisionssplit
		
		
		
	//Special Direct Cost:
		public String SpecialDirectCost = "ZKC2,ZK47,ZKW4,ZKW3,ZKO6";
		public String SpecialDirectCostPrice = "101,202,303,404,505";
	
	// Service Product:
		public String SProduct = "Comfort";
		public String subSProduct = "";
		
	// Service Subsidy:
				public String subsidy = "500";
		
	// Garantie Product:
		public String GProduct = "Gesamtfahrzeug";
		public String subGProduct = ""; //2. Line wird ausgewählt
			
	// Finance Product:	
		public String FProduct = "Kilometerleasing";
		public String subFProduct = ""; //nicht nötig
			
	// Buy Back Product:
			
		public String BProduct = "Buy Back";
		public String subBProduct = ""; //nicht nötig		
			
	// Inzahlungsname Product:
			
		public String IProduct = "Inzahlungnahme";
		public String subIProduct = ""; //nicht nötig
			
	//MANCode:
		//public String MANCode = "LMAPJKFO";
		public String MANCode = "SNLWRUQN";
	
	
	@BeforeMethod
	
public void initialize() throws IOException, InterruptedException {
		
		testBlocks test = new testBlocks();
		driver = initializeDriver();
		driver.get("https://salesman.lightning.force.com/lightning/page/home");
		wait = new WebDriverWait(driver,30);	
		login login = new login();
		/*
		driver = login.prod_Login(driver, wait, true, "");
		test.changeMock(driver, wait, MANCode, "E", "SCFI Verkaufsbeauftragter");
		driver.quit();
		driver = initializeDriver();
		driver.get("https://salesman.lightning.force.com/lightning/page/home");
		wait = new WebDriverWait(driver,30);
		*/
		driver = login.prod_Login(driver, wait, false, testuser);
	}
	
	@Test

	public void PROD_Regression_Calculation_Szenario1() throws InterruptedException, IOException {
		boolean pass = true;
		boolean testpass = true;
		testBlocks test = new testBlocks();
		String randomValue = "Prodtest_"+getRandomText();
		//String AccountName = getDateString()+"_"+getRunTime(getDateString())+" "+randomValue;
		Log.info("PROD_Regression_Calculation_Szenario1_PROD");
		Log.info("TestUser: " +testuser);
		Log.info("Account: " +AccountName);
		pass = test.openAccount(driver, wait, AccountName, contactName);
		//AssertJUnit.assertTrue(pass);
		Log.info("Create new Opportunity");
		pass = test.createOpptyFromContact(driver, wait, randomValue, contactName);
		if (!pass) {
			testpass = false;
		}
		AssertJUnit.assertTrue(pass);
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
		Log.info("Change Customer End Price");
		pass = test.changeCustomerEndPrice(driver, wait, randomValue, CustomerEndPrice, "1");
		if (!pass) {
			testpass = false;
		}
		Log.info("Customer End Price changed");
		Log.info("Check calculations");
		//pass = test.checkCalculation(driver, wait, randomValue, ABL_1, DB2_1, Provision_1, logText_1, "1", false, "");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_1, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
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
		pass = test.specialDirectCost(driver, wait, randomValue, SpecialDirectCost, SpecialDirectCostPrice, "1");
		Log.info("Check calculations");				
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_3, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		pass = test.checkPartnerRoles(driver, wait, randomValue, "Neufahrzeug", "", "0.00", "0.00", "0.00", "0.00", false, false);
		if (!pass) {
			testpass = false;
		}
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
		if (testpass) {
			Log.info("Test OK");
		} else {
			Log.error("Test NOK");
		}
		AssertJUnit.assertTrue(testpass);
		pass = test.finish(driver, wait);
		////////
	}
}