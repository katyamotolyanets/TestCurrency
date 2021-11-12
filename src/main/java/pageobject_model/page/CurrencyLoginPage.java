package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyLoginPage extends BasePage {

    @FindBy(css = "input[name='email']")
    private WebElement fieldForEmail;

    @FindBy(css = "input[name='password']")
    private WebElement fieldForPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement submitLogInButton;

    protected CurrencyLoginPage(WebDriver driver) {
        super(driver);
    }

    public CurrencyLoginPage enterEmail(String email) {
        waitForVisibilityOfElement(driver, fieldForEmail);
        fieldForEmail.sendKeys(email);
        return this;
    }

    public CurrencyLoginPage enterPassword(String password) {
        waitForVisibilityOfElement(driver, fieldForPassword);
        fieldForPassword.sendKeys(password);
        return this;
    }

    public CurrencyTradingPlatformPage signIn() {
        waitForElementToBeClickable(driver, submitLogInButton);
        submitLogInButton.click();
        return new CurrencyTradingPlatformPage(driver);
    }
}
