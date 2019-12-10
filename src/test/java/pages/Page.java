package pages;
import com.sun.codemodel.JTryBlock;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class Page {

    private String url;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement getByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public void moveToElement(WebElement element) {
        new Actions(getDriver()).moveToElement(element).perform();
    }

    public void clickWithJS(WebElement element) {
        getExecutor().executeScript("arguments[0].click();",element);
    }

    public void waitForVisible(WebElement element) {
        new WebDriverWait(getDriver(), 8).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForLittle(WebElement element) {
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOf(element));
    }

    public void textToBeVisble (By by, String clipname){
        new WebDriverWait(getDriver(), 7).until(ExpectedConditions.textToBePresentInElementLocated(by, clipname));
    }

    public  void waitForChangingUrl(String currentUrl) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
    }

    public void waitForClickable(WebElement element) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));
    }


    public void click(WebElement element) {
        waitForClickable(element);
        try {
            element.click();
        } catch (WebDriverException e) {
            clickWithJS(element);
        }
    }

    public void sendKeys(WebElement element, String text) {
        waitForVisible(element);
        element.sendKeys(text);
    }

    public void open() {
        getDriver().get(url);
    }

    public void waitForPresence(By by) throws InterruptedException {
         new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public String waitForSpecificPage(String urlToWaitFor) {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains(urlToWaitFor));
            return urlToWaitFor;
    }

    public static String returnDateStamp() {

//        String pattern = "MM-dd-yyyy";
        String pattern = "dd MMMM , yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }


}