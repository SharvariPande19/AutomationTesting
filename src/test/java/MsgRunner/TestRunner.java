package MsgRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\Features\\Msg.feature",
glue="StepDefinition",
//tags="@newconversation" )
plugin= {"pretty" , "html:target/HTMLReports/LinkdInReport.html",
		"json:target/JSONReports/LinkdInReport.json",
		"junit:target/JUNITReports/LinkdInReport.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})

public class TestRunner extends AbstractTestNGCucumberTests{
	
	

}