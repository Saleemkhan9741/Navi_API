package Navi.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/test.feature",
        glue = {"Navi.StepDefs","listener"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}