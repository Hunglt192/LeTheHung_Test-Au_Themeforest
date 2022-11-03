package pageUIs;

public class CartPageUI {
	public static final String ITEM_LINK_BY_TITLE = "xpath=//section[@data-view='cartPage']//article[@class='shopping-cart__entry']//a[contains(text(),'%s')]";
	public static final String ITEM_PRICE_BY_TITLE = "xpath=//section[@data-view='cartPage']//article[@class='shopping-cart__entry']//a[contains(text(),'%s')]/ancestor::div[@class='item-result__details']/following-sibling::div[@class='item-result__price']//b[contains(@class,'item-price')]";
	public static final String CART_T0TAL_PRICE = "xpath=//div[@class='shopping-cart__checkout-primary']//span[@class='js-item-upgrade__cart-total']";
	public static final String SECURE_CHECKOUT_BUTTON = "xpath=//div[@class='shopping-cart__checkout-primary']//input[@value='Secure Checkout']";
}
