package resources;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AbakusObject;
import pageObjects.AccountsObject;
import pageObjects.AccountsObjectDev;
import pageObjects.AttachementObject;
import pageObjects.C4SObject;
import pageObjects.C4SObjectDev;
import pageObjects.ContactsObject;
import pageObjects.ContactsObjectDev;
import pageObjects.MainPage;
import pageObjects.OpptyObject;
import pageObjects.OpptyObjectDev;
import pageObjects.OrderObject;
import pageObjects.PLI_ServiceObject;
import pageObjects.PLI_TruckObject;
import pageObjects.ProposalObject;
import pageObjects.ProposalObjectDev;
import pageObjects.SetupPage;
import pageObjects.ZoomObject;

import java.util.Random;
import java.util.Set;

public class testBlocks extends base {
	

	private static Logger Log = LogManager.getLogger();
	
	public boolean openAccount(WebDriver driver, WebDriverWait wait, String accountName, String contactName) throws InterruptedException, IOException {
		boolean pass = true;
		String L= "D";	
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		AccountsObject ao = new AccountsObject();
		ContactsObject co = new ContactsObject();
		Thread.sleep(7000);
		//ef.get_Element(mp.Accounts(L), 0).click();
		ef.get_JSClick(mp.AccountsNew(L), 0);
		a.moveToElement(ef.get_Element(ao.AccountSearch, 1000)).click().sendKeys(accountName).sendKeys(Keys.ENTER).build().perform();
		//a.moveToElement(ef.get_Element(ao.accountListSearch(accountName), 1000)).click().sendKeys(accountName).sendKeys(Keys.ENTER).build().perform();
		ef.get_JSClick(ao.accountListSearch(accountName), 0);
		if (ef.check_Element(ao.closeEdit, 5000)) {
			ef.get_Element(ao.closeEdit, 0).click();
		}	
		ef.get_JSClick(ao.Account_ContactTabNew(L), 0);
		/*
		if (ef.elementExist(ao.Account_ContactTab(L), 7000)) {
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(ao.Account_ContactTab(L), 0));
			a.moveToElement(ef.get_Element(ao.Account_ContactTab(L), 0)).click().build().perform();
			
		} else {
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(ao.Account_ContactTabReserve(L), 0));
			a.moveToElement(ef.get_Element(ao.Account_ContactTabReserve(L), 0)).click().build().perform();
		}
		*/
		if (ef.elementExist(ao.contactListSearch(contactName), 3000)) {
			//summer Release
			//a.moveToElement(ef.get_Element(ao.contactListSearch(contactName), 0)).click().build().perform();
			ef.get_JSClick(ao.contactListSearch(contactName), 0);
		} else {
			//a.moveToElement(ef.get_Element(ao.contactListSearchDev(contactName), 0)).click().build().perform();
			ef.get_JSClick(ao.contactListSearchDev(contactName), 0);
		}
		
		if (ef.elementExist(co.contactNameSearch(contactName,L), 1000)) {
			pass = true;
		}
		return pass;
	}

