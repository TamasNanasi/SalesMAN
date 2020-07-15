package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public By username = By.id("username");
	public By password = By.id("password");
	public By login = By.id("Login");
	
	public By Test01Salesrep = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[1]/li[1]/a");
	public By Test02Salesrep = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[1]/li[2]/a");
	public By Test03Salesrep = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[1]/li[3]/a");
	public By Test05Salesrep = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[1]/li[4]/a");
	public By Test07Salesrep = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[1]/li[5]/a");
	public By TiemannTest01 = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[1]/li[6]/a");
	public By Test01SalesSupport = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[3]/li[1]/a");
	public By Test01SalesAdmin = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[3]/li[3]/a");
	public By Test01SalesManager = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[2]/li[1]/a");
	public By Test05SalesManager = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/div/div[1]/ul[2]/li[2]/a");

}
