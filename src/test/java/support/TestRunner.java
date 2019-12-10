package support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
//import com.cucumber.listener.Reporter;
//import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/report.json", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
        features = "src/test/resources/features",
        glue = {"definitions", "support"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setup() {
        System.out.println("BeforeAll");
    }

    @AfterClass
    public static void teardown() throws IOException {
        System.out.println("AfterAll");
    }
}