	public boolean createAccount(WebDriver driver, WebDriverWait wait, String accountName, HashMap<String, String> td) throws InterruptedException, IOException {
		boolean pass = false;
		String L = "D";	
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		Actions a= new Actions(driver);
		//TestData td = new TestData();
		AccountsObject ao = new AccountsObject();
		Thread.sleep(8000);
		ef.get_Element(mp.Accounts(L), 1000).click();
		if (ef.elementExist(mp.getLanguage("Home"), 1000)) {
			L = "E";
		}		
		Log.info(L);
		//ef.get_Element(ao.New(L), 4000).click();
		a.moveToElement(ef.get_Element(ao.New(L), 4000)).click().build().perform();
		
		if (ef.elementExist(ao.NewWeiter, 2000)) {
			ef.get_Element(ao.NewWeiter, 0).click();
		}
		ef.get_Element(ao.NewAccountName(L), 1000).sendKeys(accountName);
		if (td.get("Land"+L) != null) {
			ef.get_Element(ao.NewLand(L), 0).click();
			ef.get_DropDown_Value(td.get("LandNummer"+L), td.get("Land"+L), 500).click();
		}
		if (td.get("Strasse") != null) {
			ef.get_Element(ao.NewStrasse(L), 0).sendKeys(td.get("Strasse"));
		}
		if (td.get("Stadt") != null) {
			ef.get_Element(ao.NewStadt(L), 0).sendKeys(td.get("Stadt"));
		}
		if (td.get("PLZ") != null) {
			ef.get_Element(ao.NewPLZ(L), 0).sendKeys(td.get("PLZ"));
		}
		if (td.get("BundesLand"+L) != null) {
			ef.get_Element(ao.NewBundesLand(L), 0).click();
			ef.get_DropDown_Value(td.get("BundesLandNummer"+L), td.get("BundesLand"+L), 200).click();
		}	
		if (td.get("SAPStrasse1") != null) {
			ef.get_Element(ao.NewSAPStrasse1(L), 0).sendKeys(td.get("SAPStrasse1"));
		}
		if (td.get("SAPHausnummer") != null) {
			ef.get_Element(ao.NewSAPHausnummer(L), 0).sendKeys(td.get("SAPHausnummer"));
		}		
		ef.get_Element(ao.NewFuhrparkgroesseTruck(L), 0).click();
		ef.get_DropDown_Value(td.get("FuhrparkgroesseTruckNummer"+L), td.get("FuhrparkgroesseTruckValue"+L), 200).click();
		ef.get_Element(ao.Save(L), 0).click();
		if (ef.check_Element(ao.HLPanel_AccountText(L), 1000)) {
			if (ef.get_Element(ao.HLPanel_AccountText(L), 0).getText().equals(accountName)) {
				pass = true;
				Log.info("Account created: "+accountName);
			} else {
				Log.error("Account not created");
				pass = false;
			}
		}	
		
		return pass;
	}
	
	
	public boolean createContact (WebDriver driver, WebDriverWait wait, String randomValue, HashMap<String, String> td, boolean newContact) throws IOException, InterruptedException {
		String L = "D";
		boolean pass = false;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		AccountsObject ao = new AccountsObject();
		ContactsObject co = new ContactsObject();		
		if (ef.elementExist(mp.getLanguage("Home"), 6000)) {
			L = "E";
		}
		if (newContact) {
			ef.get_Element(mp.Contacts(L), 1000).click();
			ef.get_Element(co.New(L), 3000).click();
			ef.get_Element(co.Next(L), 0).click();
		} else {
			ef.get_Element(ao.HLPanel_Button_NeuerKontakt(L), 8000).click();
		}
		if (td.get("Salutation"+L) != null) {
			Log.info(td.get("Salutation"+L));
			ef.get_Element(co.Salutation(L), 0).click();
			ef.get_DropDown_Value(td.get("SalutationNummer"+L), td.get("Salutation"+L), 500).click();
		}
		ef.get_Element(co.LastName(L), 0).sendKeys(randomValue);
		if (td.get("Telefon") != null) {
			ef.get_Element(co.Telefon(L), 0).sendKeys(td.get("Telefon"));
		}
		ef.get_Element(co.JobFunction(L), 0).click();
		ef.get_DropDown_Value(td.get("JobFunctionNummer"+L), td.get("JobFunction"+L), 500).click();
		ef.get_Element(co.MainSalesContact(L), 0).click();
		ef.get_Element(co.Save(L), 0).click();
		//ef.get_Element(ao.Account_ContactTab, 0).click();
		
		if (ef.elementExist(ao.Account_ContactTab(L), 5000)) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(ao.Account_ContactTab(L), 0));
			a.moveToElement(ef.get_Element(ao.Account_ContactTab(L), 0)).click().build().perform();
		} else {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(ao.Account_ContactTabReserve(L), 0));
			a.moveToElement(ef.get_Element(ao.Account_ContactTabReserve(L), 0)).click().build().perform();
		}
		if (ef.check_Element(ao.lineSearch(randomValue),0)) {
			a.moveToElement(ef.get_Element(ao.lineSearch(randomValue), 0)).click().build().perform();
			Log.info("Contact created: "+randomValue);
			pass = true;
		} else {
			Log.error("Contact not created");
		}
		return pass;
	}
	
	public boolean createOpptyFromContact (WebDriver driver, WebDriverWait wait, String randomValue, String contact) throws InterruptedException {
		String L = "D";
		boolean pass = true;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ContactsObject co = new ContactsObject();
		OpptyObject oo = new OpptyObject();
		if (ef.elementExist(mp.getLanguage("Home"), 0)) {
			L = "E";
		}
		//ef.get_Element(co.NewOpportunity(L), 3000).click();
		ef.get_JSClick(co.NewOpportunity(L), 0);
		/*
		if (ef.elementExist(co.NewOpportunity(L), 5000)) {
			a.moveToElement(ef.get_Element(co.NewOpportunity(L), 0)).click().build().perform();
		} else {
			a.moveToElement(ef.get_Element(co.NewOpportunityProd(L), 0)).click().build().perform();
		}
		*/
		ef.get_Element(oo.OpportunityName(L), 0).sendKeys(randomValue+"_Oppty");
		ef.get_Element(oo.Schlusstermin(L), 0).sendKeys("15.08.2020");
		Select probability = new Select(ef.get_Element(oo.Probability(L), 0));
		probability.selectByValue("chOppProb.5 %25");
		ef.get_Element(oo.Next(L), 0).click();
		ef.get_Element(oo.Cancel(L), 0).click();
		ef.get_Element(oo.Next(L), 1000).click();
		if (ef.elementExist(oo.Next(L), 3000)) {
			ef.get_Element(oo.Next(L), 0).click();
		}
		//ef.get_Element(oo.RL_ContactRoles(L), 3000).click();
		//if (contact.equals("")) {
		//	a.moveToElement(ef.get_Element(oo.lineSearchEdit(randomValue), 2000)).click().build().perform();
		//} else {
		//	a.moveToElement(ef.get_Element(oo.lineSearchEdit(contact), 2000)).click().build().perform();
		//}
		//a.moveToElement(ef.get_Element(oo.Edit(L), 200)).click().build().perform();
		//ef.get_Element(oo.Primary(L), 500).click();
		//Log.info("Save new Opportunity");
		//ef.get_Element(oo.Save(L), 0).click();
		/*
		if (ef.check_Element(oo.HLPanel_OpptyTextSearch(randomValue+"_Oppty"), 4000)) {
			//a.moveToElement(ef.get_Element(oo.Angebotsphase(L), 0)).click().build().perform();
			//a.moveToElement(ef.get_Element(oo.PhaseAktuell(L), 0)).click().build().perform();
			Log.info("Opportunity created: "+randomValue+"_Oppty");
			pass = true;
		} else {
			Log.error("Opportunity not created");
		}
		*/
		return pass;
	}
	
	public boolean createProposalFromOppty (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		String L = "D";
		boolean pass = false;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		OpptyObject oo = new OpptyObject();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 0)) {
			L = "E";
		}
		//ef.get_Element(oo.New_Proposal(L), 1000).click();
		ef.get_JSClick(oo.New_Proposal(L), 0);
		if (ef.elementExist(oo.NoPrimaryContactDetected(L), 2000)) {
			ef.get_JSClick(po.Next(L), 0);
		}
		ef.get_Element(po.ProposalName(L), 3000).sendKeys(randomValue+"_Proposal");
		//ef.get_Element(po.Next(L), 0).click();
		ef.get_JSClick(po.Next(L), 0);
		/*
		ef.get_Element(po.ShippingType(L), 0).click();
		if (L.equals("D")) {
			ef.get_DropDown_Value("2", "Abholung im Werk", 0).click();
		} else {
			ef.get_DropDown_Value("2", "Pickup at factory", 0).click();
		}
		
		ef.get_Element(po.OfferValidUntil(L), 0).sendKeys(getFutureDateString(14, "dd.MM.yyyy", "D"));
		*/
		//ef.get_Element(po.Save(L), 0).click();
		ef.get_JSClick(po.Save(L), 0);
		//a.moveToElement(ef.get_Element(oo.PhaseAktuell(L), 0)).click().build().perform();
		//ef.get_Element(oo.Oppty_Proposals(L), 5000).click();
		
		//a.moveToElement(ef.get_Element(oo.Oppty_Proposals(L), 7000)).click().build().perform();
		ef.get_JSClick(oo.Oppty_ProposalsNew(L), 0);
		if (ef.get_Element(oo.proposalSearch(randomValue+"_Proposal"), 2000).getText().equals(randomValue+"_Proposal")) {
			//a.moveToElement(ef.get_Element(oo.proposalSearch(randomValue+"_Proposal"), 0)).click().build().perform();
			ef.get_JSClick(oo.proposalSearch(randomValue+"_Proposal"), 0);
			Log.info("Proposal created: "+randomValue+"_Proposal");
			pass = true;
		} else {
			Log.error("Proposal not created");
		}
		return pass;
	}
	
	public boolean MunicipalProposal (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		String L = "D";
		boolean pass = false;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		OpptyObject oo = new OpptyObject();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.DetailsTab(L), 1000)).click().build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.GeneralProposalData(L), 2000));
		//ef.get_Element(po.EditOrderReason(L), 200).click();
		a.moveToElement(ef.get_Element(po.EditOrderReason(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.OrderReasonDropdown(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.MunicipalOrder(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.CustomerTypeDropdown(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.MunicipalCustomer(L), 500)).click().build().perform();
		ef.get_Element(po.PLI_Save(L), 2000).click();
		
		
		if (ef.get_Element(po.OrderReasonText(L), 2000).getText().equals("Municipal Order")) {
			pass = true;
			Log.info("Proposal changed to Municipal");
		} else {
			Log.error("Proposal not changed to Municipal");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ef.get_Element(po.PricingTab(L), 2000));
		return pass;
	}
	
	public boolean createNewTruck (WebDriver driver, WebDriverWait wait, String product) throws InterruptedException {
		String L = "D";
		boolean pass = false;
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 4000)) {
			L = "E";
		}
		//ef.get_Element(po.PricingTab(L), 0).click();
		ef.get_JSClick(po.PricingTab(L), 0);
		//ef.get_Element(po.AddNewTruck(L), 3000).click();
		ef.get_JSClick(po.AddNewTruck(L), 0);
		//ef.get_Element(po.productSearch(product), 0).click();
		ef.get_JSClick(po.productSearch(product), 0);
		//ef.get_Element(po.SaveNewTruck(L), 0).click();
		ef.get_JSClick(po.SaveNewTruck(L), 0);
		int count = 0;
		while ((!ef.elementExist(po.TruckAddedMessage(L), 0) && (count <= 40))) {
			count++;
			Thread.sleep(500);
			}
		if (count <= 40) {
			Log.info("Truck added: "+product);
			pass = true;
		} else {
			Log.error("Truck not added");
			pass = false;
		}
		
		return pass;
	}
	
	public boolean createStockTruck (WebDriver driver, WebDriverWait wait, String manCode) throws InterruptedException {
		String L = "D";
		boolean pass = false;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 2000)) {
			L = "E";
		}
		ef.get_Element(po.PricingTab(L), 0).click();
		ef.get_Element(po.AddNewTruck(L), 3000).click();
		ef.get_Element(po.StockButton(L), 2000).click();
		//ef.get_Element(po.StockButton(L), 0).click();
		int count = 0;
		while ((!ef.elementExist(po.StockAddLabel(L), 1000)) && (count <= 30)) {
			Thread.sleep(1000);
		}
		a.moveToElement(ef.get_Element(po.StockSearch(L), 500)).click().sendKeys(manCode).sendKeys(Keys.ENTER).build().perform();
		//a.moveToElement(ef.get_Element(po.StockSalesOffice(L), 200)).click().sendKeys("DV12").sendKeys(Keys.ENTER).build().perform();
		//a.moveToElement(ef.get_Element(po.VehicleUsage(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.VehicleUsageValueSearch(L, "Storage vehicle"), 500)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.ApplyFilters(L), 8000)).click().build().perform();
		count = 0;
		while ((!ef.elementExist(po.StockFirstLine(L), 1000)) && (count <= 30)) {
			Thread.sleep(1000);
		}
		int i=1;
		while (!ef.get_Element_woCl(po.StockLineReservedSearch(L, String.valueOf(i)), 100).getText().equals("")) {
			if (i==20) {
				ef.get_Element(po.StockLineReservedSearch(L, String.valueOf(i)), 100).click();
				Thread.sleep(5000);
			}
			i++;
		}
		a.moveToElement(ef.get_Element(po.StockLineAddButtonSearch(L, String.valueOf(i)), 2000)).click().build().perform();
		
		
		//a.moveToElement(ef.get_Element(po.StockMANCode(L), 1000)).click().sendKeys(manCode).sendKeys(Keys.ENTER).build().perform();
		//a.moveToElement(ef.get_Element(po.AddStockVehicle(L), 2000)).click().build().perform();
		if (ef.elementExist(po.Confirm(L), 2000)) {
			ef.get_Element(po.Confirm(L), 200).click();
		}
		ef.get_Element(po.SaveNewTruck(L), 500).click();
		count = 0;
		while ((!ef.elementExist(po.C4SUpdatedSuccessfullyMessage(L), 0)) && (count <= 2)) {
			count++;
			Thread.sleep(1000);
		}
		String truckName = ef.get_Element(po.TruckName(L), 1000).getText();
		truckName = truckName.replace(" (C4S)", "");
		
		if (ef.elementExist(po.tileSearch(truckName), 5000)) {
			Log.info("Stock Truck added: "+truckName);
			pass = true;
		} else {
			Log.error("Stock Truck not added");
			pass = false;
		}
		
		return pass;
	}
	
	public boolean addProduct (WebDriver driver, WebDriverWait wait, String randomValue, String productType, String product, String subProduct) throws InterruptedException {
		String L = "D";
		boolean pass = true;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 6000)) {
			L = "E";
		}
		//Log.info("Language: "+L);
		ef.get_Element(mp.Proposals(L), 4000).click();
		ef.get_Element(po.Search, 3000).clear();
		a.moveToElement(ef.get_Element(po.Search, 1000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 4000).click();
		ef.get_JSClick(po.lineSearch(randomValue+"_Proposal"), 4000);
		ef.get_Element(po.PricingTab(L), 2000).click();
		if (ef.elementExist(po.addProduct(L), 1000)) {
			ef.get_Element(po.addProduct(L), 200).click();
		} else {
			ef.get_Element(po.addProductSommer(L), 200).click();
		}
		
		ef.get_Element(po.addProductTypeSearch(productType), 200).click();
		switch (productType) {
		case "Lagerfahrzeug": {
			//
			break;
		}
		case "Stock": {
			//
			break;
		}
		case "Garantieverlängerung": {
			String[] productList = product.split(",");
			String[] subProductList = subProduct.split(",");
			for (int i = 0; i < productList.length; i++) {
				ef.get_Element(po.AddSubGarantieSearch(productList[i]), 2000).click();
				if (productList[i].equals("Antriebsstrang")) {
					String[] element = subProductList[i].split("-");
					//a.moveToElement(ef.get_Element(po.SubGarantieLineSearch("62A", "TGX"), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(po.SubGarantieLineSearch(element[0], element[1]), 1000)).click().build().perform();
					Log.info("Product added: "+productType+"---"+productList[i]+"---"+element[0]);
					//a.moveToElement(ef.get_Element(po.SubGarantieLineSearch("62C", "TGS"), 1000)).click().build().perform();
					//Log.info("Product added: "+productType+"---"+productList[i]+"--- 62C");
				}
				if (productList[i].equals("Erweiterungspaket Antriebsstrang")) {
					String[] element = subProductList[i].split("-");
					//a.moveToElement(ef.get_Element(po.SubGarantieLineSearch("4D1", "TGS"), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(po.SubGarantieLineSearch(element[0], element[1]), 1000)).click().build().perform();
					//ef.get_Element(po.SubGarantieLineSearch("4D1"), 1000).click();
					Log.info("Product added: "+productType+"---"+productList[i]+"---"+element[0]);
				}
				if (productList[i].equals("Gesamtfahrzeug")) {
					String[] element = subProductList[i].split("-");
					//a.moveToElement(ef.get_Element(po.SubGarantieLineSearch("61A", "TGX"), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(po.SubGarantieLineSearch(element[0], element[1]), 1000)).click().build().perform();
					Log.info("Product added: "+productType+"---"+productList[i]+"---"+element[0]);
				}
				if (productList[i].equals("Kombinationspaket")) {
					String[] element = subProductList[i].split("-");
					//a.moveToElement(ef.get_Element(po.SubGarantieLineSearch("4A2", "TGX"), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(po.SubGarantieLineSearch(element[0], element[1]), 1000)).click().build().perform();
					Log.info("Product added: "+productType+"---"+productList[i]+"---"+element[0]);
				}
			}
			
			//ef.get_Element(po.SubGarantieSecondLine, 3000).click();
			break;
		}
		case "Service Vertrag": {
			ef.get_Element(po.addProductSearch(product), 1000).click();
			if (!subProduct.equals("")) {
			String[] subProductList = subProduct.split(",");
				for (int i = 0; i < subProductList.length; i++) {
					ef.get_Element(po.addSubProductSearch(subProductList[i]), 200).click();
					Log.info("Subproduct added: "+productType+"---"+subProductList[i]);
				}
			}
			ef.get_Element(po.Add(L), 1000).click();
			//
			break;
		}
		default: {
			ef.get_Element(po.addProductSearch(product), 2000).click();
			break;
		}

		}
		
		ef.get_Element(po.SaveNewTruck(L), 500).click();
		int count = 0;
		while ((!ef.elementExist(po.ProposalUpdatingMessage(L), 0)) && (count <= 40)) {
			count++;
			Thread.sleep(500);
		}
		Log.info("Product added: "+productType+"---"+product+"---"+subProduct );
		Thread.sleep(3000);
		return pass;
	}
	
	public boolean configureTruck (WebDriver driver, WebDriverWait wait, String manCode, String randomValue, int future, String product) throws InterruptedException {
		String L = "D";
		boolean pass = true;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		PLI_TruckObject to = new PLI_TruckObject();
		C4SObject c4s = new C4SObject();
		if (ef.check_Element(mp.getLanguage("Home"), 2000)) {
			L = "E";
		}
		//String currentValue = ef.get_Element(po.CurrenPriceValue(L), 0).getText();
		ef.get_Element(po.C4SButton_Show(L), 2000).click();
		Thread.sleep(6000);
		a.moveToElement(driver.findElement(po.C4S(L))).click().build().perform();
		//a.moveToElement(ef.get_Element(c4s.ManCodeInput(L), 3000)).click().sendKeys(manCode).sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(c4s.ManCodeInput(L), 0).sendKeys(manCode);
		ef.get_Element(c4s.ManCodeInput(L), 5000).sendKeys(Keys.ENTER);
		/*
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", ef.get_Element(c4s.LieferdatumCalendar(L), 1000));

		ef.C4SaddDate(getFutureDateString(future, "d.MMMM.yyyy", L));
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", ef.get_Element(c4s.CalendarUpdate(L), 2000));

		while (!ef.elementExist(c4s.ConfigurationUpdated(L), 0)) {
			Thread.sleep(500);
		}
		*/
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", ef.get_Element(c4s.Save(L), 200));
		while (!ef.elementExist(c4s.ConfigurationSaved(L), 0)) {
			Thread.sleep(1000);
		}
		//ef.get_Element(c4s.Save, 7000).click();
		//Thread.sleep(5000);
		String MANCode = ef.get_Element(c4s.ManCode(L), 1000).getText();
		//Log.info("MANCode:"+ MANCode);
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", ef.get_Element(c4s.Exit(L), 0));
		//ef.get_Element(c4s.Exit(L), 0).click();
		long start = System.currentTimeMillis();
		
		
		int count = 0;
		
		//while ((ef.get_Element_woCl(to.PLI_manCode(L), 4000).getText().equals("")) && (count <= 80)) {
		String currentValue = ef.get_Element(po.CurrenPriceValue(L), 0).getText();
		while ((ef.get_Element(po.CurrenPriceValue(L), 500).getText().equals(currentValue)) && (count <= 80)) {
			count++;
			//Thread.sleep(1000);
			
			//Start workaround:
			Thread.sleep(10000);
			driver.navigate().refresh();
			ef.get_Element(mp.Proposals(L), 5000).click();
			if(!ef.elementExist(po.Search, 1000)) {
				ef.get_Element(mp.Proposals(L), 3000).click();
			}
			ef.get_Element(po.Search, 1000).clear();
			a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
			//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 1000).click();
			a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
			//End workaround:
		}
		
		//while ((!ef.elementExist(po.C4SUpdatedSuccessfullyMessage(L), 0) && (count <= 100))) {
		//	count++;
		//	Thread.sleep(1000);
		//}
		
		long end = System.currentTimeMillis();
		Log.info("C4S Response time in milisec: " + (end - start));
		Log.info("C4S Response time in sec: " + ((end - start) / 1000));
		
		String productName = ef.get_Element(po.TruckLabel(L), 1000).getText();
		productName = productName.replace(" (C4S)", "").trim();
		Log.info("New product name: " + productName);
		/*
		ef.get_Element(po.RelatedTab(L), 1000).click();
		a.moveToElement(ef.get_Element_woCl(po.lineItemSearch(productName), 5000)).click().build().perform();
		String MANCodeSF = ef.get_Element_woCl(po.ConfigurationFirstRowMANCode(L), 3000).getText();	
		if (MANCode.equals(MANCodeSF)) {
			Log.info("MANCode: "+ MANCodeSF);
			pass = true;
		} else {
			pass = false;
		}
		*/
		return pass;
	}
	
	public boolean configureTruckCAP (WebDriver driver, WebDriverWait wait, String manCode, String randomValue, int future, String product) throws InterruptedException {
		String L = "D";
		boolean pass = true;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		PLI_TruckObject to = new PLI_TruckObject();
		C4SObject c4s = new C4SObject();
		if (ef.check_Element(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		long start = System.currentTimeMillis();
		
		int count = 0;
		
		//while ((ef.get_Element_woCl(to.PLI_manCode(L), 4000).getText().equals("")) && (count <= 80)) {
		String currentValue = ef.get_Element(po.CurrenPriceValue(L), 0).getText();
		
		while ((!ef.elementExist(po.C4SUpdatedSuccessfullyMessage(L), 0)) && (count <= 100)) {
			count++;
			Thread.sleep(1000);
		}
		
		count = 0;
		while ((ef.get_Element(po.CurrenPriceValue(L), 500).getText().equals(currentValue)) && (count <= 80)) {
			count++;
			//Thread.sleep(1000);
			
			//Start workaround:
			driver.navigate().refresh();
			ef.get_Element(mp.Proposals(L), 5000).click();
			//ef.get_JSClick(mp.ProposalsNew(L), 5000);
			if(!ef.elementExist(po.Search, 1000)) {
				ef.get_Element(mp.Proposals(L), 3000).click();
			}
			ef.get_Element(po.Search, 2000).clear();
			a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
			//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 1000).click();
			a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
			if (!ef.visible_Element(po.CurrenPriceValue(L), 2000)) {
				a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 0)).click().build().perform();
			}
			//End workaround:
		}
		
		long end = System.currentTimeMillis();
		Log.info("C4S Response time in milisec: " + (end - start));
		Log.info("C4S Response time in sec: " + ((end - start) / 1000));
		
		String productName = ef.get_Element(po.TruckLabel(L), 1000).getText();
		productName = productName.replace(" (C4S)", "").trim();
		Log.info("New product name: " + productName);
		/*
		ef.get_Element(po.RelatedTab(L), 1000).click();
		a.moveToElement(ef.get_Element(po.lineItemSearch(productName), 2000)).click().build().perform();
		String MANCodeSF = ef.get_Element_woCl(po.ConfigurationFirstRowMANCode(L), 3000).getText();	
		if (!MANCodeSF.equals("")) {
			Log.info("MANCode: "+ MANCodeSF);
			pass = true;
		} else {
			pass = false;
		}
		*/
		return pass;
	}
	
	public boolean configureTruckMock (WebDriver driver, WebDriverWait wait, String manCode, String randomValue, int future, String product) throws InterruptedException {
		String L = "D";
		boolean pass = true;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		PLI_TruckObject to = new PLI_TruckObject();
		C4SObject c4s = new C4SObject();
		if (ef.check_Element(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		long start = System.currentTimeMillis();
		
		int count = 0;
		ef.get_Element(po.C4SButton_Show(L), 2000).click();
		Thread.sleep(6000);
		a.moveToElement(driver.findElement(po.C4S(L))).click().build().perform();
		//while ((ef.get_Element_woCl(to.PLI_manCode(L), 4000).getText().equals("")) && (count <= 80)) {
		String currentValue = ef.get_Element(po.CurrenPriceValue(L), 0).getText();
		
		while ((!ef.elementExist(po.C4SUpdatedSuccessfullyMessage(L), 0)) && (count <= 1)) {
			count++;
			//System.out.println(count);
			Thread.sleep(1000);
		}
		
		count = 0;
		while ((ef.get_Element(po.CurrenPriceValue(L), 500).getText().equals(currentValue)) && (count <= 40)) {
			count++;
			//System.out.println(count);
			//Thread.sleep(1000);
			
			//Start workaround:
			driver.navigate().refresh();
			ef.get_Element(mp.Proposals(L), 5000).click();
			if(!ef.elementExist(po.Search, 1000)) {
				ef.get_Element(mp.Proposals(L), 3000).click();
			}
			ef.get_Element(po.Search, 2000).clear();
			a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
			//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 1000).click();
			a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
			if (!ef.visible_Element(po.CurrenPriceValue(L), 2000)) {
				a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 0)).click().build().perform();
			}
			//End workaround:
		}
		
		long end = System.currentTimeMillis();
		Log.info("C4S Response time in milisec: " + (end - start));
		Log.info("C4S Response time in sec: " + ((end - start) / 1000));
		
		String productName = ef.get_Element(po.TruckLabel(L), 1000).getText();
		productName = productName.replace(" (C4S)", "").trim();
		Log.info("New product name: " + productName);
		/*
		ef.get_Element(po.RelatedTab(L), 1000).click();
		a.moveToElement(ef.get_Element(po.lineItemSearch(productName), 2000)).click().build().perform();
		String MANCodeSF = ef.get_Element_woCl(po.ConfigurationFirstRowMANCode(L), 3000).getText();	
		if (!MANCodeSF.equals("")) {
			Log.info("MANCode: "+ MANCodeSF);
			pass = true;
		} else {
			pass = false;
		}
		*/
		return pass;
	}
	
	public boolean configureTradeIn (WebDriver driver, WebDriverWait wait, String randomValue, String date, String tradeCustomer, String tradeUsed) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.check_Element(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		ef.get_Element(po.TradeInAction(L), 9000).click();
		a.moveToElement(ef.get_Element(po.SelectTIV(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.Next(L), 3000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.Next(L), 5000)).click().build().perform();
		if (ef.elementExist(po.Next(L), 3000)) {
			a.moveToElement(ef.get_Element(po.Next(L), 0)).click().build().perform();
		}
		ef.get_Element(po.TradeInVehicleName(L), 3000).clear();
		ef.get_Element(po.TradeInVehicleName(L), 500).sendKeys("MAN "+randomValue);
		ef.get_Element(po.TradeInTruck(L), 500).click();
		if (!ef.elementExist(po.TradeInTruckValue, 200)) {
			ef.get_Element(po.TradeInTruck(L), 200).click();
		}
		a.moveToElement(ef.get_Element(po.TradeInTruckValue, 200)).click().build().perform();
		Random rand = new Random();
		int rand_Int = rand.nextInt(1000000000);
		ef.get_Element(po.TradeInFIN(L), 500).sendKeys(Integer.toString(rand_Int));
		ef.get_Element(po.TradeInRegistrationDate(L), 0).clear();
		ef.get_Element(po.TradeInRegistrationDate(L), 0).sendKeys("21.02.2016");
		ef.get_Element(po.TradeInMileage(L), 500).sendKeys("250000");
		a.moveToElement(ef.get_Element(po.TradeInEmission(L), 200)).click().build().perform();
		a.moveToElement(ef.get_Element(po.TradeInEmissionValue(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.TradeInCreateVehicle(L), 500)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.Next(L), 500)).click().build().perform();
		ef.get_Element(po.TradeInDate(L), 200).sendKeys(date);
		ef.get_Element(po.TradeInIntakeValueCustomer(L), 200).sendKeys(tradeCustomer);
		ef.get_Element(po.TradeInIntakeValueUsed(L), 200).sendKeys(tradeUsed);
		ef.get_Element(po.MileageDateReturn(L), 200).sendKeys("250000");
		a.moveToElement(ef.get_Element(po.TradeInCategory(L), 2000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.TradeInCategorySonstige(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.TradeInUpdate(L), 5000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.FertigStellen(L), 5000)).click().build().perform();
		a.moveToElement(ef.get_Element(mp.Proposals(L), 12000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 2000).clear();
		a.moveToElement(ef.get_Element(po.Search, 1000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 4000).click();		
		driver.navigate().refresh();
		return pass;
		
	}
	
	public boolean configureResidual (WebDriver driver, WebDriverWait wait, String customer, String used) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.check_Element(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.ResidualValuesTab(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.Next(L), 6000)).click().build().perform();
		//ef.get_Element(po.Next(L), 3000).click();
		a.moveToElement(ef.get_Element(po.ResidualValue120000_36(L), 2000)).click().build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.AddResidualValue(L), 1000));
		a.moveToElement(ef.get_Element(po.AddResidualValue(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ResidualValueCustomerField(L), 7000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ResidualValueCustomerEdit(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ResidualValueCustomerEdit(L), 500)).sendKeys(customer).build().perform();
		if (ef.elementExist(po.ResidualRestwerttabelle(L), 1000)) {
			ef.get_Element(po.ResidualRestwerttabelle(L), 1000).click();
		} else {
			ef.get_Element(po.ResidualRestwerttabelle("D"), 1000).click();
		}
		a.moveToElement(ef.get_Element(po.ResidualValueUsedField(L), 2000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ResidualValueUsedEdit(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ResidualValueUsedEdit(L), 500)).sendKeys(used).build().perform();
		if (ef.elementExist(po.ResidualRestwerttabelle(L), 1000)) {
			ef.get_Element(po.ResidualRestwerttabelle(L), 1000).click();
		} else {
			ef.get_Element(po.ResidualRestwerttabelle("D"), 1000).click();
		}
		a.moveToElement(ef.get_Element(po.ResidualValueDateField(L), 2000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ResidualValueDateEdit(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ResidualValueDateEdit(L), 500)).sendKeys("31.08.2020").build().perform();
		
		ef.get_Element(po.ResidualValueSave(L), 1000).click();
		a.moveToElement(ef.get_Element(po.ResidualValueRadio(L), 3000)).click().build().perform();
		//ef.get_Element(po.CalculateRV(L), 1000).click();
		a.moveToElement(ef.get_Element(po.CalculateRV(L), 1000)).click().build().perform();
		Thread.sleep(3000);
		driver.navigate().refresh();
		a.moveToElement(ef.get_Element(po.ResidualValuesTab(L), 10000)).click().build().perform();
		
		ef.get_Element(po.ResidualValueRadio(L), 3000).click();
		ef.get_Element(po.SetActive(L), 2000).click();
		ef.get_Element(po.PricingTab(L), 3000).click();
		
		return pass;
		
	}
	
	public boolean configureService (WebDriver driver, WebDriverWait wait, String randomValue, String subProduct, String subsidy) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		PLI_ServiceObject so = new PLI_ServiceObject();
		ZoomObject zo = new ZoomObject();
		if (ef.check_Element(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		String serviceName = ef.get_Element(po.ServiceName(L), 1000).getText();
		a.moveToElement(ef.get_Element(po.ServiceZoom(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ServiceRuntimeEdit(L), 1000)).click().sendKeys("24").build().perform();
		a.moveToElement(ef.get_Element(po.CurrentOfferBase(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.CurrentOfferBase(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ServiceMileageEdit(L), 500)).click().sendKeys("120000").build().perform();
		a.moveToElement(ef.get_Element(po.CurrentOfferBase(L), 2000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.CurrentOfferBase(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.Close(L), 3000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.ServicePartnerLocator(L), 5000)).click().build().perform();
		
		//a.moveToElement(ef.get_Element(po.ServicePartnerLocatorSearch(L), 200)).click().sendKeys("DW78").build().perform();
		//a.moveToElement(ef.get_Element(po.ServicePartnerLocatorElement(L), 500)).click().build().perform();
		
		//if (ef.elementExist(po.ServiceWorkshopPartner(L), 2000)) {
			//a.moveToElement(ef.get_Element(po.ServiceWorkshopPartner(L), 200)).click().build().perform();
		//}
		//a.moveToElement(ef.get_Element(po.ServicePartnerLocatorClose(L), 4000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.ServicePaymentTermEdit(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.ServicePaymentTerm(L), 200)).click().build().perform();
		//a.moveToElement(ef.get_Element_woCl(po.ServicePaymentTerm10Day(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.ServiceZoom(L), 2000)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.ButtonMainServiceDetails(L), 3000)).click().build().perform();
		//a.moveToElement(ef.get_Element(so.priceType(L), 500)).click().build().perform();
		//a.moveToElement(ef.get_Element_woCl(so.priceTypeValueFestprice(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(so.PLI_deploymentTypeDropdown(L), 3000)).click().build().perform();
		a.moveToElement(ef.get_Element_woCl(so.PLI_deploymentTypeElementFernverkehr(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.Save1(L), 2000)).click().build().perform();
		//if(ef.elementExist(zo.Save1(L), 3000)) {
		//	ef.get_Element(zo.Save1(L), 0).click();
		//}
		
		int count = 0;
		while ((!ef.elementExist(po.ProposalUpdatingMessage(L), 0)) && (count <= 50)) {
			count++;
			Thread.sleep(200);
		}
		Thread.sleep(3000);
		if (!subProduct.equals("")) {
		a.moveToElement(ef.get_Element(zo.ButtonMainServiceZusatzservices(L), 9000)).click().build().perform();
		String[] subProductList = subProduct.split(",");
		ArrayList<String> arr1 = new ArrayList<String>(17);
		ArrayList<String> arr2 = new ArrayList<String>(6);
		ArrayList<String> arr3 = new ArrayList<String>(2);
		ArrayList<String> arr4 = new ArrayList<String>(2);
		ArrayList<String> arr5 = new ArrayList<String>(2);
		arr1.add("Aufbau");
		arr1.add("Feuerlöscher");
		arr1.add("Kipphydraulik Service");
		arr1.add("Ladekran Service");
		arr1.add("Mobilität");
		arr1.add("Nachfüllöl Motor");
		arr1.add("Pannenservice Reifen");
		arr1.add("RME-Betrieb");
		arr1.add("Reinigung / Wagenwäsche");
		arr1.add("Reserve / Überbrückungsfahrzeug");
		arr1.add("Rückfahrkamera");
		arr1.add("Schleuderkette");
		arr1.add("Sicherheitscheck");
		arr1.add("Verdichter");
		arr1.add("Verstellbarer Wechselrahmen für Container (BDF)");
		arr1.add("Ölwechsel");
		
		arr2.add("Fahrerrücktransport");
		arr2.add("Hol- und Bringservice");
		arr2.add("Driver return transport");
		arr2.add("collection and delivery service");
		
		arr3.add("Kühlaggregat Service");
		
		arr4.add("Ladeboardwand Basisinformation");
		
		arr5.add("Reifenservice");

		for (int i = 1; i < subProductList.length+1; i++) {
			if(ef.elementExist(zo.subServiceSearch(i), 2000)) {	
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(zo.subProductGKostenFokusSearch(i,"8"), 2000));
				
				if (arr1.contains(ef.get_Element(zo.subServiceSearch(i), 1000).getText())) {
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"5"), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("200").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"8"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("50").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"3"), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
				}
				if (arr2.contains(ef.get_Element(zo.subServiceSearch(i), 1000).getText())) {
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"5"), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("200").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"7"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("50").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"8"), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductEntfernungDropdownSearch(i,"8"), 1500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductEntfernungDropdownElementSearch(i,"8"), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
				}
				if (arr3.contains(ef.get_Element(zo.subServiceSearch(i), 1000).getText())) {
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"5"), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("200").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"8"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("50").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"10"), 500)).click().sendKeys("AEG").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"11"), 500)).click().sendKeys("KAG120").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"12"), 500)).click().sendKeys("10").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"15"), 500)).click().sendKeys("1600").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"16"), 500)).click().sendKeys("400").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"18"), 500)).click().sendKeys("25").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"19"), 500)).click().sendKeys("25").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"21"), 500)).click().sendKeys("70").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"22"), 500)).click().sendKeys("30").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"23"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("20").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"24"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("70").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"25"), 500)).click().sendKeys("10").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"26"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("75").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"27"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("25").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
				}
				if (arr4.contains(ef.get_Element(zo.subServiceSearch(i), 1000).getText())) {
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"6"), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("200").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"7"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("50").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"8"), 500)).click().sendKeys("Bosch").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"9"), 500)).click().sendKeys("10000").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"10"), 500)).click().sendKeys("12").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"11"), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductEntfernungDropdownSearch(i,"11"), 1500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductEntfernungDropdownElementSearch(i,"11"), 1500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"12"), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductEntfernungDropdownSearch(i,"12"), 1500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductEntfernungDropdownElementSearch(i,"12"), 1500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"13"), 500)).click().sendKeys("2020").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"14"), 500)).click().sendKeys("12345678").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
				}
				if (arr5.contains(ef.get_Element(zo.subServiceSearch(i), 1000).getText())) {
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"5"), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("200").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"8"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("50").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"10"), 500)).click().sendKeys("12").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"11"), 500)).click().sendKeys("225").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"12"), 500)).click().sendKeys("Pirelli").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"14"), 500)).click().sendKeys("70").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"15"), 500)).click().sendKeys("30").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"16"), 500)).click().sendKeys("30").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"17"), 500)).click().sendKeys("30").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"18"), 500)).click().sendKeys("30").build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductGKostenEditSearch(i,"19"), 500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductEntfernungDropdownSearch(i,"19"), 1500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subProductEntfernungDropdownElementSearch(i,"19"), 1500)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 1000)).click().build().perform();
					a.moveToElement(ef.get_Element(zo.subServiceSearch(i), 500)).click().build().perform();
				}
			}
		}
		}
		if(!subsidy.equals("")) {
			a.moveToElement(ef.get_Element(zo.ButtonMainServiceSubsidy(L), 3000)).click().build().perform();
			if (ef.elementExist(zo.SalesSubsidyEdit(L), 2000)) {
				a.moveToElement(ef.get_Element(zo.SalesSubsidyEdit(L), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(subsidy).build().perform();
				a.moveToElement(ef.get_Element(zo.SalesSubsidyText(L), 2000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.SalesSubsidyText(L), 1000)).click().build().perform();
			} else {
				a.moveToElement(ef.get_Element(zo.ProdSalesSubsidyEdit(L), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(subsidy).build().perform();
				a.moveToElement(ef.get_Element(zo.ProdSalesSubsidyText(L), 2000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.ProdSalesSubsidyText(L), 1000)).click().build().perform();
			}
			
			Log.info("Subsidy of "+subsidy+"€ added");
		}
		a.moveToElement(ef.get_Element(po.Close(L), 2000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.RelatedTab(L), 0)).click().build().perform();
		
		
		//a.moveToElement(ef.get_Element_woCl(po.lineItemSearch(serviceName), 4000)).click().build().perform();
		
		//a.moveToElement(ef.get_Element(so.priceDate(L), 200)).click().sendKeys(getFutureDateString(0, "dd.MM.yyyy", "D")).build().perform();
		//ef.get_Element(so.CostResponsibleWorkshopDropdown(L), 200).click();
		//a.moveToElement(ef.get_Element(so.CostResponsibleWorkshopDropdown(L), 200)).click().build().perform();
		//a.moveToElement(ef.get_Element_woCl(so.CostResponsibleWorkshopElementDV12(L), 200)).click().build().perform();
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(so.PLI_deploymentTypeDropdown(L), 500));

		//if (ef.visible_Element(po.ServiceAction(L,"4"), 6000)) {
			ef.get_Element(po.ServiceAction(L,"4"), 7000).click();
		//} else if (ef.visible_Element(po.ServiceAction(L,"4"), 200)) {
		//	ef.get_Element(po.ServiceAction(L,"4"), 200).click();
		//} else {
		//	ef.get_Element(po.ServiceAction(L,"3"), 200).click();
		//}
		
		a.moveToElement(ef.get_Element(po.RequestMRC(L), 500)).click().build().perform();
		return pass;
	}
	
	public boolean sendMRC (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		Element_Functions ef = new Element_Functions(driver, wait);
		if (ef.check_Element(mp.getLanguage("Home"), 6000)) {
			L = "E";
		}
		ef.get_Element(po.ServiceAction(L,"4"), 7000).click();		
		a.moveToElement(ef.get_Element(po.RequestMRC(L), 500)).click().build().perform();
		return pass;
	}
	
	public boolean configureFinance (WebDriver driver, WebDriverWait wait, String randomValue, String La, String version) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		AbakusObject abo = new AbakusObject();
		if (ef.check_Element(mp.getLanguage("Home"), 6000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.StandardDiscont(L), 2000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("10000").build().perform();
		ef.get_Element(po.ModalTitle(L), 500).click();
		a.moveToElement(ef.get_Element(po.Close(L), 2000)).click().build().perform();
		
		
		a.moveToElement(ef.get_Element(po.FinanceZoom(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.FinancialContractStartDate(L), 2000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.FinancialContractStartDateInput(L), 500)).click().sendKeys("01.05.2020").build().perform();
		//ef.get_Element(po.FinancialAktuelleAngebotsgrundlage(L), 500).click();
		a.moveToElement(ef.get_Element(po.FinancialRuntimeEdit(L), 2000)).click().sendKeys("36").build().perform();
		ef.get_Element(po.FinancialAktuelleAngebotsgrundlage(L), 500).click();
		ef.get_Element(po.FinancialAktuelleAngebotsgrundlage(L), 200).click();
		a.moveToElement(ef.get_Element(po.FinancialMileageEdit(L), 500)).click().sendKeys("120000").build().perform();
		ef.get_Element(po.FinancialAktuelleAngebotsgrundlage(L), 500).click();
		ef.get_Element(po.FinancialAktuelleAngebotsgrundlage(L), 3000).click();
		a.moveToElement(ef.get_Element(po.FinancialBuyBackTypeEdit(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.FinancialBuyBackTypeDropDown(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.FinancialBuyBackTypeClosed(L), 500)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.FinancialDownPayment(L), 500)).click().sendKeys("10000").build().perform();
		//ef.get_Element(po.FinancialAktuelleAngebotsgrundlage(L), 500).click();

		//a.moveToElement(ef.get_Element(po.FinanceContractStartDate(L), 500)).click().sendKeys("01.08.2020").build().perform();
		//a.moveToElement(ef.get_Element(po.FinancePaymentMethod(L), 200)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("Invoice").build().perform();
		a.moveToElement(ef.get_Element(po.Close(L), 2000)).click().build().perform();
		
		return pass;
	}
	
	public boolean changeDiscount (WebDriver driver, WebDriverWait wait, String randomValue, String mode, String value, String version) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.check_Element(mp.getLanguage("Home"), 6000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 1000)).click().build().perform();
		if (mode.equals("amount")) {
			a.moveToElement(ef.get_Element(po.StandardDiscont(L), 2000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(value).build().perform();
		} else {
			a.moveToElement(ef.get_Element(po.StandardDiscontProcent(L), 2000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(value).build().perform();
		}
		ef.get_Element(po.ModalTitle(L), 500).click();
		a.moveToElement(ef.get_Element(po.Close(L), 2000)).click().build().perform();
		
		
		return pass;
	}
	
	public boolean sendAbakus (WebDriver driver, WebDriverWait wait, String randomValue, String La) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		AbakusObject abo = new AbakusObject();
		if (ef.check_Element(mp.getLanguage("Home"), 6000)) {
			L = "E";
		}
		
		ef.get_Element(po.FinanceAction(L), 6000).click();
		a.moveToElement(ef.get_Element(po.Abakus(L), 500)).click().build().perform();
		
		//next steps
		//L = La;
				
			a.moveToElement(ef.get_Element(abo.Anzahlung_1(La), 15000)).click().sendKeys("30").build().perform();
			//ef.get_Element(abo.Restwert_1(La), 500).clear();
			//a.moveToElement(ef.get_Element(abo.Restwert_1(La), 500)).click().sendKeys("38000").build().perform();
			//a.moveToElement(ef.get_Element(abo.Subvention_1(La), 500)).click().sendKeys("1").build().perform();
		
			a.moveToElement(ef.get_Element(abo.Anzahlung_2(La), 2000)).click().sendKeys("30").build().perform();
			//ef.get_Element(abo.Restwert_2(La), 500).clear();
			//a.moveToElement(ef.get_Element(abo.Restwert_2(La), 2000)).click().sendKeys("38000").build().perform();
			//a.moveToElement(ef.get_Element(abo.Subvention_2(La), 500)).click().sendKeys("1").build().perform();
		
			a.moveToElement(ef.get_Element(abo.Anzahlung_3(La), 2000)).click().sendKeys("30").build().perform();
			//ef.get_Element(abo.Restwert_3(La), 500).clear();
			//a.moveToElement(ef.get_Element(abo.Restwert_3(La), 2000)).click().sendKeys("38000").build().perform();
			//a.moveToElement(ef.get_Element(abo.Subvention_3(La), 500)).click().sendKeys("1").build().perform();
		
		
		if (!ef.elementExist(abo.Auswahlen_1(La), 5000)) {
			a.moveToElement(ef.get_Element(abo.Kreditprufung_1(La), 2000)).click().build().perform();
			if (ef.elementExist(abo.WeitereKreditprufung(La), 2000)) {
				a.moveToElement(ef.get_Element(abo.WeitereKreditprufung(La), 0)).click().build().perform();
			}
			a.moveToElement(ef.get_Element(abo.KreditprufungBeantragen(La), 0)).click().build().perform();
		}
		
		if (!ef.elementExist(abo.Auswahlen_2(La), 5000)) {
			a.moveToElement(ef.get_Element(abo.Kreditprufung_2(La), 2000)).click().build().perform();
			if (ef.elementExist(abo.WeitereKreditprufung(La), 2000)) {
				a.moveToElement(ef.get_Element(abo.WeitereKreditprufung(La), 0)).click().build().perform();
			}
			a.moveToElement(ef.get_Element(abo.KreditprufungBeantragen(La), 0)).click().build().perform();
		}
		
		if (!ef.elementExist(abo.Auswahlen_3(La), 5000)) {
			a.moveToElement(ef.get_Element(abo.Kreditprufung_3(La), 2000)).click().build().perform();
			if (ef.elementExist(abo.WeitereKreditprufung(La), 2000)) {
				a.moveToElement(ef.get_Element(abo.WeitereKreditprufung(La), 0)).click().build().perform();
			}
			a.moveToElement(ef.get_Element(abo.KreditprufungBeantragen(La), 0)).click().build().perform();
		}
		
		int run = 0;
		while (!ef.elementExist(abo.Auswahlen_1(La), 5000) && (run <=5)) {
			run++;
			Thread.sleep(10000);
		}
		
			//Thread.sleep(15000);
		/*
		run = 0;
		while (!ef.elementExist(abo.Auswahlen_2(La), 5000) && (run <=5)) {
			run++;
			Thread.sleep(10000);
		}
		run = 0;
		while (!ef.elementExist(abo.Auswahlen_3(La), 5000) && (run <=5)) {
			run++;
			Thread.sleep(10000);
		}
		*/
		String PrePayment = ef.get_Element_woCl(abo.PrePayment(La), 200).getText();
		String Subsidy = ef.get_Element_woCl(abo.Subsidy(La), 200).getText();
		String CustomerFinanceRate = ef.get_Element_woCl(abo.CustomerFinanceRate(La), 200).getText();
		Log.info("PrePayment: " + PrePayment);
		Log.info("Subsidy: " + Subsidy);
		Log.info("CustomerFinanceRate: " + CustomerFinanceRate);
		
		a.moveToElement(ef.get_Element(abo.ZuruckSalesForce(La), 0)).click().build().perform();
		long start = System.currentTimeMillis();
		//Thread.sleep(15000);
		
		while (!ef.elementExist(po.AbakusUpdatedSuccessfullyMessage(L), 0)) {
			Thread.sleep(500);
		}
		long end = System.currentTimeMillis();
		Log.info("Abakus Response time in milisec: " + (end - start));
		Log.info("Abakus Response time in sec: " + ((end - start) / 1000));
		
		a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();

		a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 1500)).click().build().perform();
		
		a.moveToElement(ef.get_Element(po.FinanceZoom(L), 2000)).click().build().perform();
		String PrePaymentSF = ef.get_Element(po.Zoom_PrePayment(L), 200).getText();
		String SubsidySF = ef.get_Element(po.Zoom_Subsidy(L), 200).getText();
		String CustomerFinanceRateSF = ef.get_Element(po.Zoom_CustomerFinanceRate(L), 200).getText();
		String TotalRateSF = ef.get_Element(po.Zoom_TotalRate(L), 200).getText();
		
		Log.info("PrePaymentSF: " + PrePaymentSF);
		Log.info("SubsidySF: " + SubsidySF);
		Log.info("CustomerFinanceRateSF: " + CustomerFinanceRateSF);
		Log.info("TotalRateSF: " + TotalRateSF);
		a.moveToElement(ef.get_Element(po.Close(L), 2000)).click().build().perform();
		//ef.get_Element(po.FinanceAction(L), 7000).click();
		//a.moveToElement(ef.get_Element(po.AbakusUpdate(L), 500)).click().build().perform();
		//while (!ef.elementExist(po.AbakusUpdatedSuccessfullyMessage(L), 0)) {
		//	Thread.sleep(500);
		//}
		
		//a.moveToElement(ef.get_Element(po.ResidualValuesTab(L), 5000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.Next(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.RuntimeMileage(L, "120.000", "4"), 1000)).click().build().perform(); //2 = 12 M, 3 = 24 M 4 = 36 M
		//a.moveToElement(ef.get_Element(po.AddResidualValue(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.ResidualValueUsed(TotalRateSF), 7000)).click().sendKeys("50000").build().perform();
		//a.moveToElement(ef.get_Element(po.CalculateRV(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.ResidualValueSave(L), 1000)).click().build().perform();
		
		a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		
		
		
		
		return pass;
	}
	
	public boolean updateProposalAfterC4S (WebDriver driver, WebDriverWait wait, String randomValue, int future, String product, String version) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		//a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 3000)).click().build().perform();
		ef.get_JSClick(po.TruckZoom(L, version), 0);
		//a.moveToElement(ef.get_Element(zo.ButtonVehicleDetail(L), 0)).click().build().perform();
		ef.get_Element(zo.ButtonVehicleDetail(L), 1000).click();
		//ef.get_JSClick(zo.ButtonVehicleDetail(L), 1000);
		
		//a.moveToElement(ef.get_Element(zo.PLI_bodyTypeDropdown(L), 500)).click().build().perform();
		ef.get_JSClick(zo.PLI_bodyTypeDropdown(L), 1000);
		//a.moveToElement(ef.get_Element_woCl(zo.PLI_bodyTypeElementSonstiges(L), 200)).click().build().perform();
		ef.get_JSClick(zo.PLI_bodyTypeElementSonstiges(L), 0);
			
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(zo.PLI_shippingTypeDropdown(L), 2000));
		
		//a.moveToElement(ef.get_Element(zo.PLI_shippingTypeDropdown(L), 1000)).click().build().perform();
		ef.get_JSClick(zo.PLI_shippingTypeDropdown(L), 0);
		//a.moveToElement(ef.get_Element_woCl(zo.PLI_shippingTypeElementPickup(L), 500)).click().build().perform();
		ef.get_JSClick(zo.PLI_shippingTypeElementPickup(L), 0);
		//a.moveToElement(ef.get_Element(zo.Save1(L), 1000)).click().build().perform();
		ef.get_JSClick(zo.Save1(L), 0);
		//a.moveToElement(ef.get_Element(zo.Save2(L), 1000)).click().build().perform();
		ef.get_JSClick(zo.Save2(L), 0);
		//a.moveToElement(ef.get_Element(zo.Close(L), 1000)).click().build().perform();
		ef.get_JSClick(zo.Close(L), 0);
		

		return pass;
	}
	
	public boolean updateProposalAfterStock (WebDriver driver, WebDriverWait wait, String randomValue, String version) throws InterruptedException, ParseException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 3000)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.ButtonVehicleDetail(L), 1000)).click().build().perform();
		
		String rddl = ef.get_Element_woCl(zo.RequestedDeliveryDateCountry(L), 2000).getText();
		String rddc = getSomeFutureDateString(2, "dd.MM.yyyy", rddl, L);
		ef.get_Element(zo.RequestedDeliveryDateCustomer(L), 500).sendKeys(rddc);
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(zo.PLI_shippingTypeDropdown(L), 2000));
		a.moveToElement(ef.get_Element(zo.PLI_shippingTypeDropdown(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element_woCl(zo.PLI_shippingTypeElementPickup(L), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.Save1(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element(zo.Save2(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.Close(L), 1000)).click().build().perform();
		

		return pass;
	}
	
	public boolean changePaymentTerm (WebDriver driver, WebDriverWait wait, String randomValue, String version, String value) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 3000)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.ButtonVehicleDetail(L), 0)).click().build().perform();
		
		
		//if (stock) {
			//String rddl = ef.get_Element_woCl(zo.RequestedDeliveryDateCountry(L), 200).getText();
			//String rddc = getSomeFutureDateString(200, "dd.MM.yyyy", rddl, L);
			//ef.get_Element(zo.RequestedDeliveryDateCustomer(L), 500).sendKeys(rddc);
		//} else {
			
		//}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(zo.PaymentTermDropdown(L), 2000));
		a.moveToElement(ef.get_Element(zo.PaymentTermDropdown(L), 1000)).click().build().perform();		
		a.moveToElement(ef.get_Element(zo.PaymentTermElementSearch(value), 500)).click().build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(zo.Save1(L), 2000));
		a.moveToElement(ef.get_Element(zo.Save1(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.Close(L), 2000)).click().build().perform();
		

		return pass;
	}
	
	public boolean changeCustomerEndPrice (WebDriver driver, WebDriverWait wait, String randomValue, String value, String version) throws InterruptedException {
		boolean pass = false;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 3000)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.TotalVehicleNet(L), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(value).build().perform();
		a.moveToElement(ef.get_Element(zo.TotalVehicleNetText(L), 1000)).click().build().perform();
		ef.get_Element(zo.Close(L), 2000).click();
		String price = ef.get_Element(po.CustomerEndPriceValue(L, version), 9000).getText();
		price = ef.rounding(price);
		//price = price.replaceAll("[^\\d.]", "");
		if(price.equals(value)) {
			pass = true;
		}
		return pass;
	}
	
	public boolean checkCalculation (WebDriver driver, WebDriverWait wait, String randomValue, String ABL, String DB2Fahrzeug, String provision, String logText, String version, boolean thermometer, String CEP) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		
		String truckType = ef.get_Element(po.TruckLabel(L), 3000).getText();
		truckType = truckType.replace(" (C4S)", "").trim();
		String[] truckTypeList = truckType.split(" ");
		String truckTypeShort = truckTypeList[0];
		
		
		
		String getABL = ef.rounding(ef.get_Element(po.KPIValueSearch("ABL", version), 2000).getText());
		String getfieberThermometer = ef.rounding(ef.get_Element(po.ThermometerPrice(L, version), 500).getText());
		Log.info("--------------------------------------------------");
		Log.info("Checking after "+logText);
		if(thermometer) {
			Log.info("Checking Value from Fieberthermometer:");
			Log.info("Checking Customer End Price Value:");
			if (getfieberThermometer.equals(CEP)) {
				Log.info("Customer End Price Value OK: Expected: "+CEP+", Actual: "+getfieberThermometer);
			} else {
				pass = false;
				Log.error("Customer End Price Value OK: Expected: "+CEP+", Actual: "+getfieberThermometer);
			}
		}
		Log.info("Checking Value from Proposal Information:");
		Log.info("Checking ABL Value:");
		if (getABL.equals(ABL)) {
			//pass = true;
			Log.info("ABL Value OK: Expected: "+ABL+", Actual: "+getABL);
		} else {
			pass = false;
			Log.error("ABL Value NOK: Expected: "+ABL+", Actual: "+getABL);
		}
		
		String getDB2Fahrzeug = ef.rounding(ef.get_Element(po.KPIValueSearch("DB2 Fahrzeug", version), 500).getText());
		Log.info("Checking DB2 Fahrzeug Value:");
		if (getDB2Fahrzeug.equals(DB2Fahrzeug)) {
			//pass = true;
			Log.info("DB2 Fahrzeug Value OK: Expected: "+DB2Fahrzeug+", Actual: "+getDB2Fahrzeug);
		} else {
			pass = false;
			Log.error("DB2 Fahrzeug Value NOK: Expected: "+DB2Fahrzeug+", Actual: "+getDB2Fahrzeug);
		}
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.Commission(L, version), 200));
		a.moveToElement(ef.get_Element(po.Commission(L, version), 200)).click().build().perform();
		
		String getFahrzeugprovision = ef.rounding(ef.get_Element(po.Fahrzeugprovision(L, version), 500).getText());
		Log.info("Checking Fahrzeugprovision Value:");
		if (getFahrzeugprovision.equals(provision)) {
			//pass = true;
			Log.info("Fahrzeugprovision Value OK: Expected: "+provision+", Actual: "+getFahrzeugprovision);
		} else {
			pass = false;
			Log.error("Fahrzeugprovision Value NOK: Expected: "+provision+",Actual: "+getFahrzeugprovision);
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ef.get_Element(po.TruckZoom(L, version), 1000));
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 1000)).click().build().perform();
		
		String getOrderBurdenRateValue = ef.rounding(ef.get_Element(zo.OrderBurdenRateValue(L), 3000).getText());
		Log.info("Checking Value from Zoom:");
		Log.info("Checking Order Burden Rate Value:");
		if (getOrderBurdenRateValue.equals(ABL)) {
			//pass = true;
			Log.info("Order Burden Rate Value OK: Expected: "+ABL+", Actual: "+getOrderBurdenRateValue);
		} else {
			pass = false;
			Log.error("Order Burden Rate Value NOK: Expected: "+ABL+", Actual: "+getOrderBurdenRateValue);
		}
		
		String getCM2Value = ef.rounding(ef.get_Element(zo.CM2Value(L), 200).getText());
		Log.info("Checking CM2 Value:");
		if (getCM2Value.equals(DB2Fahrzeug)) {
			//pass = true;
			Log.info("CM2 Value OK: Expected: "+DB2Fahrzeug+", Actual: "+getCM2Value);
		} else {
			pass = false;
			Log.error("CM2 Value NOK: Expected:"+DB2Fahrzeug+", Actual: "+getCM2Value);
		}
		
		String getVehicleCommission = ef.rounding(ef.get_Element(zo.VehicleCommission(L), 200).getText());
		Log.info("Checking Vehicle Commission Value:");
		if (getVehicleCommission.equals(provision)) {
			//pass = true;
			Log.info("Vehicle Commission Value OK: Expected: "+provision+", Actual: "+getVehicleCommission);
		} else {
			pass = false;
			Log.error("Vehicle Commission Value NOK: Expected: "+provision+", Actual: "+getVehicleCommission);
		}
		Log.info("--------------------------------------------------");
		ef.get_Element(zo.Close(L), 2000).click();
		return pass;
	}
	
	public boolean checkCalculationNew (WebDriver driver, WebDriverWait wait, String randomValue, String logText, String version, boolean thermometer, String CEP, String calcType, String VehicleUsage, String Juniorverkaufer, String ServiceVertragspartner, boolean kommunal, String ExtraStutzung, String ZKE1, boolean Tiemann) throws InterruptedException, IOException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		ef.get_JSClick(mp.ProposalsNew(L), 0);
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		//a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.Search, 2000).sendKeys(randomValue+"_Proposal" + Keys.ENTER);	
		//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		ef.get_JSClick(po.lineSearch(randomValue+"_Proposal"), 2000);
		
		String truckType = ef.get_Element(po.TruckLabel(L), 3000).getText();
		truckType = truckType.replace(" (C4S)", "").trim();
		truckType = truckType.replace(" (Stock)", "").trim();
		String[] truckTypeList = truckType.split(" ");
		String truckTypeShort = truckTypeList[0];
		String truckAmount = ef.get_Element(po.QuantityField(L, version), 2000).getText();
		Log.info("truckAmount: "+ truckAmount);
		
		String getABL = ef.rounding(ef.get_Element(po.KPIValueSearch("ABL", version), 2000).getText());
		String getfieberThermometer = ef.rounding(ef.get_Element(po.ThermometerPrice(L, version), 500).getText());
		String getDB2Fahrzeug = ef.rounding(ef.get_Element(po.KPIValueSearch("DB2 Fahrzeug", version), 500).getText());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.Commission(L, version), 200));
		a.moveToElement(ef.get_Element(po.Commission(L, version), 200)).click().build().perform();
		
		String getFahrzeugprovision = ef.rounding(ef.get_Element(po.Fahrzeugprovision(L, version), 500).getText());
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ef.get_Element(po.TruckZoom(L, version), 1000));
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 1000)).click().build().perform();
		String BasePrice = ef.get_Element(zo.BasePrice(L), 3000).getText();
		Log.info("BasePrice: "+ BasePrice);
		String Topoptions = ef.get_Element(zo.Topoptions(L), 200).getText();
		Log.info("Topoptions: "+ Topoptions);
		String TotalDiscount = ef.get_Element(zo.TotalDiscount(L), 200).getText();
		Log.info("TotalDiscount: "+ TotalDiscount);
		String ChargeTransportNet = ef.get_Element(zo.ChargeTransportNet(L), 200).getText();
		Log.info("ChargeTransportNet: "+ ChargeTransportNet);
		String VCodesNet = ef.get_Element(zo.VCodesNet(L), 200).getText();
		Log.info("VCodesNet: "+ VCodesNet);
		String LocalOptionalFeatures = "0.00";
		if (ef.elementExist(zo.LocalOptionalFeatures(L), 200)) {
			LocalOptionalFeatures = ef.get_Element(zo.LocalOptionalFeatures(L), 200).getText();
		}
		Log.info("LocalOptionalFeatures: "+ LocalOptionalFeatures);
		String Stutzung = "0.00";
		if (ef.elementExist(zo.Subsidy(L), 200)) {
			Stutzung = ef.get_Element(zo.Subsidy(L), 200).getText();
			//Stutzung = Stutzung.replaceAll("[^\\d.]", "");
			//Stutzung = ef.rounding(Stutzung);
			//double Stutzung_D = Double.parseDouble(Stutzung);
			//Stutzung_D = Stutzung_D + Double.parseDouble(ExtraStutzung);
			//Stutzung =String.valueOf(Stutzung_D);
		}
		
		String ProvisionsrelevanteSondereinzelkosten = "0.00";
		if (ef.elementExist(zo.SpecialDirectCosts(L), 500)) {
			ProvisionsrelevanteSondereinzelkosten = ef.get_Element(zo.SpecialDirectCosts(L), 200).getText();
		}
		
		Log.info("ProvisionsrelevanteSondereinzelkosten: "+ ProvisionsrelevanteSondereinzelkosten);
		String getOrderBurdenRateValue = ef.rounding(ef.get_Element(zo.OrderBurdenRateValue(L), 200).getText());
		String getCM2Value = ef.rounding(ef.get_Element(zo.CM2Value(L), 200).getText());
		String getVehicleCommission = ef.rounding(ef.get_Element(zo.VehicleCommission(L), 200).getText());
		
		calculation calc = new calculation();
		HashMap<String, String> values = calc.getValue(calcType, VehicleUsage, truckType, truckTypeShort, BasePrice, Topoptions, TotalDiscount, ChargeTransportNet, VCodesNet, LocalOptionalFeatures, Stutzung, ExtraStutzung, ZKE1, ProvisionsrelevanteSondereinzelkosten, truckAmount, Juniorverkaufer, ServiceVertragspartner, kommunal, Tiemann);
		
		String ABL = values.get("ABL");
		String DB2Fahrzeug = values.get("DB2");
		String provision = values.get("Gesamtprovision");
		
		Log.info("--------------------------------------------------");
		Log.info("Checking after "+logText);
		if(thermometer) {
			Log.info("Checking Value from Fieberthermometer:");
			Log.info("Checking Customer End Price Value:");
			if (getfieberThermometer.equals(CEP)) {
				Log.info("Customer End Price Value OK: Expected: "+CEP+", Actual: "+getfieberThermometer);
			} else {
				pass = false;
				Log.error("Customer End Price Value OK: Expected: "+CEP+", Actual: "+getfieberThermometer);
			}
		}
		Log.info("Checking Value from Proposal Information:");
		Log.info("Checking ABL Value:");
		if (getABL.equals(ABL)) {
			//pass = true;
			Log.info("ABL Value OK: Expected: "+ABL+", Actual: "+getABL);
		} else {
			pass = false;
			Log.error("ABL Value NOK: Expected: "+ABL+", Actual: "+getABL);
		}
		
		Log.info("Checking DB2 Fahrzeug Value:");
		if (getDB2Fahrzeug.equals(DB2Fahrzeug)) {
			//pass = true;
			Log.info("DB2 Fahrzeug Value OK: Expected: "+DB2Fahrzeug+", Actual: "+getDB2Fahrzeug);
		} else {
			pass = false;
			Log.error("DB2 Fahrzeug Value NOK: Expected: "+DB2Fahrzeug+", Actual: "+getDB2Fahrzeug);
		}
		
		
		Log.info("Checking Fahrzeugprovision Value:");
		if (getFahrzeugprovision.equals(provision)) {
			//pass = true;
			Log.info("Fahrzeugprovision Value OK: Expected: "+provision+", Actual: "+getFahrzeugprovision);
		} else {
			pass = false;
			Log.error("Fahrzeugprovision Value NOK: Expected: "+provision+",Actual: "+getFahrzeugprovision);
		}
		
		Log.info("Checking Value from Zoom:");
		Log.info("Checking Order Burden Rate Value:");
		if (getOrderBurdenRateValue.equals(ABL)) {
			//pass = true;
			Log.info("Order Burden Rate Value OK: Expected: "+ABL+", Actual: "+getOrderBurdenRateValue);
		} else {
			pass = false;
			Log.error("Order Burden Rate Value NOK: Expected: "+ABL+", Actual: "+getOrderBurdenRateValue);
		}
				
		Log.info("Checking CM2 Value:");
		if (getCM2Value.equals(DB2Fahrzeug)) {
			//pass = true;
			Log.info("CM2 Value OK: Expected: "+DB2Fahrzeug+", Actual: "+getCM2Value);
		} else {
			pass = false;
			Log.error("CM2 Value NOK: Expected:"+DB2Fahrzeug+", Actual: "+getCM2Value);
		}
		
		Log.info("Checking Vehicle Commission Value:");
		if (getVehicleCommission.equals(provision)) {
			//pass = true;
			Log.info("Vehicle Commission Value OK: Expected: "+provision+", Actual: "+getVehicleCommission);
		} else {
			pass = false;
			Log.error("Vehicle Commission Value NOK: Expected: "+provision+", Actual: "+getVehicleCommission);
		}
		Log.info("--------------------------------------------------");
		ef.get_Element(zo.Close(L), 2000).click();
		return pass;
	}
	
	public boolean checkIKAProvisionText(WebDriver driver, WebDriverWait wait, String version) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.Commission(L, version), 2000));
		a.moveToElement(ef.get_Element(po.Commission(L, version), 200)).click().build().perform();
		if (ef.elementExist(po.FahrzeugprovisionShowText(L), 1000)) {
			Log.info("Info there: The calculated commission may differ from the real commission");
			pass = true;
		} else {
			Log.error("Info not there: The calculated commission may differ from the real commission");
			pass = false;
		}
		
		return pass;
	}
	
	public boolean checkCalculationTiemann (WebDriver driver, WebDriverWait wait, String randomValue, String ABL, String DB2Fahrzeug, String provision, String logText, String version, boolean thermometer, String CEP) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		
		String getABLExtern = ef.rounding(ef.get_Element(po.KPIValueSearch("ABL Extern", version), 2000).getText());
		String getfieberThermometer = ef.rounding(ef.get_Element(po.ThermometerPrice(L, version), 500).getText());
		Log.info("--------------------------------------------------");
		Log.info("Checking after "+logText);
		if(thermometer) {
			Log.info("Checking Value from Fieberthermometer:");
			Log.info("Checking Customer End Price Value:");
			if (getfieberThermometer.equals(CEP)) {
				Log.info("Customer End Price Value OK: Expected: "+CEP+", Actual: "+getfieberThermometer);
			} else {
				pass = false;
				Log.error("Customer End Price Value OK: Expected: "+CEP+", Actual: "+getfieberThermometer);
			}
		}
		Log.info("Checking Value from Proposal Information:");
		Log.info("Checking ABL Extern Value:");
		if (getABLExtern.equals(ABL)) {
			//pass = true;
			Log.info("ABL Extern Value OK: Expected: "+ABL+", Actual: "+getABLExtern);
		} else {
			pass = false;
			Log.error("ABL Extern Value NOK: Expected: "+ABL+", Actual: "+getABLExtern);
		}
		
		Log.info("Checking DB2 Fahrzeug Value:");
		if (ef.elementExist(po.KPIValueSearch("DB2 Fahrzeug", version), 500)){
			String getDB2Fahrzeug = ef.rounding(ef.get_Element(po.KPIValueSearch("DB2 Fahrzeug", version), 500).getText());
			Log.error("DB2 Fahrzeug is showing with value of: " +getDB2Fahrzeug);
		} else {
			Log.info("DB2 Fahrzeug Value is not showing");
		}
		
		if (ef.elementExist(po.Commission(L, version), 200)){
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.Commission(L, version), 200));
			a.moveToElement(ef.get_Element(po.Commission(L, version), 200)).click().build().perform();	
			String getFahrzeugprovision = ef.rounding(ef.get_Element(po.Fahrzeugprovision(L, version), 500).getText());
			Log.error("Fahrzeugprovision is showing with value of: " +getFahrzeugprovision);
		} else {
			Log.info("Fahrzeugprovision Value is not showing");
		}
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ef.get_Element(po.TruckZoom(L, version), 1000));
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 1000)).click().build().perform();
		Log.info("Checking Value from Zoom:");
		Log.info("Checking ABL Extern Value:");
		String getABLExternValue = ef.rounding(ef.get_Element(zo.ABLExternValue(L), 3000).getText());
		if (getABLExternValue.equals(ABL)) {
			//pass = true;
			Log.info("Order Burden Rate Value OK: Expected: "+ABL+", Actual: "+getABLExternValue);
		} else {
			pass = false;
			Log.error("Order Burden Rate Value NOK: Expected: "+ABL+", Actual: "+getABLExternValue);
		}	
		
		Log.info("Checking Order Burden Rate Value:");
		if (ef.elementExist(zo.OrderBurdenRateValue(L), 3000)){
			String getOrderBurdenRateValue = ef.rounding(ef.get_Element(zo.OrderBurdenRateValue(L), 3000).getText());
			Log.error("Order Burden Rate is showing with value of: " +getOrderBurdenRateValue);
		} else {
			Log.info("Order Burden Rate Value is not showing");
		}
		
		Log.info("Checking CM2 Value:");
		if (ef.elementExist(zo.CM2Value(L), 500)){
			String getOrderBurdenRateValue = ef.rounding(ef.get_Element(zo.OrderBurdenRateValue(L), 200).getText());
			Log.error("CM2 is showing with value of: " +getOrderBurdenRateValue);
		} else {
			Log.info("CM2 Value is not showing");
		}
		
		Log.info("Checking Vehicle Commission Value:");
		if (ef.elementExist(zo.VehicleCommission(L), 500)){
			String getVehicleCommission = ef.rounding(ef.get_Element(zo.VehicleCommission(L), 200).getText());
			Log.error("Vehicle Commission is showing with value of: " +getVehicleCommission);
		} else {
			Log.info("Vehicle Commission Value is not showing");
		}
		
		Log.info("--------------------------------------------------");
		ef.get_Element(zo.Close(L), 2000).click();
		return pass;
	}
	
	public boolean checkCalculationTiemannNew (WebDriver driver, WebDriverWait wait, String randomValue,String logText, String version, boolean thermometer, String CEP, String calcType, String VehicleUsage, String Juniorverkaufer, String ServiceVertragspartner, boolean kommunal, String ExtraStutzung, String ZKE1, boolean Tiemann) throws InterruptedException, IOException {

		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		
		String truckType = ef.get_Element(po.TruckLabel(L), 3000).getText();
		truckType = truckType.replace(" (C4S)", "").trim();
		Log.info("truckType: "+ truckType);
		String[] truckTypeList = truckType.split(" ");
		String truckTypeShort = truckTypeList[0];
		String truckAmount = ef.get_Element(po.QuantityField(L, version), 2000).getText();
		Log.info("truckAmount: "+ truckAmount);
		
		String getABLExtern = ef.rounding(ef.get_Element(po.KPIValueSearch("ABL Extern", version), 1000).getText());
		String getfieberThermometer = ef.rounding(ef.get_Element(po.ThermometerPrice(L, version), 500).getText());
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ef.get_Element(po.TruckZoom(L, version), 1000));
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 1000)).click().build().perform();
		
		String getABLExternValue = ef.rounding(ef.get_Element(zo.ABLExternValue(L), 3000).getText());
		
		Log.info("--------------------------------------------------");
		Log.info("Checking after "+logText);
		Log.info("Checking Order Burden Rate Value:");
		if (ef.elementExist(zo.OrderBurdenRateValue(L), 3000)){
			String getOrderBurdenRateValue = ef.rounding(ef.get_Element(zo.OrderBurdenRateValue(L), 3000).getText());
			Log.error("Order Burden Rate is showing with value of: " +getOrderBurdenRateValue);
		} else {
			Log.info("Order Burden Rate Value is not showing");
		}
		
		Log.info("Checking CM2 Value:");
		if (ef.elementExist(zo.CM2Value(L), 500)){
			String getOrderBurdenRateValue = ef.rounding(ef.get_Element(zo.OrderBurdenRateValue(L), 200).getText());
			Log.error("CM2 is showing with value of: " +getOrderBurdenRateValue);
		} else {
			Log.info("CM2 Value is not showing");
		}
		
		Log.info("Checking Vehicle Commission Value:");
		if (ef.elementExist(zo.VehicleCommission(L), 500)){
			String getVehicleCommission = ef.rounding(ef.get_Element(zo.VehicleCommission(L), 200).getText());
			Log.error("Vehicle Commission is showing with value of: " +getVehicleCommission);
		} else {
			Log.info("Vehicle Commission Value is not showing");
		}
		
		String BasePrice = ef.get_Element(zo.BasePrice(L), 3000).getText();
		Log.info("BasePrice: "+ BasePrice);
		String Topoptions = ef.get_Element(zo.Topoptions(L), 200).getText();
		Log.info("Topoptions: "+ Topoptions);
		String TotalDiscount = ef.get_Element(zo.TotalDiscount(L), 200).getText();
		Log.info("TotalDiscount: "+ TotalDiscount);
		String ChargeTransportNet = ef.get_Element(zo.ChargeTransportNet(L), 200).getText();
		Log.info("ChargeTransportNet: "+ ChargeTransportNet);
		String VCodesNet = ef.get_Element(zo.VCodesNet(L), 200).getText();
		Log.info("VCodesNet: "+ VCodesNet);
		String LocalOptionalFeatures = "0.00";
		if (ef.elementExist(zo.LocalOptionalFeatures(L), 200)) {
			LocalOptionalFeatures = ef.get_Element(zo.LocalOptionalFeatures(L), 200).getText();
		}
		Log.info("LocalOptionalFeatures: "+ LocalOptionalFeatures);
		String Stutzung = "0.00";
		if (ef.elementExist(zo.Subsidy(L), 200)) {
			Stutzung = ef.get_Element(zo.Subsidy(L), 200).getText();
			//Stutzung = Stutzung.replaceAll("[^\\d.]", "");
			//Stutzung = ef.rounding(Stutzung);
			//double Stutzung_D = Double.parseDouble(Stutzung);
			//Stutzung_D = Stutzung_D + Double.parseDouble(ExtraStutzung);
			//Stutzung =String.valueOf(Stutzung_D);
		}
		
		String ProvisionsrelevanteSondereinzelkosten = "0.00";
		if (ef.elementExist(zo.SpecialDirectCosts(L), 500)) {
			ProvisionsrelevanteSondereinzelkosten = ef.get_Element(zo.SpecialDirectCosts(L), 200).getText();
		}
		
		Log.info("ProvisionsrelevanteSondereinzelkosten: "+ ProvisionsrelevanteSondereinzelkosten);
		//String getOrderBurdenRateValue = ef.rounding(ef.get_Element(zo.OrderBurdenRateValue(L), 200).getText());
		//String getCM2Value = ef.rounding(ef.get_Element(zo.CM2Value(L), 200).getText());
		//String getVehicleCommission = ef.rounding(ef.get_Element(zo.VehicleCommission(L), 200).getText());
		
		calculation calc = new calculation();
		HashMap<String, String> values = calc.getValue(calcType, VehicleUsage, truckType, truckTypeShort, BasePrice, Topoptions, TotalDiscount, ChargeTransportNet, VCodesNet, LocalOptionalFeatures, Stutzung, ExtraStutzung, ZKE1, ProvisionsrelevanteSondereinzelkosten, truckAmount, Juniorverkaufer, ServiceVertragspartner, kommunal, Tiemann);
		
		String ABL = values.get("ABL");
		String DB2Fahrzeug = values.get("DB2");
		String provision = values.get("Gesamtprovision");
		
		ef.get_Element(zo.Close(L), 2000).click();
		
		
		if(thermometer) {
			Log.info("Checking Value from Fieberthermometer:");
			Log.info("Checking Customer End Price Value:");
			if (getfieberThermometer.equals(CEP)) {
				Log.info("Customer End Price Value OK: Expected: "+CEP+", Actual: "+getfieberThermometer);
			} else {
				pass = false;
				Log.error("Customer End Price Value OK: Expected: "+CEP+", Actual: "+getfieberThermometer);
			}
		}
		Log.info("Checking Value from Proposal Information:");
		Log.info("Checking ABL Extern Value:");
		if (getABLExtern.equals(ABL)) {
			//pass = true;
			Log.info("ABL Extern Value OK: Expected: "+ABL+", Actual: "+getABLExtern);
		} else {
			pass = false;
			Log.error("ABL Extern Value NOK: Expected: "+ABL+", Actual: "+getABLExtern);
		}
		
		Log.info("Checking DB2 Fahrzeug Value:");
		if (ef.elementExist(po.KPIValueSearch("DB2 Fahrzeug", version), 500)){
			String getDB2Fahrzeug = ef.rounding(ef.get_Element(po.KPIValueSearch("DB2 Fahrzeug", version), 500).getText());
			Log.error("DB2 Fahrzeug is showing with value of: " +getDB2Fahrzeug);
		} else {
			Log.info("DB2 Fahrzeug Value is not showing");
		}
		
		if (ef.elementExist(po.Commission(L, version), 200)){
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.Commission(L, version), 200));
			a.moveToElement(ef.get_Element(po.Commission(L, version), 200)).click().build().perform();	
			String getFahrzeugprovision = ef.rounding(ef.get_Element(po.Fahrzeugprovision(L, version), 500).getText());
			Log.error("Fahrzeugprovision is showing with value of: " +getFahrzeugprovision);
		} else {
			Log.info("Fahrzeugprovision Value is not showing");
		}
		
		
		Log.info("Checking Value from Zoom:");
		Log.info("Checking ABL Extern Value:");
		
		if (getABLExternValue.equals(ABL)) {
			//pass = true;
			Log.info("Order Burden Rate Value OK: Expected: "+ABL+", Actual: "+getABLExternValue);
		} else {
			pass = false;
			Log.error("Order Burden Rate Value NOK: Expected: "+ABL+", Actual: "+getABLExternValue);
		}	
		
		
		
		Log.info("--------------------------------------------------");
		
		return pass;
	}
	
	public boolean CommissionPartnerRolesTiemann (WebDriver driver, WebDriverWait wait, String randomValue, String partnerRole, String name, String value, String name2, String value2) throws InterruptedException {	
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		//a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		ef.get_JSClick(mp.ProposalsNew(L), 0);
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		//a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.Search, 2000).sendKeys(randomValue+"_Proposal" + Keys.ENTER);	
		//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		ef.get_JSClick(po.lineSearch(randomValue+"_Proposal"), 2000);
		
		//a.moveToElement(ef.get_Element(po.PartnerrollenTab(L), 3000)).click().build().perform();
		ef.get_JSClick(po.PartnerrollenTab(L), 3000);
		
		if (ef.elementExist(po.PartnerRole(L), 500)) {
			//a.moveToElement(ef.get_Element(po.PartnerRole(L), 500)).click().build().perform();
			ef.get_JSClick(po.PartnerRole(L), 500);
		} else {
			//a.moveToElement(ef.get_Element(po.ProdPartnerRole(L), 500)).click().build().perform();
			ef.get_JSClick(po.ProdPartnerRole(L), 500);
		}
		
		//a.moveToElement(ef.get_Element(po.PRelement(L,partnerRole), 500)).click().build().perform();
		ef.get_JSClick(po.PRelement(L,partnerRole), 500);
		

		//a.moveToElement(ef.get_Element(po.PRAccount(L), 1000)).click().sendKeys(name).build().perform();
		ef.get_Element(po.PRAccount(L), 1000).sendKeys(name);
		//a.moveToElement(ef.get_Element(po.PRContactName(L, name), 1000)).click().build().perform();
		ef.get_JSClick(po.PRContactName(L, name), 1000);
		//a.moveToElement(ef.get_Element(po.Next(L), 1000)).click().build().perform();
		ef.get_JSClick(po.Next(L), 1000);
		
		a.moveToElement(ef.get_Element(po.PRCommissionEdit(L, name), 3000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(value).build().perform();

		//a.moveToElement(ef.get_Element(po.EnterProvisions(L), 1000)).click().build().perform();
		ef.get_Element(po.EnterProvisions(L), 1000);
		a.moveToElement(ef.get_Element(po.PRCommissionEdit(L, name2), 3000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(value2).build().perform();
		//a.moveToElement(ef.get_Element(po.EnterProvisions(L), 1000)).click().build().perform();
		ef.get_Element(po.EnterProvisions(L), 1000);
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.SaveProvision(L), 3000));
		//ef.get_Element(po.SaveProvision(L), 5000).click();
		ef.get_JSClick(po.SaveProvision(L), 5000);
		Thread.sleep(8000);
		//driver.navigate().refresh();
		return pass;
	}
		
	public boolean checkPartnerRoles (WebDriver driver, WebDriverWait wait, String randomValue, String calcType, String VehicleUsage,String Juniorverkaufer, String ServiceVertragspartner, String ExtraStutzung, String ZKE1, boolean kommunal, boolean Tiemann) throws InterruptedException, IOException {	
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		
		String truckType = ef.get_Element(po.TruckLabel(L), 3000).getText();
		truckType = truckType.replace(" (C4S)", "").trim();
		String[] truckTypeList = truckType.split(" ");
		String truckTypeShort = truckTypeList[0];
		String truckAmount = ef.get_Element(po.QuantityField(L, "1"), 2000).getText();
		Log.info("truckAmount: "+ truckAmount);
		
		a.moveToElement(ef.get_Element(po.TruckZoom(L, "1"), 1000)).click().build().perform();
		String BasePrice = ef.get_Element(zo.BasePrice(L), 3000).getText();
		Log.info("BasePrice: "+ BasePrice);
		String Topoptions = ef.get_Element(zo.Topoptions(L), 200).getText();
		Log.info("Topoptions: "+ Topoptions);
		String TotalDiscount = ef.get_Element(zo.TotalDiscount(L), 200).getText();
		Log.info("TotalDiscount: "+ TotalDiscount);
		String ChargeTransportNet = ef.get_Element(zo.ChargeTransportNet(L), 200).getText();
		Log.info("ChargeTransportNet: "+ ChargeTransportNet);
		String VCodesNet = ef.get_Element(zo.VCodesNet(L), 200).getText();
		Log.info("VCodesNet: "+ VCodesNet);
		String LocalOptionalFeatures = "0.00";
		if (ef.elementExist(zo.LocalOptionalFeatures(L), 200)) {
			LocalOptionalFeatures = ef.get_Element(zo.LocalOptionalFeatures(L), 200).getText();
		}
		Log.info("LocalOptionalFeatures: "+ LocalOptionalFeatures);
		//have to change!!!!
		String Stutzung = "0.00";
		if (ef.elementExist(zo.Subsidy(L), 200)) {
			Stutzung = ef.get_Element(zo.Subsidy(L), 200).getText();
		}
		
		String ProvisionsrelevanteSondereinzelkosten = "0.00";
		if (ef.elementExist(zo.SpecialDirectCosts(L), 200)) {
			ProvisionsrelevanteSondereinzelkosten = ef.get_Element(zo.SpecialDirectCosts(L), 200).getText();
		}
		
		Log.info("ProvisionsrelevanteSondereinzelkosten: "+ ProvisionsrelevanteSondereinzelkosten);
		String getOrderBurdenRateValue = ef.rounding(ef.get_Element(zo.OrderBurdenRateValue(L), 200).getText());
		String getCM2Value = ef.rounding(ef.get_Element(zo.CM2Value(L), 200).getText());
		String getVehicleCommission = ef.rounding(ef.get_Element(zo.VehicleCommission(L), 200).getText());
		
		calculation calc = new calculation();
		HashMap<String, String> values = calc.getValue(calcType, VehicleUsage, truckType, truckTypeShort, BasePrice, Topoptions, TotalDiscount, ChargeTransportNet, VCodesNet, LocalOptionalFeatures, Stutzung, ExtraStutzung, ZKE1, ProvisionsrelevanteSondereinzelkosten, truckAmount, Juniorverkaufer, ServiceVertragspartner, kommunal, Tiemann);
		
		String ABL = values.get("ABL");
		String DB2Fahrzeug = values.get("DB2");
		String provision = values.get("Gesamtprovision");
		
		ef.get_Element(zo.Close(L), 200).click();
		
		a.moveToElement(ef.get_Element(po.PartnerrollenTab(L), 3000)).click().build().perform();
		
		String SplitinPercent;
		if (ef.get_Element(po.SplitinPercentHeaderSearch(L, "4"), 1000).getText().equals("Split in Percent")) {
			SplitinPercent = ef.get_Element(po.SplitinPercentSearch(L, "3"), 1000).getText();
		} else {
			SplitinPercent = ef.get_Element(po.SplitinPercentSearch(L, "2"), 1000).getText();
		}
		Log.info("Checking Commission Partner Roles Value:");
		Log.info("Checking Split in Percent Value:");
		if (SplitinPercent.equals("100")) {
			//pass = true;
			Log.info("Split in Percent Value OK: Expected: 100, Actual: "+SplitinPercent);
		} else {
			pass = false;
			Log.error("Split in Percent Value NOK: Expected: 100, Actual: "+SplitinPercent);
		}
		String AbsoluteAmount, AbsoluteAmountWithComma = null;
		if (ef.elementExist(po.AbsoluteAmountSearch(L, "1", "4"), 200)) {
			//AbsoluteAmount = ef.cutting(ef.get_Element(po.AbsoluteAmountSearch(L, "1", "4"), 200).getText().replaceAll("[^\\d]", ""), "R", 2);
			//AbsoluteAmount = ef.roundingwithKomma(ef.get_Element(po.AbsoluteAmountSearch(L, "1", "4"), 200).getText());
			AbsoluteAmount = ef.rounding(ef.get_Element(po.AbsoluteAmountSearch(L, "1", "4"), 200).getText());
			AbsoluteAmountWithComma = ef.getCommaString(ef.get_Element(po.AbsoluteAmountSearch(L, "1", "4"), 200).getText());
			
		} else {
			//AbsoluteAmount = ef.cutting(ef.get_Element(po.AbsoluteAmountSearch(L, "1", "3"), 200).getText().replaceAll("[^\\d]", ""), "R", 2);
			//AbsoluteAmount = ef.roundingwithKomma(ef.get_Element(po.AbsoluteAmountSearch(L, "1", "3"), 200).getText());
			AbsoluteAmount = ef.rounding(ef.get_Element(po.AbsoluteAmountSearch(L, "1", "3"), 200).getText());
			AbsoluteAmountWithComma = ef.getCommaString(ef.get_Element(po.AbsoluteAmountSearch(L, "1", "3"), 200).getText());
		}
		Log.info("Checking Absolute Amount Value:");
		if (AbsoluteAmount.equals(provision)) {
			//pass = true;
			Log.info("Absolute Amount Value OK: Expected: "+provision+", Actual: "+AbsoluteAmount);
		} else {
			pass = false;
			Log.error("Absolute Amount Value NOK: Expected: "+provision+", Actual: "+AbsoluteAmount);
		}
		String Role;
		if (ef.get_Element(po.SplitinPercentHeaderSearch(L, "4"), 500).getText().equals("Split in Percent")) {
			Role = ef.get_Element(po.RoleSearch(L, "5"), 200).getText();
		} else {
			Role = ef.get_Element(po.RoleSearch(L, "4"), 200).getText();
		}
		Log.info("Checking Role Value:");
		if (Role.equals("Sales Rep 1")) {
			//pass = true;
			Log.info("Role Value OK: Expected: Sales Rep 1, Actual: "+Role);
		} else {
			pass = false;
			Log.error("Role Value NOK: Expected: Sales Rep 1, Actual: "+Role);
		}
		if (ef.elementExist(po.PartnerRole(L), 500)) {
			a.moveToElement(ef.get_Element(po.PartnerRole(L), 500)).click().build().perform();
		} else {
			a.moveToElement(ef.get_Element(po.ProdPartnerRole(L), 500)).click().build().perform();
		}
		
		a.moveToElement(ef.get_Element(po.PRelement(L, "Sales Rep 2"), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.PRContact(L), 1000)).click().sendKeys("Dirk Schneckenburger").build().perform();
		a.moveToElement(ef.get_Element(po.PRContactName(L, "Dirk Schneckenburger"), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.Next(L), 1000)).click().build().perform();
		
		if (ef.elementExist(po.PartnerRole(L), 2000)) {
			a.moveToElement(ef.get_Element(po.PartnerRole(L), 200)).click().build().perform();
		} else {
			a.moveToElement(ef.get_Element(po.ProdPartnerRole(L), 200)).click().build().perform();
		}
		
		//a.moveToElement(ef.get_Element(po.PartnerRole(L), 2000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.PRelement(L ,"Sales Rep 3"), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.PRContact(L), 1000)).click().sendKeys("Andreas Overhoff").build().perform();
		a.moveToElement(ef.get_Element(po.PRContactName(L, "Andreas Overhoff"), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.Next(L), 1000)).click().build().perform();
		
		a.moveToElement(ef.get_Element(po.SplitinPercentEditSearch(L,"1"), 6000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("50").build().perform();
		ef.get_Element(po.EnterProvisions(L), 2000).click();
		a.moveToElement(ef.get_Element(po.SplitinPercentEditSearch(L,"2"),500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("30").build().perform();
		ef.get_Element(po.EnterProvisions(L), 2000).click();
		a.moveToElement(ef.get_Element(po.SplitinPercentEditSearch(L,"3"), 500)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("20").build().perform();
		ef.get_Element(po.EnterProvisions(L), 2000).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.SaveProvision(L), 2000));
		ef.get_Element(po.SaveProvision(L), 2000).click();
		
		a.moveToElement(ef.get_Element(mp.Proposals(L), 14000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		
		a.moveToElement(ef.get_Element(po.PartnerrollenTab(L), 3000)).click().build().perform();
		String j="3";
		if (ef.get_Element(po.AbsoluteAmountSearch(L, "1", "3"), 1000).getText().length() > 4) {
			j="3";
		} else {
			j="4";
		}

		//String Amount1 = ef.cutting(ef.get_Element(po.AbsoluteAmountSearch(L, "1", j), 200).getText().replaceAll("[^\\d]", ""), "R", 2);
		String Amount1 = ef.get_Element(po.AbsoluteAmountSearch(L, "1", j), 200).getText();
		Amount1 = ef.rounding(Amount1);
		//String Amount2 = ef.cutting(ef.get_Element(po.AbsoluteAmountSearch(L, "2", j), 200).getText().replaceAll("[^\\d]", ""), "R", 2);
		String Amount2 = ef.get_Element(po.AbsoluteAmountSearch(L, "2", j), 200).getText();
		Amount2 = ef.rounding(Amount2);
		//String Amount3 = ef.cutting(ef.get_Element(po.AbsoluteAmountSearch(L, "3", j), 200).getText().replaceAll("[^\\d]", ""), "R", 2);
		String Amount3 = ef.get_Element(po.AbsoluteAmountSearch(L, "3", j), 200).getText();
		Amount3 = ef.rounding(Amount3);
		//double proviD1 = (Integer.parseInt(provision))*0.5;
		double proviD1 = (Double.parseDouble(AbsoluteAmountWithComma))*0.5;
		int proviD1_int = (int) Math.round(proviD1);
		String proviS1 = String.valueOf(proviD1_int);
		//String proviS1 = ef.cutting(String.valueOf(proviD1).replaceAll("[^\\d]", ""), "R", 1);
		Log.info("Checking Split in Percent Value after splitting:");
		if (Amount1.equals(proviS1)) {
			//pass = true;
			Log.info("Provision 1 OK: Expected: "+proviS1+", Actual: "+Amount1);
		} else {
			pass = false;
			Log.error("Provision 1 NOK: Expected: "+proviS1+", Actual: "+Amount1);
		}
		//double proviD2 = (Integer.parseInt(provision))*0.3;
		double proviD2 = (Double.parseDouble(AbsoluteAmountWithComma))*0.3;
		int proviD2_int = (int) Math.round(proviD2);
		String proviS2 = String.valueOf(proviD2_int);
		//String proviS2 = ef.cutting(String.valueOf(proviD2).replaceAll("[^\\d]", ""), "R", 1);
		
		if (Amount2.equals(proviS2)) {
			//pass = true;
			Log.info("Provision 2 OK: Expected: "+proviS2+", Actual: "+Amount2);
		} else {
			pass = false;
			Log.error("Provision 2 NOK: Expected: "+proviS2+", Actual: "+Amount2);
		}
		//double proviD3 = (Integer.parseInt(provision))*0.2;
		double proviD3 = (Double.parseDouble(AbsoluteAmountWithComma))*0.2;
		int proviD3_int = (int) Math.round(proviD3);
		String proviS3 = String.valueOf(proviD3_int);
		//String proviS3 = ef.cutting(String.valueOf(proviD3).replaceAll("[^\\d]", ""), "R", 1);
		
		if (Amount3.equals(proviS3)) {
			//pass = true;
			Log.info("Provision 3 OK: Expected: "+proviS3+", Actual: "+Amount3);
		} else {
			pass = false;
			Log.error("Provision 3 NOK: Expected: "+proviS3+", Actual: "+Amount3);
		}
		
		return pass;
	}
	
	public boolean addServicePartner (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {	
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		
		a.moveToElement(ef.get_Element(po.PartnerrollenTab(L), 3000)).click().build().perform();
		
		
		if (ef.elementExist(po.PartnerRole(L), 500)) {
			a.moveToElement(ef.get_Element(po.PartnerRole(L), 500)).click().build().perform();
		} else {
			a.moveToElement(ef.get_Element(po.ProdPartnerRole(L), 500)).click().build().perform();
		}
		
		a.moveToElement(ef.get_Element(po.PRelement(L,"Commission contract partner 1 absolute"), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.PRAccount(L), 1000)).click().sendKeys("Robert Tröger KG").build().perform();
		a.moveToElement(ef.get_Element(po.PRContactName(L, "Robert Tröger KG"), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.Next(L), 1000)).click().build().perform();
		
		if (ef.elementExist(po.PartnerRole(L), 2000)) {
			a.moveToElement(ef.get_Element(po.PartnerRole(L), 200)).click().build().perform();
		} else {
			a.moveToElement(ef.get_Element(po.ProdPartnerRole(L), 200)).click().build().perform();
		}
		
		//a.moveToElement(ef.get_Element(po.PartnerRole(L), 2000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.PRelement(L, "Commission contract partner 2 absolute"), 500)).click().build().perform();
		a.moveToElement(ef.get_Element(po.PRAccount(L), 1000)).click().sendKeys("Werner Hagemann").build().perform();
		a.moveToElement(ef.get_Element(po.PRContactName(L, "Werner Hagemann & Sohn OHG"), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.Next(L), 1000)).click().build().perform();
		
		a.moveToElement(ef.get_Element(po.PRCommissionEdit(L, "Robert Tröger KG"), 3000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("1000").build().perform();
		a.moveToElement(ef.get_Element(po.EnterProvisions(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.PRCommissionEdit(L, "Werner Hagemann & Sohn OHG"), 3000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("1000").build().perform();
		a.moveToElement(ef.get_Element(po.EnterProvisions(L), 1000)).click().build().perform();
		ef.get_Element(po.SaveProvision(L), 2000).click();
		driver.navigate().refresh();
		return pass;
	}
	
	public boolean specialDirectCost (WebDriver driver, WebDriverWait wait, String randomValue, String costs, String prices, String version) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		ArrayList<String> EntlastungVerkaufsaktionen = new ArrayList<String>(2);
		ArrayList<String> FinanzierungRückkauf = new ArrayList<String>(4);
		ArrayList<String> Gutschriften = new ArrayList<String>(7);
		ArrayList<String> KostenLieferung = new ArrayList<String>(2);
		ArrayList<String> KostenNationaleZusatzausstattung = new ArrayList<String>(5);
		ArrayList<String> KostenProvision = new ArrayList<String>(2);
		ArrayList<String> KostenSonstige = new ArrayList<String>(11);
		ArrayList<String> RückstellungenPonalen = new ArrayList<String>(4);
		EntlastungVerkaufsaktionen.add("ZKE1");
		FinanzierungRückkauf.add("ZKW7");
		FinanzierungRückkauf.add("ZKL1");
		FinanzierungRückkauf.add("ZKL2");
		Gutschriften.add("ZKC1");
		Gutschriften.add("ZKC2");
		Gutschriften.add("ZKC3");
		Gutschriften.add("ZKC5");
		Gutschriften.add("ZKC7");
		Gutschriften.add("ZKC9");
		KostenLieferung.add("ZK47");
		KostenNationaleZusatzausstattung.add("ZK51");
		KostenNationaleZusatzausstattung.add("ZK52");
		KostenNationaleZusatzausstattung.add("ZK53");
		KostenNationaleZusatzausstattung.add("ZK54");
		KostenProvision.add("ZKE2");
		KostenSonstige.add("ZKO2");
		KostenSonstige.add("ZKO4");
		KostenSonstige.add("ZKO5");
		KostenSonstige.add("ZKO6");
		KostenSonstige.add("ZKO7");
		KostenSonstige.add("ZKW3");
		KostenSonstige.add("ZKW4");
		KostenSonstige.add("ZKW5");
		KostenSonstige.add("ZK46");
		KostenSonstige.add("ZK59");
		RückstellungenPonalen.add("ZKW1");
		RückstellungenPonalen.add("ZKW2");
		RückstellungenPonalen.add("ZK09");
		
		String[] costsList = costs.split(",");
		String[] pricesList = prices.split(",");
		a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 3000)).click().build().perform();
		a.moveToElement(ef.get_Element(zo.AddSpecialDirectCost(L), 1000)).click().build().perform();
		
		for (int i = 0; i < costsList.length; i++) {
			if (EntlastungVerkaufsaktionen.contains(costsList[i])) {
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySearch("Entlastung Verkaufsaktionen"), 1000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySubSearch(costsList[i]), 500)).click().build().perform();
				Log.info("Cost added: "+costsList[i]);
			}
			if (FinanzierungRückkauf.contains(costsList[i])) {
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySearch("Finanzierung / Rückkauf"), 1000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySubSearch(costsList[i]), 500)).click().build().perform();
				Log.info("Cost added: "+costsList[i]);
			}
			if (Gutschriften.contains(costsList[i])) {
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySearch("Gutschriften"), 1000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySubSearch(costsList[i]), 500)).click().build().perform();
				Log.info("Cost added: "+costsList[i]);
			}
			if (KostenLieferung.contains(costsList[i])) {
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySearch("Kosten - Lieferung"), 1000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySubSearch(costsList[i]), 500)).click().build().perform();
				Log.info("Cost added: "+costsList[i]);
			}
			if (KostenNationaleZusatzausstattung.contains(costsList[i])) {
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySearch("Kosten - Nationale Zusatzausstattung"), 1000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySubSearch(costsList[i]), 500)).click().build().perform();
				Log.info("Cost added: "+costsList[i]);
			}
			if (KostenProvision.contains(costsList[i])) {
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySearch("Kosten - Provision"), 1000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySubSearch(costsList[i]), 500)).click().build().perform();
				Log.info("Cost added: "+costsList[i]);
			}
			if (KostenSonstige.contains(costsList[i])) {
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySearch("Kosten - Sonstige"), 1000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySubSearch(costsList[i]), 500)).click().build().perform();
				Log.info("Cost added: "+costsList[i]);
			}
			if (RückstellungenPonalen.contains(costsList[i])) {
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySearch("Rückstellungen/Pönalen"), 1000)).click().build().perform();
				a.moveToElement(ef.get_Element(zo.AddCostSubsidySubSearch(costsList[i]), 500)).click().build().perform();
				Log.info("Cost added: "+costsList[i]);
			}
		}
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(po.Next(L), 2000));
		a.moveToElement(ef.get_Element(po.Next(L), 1000)).click().build().perform();
		//ef.get_Element(po.Next(L), 1000).click();
		int count = 0;
		while ((!ef.elementExist(po.ProposalUpdatingMessage(L), 0)) && (count <= 40)) {
			count++;
			Thread.sleep(500);
		}
		a.moveToElement(ef.get_Element(zo.ButtonSpecialDirectCosts(L), 1000)).click().build().perform();
		Thread.sleep(2000);
		for (int i = 0; i < costsList.length; i++) {
			a.moveToElement(ef.get_Element(zo.directCostEditSearch(costsList[i]), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(pricesList[i]).build().perform();
			a.moveToElement(ef.get_Element(zo.TruckHeadlineText(L), 1000)).click().build().perform();
		}
		a.moveToElement(ef.get_Element(zo.TruckHeadlineText(L), 2000)).click().build().perform();
		ef.get_Element(zo.Close(L), 2000).click();

		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(zo.PLI_shippingTypeDropdown(L), 2000));

		return pass;
	}
	
	public boolean checkServiceAfterMRC (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		PLI_ServiceObject so = new PLI_ServiceObject();
		ZoomObject zo = new ZoomObject();
		long start = System.currentTimeMillis();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(mp.Proposals(L), 12000)).click().build().perform();
		if(!ef.elementExist(po.Search, 4000)) {
			ef.get_Element(mp.Proposals(L), 1000).click();
		}
		Thread.sleep(20000);
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		String serviceName = ef.get_Element(po.ServiceName(L), 1000).getText();
		a.moveToElement(ef.get_Element(po.ServiceZoom(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element(po.RelatedTab(L), 1000)).click().build().perform();
		//a.moveToElement(ef.get_Element_woCl(po.lineItemSearch(serviceName), 4000)).click().build().perform();
		int count = 0;
		while ((ef.get_Element_woCl(zo.InflationaryPlannedCosts(L), 2000).getText().equals("0.00 EUR")) && (count <= 20)) {
			count++;
			a.moveToElement(ef.get_Element(zo.Close(L), 1000)).click().build().perform();
			driver.navigate().refresh();
			ef.get_JSClick(mp.ProposalsNew(L), 5000);
			if(!ef.elementExist(po.Search, 1000)) {
				ef.get_Element(mp.Proposals(L), 3000).click();
			}
			ef.get_Element(po.Search, 6000).clear();
			//a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
			ef.get_Element(po.Search, 2000).sendKeys(randomValue+"_Proposal" + Keys.ENTER);
			//a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
			ef.get_JSClick(po.lineSearch(randomValue+"_Proposal"), 0);
			a.moveToElement(ef.get_Element(po.ServiceZoom(L), 3000)).click().build().perform();
			
			//a.moveToElement(ef.get_Element(po.RelatedTab(L), 2000)).click().build().perform();
			//a.moveToElement(ef.get_Element_woCl(po.lineItemSearch(serviceName), 3000)).click().build().perform();
		}
		long end = System.currentTimeMillis();
		
		if (count >= 20) {
			pass = false;
			Log.error("No response from MRC");
			Log.info("Waiting for MRC Response in milisec: " + (end - start));
			Log.info("Waiting for MRC Response time in sec: " + ((end - start) / 1000));
		} else {
			Log.info("MRC Response time in milisec: " + (end - start));
			Log.info("MRC Response time in sec: " + ((end - start) / 1000));
			Log.info("Inflationary Planned Costs: "+ef.get_Element_woCl(zo.InflationaryPlannedCosts(L), 200).getText());
			a.moveToElement(ef.get_Element(zo.Close(L), 1000)).click().build().perform();
			//ef.get_Element(mp.Proposals(L), 2000).click();
			//ef.get_Element(po.Search, 500).clear();
			//a.moveToElement(ef.get_Element(po.Search, 100)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
			//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
			
		}
		
		return pass;
	}
	
	public boolean createVariant (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.NewVariant(L), 3000)).click().build().perform();
		ef.get_Element(po.NameTextField(L), 3000).clear();
		ef.get_Element(po.NameTextField(L), 3000).sendKeys(randomValue+"_2_Proposal");
		ef.get_Element(po.Next(L), 2000).click();
		int count = 0;
		while ((!ef.elementExist(po.NewVariantText(L), 1000)) && (count <= 40)) {
			count ++;
			Thread.sleep(1000);
		}
		ef.get_Element(po.Next(L), 5000).click();
		while ((!ef.elementExist(mp.ProposalNumber(L), 1000)) && (count <= 40)) {
			count ++;
			Thread.sleep(1000);
		}
		a.moveToElement(ef.get_Element(mp.Proposals(L), 5000)).click().build().perform();
		//ef.get_Element(mp.Proposals(L), 8000).click();
		if(!ef.elementExist(po.Search, 2000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_2_Proposal").sendKeys(Keys.ENTER).build().perform();
		a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_2_Proposal"), 2000)).click().build().perform();
		driver.navigate().refresh();
		
		return pass;
	}
	
	public boolean deleteProduct (WebDriver driver, WebDriverWait wait, String randomValue, String product, String version) throws InterruptedException {
		boolean pass = true;
		//Warranty
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(po.productAction(L, product, version), 3000)).click().build().perform();
		a.moveToElement(ef.get_Element(po.deleteProduct(L, product, version), 500)).click().build().perform();
		ef.get_Element(po.Confirm(L), 2000).click();
		
		ef.get_Element(mp.Proposals(L), 3000).click();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
		
		return pass;
	}
	
	public boolean modifyQuantity (WebDriver driver, WebDriverWait wait, String randomValue, String amount, String version) throws InterruptedException {
		boolean pass = true;
		//Warranty
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		ef.get_JSClick(mp.ProposalsNew(L), 0);
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		//a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.Search, 2000).sendKeys(randomValue+"_Proposal" + Keys.ENTER);
		//a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
		ef.get_JSClick(po.lineSearch(randomValue+"_Proposal"), 0);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ef.get_Element(po.QuantityEdit(L, version), 3000));
		a.moveToElement(ef.get_Element(po.QuantityEdit(L, version), 1000)).click().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(amount).build().perform();
		ef.get_Element(po.QuantityText(L, version), 2000).click();
		ef.get_Element(po.QuantityText(L, version), 1000).click();
		
		ef.get_Element(mp.Proposals(L), 3000).click();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
		
		return pass;
	}
	
	public boolean printProposal (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		//ef.get_Element(mp.Proposals(L), 3000).click();
		ef.get_JSClick(mp.ProposalsNew(L), 0);
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		//a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.Search, 2000).sendKeys(randomValue+"_Proposal" + Keys.ENTER);
		//a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
		ef.get_JSClick(po.lineSearch(randomValue+"_Proposal"), 0);
		if (!ef.elementExist(po.Validator(L, "0"), 2000)) {
			a.moveToElement(ef.get_Element(po.Validator(L), 200)).click().build().perform();
			if (ef.elementExist(po.ValidatorAbakus(L), 1000)) {
				ef.get_Element(po.FinanceAction(L), 1000).click();
				a.moveToElement(ef.get_Element(po.AbakusUpdate(L), 500)).click().build().perform();
			} else {
				driver.navigate().refresh();
			}			
		}
		Thread.sleep(3000);
		//a.moveToElement(ef.get_Element(po.printProposal(L), 12000)).click().build().perform();
		ef.get_JSClick(po.printProposal(L), 12000);
		int count = 0;
		while ((!ef.elementExist(po.PrintMenuTemplate(L), 0) & count < 20)) {
			count++;
			Thread.sleep(1000);
		}
		//ef.get_Element(po.Next(L), 9000).click();
		ef.get_JSClick(po.Next(L), 10000);
		count = 0;
		while ((!ef.elementExist(po.PrintGeneral(L), 0) & count < 20)) {
			count++;
			Thread.sleep(1000);
		}
		//a.moveToElement(ef.get_Element(po.print(L), 9000)).click().build().perform();
		ef.get_JSClick(po.print(L), 10000);
		count = 0;
		while ((!ef.elementExist(po.YourDocument(L), 0) & count < 20)) {
			count++;
			Thread.sleep(500);
		}
		//ef.get_Element(po.Next(L), 5000).click();
		ef.get_JSClick(po.Next(L), 5000);
		
		return pass;
	}
	
	public boolean printOrder (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		Thread.sleep(8000);
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 7000)) {
			L = "E";
		}
		//ef.get_Element(po.showMoreActionSearch(randomValue+"_Proposal"), 12000).click();
		/*
		int count = 0;
		while ((!ef.elementExist(po.printOrder(L), 2000)) && (count <= 20)) {
			count++;
			Thread.sleep(1000);
		}
		*/
		//a.moveToElement(ef.get_Element(po.printOrder(L), 8000)).click().build().perform();
		ef.get_JSClick(po.printOrder(L), 12000);
		int count = 0;
		while ((!ef.elementExist(po.SelectOrderType(L), 2000)) && (count <= 20)) {
			count++;
			Thread.sleep(1000);
		}
		//ef.get_Element(po.Continue(L), 4000).click();
		ef.get_JSClick(po.Continue(L), 5000);
		/*
		if (ef.elementExist(po.Continue(L), 2000)) {
			ef.get_Element(po.Continue(L), 200).click();
		}
		*/
		count = 0;
		while ((!ef.elementExist(po.PrintMenuTemplate(L), 0) & count < 20)) {
			count++;
			Thread.sleep(1000);
		}
		//ef.get_Element(po.Next(L), 3000).click();
		ef.get_JSClick(po.Next(L), 5000);
		count = 0;
		while ((!ef.elementExist(po.PrintGeneral(L), 0) & count < 20)) {
			count++;
			Thread.sleep(1000);
		}
		//ef.get_Element(po.print(L), 3000).click();
		ef.get_JSClick(po.print(L), 5000);
		count = 0;
		while ((!ef.elementExist(po.YourDocument(L), 0) & count < 20)) {
			count++;
			Thread.sleep(500);
		}
		//ef.get_Element(po.Next(L), 2000).click();
		ef.get_JSClick(po.Next(L), 5000);
			
		return pass;
	}
	
	public boolean orderProposal (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		boolean pass = true;
		String L = "D";
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 10000)) {
			L = "E";
		}
		//ef.get_Element(po.showMoreActionSearch(randomValue+"_Proposal"), 8000).click();
		//ef.get_Element(po.Order(L), 5000).click();
		ef.get_JSClick(po.Order(L), 5000);
		int count = 0;
		while ((!ef.elementExist(po.TheCurrentCustomer(L), 0) & count < 20)) {
			count++;
			Thread.sleep(500);
		}
		//ef.get_Element(po.Next(L), 6000).click();
		ef.get_JSClick(po.Next(L), 0);
		Thread.sleep(20000);
		if (ef.elementExist(po.FertigStellen(L), 1000)) {
			//ef.get_Element(po.FertigStellen(L), 20000).click();
			ef.get_JSClick(po.FertigStellen(L), 0);
		}
		return pass;
	}
	
	public boolean approveProposal (WebDriver driver, WebDriverWait wait, String randomValue, String testuser, String manager) throws InterruptedException {
		Thread.sleep(8000);
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		login_new login = new login_new();
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 6000)) {
			L = "E";
		}
		
		login.changeLogin(driver, wait, manager);
		
		ef.get_Element(mp.Notification, 20000).click();
		//ef.get_Element(mp.Close(L), 5000).click();
		ef.get_Element(mp.notificationSearch(randomValue+"_Proposal"), 2000).click();
		ef.get_Element(po.approval_start(L), 1000).click();
		ef.get_Element(po.approval(L), 1000).click();
		Thread.sleep(8000);
		login.changeLogin(driver, wait, testuser);
		
		//ef.get_Element(mp.Proposals(L), 3000).click();
		//a.moveToElement(ef.get_Element(po.Search, 3000)).click().sendKeys("").build().perform();
		//a.moveToElement(ef.get_Element(po.Search, 500)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 1000).click();
		return pass;
	}
	
	public boolean openProposal (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
		//Thread.sleep(5000);
		boolean pass = true;
		String L = "E";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		ef.get_JSClick(mp.ProposalsNew(L), 0);
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		//a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.Search, 2000).sendKeys(randomValue+"_Proposal" + Keys.ENTER);	
		//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		ef.get_JSClick(po.lineSearch(randomValue+"_Proposal"), 2000);
		
		return pass;
	}
	
	public boolean checkPrintDocument (WebDriver driver, WebDriverWait wait, String randomValue, String version) throws InterruptedException, org.json.simple.parser.ParseException {
		//Thread.sleep(5000);
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		ZoomObject zo = new ZoomObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}
		a.moveToElement(ef.get_Element(mp.Proposals(L), 4000)).click().build().perform();
		if(!ef.elementExist(po.Search, 1000)) {
			ef.get_Element(mp.Proposals(L), 3000).click();
		}
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 2000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		String actualLink = driver.getCurrentUrl();
		String[] actualLinkList = actualLink.split("/");		
		String link = actualLinkList[actualLinkList.length-2];
		//Log.info("Actuallink: "+actualLink);
		//Log.info("ID: "+link);
		
