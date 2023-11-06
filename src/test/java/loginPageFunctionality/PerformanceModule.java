package loginPageFunctionality;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PerformanceModule {
	WebDriver driver;

	public PerformanceModule(WebDriver ldriver) {
		driver = ldriver;
	}

	// Repository of an element
	By UserName = By.name("username");
	By Pass = By.name("password");
	By Submit = By.xpath("//button[@type='submit']");
	By OpenPerformanceM = By.xpath(
			"//ul[@class='oxd-main-menu']//child::li[7]//child::span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][1]");
	By VConfigure = By
			.xpath("//div[@class='oxd-topbar-body']//child::li[1]//child::span[@class='oxd-topbar-body-nav-tab-item']");
	By VCValue1 = By
			.xpath("//ul[@class='oxd-dropdown-menu']//child::li[1]//child::a[@class='oxd-topbar-body-nav-tab-link']");
    By JobValue=By.xpath("//div[@class='oxd-select-text-input'][1]");
	By SubmitJob=By.xpath("//button[@type='submit']");
	By ClickReset=By.xpath("//button[@type='reset']");
	By VerifyPMTracker=By.xpath("//div[@class='oxd-topbar-body']//child::li[1]//child::span[@class='oxd-topbar-body-nav-tab-item']");
	By VerifyTrackerValue=By.xpath("//ul[@class='oxd-dropdown-menu']//child::li[2]//child::a[@class='oxd-topbar-body-nav-tab-link']");
	By VTPMVlaue1=By.xpath(
			"//div[@class='oxd-autocomplete-wrapper'][1]//child::div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active'][1]//child::input[1]");
	By SubmitBtn=By.xpath("//button[@type='submit']");
	By ResetTrackerPM=By.xpath("//button[@type='button']");
	By PMOpenManageReviews=By.xpath(
			"//div[@class='oxd-topbar-body']//child::li[2]//child::span[@class='oxd-topbar-body-nav-tab-item']");
	By PMOpenManageRVlaue=By.xpath(
			"//ul[@class='oxd-dropdown-menu']//child::li[2]//child::a[@class='oxd-topbar-body-nav-tab-link']");
	By PMOpenEmpReviews=By.xpath(
			"//div[@class='oxd-topbar-body']//child::li[2]//child::span[@class='oxd-topbar-body-nav-tab-item']");
	By PMOpenEmpReviewsValue=By.xpath(
			"//ul[@class='oxd-dropdown-menu']//child::li[3]//child::a[@class='oxd-topbar-body-nav-tab-link']");
	By PMOpenMyTrackers=By.xpath(
			"//div[@class='orangehrm-header-container']//child::h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'][1]");
	By PMOpenEmpTrackers=By.linkText("Employee Trackers");
	By PMCMPValue=By.xpath(
			"//div[@class='oxd-table-filter-header-title']//child::h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title'][1]");
	
	
	
	
	@BeforeSuite
	public void PMlunchURL() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
	}

	@Test(priority = 1, description = "Login into the portal")

	public void loginOHRM() throws IOException, InterruptedException {
		driver.findElement(UserName).clear();
		driver.findElement(UserName).sendKeys("Admin");
		driver.findElement(Pass).clear();
		driver.findElement(Pass).sendKeys("admin123");
		driver.findElement(Submit).click();
		Thread.sleep(2000);
	}

	@Test(priority = 2, description = "Open Performance Module")
	public void openPerformanceModule() throws IOException, InterruptedException {
		driver.findElement(OpenPerformanceM).click();
		Thread.sleep(2000);
	}

	@Test(priority = 3, description = "Verify Configure")
	public void verifyConfigure() throws IOException, InterruptedException {
		driver.findElement(VConfigure).click();
		Thread.sleep(1000);
		driver.findElement(VCValue1).click();
		Thread.sleep(1000);
	}

	@Test(priority = 4, description = "Verify Key Performance Indicators for Job Title")
	public void verifyKPI() throws InterruptedException {
		WebElement Job = driver.findElement(JobValue);
		Job.click();
		Actions keyDown = new Actions(driver);
		keyDown.sendKeys(Keys.chord(Keys.DOWN)).perform();
		driver.findElement(SubmitJob).click();
	}

	@Test(priority = 5, description = "Reset Key Performance Indicators for Job Title")
	public void resetKPI() throws InterruptedException {
		WebElement Job1 = driver.findElement(JobValue);
		driver.findElement(ClickReset).click();
	}

	@Test(priority = 6, description = "Verify Tracker")
	public void verifyTracker() throws InterruptedException {
		driver.findElement(VerifyPMTracker)
				.click();
		Thread.sleep(1000);
		driver.findElement(VerifyTrackerValue).click();
		Thread.sleep(1000);

		Thread.sleep(1000);
		driver.findElement(VTPMVlaue1)
				.sendKeys("Paul Collings");
		driver.findElement(SubmitBtn).click();
		Thread.sleep(1000);
	}

	@Test(priority = 7, description = "Reset Tracker")
	public void resetTracker() throws InterruptedException {
		driver.findElement(ResetTrackerPM).click();
	}

	@Test(priority = 8, description = "Refresh Page")
	public void refreshPage() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

	@Test(priority = 9, description = "Open My Reviews ")
	public void OpenManageReviews() throws IOException, InterruptedException {
		driver.findElement(PMOpenManageReviews)
				.click();
		Thread.sleep(1000);
		driver.findElement(PMOpenManageRVlaue)
				.click();
		Thread.sleep(1000);
	}

	@Test(priority = 10, description = "Open Employee Reviews")
	public void OpenEmpReviews() throws IOException, InterruptedException {
		driver.findElement(PMOpenEmpReviews)
				.click();
		Thread.sleep(1000);
		driver.findElement(PMOpenEmpReviewsValue)
				.click();
		Thread.sleep(1000);
	}

	@Test(priority = 11, description = "Open My Trackers")
	public void OpenMyTrackers() throws IOException, InterruptedException {
		driver.findElement(By.linkText("My Trackers")).click();
		Thread.sleep(2000);
		WebElement MPT = driver.findElement(PMOpenMyTrackers);
		if (MPT.isDisplayed()) {
			System.out.println("My Performance Trackers is present");
		} else {
			System.out.println("My Performance Trackers is not present");
		}
	}

	@Test(priority = 12, description = "Open Employee Trackers")
	public void OpenEmpTrackers() throws IOException, InterruptedException {
		driver.findElement(PMOpenEmpTrackers).click();
		Thread.sleep(2000);
		WebElement EPT = driver.findElement(PMCMPValue);
		if (EPT.isDisplayed()) {
			System.out.println("My Employee Trackers is present");
		} else {
			System.out.println("My Employee Trackers is not present");
		}

	}

	@AfterSuite
	public void PMDriverClose() {
		driver.close();
	}

}
