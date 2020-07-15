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

public class PROD_Regression_Calculation_Szenario7_PROD extends base{
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
				
				public String logText_2 = "added Sondereinzelkosten and change Payment Term";
			
				public String logText_3 = "changed customer end price to: "+CustomerEndPrice;

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

	public void PROD_Regression_Calculation_Szenario5() throws InterruptedException, IOException, ParseException {
		boolean pass = true;
		testBlocks test = new testBlocks();
		String randomValue = "Prodtest_"+getRandomText();
		//String AccountName = getDateString()+"_"+getRunTime(getDateString())+" "+randomValue;
		Log.info("Start CAP_Regression_Calculation_TC4_PROD");
		Log.info("TestUser: " +testuser);
		Log.info("Account: " +AccountName);
		pass = test.openAccount(driver, wait, AccountName, contactName);
		//AssertJUnit.assertTrue(pass);
		Log.info("Create new Opportunity");
		pass = test.createOpptyFromContact(driver, wait, randomValue, contactName);
		AssertJUnit.assertTrue(pass);
		Log.info("Create new Proposal");
		pass = test.createProposalFromOppty(driver, wait, randomValue);
		AssertJUnit.assertTrue(pass);
		Log.info("Add new Truck");
		pass = test.createNewTruck(driver, wait, product);
		//AssertJUnit.assertTrue(pass);
		Log.info("Go to C4S");
		Log.info("Used MAN Code: "+MANCode);
		pass = test.configureTruckMock(driver, wait, MANCode, randomValue, 160, product);
		AssertJUnit.assertTrue(pass);
		Log.info("C4S OK");
		pass = test.updateProposalAfterC4S(driver, wait, randomValue, 121, product, "1");
		AssertJUnit.assertTrue(pass);
		Log.info("Update Proposal after C4s OK");
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_1, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "0.00", false);
		Log.info("Change Payment Term to: Payable within 45 days w/o deduction");
		pass = test.changePaymentTerm(driver, wait, randomValue, "1", "Payable within 45 days w/o deduction");
		Log.info("Add Special Direct Cost: "+SpecialDirectCost);
		pass = test.specialDirectCost(driver, wait, randomValue, SpecialDirectCost, SpecialDirectCostPrice, "1");
		/*
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_1, "1", false, "", "Neufahrzeug", "0", "0", false, "0", false);
		pass = test.configureResidual(driver, wait, "40000", "40000");
		pass = test.addProduct(driver, wait, randomValue, "Finance", FProduct, subFProduct);
		Log.info("Product added: "+ FProduct);
		pass = test.configureFinance(driver, wait, randomValue, "E", "1");
		pass = test.sendAbakus(driver, wait, randomValue, "E");
		*/
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_2, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "500.00", false);
		Log.info("Change Customer End Price");
		pass = test.changeCustomerEndPrice(driver, wait, randomValue, CustomerEndPrice, "1");
		Log.info("Customer End Price changed to:" +CustomerEndPrice);
		Log.info("Check calculations");
		pass = test.checkCalculationNew(driver, wait, randomValue, logText_3, "1", false, "", "Neufahrzeug", "", "0.00", "0.00", false, "0.00", "500.00", false);
		
		pass = test.printProposal(driver, wait, randomValue);
		AssertJUnit.assertTrue(pass);
		Log.info("Print Proposal OK");
		pass = test.printOrder(driver, wait, randomValue);
		AssertJUnit.assertTrue(pass);
		Log.info("Print Order OK");
		Thread.sleep(30000);
		pass = test.checkPDF(driver, wait, randomValue, 195, false, false);
		pass = test.checkPrintDocument(driver, wait, randomValue, "1");
		////////
		AssertJUnit.assertTrue(pass);
		Log.info("Test OK");
			
		pass = test.finish(driver, wait);
	}
}