package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
