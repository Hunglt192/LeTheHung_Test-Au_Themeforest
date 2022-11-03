package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CheckoutPageUI;

public class CheckoutPageObject extends BasePage {
	private WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, CheckoutPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, CheckoutPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, CheckoutPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, CheckoutPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtUsernameTextbox() {
		waitForElementVisible(driver, CheckoutPageUI.USERNAME_ERROR_MESSAGE);
		return getElementText(driver, CheckoutPageUI.USERNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtRecaptchaCheckbox(WebDriver driver) {
		waitForElementVisible(driver, CheckoutPageUI.RECAPTCHA_ERROR_MESSAGE);
		return getElementText(driver, CheckoutPageUI.RECAPTCHA_ERROR_MESSAGE);
	}

	public void checkToImNotARobotCheckBox(WebDriver driver) {
		waitForElementVisible(driver, CheckoutPageUI.RECAPTCHA_IFRAME);
		switchToFrameIframe(driver, CheckoutPageUI.RECAPTCHA_IFRAME);

		waitForElementVisible(driver, CheckoutPageUI.IM_NOT_A_ROBOT_CHECKBOX);
		checkToDefaultCheckBoxOrRadio(driver, CheckoutPageUI.IM_NOT_A_ROBOT_CHECKBOX);
		switchToDefaultContent(driver);
	}

	public void checkToSendMeTipsCheckBox(WebDriver driver) {
		waitForElementVisible(driver, CheckoutPageUI.SEND_ME_TIPS_BUTTON);
		checkToDefaultCheckBoxOrRadio(driver, CheckoutPageUI.SEND_ME_TIPS_BUTTON);
	}

	public void uncheckToSendMeTipsCheckBox(WebDriver driver) {
		waitForElementVisible(driver, CheckoutPageUI.SEND_ME_TIPS_BUTTON);
		uncheckToDefaultCheckBox(driver, CheckoutPageUI.SEND_ME_TIPS_BUTTON);
	}

	public void clickToCreateAccountContinueButton(WebDriver driver) {
		waitForElementVisible(driver, CheckoutPageUI.CREATE_ACCOUNT_CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.CREATE_ACCOUNT_CONTINUE_BUTTON);
	}
}
