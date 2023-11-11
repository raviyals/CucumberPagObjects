package runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features={"src/test/resources/features"},
		glue={"steps"},
		monochrome=true,
		tags={"@Search-Cars,@Used-Search-Cars"},
		plugin= {"json:target/RunCukeTest/cucumber.json","pretty","html:target/RunCukeTest/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"}
		)
public class RunCukeTest extends AbstractTestNGCucumberTests{

	@BeforeClass
	public static void setup()
	{
		// Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String fileName = System.getProperty("user.dir")+"\\target\\Extent_Reports\\" + strDate+".html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,false);
		
		//Loads the extent config xml to customize on the report.
		ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

		//User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "FireFox");
		ExtentCucumberFormatter.addSystemInfo("Browser Version", "v119.0.1");
		ExtentCucumberFormatter.addSystemInfo("Selenium Version", "v3.149.59");
	
        // Also you can add system information using a hash map
        Map<String,String> systemInfo = new HashMap<>();
        systemInfo.put("Cucumber version", "v1.2.5");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
		
	}
}
