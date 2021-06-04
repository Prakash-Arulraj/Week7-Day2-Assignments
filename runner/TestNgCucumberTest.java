package runner;

import hooks.TestNgHooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        dryRun = false,
        features = {"src/main/java/features/CreateLead.feature"},
        glue = {"Pages","hooks"},
        monochrome = true
        
        )
        
public class TestNgCucumberTest extends AbstractTestNGCucumberTests {
				
		

	}


