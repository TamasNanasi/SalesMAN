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

public class PROD_Regression_Calculation_Szenario6a_PROD extends base{
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
		public String product = "TGL <= 10t";
		//public String product = "TGM";
	
		//Customer End Price
				public String CustomerEndPrice ="150000";
				
				// ABL / DB2 / Provision
				public String logText_1 = "Fahrzeugkonfiguration";
				
				public String logText_2 = "changed discount price as percentage";
				
				public String logText_3 = "added Sondereinzelkosten";

				/*
				public String logText_4 = "added all product with subventions";
				public String ABL_4 = "27107";
				public String DB2_4 = "110794";
				public String Provision_4 = "16642";
				*/ 
				
			//Special Direct Cost:
				public String SpecialDirectCost = "ZKE1";
				public String SpecialDirectCostPrice = "500";
			
			// Service Product:
				public String SProduct = "Comfort Super";
				public String subSProduct = "";
				
			// Service Subsidy:
						public String subsidy = "1000";
				
			// Garantie Product:
				public String GProduct = "Antriebsstrang";
				public String subGProduct = "62B-TGS";
					
			// Finance Product:	
				public String FProduct = "Mietkauf";
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
		public String MANCode = "LF0PNNK3";
	
	
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

	public void PROD_Regression_Calculation_Szenario5() throws InterruptedException, IOException, ParseException, java.text.ParseException {
		boolean pass, testpass = true;
		testBlocks test = new testBlocks();
		String randomValue = "Prodtest_"+getRandomText();
		//String AccountName = getDateString()+"_"+getRunTime(getDateString())+" "+randomValue;
		Log.info("Start PROD_Regression_Calculation_Szenario6a");
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
		Log.info("Add stock Truck");
		pass = test.createStockTruck(driver, wait, "TAV24PLJ");
		if (!pass) {
			testpass = false;
		}
		pass = test.updateProposalAfterStock(driver, wait, randomValue, "1");
		if (!pass) {
			testpass = false;
		}
		Log.info("Update Proposal after added Stock vehicle OK");
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_1, "1", false, "", "Vorfuhrfahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		Log.info("Change Discount Price as percentage");
		pass = test.changeDiscount(driver, wait, randomValue, "procent", "45", "1");
		if (!pass) {
			testpass = false;
		}
		Log.info("Discount Price changed");
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_2, "1", false, "", "Vorfuhrfahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		if (!pass) {
			testpass = false;
		}
		/*
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
		////////
		*/
		if (testpass) {
			Log.info("Test OK");
		} else {
			Log.error("Test NOK");
		}
		AssertJUnit.assertTrue(testpass);			
		pass = test.finish(driver, wait);
		
	}
}