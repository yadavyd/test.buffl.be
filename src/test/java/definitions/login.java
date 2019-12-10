package definitions;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import pages.Page;

public class login extends Page {

    @Given("client sign in using credentials: Email {string} and Password {string}")
    public void clientSignInUsingCredentialsEmailAndPassword(String email, String password) throws InterruptedException {
        getDriver().get("https://test.buffl.be/clients/auth/login");
        waitForVisible(getByXpath("//div[@class='form-container']//form"));
        sendKeys(getByXpath("//input[@placeholder='Email']"), email);
        sendKeys(getByXpath("//input[@placeholder='Password']"),password);
        click(getByXpath("//button[@class='button']"));
        waitForPresence(By.xpath("//div[@class='AppBar_clientEmail__1Sodc'][contains(text(), '"+email+"')]"));
        waitForVisible(getByXpath("//div[@class='campaigns-table-header']"));
    }
}
