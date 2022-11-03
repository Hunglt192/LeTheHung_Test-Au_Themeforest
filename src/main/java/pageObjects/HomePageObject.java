package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToGlobalHeaderMarketLinkByText(WebDriver driver, String headerMarketLinkText) {
		waitForElementVisible(driver, HomePageUI.GLOBAL_HEADER_MARKETS_LINK, headerMarketLinkText);
		clickToElement(driver, HomePageUI.GLOBAL_HEADER_MARKETS_LINK, headerMarketLinkText);
	}

	public CategoryPageObject clickToItemByTextAndGlobalHeaderCategoryLinkText(WebDriver driver, String headerCategoryLinkText, String itemText) {
		sleepInSecond(1);
		waitForElementVisible(driver, HomePageUI.GLOBAL_HEADER_CATEGORIES_LINK, headerCategoryLinkText);
		hoverMouseToElement(driver, HomePageUI.GLOBAL_HEADER_CATEGORIES_LINK, headerCategoryLinkText);

		waitForElementVisible(driver, HomePageUI.ITEM_LINK_BY_ITEM_TEXT_AND_GLOBAL_HEADER_CATEGORY_LINK_TEXT, headerCategoryLinkText, itemText);
		clickToElement(driver, HomePageUI.ITEM_LINK_BY_ITEM_TEXT_AND_GLOBAL_HEADER_CATEGORY_LINK_TEXT, headerCategoryLinkText, itemText);
		return PageGeneratorManager.getCategoryPage(driver);
	}
}
