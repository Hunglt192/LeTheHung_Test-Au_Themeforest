package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CartPageUI;

public class CartPageObject extends BasePage {
	private WebDriver driver;

	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isItemDisplayByTitle(WebDriver driver, String firstItemTitle) {
		waitForElementVisible(driver, CartPageUI.ITEM_LINK_BY_TITLE, firstItemTitle);
		return isElementDisplay(driver, CartPageUI.ITEM_LINK_BY_TITLE, firstItemTitle);
	}

	public boolean isPriceOfItemCorrect(WebDriver driver, String itemTitle, double itemPrice) {
		waitForElementVisible(driver, CartPageUI.ITEM_PRICE_BY_TITLE, itemTitle);
		double itemPriceCartPage = Double.parseDouble(getElementText(driver, CartPageUI.ITEM_PRICE_BY_TITLE,itemTitle, itemTitle).trim().substring(1));
		return itemPrice==itemPriceCartPage;
	}

	public boolean isCartTotalPriceCorrect(WebDriver driver, double firstItemPrice, double secondItemPrice) {
		waitForElementVisible(driver, CartPageUI.CART_T0TAL_PRICE);
		double cartTotalPrice = Double.parseDouble(getElementText(driver, CartPageUI.CART_T0TAL_PRICE));
		return cartTotalPrice==firstItemPrice+secondItemPrice;
	}

	public CheckoutPageObject clickToSecureCheckoutButton(WebDriver driver) {
		waitForElementVisible(driver, CartPageUI.SECURE_CHECKOUT_BUTTON);
		clickToElement(driver, CartPageUI.SECURE_CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckoutPage(driver);
	}
}
