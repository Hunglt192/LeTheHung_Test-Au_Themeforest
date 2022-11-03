package pageUIs;

public class HomePageUI {
	public static final String GLOBAL_HEADER_MARKETS_LINK = "xpath=//a[contains(@class,'shared-global_header-markets') and contains(text(),'%s')]";
	public static final String GLOBAL_HEADER_CATEGORIES_LINK = "xpath=//a[contains(@class,'shared-global_header-categories') and contains(text(),'%s')]";
	public static final String ITEM_LINK_BY_ITEM_TEXT_AND_GLOBAL_HEADER_CATEGORY_LINK_TEXT = "xpath=//a[contains(@class,'shared-global_header-categories') and contains(text(),'%s')]/following-sibling::div//a[contains(text(),'%s')]";
}
