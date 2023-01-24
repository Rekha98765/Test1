package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = "C:\\Users\\Mudea.Rekha\\OneDrive - parasemper.com\\Desktop\\Projects\\features\\tech.feature",
      		        tags = "@tag2",
				    glue = "steps",
				    monochrome = false,
				    dryRun = false,
					plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json","junit:target/cucumber-reports.xml",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
								}
				)



public class TestRunner {
	
	
}
