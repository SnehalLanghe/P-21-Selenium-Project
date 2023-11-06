package loginPageFunctionality;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CallingPOM {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Object Creation and calling methods
		LoginPage loginP=new LoginPage(driver);
		loginP.url();
		
		HomePageVerification homePV= new HomePageVerification(driver);
		homePV.lunchURL();
		homePV.login();		
		homePV.verifyHomepageLogo();
		homePV.VerifyAboutPage();
		homePV.CloseAboutPage();
		homePV.HPDriverClose();
		
		PerformanceModule PM= new PerformanceModule(driver);
		PM.PMlunchURL();
		PM.loginOHRM();
		PM.openPerformanceModule();
		PM.verifyConfigure();
		PM.verifyKPI();
		PM.resetKPI();
		PM.verifyTracker();
		PM.resetTracker();
		PM.refreshPage();
		PM.OpenManageReviews();
		PM.OpenEmpReviews();
		PM.OpenMyTrackers();
		PM.OpenEmpTrackers();
		PM.PMDriverClose();
		
		
	}

}
