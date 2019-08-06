package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import  static tests.Baseclass.*;
import static utilis.ReportUtilis.updateReport;

public class Browser {

	 
	
	
	public void openBrowser() throws Exception {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		updateReport("info","BrowserSetup","");
		
		
	}

	public void luanchUrl() throws Exception {
		driver.get("https://www.cleartrip.com/");
		updateReport("info","launch Browser","");
		
		
	}

	public void maximizeBrowser() throws Exception {
		driver.manage().window().maximize();
		updateReport("info","maximazie browser","");
		updateReport("info","launch Browser","");
		

	}

	public void closeBrowser() throws Exception {
driver.quit();
updateReport("info","close browser","");
	}
}
