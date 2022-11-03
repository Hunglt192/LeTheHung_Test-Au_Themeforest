package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static CategoryPageObject getCategoryPage(WebDriver driver) {
		return new CategoryPageObject(driver);
	}

	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}

	public static CartPageObject getCartPage(WebDriver driver) {
		return new CartPageObject(driver);
	}
}
