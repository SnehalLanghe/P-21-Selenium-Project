package loginPageFunctionality;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageVerification {
	WebDriver driver;
	public HomePageVerification(WebDriver ldriver) {
		driver=ldriver;
	}
	String filePath = "C://Users//Abhijeet//Documents//Snehal Selenium Testing//Data Driver Files/OrangeHRMHM.xlsx";

	//Repository of an element
	By UserName=By.name("username");
	By Password=By.name("password");
	By Submit=By.xpath("//button[@type='submit']");
	By HomePLogo=By.xpath("//div[@class='oxd-brand-banner'][1]");
	By DropDown=By.xpath("//span[@class='oxd-userdropdown-tab'][1]//child::p[@class='oxd-userdropdown-name'][1]//following::i[1]");
	By DDValue1=By.xpath("//a[@class='oxd-userdropdown-link'][1]");
	By DisplyAbout=By.xpath("//div[@class='orangehrm-modal-header']//child::h6");
	By CloseAboutP=By.xpath("//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']");
	By companynamelink=By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//child::p[@class='oxd-text oxd-text--p orangehrm-about-title'][1]");
	By cnamelink=By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][2]//child::p[@class='oxd-text oxd-text--p orangehrm-about-text'][1]");
	By SupportLink=By.xpath("//ul[@class='oxd-dropdown-menu']//child::li[2]//child::a[@class='oxd-userdropdown-link'][1]");
	By VerifySupport=By.xpath("//div[@class='orangehrm-card-container']//child::h6");
	
	@BeforeSuite
	public void lunchURL() throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}

	@Test(priority = 1, description = "Login with valid username and valid password")

	public void login() throws IOException {
		
			Stopwatch watch = null;

			try {
				watch = Stopwatch.createStarted();
				driver.findElement(UserName).clear();
				driver.findElement(UserName).sendKeys("Admin"); 
				driver.findElement(Password).clear();
				driver.findElement(Password).sendKeys("admin123");
				driver.findElement(Submit).click();
				Thread.sleep(2000);

			} catch (Exception e) {
				watch.stop();
				System.out.println(e);
				System.out.println(watch.elapsed(TimeUnit.SECONDS) + "Seconds");
			
			}
		}
		
		@Test(priority = 2, description = "Verify the HomePage Logo")
		public void verifyHomepageLogo()
		{
			WebElement Logo = driver.findElement(HomePLogo);
			if(Logo.isDisplayed())
			{
				System.out.println("Orange HRM logo is present");
			}
			else
			{
				System.out.println("Orange HRM logo is not present");
			}
		}
	
		@Test(priority = 3, description = "Verify the About Page")
		public void VerifyAboutPage() throws InterruptedException
		{
			driver.findElement(DropDown).click();
			driver.findElement(DDValue1).click();
			Thread.sleep(2000);
			WebElement About=driver.findElement(DisplyAbout);
			if(About.isDisplayed())
			{
				System.out.println("About Page Present");
			}
			else
			{
				System.out.println("AboutPage not present");
			}
		}
		
		@Test(priority = 4, description = "Close About Page")
		public void CloseAboutPage()
		{
			driver.findElement(CloseAboutP).click();
		}
		
		@Test(priority = 5, description = "Print the About Page details")
		public void PrintAboutPDetails() throws InterruptedException
		{
			driver.findElement(DropDown).click();
			driver.findElement(DDValue1).click();
			Thread.sleep(2000);
			WebElement CompanyName=driver.findElement(companynamelink);
			List<WebElement> CName=driver.findElements(cnamelink);
			System.out.println(CompanyName +" "+ CName);
			driver.findElement(CloseAboutP).click();
		}
		
		@Test(priority = 6, description = "Verify the Support Page")
		public void VerifySupportPage() throws InterruptedException
		{
			driver.findElement(DropDown).click();
			driver.findElement(SupportLink).click();
			Thread.sleep(3000);
			WebElement Support=driver.findElement(VerifySupport);
			if(Support.isDisplayed())
			{
				System.out.println("Support Page Present");
			}
			else
			{
				System.out.println("Support not present");
			}
		}
		
		@AfterSuite
		public void HPDriverClose()
		{
			driver.close();
		}
	}

