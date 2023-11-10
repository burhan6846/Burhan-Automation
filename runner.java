package testRunner;

        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ={"./src/test/resources/Features/SauceDemo.Feature"},
        glue = "stepDefinitions",
        plugin= {"pretty",//give output in console
                "html:Test-Output/html-report/report.html",
                "json:Test-Output/json-report/report.json",
                "junit:Test-Output/xml-report/report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class runner {
}