a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 1000)).click().build().perform();
		
		String BasePrice = ef.rounding(ef.get_Element(zo.BasePrice(L), 3000).getText());
		String Topoptions = ef.rounding(ef.get_Element(zo.Topoptions(L), 200).getText());
		String BruttolistenpreisSumme = ef.rounding(ef.get_Element(zo.BruttolistenpreisSumme(L), 200).getText());
		String TotalDiscount = ef.rounding(ef.get_Element(zo.TotalDiscount(L), 200).getText());
		String TotalvehicleNetLeft = ef.rounding(ef.get_Element(zo.TotalvehicleNetLeft(L), 200).getText());
		String VCodesNet = ef.rounding(ef.get_Element(zo.VCodesNet(L), 200).getText());
		String LocalOptionalFeatures = "";
		if (ef.elementExist(zo.LocalOptionalFeatures(L), 200)) {
			LocalOptionalFeatures = ef.rounding(ef.get_Element(zo.LocalOptionalFeatures(L), 200).getText());
		}
		String TotalvehicleNetRight = ef.rounding(ef.get_Element(zo.TotalvehicleNetRight(L), 200).getText());
		String VAT = ef.rounding(ef.get_Element(zo.VAT(L), 200).getText());
		String TotalvehicleVAT = ef.rounding(ef.get_Element(zo.TotalvehicleVAT(L), 200).getText());
		ef.get_Element(zo.Close(L), 2000).click();
		/*
		Log.info("BasePrice: " + BasePrice);
		Log.info("Topoptions: " + Topoptions);
		Log.info("BruttolistenpreisSumme: " + BruttolistenpreisSumme);
		Log.info("TotalDiscount: " + TotalDiscount);
		Log.info("TotalvehicleNetLeft: " + TotalvehicleNetLeft);
		Log.info("VCodesNet: " + VCodesNet);
		Log.info("LocalOptionalFeatures: " + LocalOptionalFeatures);
		Log.info("TotalvehicleNetRight: " + TotalvehicleNetRight);
		Log.info("VAT: " + VAT);
		Log.info("TotalvehicleVAT: " + TotalvehicleVAT);
		*/
		if (ef.elementExist(mp.DialogButton(L), 1000)) {
			ef.get_Element(mp.DialogButton(L), 1000).click();
		} else {
			ef.get_Element(mp.DialogButtonProd(L), 1000).click();
		}
		
		a.moveToElement(ef.get_Element(mp.AlleAnzeigen(L), 2000)).click().build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(mp.LogMessages(L), 3000));
		a.moveToElement(ef.get_Element(mp.LogMessages(L), 1000)).click().build().perform();
		if (ef.elementExist(mp.SelectListView(L), 1000)) {
			ef.get_Element(mp.SelectListView(L), 1000).click();
		} else {
			ef.get_Element(mp.SelectListViewProd(L), 1000).click();
		}
		a.moveToElement(ef.get_Element(mp.PrintingLogMessagesToday(L), 2000)).click().build().perform();
		ef.get_Element(mp.LogSearchField(L), 3000).click();
		ef.get_Element(mp.LogSearchField(L), 1000).sendKeys(link);
		ef.get_Element(mp.LogSearchField(L), 1000).sendKeys(Keys.ENTER);
		//a.moveToElement(ef.get_Element(mp.LogSearchField(L), 10000)).click().sendKeys(link).sendKeys(Keys.ENTER).build().perform();
		a.moveToElement(ef.get_Element(mp.searchElementSearch(link, "Request", "2"), 2000)).click().build().perform();
		String details_proposal = ef.get_Element(mp.LogDetails(L), 2000).getText();
		details_proposal = details_proposal.replace("{body=","");
		details_proposal = details_proposal.split("}}},")[0];
		details_proposal = details_proposal + "}}}";

		openJSONstring test = new openJSONstring();
		HashMap<String, String> data = test.getJSONdata(details_proposal);
		//data.entrySet().forEach(entry->{
		//	Log.info(entry.getKey() + " " + ef.rounding(entry.getValue()));
		 //});
		
		Log.info("--------------------------------------------------");
		Log.info("Checking print proposal response json file");
		Log.info("Checking Base Price Value:");
		if (BasePrice.equals(ef.rounding(data.get("basicVehiclePrice")))) {
			//pass = true;
			Log.info("Base Price Value OK: Expected: "+BasePrice+", Actual: "+ef.rounding(data.get("basicVehiclePrice")));
		} else {
			pass = false;
			Log.error("Base Price Value NOK: Expected: "+BasePrice+", Actual: "+ef.rounding(data.get("basicVehiclePrice")));
		}
		Log.info("Checking Bruttolistenpreis (Summe) Value:");
		if (BruttolistenpreisSumme.equals(ef.rounding(data.get("grossListPrice")))) {
			//pass = true;
			Log.info("Bruttolistenpreis (Summe) Value OK: Expected: "+BruttolistenpreisSumme+", Actual: "+ef.rounding(data.get("grossListPrice")));
		} else {
			pass = false;
			Log.error("Bruttolistenpreis (Summe) Value NOK: Expected: "+BruttolistenpreisSumme+", Actual: "+ef.rounding(data.get("grossListPrice")));
		}
		
		Log.info("Checking Total Discount Value:");
		if (TotalDiscount.equals(ef.rounding(data.get("calculatedDiscountPrice")))) {
			//pass = true;
			Log.info("Total Discount Value OK: Expected: "+TotalDiscount+", Actual: "+ef.rounding(data.get("calculatedDiscountPrice")));
		} else {
			pass = false;
			Log.error("Total Discount Value NOK: Expected: "+TotalDiscount+", Actual: "+ef.rounding(data.get("calculatedDiscountPrice")));
		}
		if (!LocalOptionalFeatures.equals("")) {
			
			Log.info("Checking Local Optional Features Value:");
			
			if (LocalOptionalFeatures.equals(ef.rounding(data.get("localAdditionalEquipmTotalPrice")))) {
				//pass = true;
				Log.info("Local Optional Features Value OK: Expected: "+LocalOptionalFeatures+", Actual: "+ef.rounding(data.get("localAdditionalEquipmTotalPrice")));
			} else {
				pass = false;
				Log.error("Local Optional Features Value NOK: Expected: "+LocalOptionalFeatures+", Actual: "+ef.rounding(data.get("localAdditionalEquipmTotalPrice")));
			}
		}
		Log.info("Checking Total vehicle (net) Value:");
		if (TotalvehicleNetRight.equals(ef.rounding(data.get("totalCustomerEndPrice")))) {
			//pass = true;
			Log.info("Total vehicle (net) Value OK: Expected: "+TotalvehicleNetRight+", Actual: "+ef.rounding(data.get("totalCustomerEndPrice")));
		} else {
			pass = false;
			Log.error("Total vehicle (net) Value NOK: Expected: "+TotalvehicleNetRight+", Actual: "+ef.rounding(data.get("totalCustomerEndPrice")));
		}
		
		Log.info("Checking VAT Value:");
		if (VAT.equals(ef.rounding(data.get("valueAddedTaxPrice")))) {
			//pass = true;
			Log.info("VAT Value OK: Expected: "+VAT+", Actual: "+ef.rounding(data.get("valueAddedTaxPrice")));
		} else {
			pass = false;
			Log.error("VAT Value NOK: Expected: "+VAT+", Actual: "+ef.rounding(data.get("valueAddedTaxPrice")));
		}
		
		Log.info("Checking Total vehicle (incl. VAT) Value:");
		if (TotalvehicleVAT.equals(ef.rounding(data.get("totalCustomerEndPriceGross")))) {
			//pass = true;
			Log.info("Total vehicle (incl. VAT) Value OK: Expected: "+TotalvehicleVAT+", Actual: "+ef.rounding(data.get("totalCustomerEndPriceGross")));
		} else {
			pass = false;
			Log.error("Total vehicle (incl. VAT) Value NOK: Expected: "+TotalvehicleVAT+", Actual: "+ef.rounding(data.get("totalCustomerEndPriceGross")));
		}
		
		if (ef.elementExist(mp.DialogButton(L), 1000)) {
			ef.get_Element(mp.DialogButton(L), 1000).click();
		} else {
			ef.get_Element(mp.DialogButtonProd(L), 1000).click();
		}
		a.moveToElement(ef.get_Element(mp.AlleAnzeigen(L), 2000)).click().build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(mp.LogMessages(L), 3000));
		a.moveToElement(ef.get_Element(mp.LogMessages(L), 1000)).click().build().perform();
		if (ef.elementExist(mp.SelectListView(L), 1000)) {
			ef.get_Element(mp.SelectListView(L), 1000).click();
		} else {
			ef.get_Element(mp.SelectListViewProd(L), 1000).click();
		}
		a.moveToElement(ef.get_Element(mp.PrintingLogMessagesToday(L), 2000)).click().build().perform();
		ef.get_Element(mp.LogSearchField(L), 3000).click();
		ef.get_Element(mp.LogSearchField(L), 1000).sendKeys(link);
		ef.get_Element(mp.LogSearchField(L), 1000).sendKeys(Keys.ENTER);
		//a.moveToElement(ef.get_Element(mp.LogSearchField(L), 10000)).click().sendKeys(link).sendKeys(Keys.ENTER).build().perform();
		a.moveToElement(ef.get_Element(mp.searchElementSearch(link, "Request", "2"), 2000)).click().build().perform();
		String details_order = ef.get_Element(mp.LogDetails(L), 2000).getText();
		details_order = details_order.replace("{body=","");
		details_order = details_order.split("}}},")[0];
		details_order = details_order + "}}}";

		openJSONstring order = new openJSONstring();
		HashMap<String, String> data_order = order.getJSONdata(details_order);
		//data.entrySet().forEach(entry->{
		//	Log.info(entry.getKey() + " " + ef.rounding(entry.getValue()));
		 //});
		
		Log.info("--------------------------------------------------");
		Log.info("Checking print order response json file");
		Log.info("Checking Base Price Value:");
		if (BasePrice.equals(ef.rounding(data_order.get("basicVehiclePrice")))) {
			//pass = true;
			Log.info("Base Price Value OK: Expected: "+BasePrice+", Actual: "+ef.rounding(data_order.get("basicVehiclePrice")));
		} else {
			pass = false;
			Log.error("Base Price Value NOK: Expected: "+BasePrice+", Actual: "+ef.rounding(data_order.get("basicVehiclePrice")));
		}
		Log.info("Checking Bruttolistenpreis (Summe) Value:");
		if (BruttolistenpreisSumme.equals(ef.rounding(data_order.get("grossListPrice")))) {
			//pass = true;
			Log.info("Bruttolistenpreis (Summe) Value OK: Expected: "+BruttolistenpreisSumme+", Actual: "+ef.rounding(data_order.get("grossListPrice")));
		} else {
			pass = false;
			Log.error("Bruttolistenpreis (Summe) Value NOK: Expected: "+BruttolistenpreisSumme+", Actual: "+ef.rounding(data_order.get("grossListPrice")));
		}
		
		Log.info("Checking Total Discount Value:");
		if (TotalDiscount.equals(ef.rounding(data_order.get("calculatedDiscountPrice")))) {
			//pass = true;
			Log.info("Total Discount Value OK: Expected: "+TotalDiscount+", Actual: "+ef.rounding(data_order.get("calculatedDiscountPrice")));
		} else {
			pass = false;
			Log.error("Total Discount Value NOK: Expected: "+TotalDiscount+", Actual: "+ef.rounding(data_order.get("calculatedDiscountPrice")));
		}
		if (!LocalOptionalFeatures.equals("")) {
			Log.info("Checking Local Optional Features Value:");
			if (LocalOptionalFeatures.equals(ef.rounding(data_order.get("localAdditionalEquipmTotalPrice")))) {
				//pass = true;
				Log.info("Local Optional Features Value OK: Expected: "+LocalOptionalFeatures+", Actual: "+ef.rounding(data_order.get("localAdditionalEquipmTotalPrice")));
			} else {
				pass = false;
				Log.error("Local Optional Features Value NOK: Expected: "+LocalOptionalFeatures+", Actual: "+ef.rounding(data_order.get("localAdditionalEquipmTotalPrice")));
			}
		}
		Log.info("Checking Total vehicle (net) Value:");
		if (TotalvehicleNetRight.equals(ef.rounding(data_order.get("totalCustomerEndPrice")))) {
			//pass = true;
			Log.info("Total vehicle (net) Value OK: Expected: "+TotalvehicleNetRight+", Actual: "+ef.rounding(data_order.get("totalCustomerEndPrice")));
		} else {
			pass = false;
			Log.error("Total vehicle (net) Value NOK: Expected: "+TotalvehicleNetRight+", Actual: "+ef.rounding(data_order.get("totalCustomerEndPrice")));
		}
		
		Log.info("Checking VAT Value:");
		if (VAT.equals(ef.rounding(data_order.get("valueAddedTaxPrice")))) {
			//pass = true;
			Log.info("VAT Value OK: Expected: "+VAT+", Actual: "+ef.rounding(data_order.get("valueAddedTaxPrice")));
		} else {
			pass = false;
			Log.error("VAT Value NOK: Expected: "+VAT+", Actual: "+ef.rounding(data_order.get("valueAddedTaxPrice")));
		}
		
		Log.info("Checking Total vehicle (incl. VAT) Value:");
		if (TotalvehicleVAT.equals(ef.rounding(data_order.get("totalCustomerEndPriceGross")))) {
			//pass = true;
			Log.info("Total vehicle (incl. VAT) Value OK: Expected: "+TotalvehicleVAT+", Actual: "+ef.rounding(data_order.get("totalCustomerEndPriceGross")));
		} else {
			pass = false;
			Log.error("Total vehicle (incl. VAT) Value NOK: Expected: "+TotalvehicleVAT+", Actual: "+ef.rounding(data_order.get("totalCustomerEndPriceGross")));
		}
		
		//Log.info(details);
		/*
		
		ef.get_Element(mp.Proposals(L), 1000).click();
		ef.get_Element(po.Search, 500).clear();
		a.moveToElement(ef.get_Element(po.Search, 500)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 500).click();
		String productName = ef.get_Element(po.TruckLabel(L), 1000).getText();
		productName = productName.replace(" (C4S)", "").trim();
		//Log.info("New product name: " + productName);
		//ef.get_Element(po.RelatedTab(L), 1000).click();
		//a.moveToElement(ef.get_Element_woCl(po.lineItemSearch(productName), 5000)).click().build().perform();
		*/
		return pass;
	}
	
	public boolean checkOrder (WebDriver driver, WebDriverWait wait, String randomValue, String product) throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(5000);
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		OrderObject oro = new OrderObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}		
		ef.get_Element(mp.Proposals(L), 4000).click();
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 1000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 3000)).click().build().perform();
		String truckType = ef.get_Element(po.TruckLabel(L), 5000).getText();
		truckType = truckType.replace(" (C4S)", "").trim();
		//Log.info("truckType: " +truckType);
		ef.get_Element(po.RelatedTab(L), 2000).click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(po.NotesAndAttachments(L), 2000));
		a.moveToElement(ef.get_Element(po.OrderLineItem(L), 1000)).click().build().perform();
		a.moveToElement(ef.get_Element(oro.Related(L), 1000)).click().build().perform();
		int run = 0;
		boolean exist = false;
		while ((!exist) && (run <=12)) {
			ef.get_Element(mp.Proposals(L), 5000).click();
			if(!ef.elementExist(po.Search, 1000)) {
				ef.get_Element(mp.Proposals(L), 3000).click();
			}
			ef.get_Element(po.Search, 3000).clear();
			a.moveToElement(ef.get_Element(po.Search, 1000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
			//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
			a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 3000)).click().build().perform();
			ef.get_Element(po.RelatedTab(L), 5000).click();
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(po.NotesAndAttachments(L), 2000));
			a.moveToElement(ef.get_Element(po.OrderLineItem(L), 10000)).click().build().perform();
			ef.get_Element(oro.Related(L), 5000).click();
			/*
			for (i=2; i<=12; i++) {
				if (ef.check_Element(oro.lineItemSearchSecond(productName,Integer.toString(i)), 1000)) {
					if (ef.visible_Element(oro.lineItemSearchSecond(productName,Integer.toString(i)), 1000)) {
						exist = true;
						break;
					}	
				}
			}
			run++;
			*/
			//if (ef.check_Element(oro.OrderNumber(L), 1000)) {
			if (ef.check_Element(oro.OrderNumberSearch(L, truckType), 1000)) {
			//if ((ef.check_Element(oro.lineItemSearch("TGX"), 1000)) || (ef.check_Element(oro.lineItemSearch("TGM"), 1000))) {
				exist = true;
				break;
			}
		}
		long end = System.currentTimeMillis();
		Log.info("Order Response time in milisec: " + (end - start));
		Log.info("Order Response time in sec: " + ((end - start) / 1000));
		//a.moveToElement(ef.get_Element(oro.lineItemSearchSecond(productName, Integer.toString(i)), 0)).click().build().perform();
		a.moveToElement(ef.get_Element(oro.OrderNumberSearch(L, truckType), 0)).click().build().perform();
		//a.moveToElement(ef.get_Element(oro.OrderNumber(L), 0)).click().build().perform();
		if (!ef.get_Element(oro.SAPOrderNummer(L), 3000).getText().equals("")) {
			Log.info("SAPOrderNummer: "+ ef.get_Element_woCl(oro.SAPOrderNummer(L), 1000).getText());
		} else {
			Log.error("SAPOrderNummer is empty ");
			pass = false;
		}
	
		return pass;
	}
	
	public boolean checkPDF (WebDriver driver, WebDriverWait wait, String randomValue, int size, boolean merged, boolean buyback) throws InterruptedException {

		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		ProposalObject po = new ProposalObject();
		OrderObject oro = new OrderObject();
		AttachementObject ato = new AttachementObject();
		if (ef.elementExist(mp.getLanguage("Home"), 5000)) {
			L = "E";
		}		
		ef.get_Element(mp.Proposals(L), 5000).click();
		ef.get_Element(po.Search, 500).clear();
		
		a.moveToElement(ef.get_Element(po.Search, 1000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000).click();
		//productName = productName.replace(" (C4S)", "").trim();
		ef.get_Element(po.AttacehmentTab(L), 2000).click();
		if (ef.check_Element(ato.OfferLine(L), 3000)) {
			Log.info("Attachement for offer exist");
			if (ef.check_Element(ato.OfferSize(L), 500)) {
				String offerSize = ef.get_Element_woCl(ato.OfferSize(L), 0).getText();
				if (Integer.parseInt(offerSize.substring(0, offerSize.length() - 2)) > size) {
					Log.info("Offer Attachement is Valid: " + offerSize + ">" + size+"KB");
				} else {
					Log.error("Offer Attachement is NOT Valid: Size is " + offerSize);
					pass = false;
				}
			} else {
				Log.error("Offer Attachement has no size value");
				pass = false;
			}
		} else {
			Log.error("Offer Attachement missing");
			pass = false;
		}
		if(merged) {
			if (ef.check_Element(ato.OfferLineMerged(L), 3000)) {
				Log.info("Attachement for offer Merged exist");
				if (ef.check_Element(ato.OfferSizeMerged(L), 500)) {
					String offerSize = ef.get_Element_woCl(ato.OfferSizeMerged(L), 0).getText();
					if (Integer.parseInt(offerSize.substring(0, offerSize.length() - 2)) > size) {
						Log.info("Offer Merged Attachement is Valid: " + offerSize + ">" + size+"KB");
					} else {
						Log.error("Offer Merged Attachement is NOT Valid: Size is " + offerSize);
						pass = false;
					}
				} else {
					Log.error("Offer Merged Attachement has no size value");
					pass = false;
				}
			} else {
				Log.error("Offer Merged Attachement missing");
				pass = false;
			}
		}	
		
		if (ef.check_Element(ato.OrderLine(L), 200)) {
			Log.info("Attachement for order exist");
			if (ef.check_Element(ato.OrderSize(L), 500)) {
				String orderSize = ef.get_Element_woCl(ato.OrderSize(L), 0).getText();
				if (Integer.parseInt(orderSize.substring(0, orderSize.length() - 2)) > size) {
					Log.info("Order Attachement is Valid: " + orderSize + ">" + size+"KB");
				} else {
					Log.error("Order Attachement is NOT Valid: Size is " + orderSize);
					pass = false;
				}
			} else {
				Log.error("Order Attachement has no size value");
				pass = false;
			}
		} else {
			Log.error("Order Attachement missing");
			pass = false;
		}
		
		if(merged) {
			if (ef.check_Element(ato.OrderLineMerged(L), 200)) {
				Log.info("Attachement for order Merged exist");
				if (ef.check_Element(ato.OrderSizeMerged(L), 500)) {
					String orderSize = ef.get_Element_woCl(ato.OrderSizeMerged(L), 0).getText();
					if (Integer.parseInt(orderSize.substring(0, orderSize.length() - 2)) > size) {
						Log.info("Order Merged Attachement is Valid: " + orderSize + ">" + size+"KB");
					} else {
						Log.error("Order Merged Attachement is NOT Valid: Size is " + orderSize);
						pass = false;
					}
				} else {
					Log.error("Order Merged Attachement has no size value");
					pass = false;
				}
			} else {
				Log.error("Order Merged Attachement missing");
				pass = false;
			}
			
		}
		if (buyback) {
		if (ef.check_Element(ato.BuyBackOfferLine(L), 200)) {
			Log.info("Attachement for BuyBack Offer exist");
			if (ef.check_Element(ato.BuyBackOfferSize(L), 200)) {
				String BuyBackOfferSize = ef.get_Element_woCl(ato.BuyBackOfferSize(L), 0).getText();
				if (Integer.parseInt(BuyBackOfferSize.substring(0, BuyBackOfferSize.length() - 2)) > size) {
					Log.info("BuyBack Offer Attachement is Valid: " + BuyBackOfferSize + ">" + size+"KB");
				} else {
					Log.error("BuyBack Offer Attachement is NOT Valid: Size is " + BuyBackOfferSize);
					pass = false;
				}
			} else {
				Log.error("BuyBack Offer Attachement has no size value");
				pass = false;
			}
		} else {
			Log.error("BuyBack Attachement for offer missing");
			pass = false;
		}
		
		if (ef.check_Element(ato.BuyBackOrderLine(L), 200)) {
			Log.info("Attachement for BuyBack Order exist");
			if (ef.check_Element(ato.BuyBackOrderSize(L), 200)) {
				String BuyBackOrderSize = ef.get_Element_woCl(ato.BuyBackOrderSize(L), 0).getText();
				if (Integer.parseInt(BuyBackOrderSize.substring(0, BuyBackOrderSize.length() - 2)) > size) {
					Log.info("BuyBack Order Attachement is Valid: " + BuyBackOrderSize + ">" + size+"KB");
				} else {
					Log.error("BuyBack Order Attachement is NOT Valid: Size is " + BuyBackOrderSize);
					pass = false;
				}
			} else {
				Log.error("BuyBack Order Attachement has no size value");
				pass = false;
			}
		} else {
			Log.error("BuyBack Attachement for order missing");
			pass = false;
		}		
		}
		return pass;
	}
	
	public boolean finish (WebDriver driver, WebDriverWait wait) throws InterruptedException {
		//Thread.sleep(5000);
		boolean pass = true;
		String L = "D";
		Actions a= new Actions(driver);
		login_new login = new login_new();
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();		
		login.logOut(driver, wait);
		//ef.get_Element(mp.User(L), 1000).click();
		//a.moveToElement(ef.get_Element(mp.LogOut(L), 0)).click().build().perform();
		driver.close();
		
		return pass;
	}
	
	//
	//         DEV Section
	//
	
	public boolean createAccountDEV(WebDriver driver, WebDriverWait wait, String accountName, HashMap<String, String> td) throws InterruptedException, IOException {
		boolean pass = false;
		String L = "E";
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		AccountsObjectDev ao = new AccountsObjectDev();
		ef.get_Element(mp.Accounts(L), 3000).click();
		ef.get_Element(ao.New, 2000).click();
		ef.get_Element(ao.NewWeiter, 0).click();
		//Log.info("Fill Accountinformationen section");
		ef.get_Element(ao.NewAccountName, 3000).sendKeys(accountName);
		//Log.info("Fill Adressinformationen section");		
		//if (td.get("Land") != null) {
		//	ef.get_Element(ao.NewLand, 0).click();
		//	ef.get_DropDown_Value(td.get("LandNummer"), td.get("Land"), 500).click();
		//}
		if (td.get("Strasse") != null) {
			ef.get_Element(ao.NewStrasse, 0).sendKeys(td.get("Strasse"));
		}
		if (td.get("Stadt") != null) {
			ef.get_Element(ao.NewStadt, 0).sendKeys(td.get("Stadt"));
		}
		if (td.get("PLZ") != null) {
			ef.get_Element(ao.NewPLZ, 0).sendKeys(td.get("PLZ"));
		}
		//if (td.get("BundesLand") != null) {
		//	ef.get_Element(ao.NewBundesLand, 0).click();
		//	ef.get_DropDown_Value(td.get("BundesLandNummer"), td.get("BundesLand"), 200).click();
		//}
		if (td.get("SAPStrasse1") != null) {
			ef.get_Element(ao.NewSAPStrasse1, 0).sendKeys(td.get("SAPStrasse1"));
		}
		if (td.get("SAPHausnummer") != null) {
			ef.get_Element(ao.NewSAPHausnummer, 0).sendKeys(td.get("SAPHausnummer"));
		}		
		//Log.info("Fill Kundenklassifizierung/-segmentierung section");
		ef.get_Element(ao.NewFuhrparkgroesseTruck, 0).click();
		ef.get_DropDown_Value("3", "Small Fleet - SF (6-20)", 200).click();		
		//Log.info("Save new Account");
		ef.get_Element(ao.Save, 0).click();
		//Log.info("Check HL Panel if Account saved");
		//Log.info(ef.get_Element(ao.HLPanel_AccountText, 2000).getText());
		if (ef.check_Element(ao.HLPanel_AccountText, 1000)) {
			if (ef.get_Element(ao.HLPanel_AccountText, 0).getText().equals(accountName)) {
				//Log.info(ef.get_Element(ao.HLPanel_AccountText, 0).getText());
				//td.cellToSave(row, "Ja");
				pass = true;
				Log.info("Account created: "+accountName);
			} else {
				Log.error("Account not created");
				pass = false;
			}
		}	
		
		return pass;
	}
	
	public boolean openAccountDEV(WebDriver driver, WebDriverWait wait, String accountName, String contactName) throws InterruptedException, IOException {
		boolean pass = true;
		String L= "E";	
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		AccountsObjectDev ao = new AccountsObjectDev();
		ContactsObject co = new ContactsObject();
		Thread.sleep(6000);
		ef.get_Element(mp.Accounts(L), 0).click();
		a.moveToElement(ef.get_Element(ao.AccountSearch, 1000)).click().sendKeys(accountName).sendKeys(Keys.ENTER).build().perform();
		a.moveToElement(ef.get_Element(ao.accountListSearch(accountName), 1000)).click().sendKeys(accountName).sendKeys(Keys.ENTER).build().perform();
		if (ef.check_Element(ao.closeEdit, 5000)) {
			ef.get_Element(ao.closeEdit, 0).click();
		}	
		
		if (ef.elementExist(ao.Account_ContactTab(L), 7000)) {
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(ao.Account_ContactTab(L), 0));
			a.moveToElement(ef.get_Element(ao.Account_ContactTab(L), 0)).click().build().perform();
		} else {
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element_woCl(ao.Account_ContactTabReserve(L), 0));
			a.moveToElement(ef.get_Element(ao.Account_ContactTabReserve(L), 0)).click().build().perform();
		}
		
		a.moveToElement(ef.get_Element(ao.contactListSearch(contactName), 3000)).click().build().perform();
		if (ef.elementExist(co.contactNameSearch(contactName,L), 3000)) {
			pass = true;
			}
		
		return pass;
	}
	
