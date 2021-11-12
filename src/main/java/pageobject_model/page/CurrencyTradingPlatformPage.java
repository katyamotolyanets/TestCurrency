package pageobject_model.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static pageobject_model.page.CurrencyHomePage.waitForElementToBeClickable;
import static pageobject_model.page.CurrencyHomePage.waitForVisibilityOfElement;

public class CurrencyTradingPlatformPage {
    private WebDriver driver;

    @FindBy(css = "div[class='btn-menu']")
    private WebElement accountMenu;

    @FindBy(xpath = "//p[text()='Перейти на демо-аккаунт']")
    private WebElement demoAccountMenuItem;

    @FindBy(xpath = "//div[text()='Gold']/../following-sibling::div[@class='col buy']/button[contains(text(), 'Купить')]")
    private WebElement buttonBuyGoldTokenInWishlist;

    @FindBy(xpath = "//div[@class='quantity']/input-number2[@class='input-number']/input")
    private WebElement countOfTokensField;

    @FindBy(xpath = "//button[@class='button-main button-main--positive ng-star-inserted']")
    private WebElement buttonBuyTokenInTradeTab;

    @FindBy(id = "popover-notification-0")
    private WebElement notificationAboutSuccessfulBuying;


    public CurrencyTradingPlatformPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CurrencyTradingPlatformPage logInToCurrencyTradingPlatform() {
        new CurrencyHomePage(driver).openPage().logIntoAccount("katyamotolyanets@mail.ru", "K@tya2112");
        return this;
    }

    public CurrencyTradingPlatformPage changeAccountToDemo() {
        waitForElementToBeClickable(driver, accountMenu);
        accountMenu.click();
        waitForElementToBeClickable(driver, demoAccountMenuItem);
        demoAccountMenuItem.click();
        return this;
    }

    public CurrencyTradingPlatformPage buyToken() {
        waitForElementToBeClickable(driver, buttonBuyGoldTokenInWishlist);
        buttonBuyGoldTokenInWishlist.click();
        waitForVisibilityOfElement(driver, countOfTokensField);
        countOfTokensField.clear();
        countOfTokensField.sendKeys(Keys.BACK_SPACE + "10");
        waitForElementToBeClickable(driver, buttonBuyTokenInTradeTab);
        buttonBuyTokenInTradeTab.click();
        waitForVisibilityOfElement(driver, notificationAboutSuccessfulBuying);
        return this;
    }

    public boolean haveTokensBeenBought() {
        return notificationAboutSuccessfulBuying.isDisplayed();
    }
}
