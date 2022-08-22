package utilities;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	
   static ExtentReports report;
    
   public static  ExtentReports getExtentReport() {
		
		String path = System.getProperty("user.dir")+"\\reports\\intex.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Solid Cab Test Report");
		reporter.config().setDocumentTitle("SolidCab report title");
		
		report = new ExtentReports();
		
		report.attachReporter(reporter);
		report.setSystemInfo("Operating System", "Windows 11");
		report.setSystemInfo("Tested by ", "Abhijeet Ghodke");
		
		return report;
}
}