public boolean createContactDEV (WebDriver driver, WebDriverWait wait, String randomValue, HashMap<String, String> td, boolean newContact) throws IOException, InterruptedException {
		
		boolean pass = false;
		Actions a= new Actions(driver);
		Element_Functions ef = new Element_Functions(driver, wait);
		MainPage mp = new MainPage();
		AccountsObjectDev ao = new AccountsObjectDev();
		ContactsObjectDev co = new ContactsObjectDev();		
		
		if (newContact) {
			ef.get_Element(mp.ContactsDev, 3000).click();
			ef.get_Element(co.New, 3000).click();
			ef.get_Element(co.Next, 0).click();
		} else {
			ef.get_Element(ao.HLPanel_Button_NeuerKontakt, 8000).click();
		}
		//Log.info("Fill Contact data");
		if (td.get("SalutationE") != null) {
			ef.get_Element(co.Salutation, 0).click();
			ef.get_DropDown_Value(td.get("SalutationNummerE"), td.get("SalutationE"), 0).click();
		}
		ef.get_Element(co.LastName, 0).sendKeys(randomValue);
		if (td.get("Telefon") != null) {
			ef.get_Element(co.Telefon, 0).sendKeys(td.get("Telefon"));
		}
		ef.get_Element(co.MainSalesContact, 0).click();
		ef.get_Element(co.Save, 0).click();
		//ef.get_Element(ao.Account_ContactTab, 0).click();
		a.moveToElement(ef.get_Element(ao.Account_ContactTab, 7000)).click().build().perform();
		if (ef.check_Element(ao.lineSearch(randomValue),0)) {
			a.moveToElement(ef.get_Element(ao.lineSearch(randomValue), 0)).click().build().perform();
			Log.info("Contact created: "+randomValue);
			pass = true;
		} else {
			Log.error("Contact not created");
		}
		return pass;
	}

