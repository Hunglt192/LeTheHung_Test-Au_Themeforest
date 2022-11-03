package pageUIs;

public class CategoryPageUI {
	public static final String VIEW_TYPE_BY_TITLE = "xpath=//div[@class='search-list_grid_component__root']//a[contains(@title,'%s')]";
	public static final String ADD_TO_CART_BUTTON_BY_ITEM_TITLE = "xpath=//main[contains(@class,'searchResultsBody')]//a[contains(@class,'itemNameLink') and contains(text(),'%s')]//parent::h3/following-sibling::div[contains(@class,'grid-image')]//a[contains(@class,'add_to_cart')]";
	public static final String KEEP_BROWSING_BUTTON = "xpath=//div[@class='cart_entries-saved_component__root']//button[contains(text(),'Keep Browsing')]";
	public static final String GO_TO_CHECKOUT_LINK = "xpath=//div[@class='cart_entries-saved_component__root']//a[contains(text(),'Go to Checkout')]";
	public static final String ITEM_PRICE = "xpath=//div[@class='cart_entries-saved_component__root']//strong[@data-new-cart-entry-target='price']";
}
