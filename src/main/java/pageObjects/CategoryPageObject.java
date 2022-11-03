package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CategoryPageUI;

public class CategoryPageObject extends BasePage {
	private WebDriver driver;

	public CategoryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectVIewTypeByTitle(WebDriver driver, String viewTypeTitle) {
		waitForElementVisible(driver, CategoryPageUI.VIEW_TYPE_BY_TITLE, viewTypeTitle);
		clickToElement(driver, CategoryPageUI.VIEW_TYPE_BY_TITLE, viewTypeTitle);
	}

	public void addItemToCartByTitle(WebDriver driver, String itemTitle) {
		scrollToElement(driver, CategoryPageUI.ADD_TO_CART_BUTTON_BY_ITEM_TITLE, itemTitle);
		waitForElementVisible(driver, CategoryPageUI.ADD_TO_CART_BUTTON_BY_ITEM_TITLE, itemTitle);
		clickToElement(driver, CategoryPageUI.ADD_TO_CART_BUTTON_BY_ITEM_TITLE, itemTitle);
	}

	public void clickToKeepBrowsingButton() {
		waitForElementVisible(driver, CategoryPageUI.KEEP_BROWSING_BUTTON);
		clickToElement(driver, CategoryPageUI.KEEP_BROWSING_BUTTON);
	}

	public CartPageObject clickToGoToCheckoutLink(WebDriver driver) {
		waitForElementVisible(driver, CategoryPageUI.GO_TO_CHECKOUT_LINK);
		clickToElement(driver, CategoryPageUI.GO_TO_CHECKOUT_LINK);
		return PageGeneratorManager.getCartPage(driver);
	}

	public double getItemPrice(WebDriver driver) {
		waitForElementVisible(driver,CategoryPageUI.ITEM_PRICE);
		String itemPrice = getElementText(driver, CategoryPageUI.ITEM_PRICE).substring(1);
		return Double.parseDouble(itemPrice);
	}
}