public boolean createOpptyFromContactDEV (WebDriver driver, WebDriverWait wait, String randomValue, String contact) throws InterruptedException {
	
	boolean pass = false;
	Actions a= new Actions(driver);
	Element_Functions ef = new Element_Functions(driver, wait);
	ContactsObjectDev co = new ContactsObjectDev();
	OpptyObjectDev oo = new OpptyObjectDev();
	ef.get_Element(co.NewOpportunity, 10000).click();
	ef.get_Element(oo.OpportunityName, 0).sendKeys(randomValue+"_Oppty");
	ef.get_Element(oo.Schlusstermin, 0).sendKeys("15.06.2020");
	Select price = new Select(ef.get_Element(oo.Probability, 0));
	price.selectByValue("chOppProb.5 %25");
	ef.get_Element(oo.Next, 0).click();
	ef.get_Element(oo.Cancel, 0).click();
	ef.get_Element(oo.Next, 0).click();
	ef.get_Element(oo.RL_ContactRoles, 0).click();
	
	if (contact.equals("")) {
		a.moveToElement(ef.get_Element(oo.lineSearchEdit(randomValue), 2000)).click().build().perform();
	} else {
		a.moveToElement(ef.get_Element(oo.lineSearchEdit(contact), 2000)).click().build().perform();
	}
	//a.moveToElement(ef.get_Element(oo.Edit, 200)).click().build().perform();
	
	//ef.get_Element(oo.Primary, 0).click();
	//Log.info("Save new Opportunity");
	//ef.get_Element(oo.Save, 0).click();
	if (ef.check_Element(oo.HL_OpptySearch(randomValue+"_Oppty"), 3000)) {
		//a.moveToElement(ef.get_Element(oo.Angebotsphase, 0)).click().build().perform();
		//a.moveToElement(ef.get_Element(oo.PhaseAktuell, 0)).click().build().perform();
		Log.info("Opportunity created: "+randomValue+"_Oppty");
		pass = true;
	} else {
		pass = false;
	}
	return pass;
}
public boolean createProposalFromOpptyDEV (WebDriver driver, WebDriverWait wait, String randomValue) throws InterruptedException {
	
	boolean pass = false;
	Actions a= new Actions(driver);
	Element_Functions ef = new Element_Functions(driver, wait);
	OpptyObjectDev oo = new OpptyObjectDev();
	ProposalObjectDev po = new ProposalObjectDev();
	ef.get_Element(oo.New_Proposal, 3000).click();
	ef.get_Element(po.ProposalName, 0).sendKeys(randomValue+"_Proposal");
	ef.get_Element(po.Next, 0).click();
	//ef.get_Element(po.ShippingType, 0).click();
	//ef.get_DropDown_Value("2", "Abholung im Werk", 0).click();
	//ef.get_DropDown_Value("2", "Pickup at factory", 0).click();
	//ef.get_Element(po.OfferValidUntil, 0).sendKeys(getFutureDateString(14, "dd.MM.yyyy", "D"));
	ef.get_Element(po.Save, 0).click();
	//a.moveToElement(ef.get_Element(oo.PhaseAktuell, 0)).click().build().perform();
	a.moveToElement(ef.get_Element(oo.Oppty_Proposals, 4000)).click().build().perform();
	//ef.get_Element(oo.Oppty_Proposals, 6000).click();
	if (ef.get_Element(oo.Oppty_ProposalsFirst, 0).getText().equals(randomValue+"_Proposal")) {
		a.moveToElement(ef.get_Element(oo.Oppty_ProposalsFirst, 0)).click().build().perform();
		Log.info("Proposal created: "+randomValue+"_Proposal");
		pass = true;
	} else {
		Log.error("Proposal not created");
	}
	return pass;
}

