package com.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
 
@CucumberOptions(tags = "", features = "src/test/resources/Features/SwiggyTestngfeature.feature", glue = "stepDefinition")

public class RunnerClass extends AbstractTestNGCucumberTests {
	

}







