package components;

import static tests.Baseclass.driver;
import static utilis.ReportUtilis.updateReport;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Flights {

	public void verfifyHomePage() throws Exception {
		
		if(driver.findElement(By.xpath("//li[@class='flightApp']//a[contains(text(),'Flights')]")).isDisplayed())
		{
			System.out.println("in homepage");
		}
		else
		{
			System.out.println("not in homepage");
		}
		updateReport("pass","HomePage","");
	}

	public void searchFlights() throws Exception {
		
		
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("Hyderabad, IN - Rajiv Gandhi International (HYD)");
		driver.findElement(By.xpath("//input[@id='ToTag']")).sendKeys("Bangalore, IN - Kempegowda International Airport (BLR)");
		driver.findElement(By.xpath("//dl[@class='vertical']//i[@class='icon ir datePicker'][contains(text(),'Cal')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default')][contains(text(),'26')]")).click();
		driver.findElement(By.xpath("//select[@id='Adults']"));
		
		Select  s= new Select(driver.findElement(By.xpath("//select[@id='Adults']")));
		
		s.selectByIndex(3);
		
		
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		
		
		updateReport("info","search flights","");
		
	}

	

	public void verifyListOfFligtsPage() throws Exception {
		
		if(driver.findElement(By.xpath("//li[@class='flightApp']//a[contains(text(),'Flights')]")).isDisplayed())
		{
			updateReport("pass","home","");
		}
		else
		{
			updateReport("fail","homepage","");
		}

	}

}
