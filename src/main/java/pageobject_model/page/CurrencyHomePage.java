package pageobject_model.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrencyHomePage {
    private static final String HOMEPAGE_URL = "https://currency.com/ru";

    private WebDriver driver;

    @FindBy(css = "a[class='loginBtn js_login']")
    private WebElement loginButton;

    @FindBy(css = "input[name='email']")
    private WebElement fieldForEmail;

    @FindBy(css = "input[name='password']")
    private WebElement fieldForPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement submitLogInButton;

    public CurrencyHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CurrencyHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CurrencyHomePage logIntoAccount(String email, String password) {
        loginButton.click();
        waitForVisibilityOfElement(driver, fieldForEmail);
        fieldForEmail.sendKeys(email);
        fieldForPassword.sendKeys(password);
        waitForElementToBeClickable(driver, submitLogInButton);
        submitLogInButton.click();
        return this;
    }

    protected static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
