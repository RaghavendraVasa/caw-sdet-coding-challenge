package runner;


import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features"
        ,glue={"org.automationRunUp.stepDef"}
) public class TestRunner {

}