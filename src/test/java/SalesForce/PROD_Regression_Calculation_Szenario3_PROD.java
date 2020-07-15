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

public class PROD_Regression_Calculation_Szenario3_PROD extends base{
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
		public String product = "TGL <= 10t";
		//public String product = "TGM";
	
		//Customer End Price
				public String CustomerEndPrice ="500000";
				
				// ABL / DB2 / Provision
				public String logText_1 = "Fahrzeugkonfiguration";
				public String ABL_1 = "7946";
				public String DB2_1 = "44767";
				public String Provision_1 = "7946";
				
				public String logText_2 = "changed quantity to 5 and customer end price to :"+ CustomerEndPrice;
				public String ABL_2 = "132138";
				public String DB2_2 = "131426";
				public String Provision_2 = "25528";
				
				public String logText_3 = "changed quantity to 1";
				public String ABL_3 = "26428";
				public String DB2_3 = "26285";
				public String Provision_3 = "5106";
				/*
				public String logText_4 = "added all product with subventions";
				public String ABL_4 = "27107";
				public String DB2_4 = "110794";
				public String Provision_4 = "16642";
				*/ 
				
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
		//public String MANCode = "L6TUMFPV";
		public String MANCode = "XIRV55TK";
	
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

	public void PROD_Regression_Calculation_Szenario3() throws InterruptedException, IOException {
		boolean pass, testpass = true;
		testBlocks test = new testBlocks();
		String randomValue = "Prodtest_"+getRandomText();
		//String AccountName = getDateString()+"_"+getRunTime(getDateString())+" "+randomValue;
		Log.info("Start PROD_Regression_Calculation_Szenario3");
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
		Log.info("Change proposal to Municipal");
		pass = test.MunicipalProposal(driver, wait, randomValue);
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
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_1, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", true, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		pass = test.modifyQuantity(driver, wait, randomValue, "5", "1");
		Log.info("Vehicle quantity changet to 5");
		pass = test.changeCustomerEndPrice(driver, wait, randomValue, CustomerEndPrice, "1");
		if (!pass) {
			testpass = false;
		}
		Log.info("Customer End Price changed");
		Log.info("Check calculations");
		//boolean Fieberthermometer = true;
		//pass = test.checkCalculation(driver, wait, randomValue, ABL_2, DB2_2, Provision_2, logText_2, "1", Fieberthermometer, "80000");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_2, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", true, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		pass = test.modifyQuantity(driver, wait, randomValue, "1", "1");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_3, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", true, "0.00", "0.00", false);
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
	}
}