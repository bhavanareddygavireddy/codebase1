package utilis;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

import static com.relevantcodes.extentreports.LogStatus.*;

import  static tests.Baseclass.*;

public class ReportUtilis {
	
	
	
	public static void updateReport(String status, String msg, String screenShotName) throws Exception {

		switch (status) {
		case "pass":
			test.log(LogStatus.PASS, msg + test.addScreenCapture(captureScreenShot(screenShotName)));
			break;

		case "fail":
			test.log(LogStatus.FAIL, msg + test.addScreenCapture(captureScreenShot(screenShotName)));
			break;
		case "info":
			test.log(LogStatus.INFO, msg);

			break;
		default:
			break;
		}

	}

	public static String captureScreenShot(String screenShotName) throws Exception {
		String screenPath = System.getProperty("user.dir") + "/target/" + screenShotName + ".png";
		File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp, new File(screenPath));
		return screenPath;
	}

}



