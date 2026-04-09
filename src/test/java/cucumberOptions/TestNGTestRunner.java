package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="src/test/resources/Feature/TC25_VerifyScrollUp.feature",glue="stepDefinations",monochrome=true,
plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	
//@Override
//@DataProvider(parallel=true)
//public Object[][] scenarios()
//{
//	return super.scenarios();	
//}
	
	
}
