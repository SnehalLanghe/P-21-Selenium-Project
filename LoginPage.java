package loginPageFunctionality;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Stopwatch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		driver=ldriver;
	}
	
	//Repository of an element
	
	By Username=By.name("username");
	By Password=By.name("password");
	By Submit=By.xpath("//button[@type='submit']");
	By DropDown=By.xpath("//span[@class='oxd-userdropdown-tab'][1]//child::p[@class='oxd-userdropdown-name'][1]//following::i[1]");
	By Logout=By.linkText("Logout");
	
	public void  url() throws InterruptedException, IOException
	{
	//public static void main(String[] args) throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
		String filePath="C://Users//Abhijeet//Documents//Snehal Selenium Testing//Data Driver Files/Creds.xlsx";
		FileInputStream file=new FileInputStream(filePath);
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Data");
		
		int rows=sheet.getLastRowNum();
		System.out.println("Total number of Rows = "+rows);
	
		for(int i=1; i<=rows; i++)
		{
			XSSFRow row=sheet.getRow(i);
			XSSFCell username=row.getCell(0);
			XSSFCell password=row.getCell(1);
			XSSFCell result=row.createCell(2);
			System.out.println("Username As--> "+ username);
			System.out.println("Password As--> "+ password);
			Stopwatch watch=null;
			
			try {
			watch=Stopwatch.createStarted();
			driver.findElement(Username).clear();
			driver.findElement(Username).sendKeys(username.toString()); //Added tostring becacuse emailID has interger value we need to convert it
			driver.findElement(Password).clear();
			driver.findElement(Password).sendKeys(password.toString());
			driver.findElement(Submit).click();
			Thread.sleep(2000);
			
			driver.findElement(DropDown).click();
			driver.findElement(Logout).click();
			
			System.out.println("Credential is Valid = "+username +" and " +password );
			result.setCellValue("Valid");
			//Thread.sleep(2000);
			}
			catch (Exception e) {
				
				WebElement errorContainer = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
				String headerError=errorContainer.getText();
				System.out.println("Credential is Invalid = "+username +" and " +password);
				result.setCellValue("Invalid");
				//result.setCellValue(headerError+" "+headerErrorList);
				result.setCellValue(headerError);
				driver.navigate().refresh();
				watch.stop();
				//Thread.sleep(3000);
			}
		}
		file.close();
		//Close file if we want to enter output in file
		//write output in file
		FileOutputStream fileOutput= new FileOutputStream(filePath);
		workbook.write(fileOutput);
}
}