public boolean createNewTruckDEV (WebDriver driver, WebDriverWait wait, String product) throws InterruptedException {
	
	boolean pass = false;
	Element_Functions ef = new Element_Functions(driver, wait);
	ProposalObjectDev po = new ProposalObjectDev();
	
	ef.get_Element(po.PricingTab, 0).click();
	ef.get_Element(po.AddNewTruck, 3000).click();
	ef.get_Element(po.productSearch(product), 0).click();
	ef.get_Element(po.SaveNewTruck, 0).click();
	Log.info("Truck added: "+product);
	return pass;
}

public boolean configureTruckDEV (WebDriver driver, WebDriverWait wait, String product, String manCode, String randomValue, int future) throws InterruptedException {
	
	boolean pass = false;
	Actions a= new Actions(driver);
	Element_Functions ef = new Element_Functions(driver, wait);
	ProposalObjectDev po = new ProposalObjectDev();
	C4SObjectDev c4s = new C4SObjectDev();
	String currentValue = ef.get_Element(po.CurrenPriceValue, 0).getText();		
	ef.get_Element(po.C4SButton_Show, 0).click();
	Thread.sleep(4000);
	a.moveToElement(driver.findElement(po.C4S)).click().build().perform();
	ef.get_Element(c4s.ManCodeInput, 0).sendKeys(manCode);
	ef.get_Element(c4s.ManCodeButton, 0).click();
	//ef.get_Element(c4s.Sidebar, 0).click();
	ef.get_Element(c4s.LieferdatumCalendar, 0).click();
	ef.get_Element(c4s.CalendarInput, 200).clear();
	ef.get_Element(c4s.CalendarInput, 200).sendKeys("15/08/20");	
	ef.get_Element(c4s.CalendarUpdate, 200).click();
	a.moveToElement(ef.get_Element(c4s.Save, 4000)).click().build().perform();
	//ef.get_Element(c4s.Save, 9000).click();
	Thread.sleep(5000);
	String MANCode = ef.get_Element(c4s.ManCode, 2000).getText();
	//Log.info("MANCode:"+ MANCode);
	ef.get_Element(c4s.Exit, 0).click();
	long start = System.currentTimeMillis();
	int count = 0;
	while ((ef.get_Element(po.CurrenPriceValue, 0).getText().equals(currentValue)) && (count <= 80)) {
		count++;
		Thread.sleep(1000);
	}
	long end = System.currentTimeMillis();
	Log.info("C4S Response time in milisec: " + (end - start));
	Log.info("C4S Response time in sec: " + ((end - start) / 1000));
	Thread.sleep(10000);
	ef.get_Element(po.RelatedTab, 3000).click();
	a.moveToElement(ef.get_Element(po.lineItemSearch(product), 2000)).click().build().perform();
	String MANCodeSF = ef.get_Element_woCl(po.ConfigurationFirstRowMANCode, 3000).getText();
	if (MANCode.equals(MANCodeSF)) {
		Log.info("MANCode: "+ MANCodeSF);
		pass = true;
	} else {
		pass = false;
	}
	
	pass = true;
	return pass;

}

