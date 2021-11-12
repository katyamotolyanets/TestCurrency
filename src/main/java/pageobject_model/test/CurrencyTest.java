package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.CurrencyTradingPlatformPage;


public class CurrencyTest {
    private WebDriver driver;
    public CurrencyTradingPlatformPage currencyPage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        currencyPage = new CurrencyTradingPlatformPage(driver);
        driver.manage().window().maximize();
    }

    @Test(description = "Buy 10 tokens of Gold on Currency.com")
    public void buyTokensOnCurrency() {
        currencyPage.logInToCurrencyTradingPlatform()
                .changeAccountToDemo()
                .buyToken();

        Assert.assertTrue(currencyPage.haveTokensBeenBought());
    }
    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }

}
