package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.CurrencyHomePage;
import pageobject_model.page.CurrencyTradeTab;
import pageobject_model.page.CurrencyTradingPlatformPage;

public class CurrencyTest {
    private WebDriver driver;
    private CurrencyTradingPlatformPage currencyTradingPlatformPagePage;
    private CurrencyTradeTab currencyTradeTab;

    private String email = "katyamotolyanets@mail.ru";
    private String password = "K@tya2112";
    private String quantity = "10";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        currencyTradingPlatformPagePage = new CurrencyHomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterEmail(email)
                .enterPassword(password)
                .signIn();
    }

    @Test(description = "Buy 10 tokens of Gold on Currency.com")
    public void buyTokensOnCurrency() {
        currencyTradeTab = currencyTradingPlatformPagePage.changeAccountToDemo()
                    .clickBuyToken()
                    .enterQuantityOfTokensForBuying(quantity)
                    .confirmBuyingOfTokens();

        Assert.assertTrue(currencyTradeTab.haveTokensBeenBought());
    }

    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }

}
