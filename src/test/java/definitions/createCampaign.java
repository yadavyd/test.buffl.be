package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Page;

import javax.swing.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class createCampaign extends Page {
    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        click(getByXpath("//*[contains(text(),'"+button+"')]"));
    }

    @Then("user is navigated to form builder page")
    public void userIsNavigatedToFormBuilderPage() {
        waitForSpecificPage("clients/campaign");
    }

    @Then("user verifies that build container has {string} item")
    public void userVerifiesThatBuildContainerHasItem(String button) {
        waitForLittle(getByXpath("//div[contains(text(),'"+button+"')]"));
    }

    @Then("user verifies that text {string} is present")
    public void userVerifiesThatTextIsPresent(String arg0) {
        waitForLittle(getByXpath("//*[contains(text(), '"+arg0+"')]"));
    }

    @Then("user clicks on the logo of the header")
    public void userClicksOnTheLogoOfTheHeader() {
        click(getByXpath("//img[@class='AppBar_bufflLogoWhiteSmall__1bNE5']"));
    }

    @Then("user is navigated to campaign page")
    public void userIsNavigatedToCampaignPage() {
        waitForSpecificPage("/clients/");
    }

    @Then("user verifies that campaign {string} is present on my campaign page")
    public void userVerifiesThatCampaignIsPresentOnMyCampaignPage(String name) {
        waitForLittle(getByXpath("//div[@class='list-item-container']//div[contains(text(),'"+name+"')]"));
    }

    @When("user fills out {string} field with {string}")
    public void userFillsOutFieldWith(String field, String text) throws InterruptedException {
        Thread.sleep(400);
        switch	(field)	{
            case	"Amount of responses required":
            case	"Minimum Answer Length":
            case	"Maximum Answer Length":
            case	"Website URL":
                WebElement element = getByXpath("//*[contains(text(),'"+field+"')]//..//input");
                sendKeys(element, text);
                break;
            default:	sendKeys(getByXpath("//*[contains (@placeholder,'"+field+"')]"), text);
                break;
        }

    }

    @When("user drag and drop {string} to the question block")
    public void userDragAndDropToTheQuestionBlock(String button) throws InterruptedException {
        waitForLittle(getByXpath("//div[contains(text(),'"+button+"')]"));
        new Actions(getDriver())
//                .moveToElement(source)
//                .pause(Duration.ofSeconds(1))
//                .clickAndHold(getByXpath("(//div[contains(text(),'"+button+"')]//..//..//div[@tabindex])[1]"))
                .clickAndHold(getByXpath("//div[contains(text(),'"+button+"')]"))
                .pause(Duration.ofSeconds(1))
                .moveByOffset(719, 61)
                .moveToElement(getByXpath("//div[@class='block-dropdown']"))
                .moveByOffset(719, 61)
                .pause(Duration.ofSeconds(1))
                .release().perform();
//        Thread.sleep(3000);
    }

    @Then("user verifies that row {string} contains {string}")
    public void userVerifiesThatRowContains(String arg0, String number) {
        String string = getByXpath("//div[@class='toggle-and-label-column']//..//./input").getAttribute("value");
        assertThat(string).containsIgnoringCase(number);
    }

    @Then("user verifies that row {string} is {string}")
    public void userVerifiesThatRowIs(String row, String status) {
        String element = getByXpath("//div[contains(text(),'"+row+"')]/..//div[3]").getAttribute("class");
        assertThat(element).containsIgnoringCase(status);
    }

    @Then("user verifies that campaign {string} has amount {string}")
    public void userVerifiesThatCampaignHasAmount(String name, String number) {
        waitForLittle(getByXpath("//div[@class='list-item-container']//div[contains(text(), '"+name+"')]//..//..//div[contains(text(), '"+number+"')]"));
    }

    @Then("user verifies that campaign {string} has status {string}")
    public void userVerifiesThatCampaignHasStatus(String name, String status) {
        waitForLittle(getByXpath("//div[@class='list-item-container']//div[contains(text(), '"+name+"')]//..//..//div[contains(text(), '"+status+"')]"));
    }



    //div[@class='list-item-container']//div[contains(text(), 'test')]//..//..//div[contains(text(), 'Missing Required Data')]
}
