package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyTradingPlatformPage extends BasePage{

    @FindBy(css = "div[class='btn-menu']")
    private WebElement accountMenu;

    @FindBy(xpath = "//div[@class='account-popup__box ng-star-inserted']/p[contains(text(), 'Перейти на демо-аккаунт')]")
    private WebElement demoAccountMenuItem;

    @FindBy(xpath = "//div[contains(text(), 'Bitcoin / USD')]/../following-sibling::div[@class='col buy']/button[contains(text(), 'Купить')]")
    private WebElement buttonBuyBitcoinTokenInWishlist;

    @FindBy(xpath = "//div[contains(text(), 'Активно растущие рынки')]")
    private WebElement activelyGrowingMarketsTab;

    public CurrencyTradingPlatformPage(WebDriver driver) {
        super(driver);
    }

    public CurrencyTradingPlatformPage changeAccountToDemo() {
        waitForElementToBeClickable(driver, accountMenu);
        accountMenu.click();
        waitForElementToBeClickable(driver, demoAccountMenuItem);
        demoAccountMenuItem.click();
        return this;
    }

    public CurrencyTradingPlatformPage switchToActivelyGrowingMarketsTab() {
        waitForElementToBeClickable(driver, activelyGrowingMarketsTab);
        activelyGrowingMarketsTab.click();
        return this;
    }

    public CurrencyTradeTab clickBuyToken() {
        waitForElementToBeClickable(driver, buttonBuyBitcoinTokenInWishlist);
        buttonBuyBitcoinTokenInWishlist.click();
        return new CurrencyTradeTab(driver);
    }
}