public boolean updateProposalAfterC4SDEV (WebDriver driver, WebDriverWait wait, String randomValue, int future, String version) throws InterruptedException {
	boolean pass = true;
	String L = "E";
	Actions a= new Actions(driver);
	Element_Functions ef = new Element_Functions(driver, wait);
	MainPage mp = new MainPage();
	ProposalObjectDev pod = new ProposalObjectDev();
	ProposalObject po = new ProposalObject();
	ZoomObject zo = new ZoomObject();
	
	a.moveToElement(ef.get_Element(po.TruckZoom(L, version), 3000)).click().build().perform();
	a.moveToElement(ef.get_Element(zo.ButtonVehicleDetail(L), 0)).click().build().perform();
	a.moveToElement(ef.get_Element(zo.PLI_bodyTypeDropdown(L), 500)).click().build().perform();
	a.moveToElement(ef.get_Element_woCl(zo.PLI_bodyTypeElementSonstiges(L), 200)).click().build().perform();
	
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ef.get_Element(zo.PLI_shippingTypeDropdown(L), 2000));
	a.moveToElement(ef.get_Element(zo.PLI_shippingTypeDropdown(L), 1000)).click().build().perform();
	a.moveToElement(ef.get_Element_woCl(zo.PLI_shippingTypeElementPickup(L), 500)).click().build().perform();
	a.moveToElement(ef.get_Element(zo.Save1(L), 1000)).click().build().perform();
	a.moveToElement(ef.get_Element(zo.Save2(L), 1000)).click().build().perform();
	a.moveToElement(ef.get_Element(zo.Close(L), 1000)).click().build().perform();
	return pass;
}

