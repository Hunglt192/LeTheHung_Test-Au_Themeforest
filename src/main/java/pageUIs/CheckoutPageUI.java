package pageUIs;

public class CheckoutPageUI {
	public static final String IM_NOT_A_ROBOT_CHECKBOX = "css=div.recaptcha-checkbox-border";
	public static final String SEND_ME_TIPS_BUTTON = "xpath=//input[@id='extraInformation.promotionsSubscriber']";
	public static final String CREATE_ACCOUNT_CONTINUE_BUTTON = "xpath=//button[contains(@class,'submit')]";

	public static final String EMAIL_ERROR_MESSAGE = "xpath=//input[@id='email']/parent::div/following-sibling::div";
	public static final String PASSWORD_ERROR_MESSAGE = "xpath=//input[@id='password']/parent::div/following-sibling::div";
	public static final String USERNAME_ERROR_MESSAGE = "xpath=//input[@id='username']/parent::div/following-sibling::div[contains(text(),'Username')]";
	public static final String RECAPTCHA_ERROR_MESSAGE = "xpath=//div[@data-testid='recaptcha-v2']/div[text()]";

	public static final String RECAPTCHA_IFRAME = "xpath=//iframe[@title='reCAPTCHA']";
}
