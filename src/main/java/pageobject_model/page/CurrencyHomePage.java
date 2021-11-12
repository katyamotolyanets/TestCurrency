package pageobject_model.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CurrencyHomePage extends BasePage {
    private static final String HOMEPAGE_URL = "https://currency.com/ru";

    @FindBy(css = "a[class='loginBtn js_login']")
    private WebElement loginButton;

    public CurrencyHomePage(WebDriver driver) {
        super(driver);
    }

    public CurrencyHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CurrencyLoginPage openLoginWindow() {
        loginButton.click();
        return new CurrencyLoginPage(driver);
    }
}