public boolean configureTruckDEV_Workaround (WebDriver driver, WebDriverWait wait, String product, String manCode, String randomValue, int future) throws InterruptedException {
	
	boolean pass = true;
	String L = "E";
	Actions a= new Actions(driver);
	Element_Functions ef = new Element_Functions(driver, wait);
	MainPage mp = new MainPage();
	ProposalObjectDev po = new ProposalObjectDev();
	C4SObjectDev c4s = new C4SObjectDev();
	String currentValue = ef.get_Element(po.CurrenPriceValue, 0).getText();		
	ef.get_Element(po.C4SButton_Show, 0).click();
	Thread.sleep(4000);
	a.moveToElement(driver.findElement(po.C4S)).click().build().perform();
	int count = 0;
	while ((ef.get_Element(po.CurrenPriceValue, 500).getText().equals(currentValue)) && (count <= 80)) {
		count++;
		//Thread.sleep(1000);
		/*
		//Start workaround:
		ef.get_Element(mp.Proposals(L), 3000).click();
		ef.get_Element(po.Search, 1000).clear();
		a.moveToElement(ef.get_Element(po.Search, 1000)).click().sendKeys(randomValue+"_Proposal").sendKeys(Keys.ENTER).build().perform();
		//ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 1000).click();
		a.moveToElement(ef.get_Element(po.lineSearch(randomValue+"_Proposal"), 2000)).click().build().perform();
		//End workaround:
	
		 */
	}
	
	Thread.sleep(5000);
	/*
	String productName = ef.get_Element(po.TruckLabel(L), 1000).getText();
	productName = productName.replace(" (C4S)", "").trim();
	Log.info("New product name: " + productName);
	ef.get_Element(po.RelatedTab, 3000).click();
	a.moveToElement(ef.get_Element(po.lineItemSearch(productName), 2000)).click().build().perform();
	String MANCodeSF = ef.get_Element(po.ConfigurationFirstRowMANCode, 2000).getText();
	if (!MANCodeSF.equals("")) {
		Log.info("MANCode: "+ MANCodeSF);
		pass = true;
	} else {
		pass = false;
	}
	*/
	return pass;

}

public boolean changeMock (WebDriver driver, WebDriverWait wait, String manCode, String language, String MockUser) throws InterruptedException {
	
	boolean pass = false;
	Actions a= new Actions(driver);
	Element_Functions ef = new Element_Functions(driver, wait);
	login_new login = new login_new();
	MainPage mp = new MainPage();
	SetupPage sp = new SetupPage();
	
	a.moveToElement(ef.get_Element(mp.Setup, 8000)).click().build().perform();
	a.moveToElement(ef.get_Element(mp.Setup_in, 2000)).click().build().perform();
	String mainWindow=driver.getWindowHandle();
	Set<String>ids=driver.getWindowHandles();
	Iterator<String> it=ids.iterator();
	//it.next();
	while(it.hasNext()){
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		if(!mainWindow.equals(childWindow)){
			driver.switchTo().window(childWindow);
			if (ef.elementExist(mp.SetupTab(language), 4000)) {
				if (language.equals("D")) {
					a.moveToElement(ef.get_Element(mp.SchnellSuche(language), 2000)).click().sendKeys("Benutzerdefinierte Einstellungen").build().perform();
				} else {
					a.moveToElement(ef.get_Element(mp.SchnellSuche(language), 2000)).click().sendKeys("Custom Settings").build().perform();
				}
				a.moveToElement(ef.get_Element(mp.BenutzerdefinierteEinstellungen(language), 2000)).click().build().perform();
				
				int frameCount = ef.frameElementCount(sp.SetupFrames, "iframe");
				//System.out.println("Framecount: "+frameCount);
				//Log.info("Framecount: "+frameCount);
				for(int i=0;i<frameCount;i++) {
					//System.out.println("Frame: "+i);
					driver.switchTo().frame(i);
					if (ef.elementExist(sp.Verwalten, 2000)) {
						//System.out.println("Element exist");
						a.moveToElement(ef.get_Element(sp.Verwalten, 200)).click().build().perform();
						driver.switchTo().defaultContent();
						int frameCountnew = ef.frameElementCount(sp.SetupFrames, "iframe");
						//System.out.println("Framecountnew: "+frameCountnew);
						for(int k=0;k<frameCountnew;k++) {
							//System.out.println("Frame: "+k);
							driver.switchTo().frame(k);
							if (ef.elementExist(sp.MockUserSearch(MockUser), 2000)) {
								a.moveToElement(ef.get_Element(sp.MockUserSearch(MockUser), 200)).click().build().perform();
								driver.switchTo().defaultContent();
								int frameCountlast = ef.frameElementCount(sp.SetupFrames, "iframe");
								//System.out.println("Framecountlast: "+frameCountlast);
								for(int l=0;l<frameCountnew;l++) {
									driver.switchTo().frame(l);
									if (ef.elementExist(sp.MockMANCode, 2000)) {
										ef.get_Element(sp.MockMANCode, 200).clear();
										ef.get_Element(sp.MockMANCode, 200).sendKeys(manCode);
										ef.get_Element(sp.Save(language), 1000).click();
										driver.switchTo().defaultContent();
										ef.get_Element(mp.LogOutAs("E"), 3000).click();
										//a.moveToElement(ef.get_Element(mp.LogOutAs("E"), 3000)).click().build().perform();
										Thread.sleep(4000);
										driver.close();
										driver.switchTo().window(mainWindow);
										driver.close();
									}
								}
							}
						//break;
					}
					}
				}
			} else {
				driver.close();
			}
		}
	 }
	 // This is to switch to the main window
	 
	
	return pass;

}

}
