package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrencyTradingPlatformPage extends BasePage{

    @FindBy(css = "div[class='btn-menu']")
    private WebElement accountMenu;

    @FindBy(xpath = "//p[text()='Перейти на демо-аккаунт']")
    private WebElement demoAccountMenuItem;

    @FindBy(xpath = "//div[text()='Gold']/../following-sibling::div[@class='col buy']/button[contains(text(), 'Купить')]")
    private WebElement buttonBuyGoldTokenInWishlist;

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

    public CurrencyTradeTab clickBuyToken() {
        waitForElementToBeClickable(driver, buttonBuyGoldTokenInWishlist);
        buttonBuyGoldTokenInWishlist.click();
        return new CurrencyTradeTab(driver);
    }
}
