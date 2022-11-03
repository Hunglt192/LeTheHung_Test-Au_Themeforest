package payment;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import reportConfig.ExtentTestManager;
import java.lang.reflect.Method;
import com.aventstack.extentreports.Status;
import utilities.DataHelper;

public class Payment_01 extends BaseTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        dataFaker = DataHelper.getDataHelper();
        firstName = dataFaker.getFirstName();
        lastName = dataFaker.getLastName();
        email = dataFaker.getEmailAdress();
        userName = dataFaker.getUserName();
        password = dataFaker.getPassword();

        firstItemTitle = "Noka - Cleaning Services Company Elementor";
        secondItemTitle = "MODO - Crypto Currency Elementor";
    }

    @Test
    public void Payment_01_Add_Item_To_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Add 2 item to cart");
        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 01: Click to 'Web Themes & Templates' header market");
        homePage.clickToGlobalHeaderMarketLinkByText(driver, "Web Themes & Templates");

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 02: Click to item: 'Elementor' in header category: 'Template Kits'");
        categoryPage = homePage.clickToItemByTextAndGlobalHeaderCategoryLinkText(driver, "Elementor", "Template Kits");

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 03: Select view type: 'Grid view'");
        categoryPage.selectVIewTypeByTitle(driver, "Grid View");

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 04: Add item: '" + firstItemTitle + "' to cart");
        categoryPage.addItemToCartByTitle(driver, firstItemTitle);
        firstItemPrice = categoryPage.getItemPrice(driver);

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 05: Click to Keep Browsing button");
        categoryPage.clickToKeepBrowsingButton();

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 06: Add item: '" + secondItemTitle + "' to cart");
        categoryPage.addItemToCartByTitle(driver, secondItemTitle);
        secondItemPrice = categoryPage.getItemPrice(driver);

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 07: Click to Go to Checkout link");
        cartPage = categoryPage.clickToGoToCheckoutLink(driver);

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 08: Verify item '" + firstItemTitle + "' is displayed");
        Assert.assertTrue(cartPage.isItemDisplayByTitle(driver, firstItemTitle));

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 09: Verify item '" + secondItemTitle + "' is displayed");
        Assert.assertTrue(cartPage.isItemDisplayByTitle(driver, secondItemTitle));

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 10: Verify item '" + firstItemTitle + "' correct price");
        Assert.assertTrue(cartPage.isPriceOfItemCorrect(driver, firstItemTitle, firstItemPrice));

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 11: Verify item '" + secondItemTitle + "' correct price");
        Assert.assertTrue(cartPage.isPriceOfItemCorrect(driver, secondItemTitle, secondItemPrice));

        ExtentTestManager.getTest().log(Status.INFO, "AddItemToCart - Step 12: Verify correct Cart Total price");
        Assert.assertTrue(cartPage.isCartTotalPriceCorrect(driver, firstItemPrice, secondItemPrice));
    }

    @Test
    public void Payment_02_Checkout_With_Wrong_Information(Method method) {
        ExtentTestManager.startTest(method.getName(), "Checkout with wrong information");
        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 01: Navigate to 'Checkout' page");
        checkoutPage = cartPage.clickToSecureCheckoutButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 02: Enter to First Name textbox with value is 'Vincent'");
        checkoutPage.inputToTextboxByID(driver, "firstName", "Vincent");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 03: Enter to Last Name textbox with value is 'VSM'");
        checkoutPage.inputToTextboxByID(driver, "lastName", "VSM");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 04: Enter to Email textbox with value is 'vincent@gmail.com'");
        checkoutPage.inputToTextboxByID(driver, "email", "vincent@gmail.com");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 05: Enter to Username textbox with value is 'vincent218'");
        checkoutPage.inputToTextboxByID(driver, "username", "vincent218");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 06: Enter to Password textbox with value is 'Vincent@218'");
        checkoutPage.inputToTextboxByID(driver, "password", "Vincent@218");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 07: Check to 'I'm not a robot' checkbox");
        //checkoutPage.checkToImNotARobotCheckBox(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 08: Check to 'Send me tips' checkbox");
        checkoutPage.checkToSendMeTipsCheckBox(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 09: Click to 'Create account & continue' button");
        checkoutPage.clickToCreateAccountContinueButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 10: Verify error message at Email textbox is displayed");
        Assert.assertEquals(checkoutPage.getErrorMessageAtEmailTextbox(), "Email is already in use");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 11: Verify error message at Password textbox is displayed");
        Assert.assertEquals(checkoutPage.getErrorMessageAtPasswordTextbox(), "Your password cannot contain your name or username");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 12: Refresh current page");
        checkoutPage.refreshCurrentPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 13: Enter to First Name textbox with value is 'Leo'");
        checkoutPage.inputToTextboxByID(driver, "firstName", "Leo");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 14: Enter to Last Name textbox with value is 'VSM'");
        checkoutPage.inputToTextboxByID(driver, "lastName", "VSM");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 15: Enter to Email textbox with value is 'leo@gmail.com'");
        checkoutPage.inputToTextboxByID(driver, "email", "leo@gmail.com");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 16: Enter to Username textbox with value is 'leo123'");
        checkoutPage.inputToTextboxByID(driver, "username", "leo123");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 17: Enter to Password textbox with value is 'Leo@5421'");
        checkoutPage.inputToTextboxByID(driver, "password", "Leo@5421");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 18: Uncheck to 'Send me tips checkbox'");
        checkoutPage.uncheckToSendMeTipsCheckBox(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 19: Click to 'Create account & continue' button");
        checkoutPage.clickToCreateAccountContinueButton(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 20: Verify error message at Email textbox is displayed");
        Assert.assertEquals(checkoutPage.getErrorMessageAtEmailTextbox(), "Email is already in use");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 21: Verify error message at Username textbox is displayed");
        Assert.assertEquals(checkoutPage.getErrorMessageAtUsernameTextbox(), "Username has already been taken");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 22: Verify error message at Password textbox is displayed");
        Assert.assertEquals(checkoutPage.getErrorMessageAtPasswordTextbox(), "Your password cannot contain your name or username");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutWithWrongInformation - Step 23: Verify error message at reCAPTCHA checkbox is displayed");
        Assert.assertEquals(checkoutPage.getErrorMessageAtRecaptchaCheckbox(driver), "Please confirm you're not a robot");
    }

    @Test
    public void Payment_03_Checkout_Success(Method method) {
        ExtentTestManager.startTest(method.getName(), "Checkout Success");

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutSuccess - Step 01: Refresh current page");
        checkoutPage.refreshCurrentPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutSuccess - Step 02: Enter to First Name textbox with value is '" + firstName + "'");
        checkoutPage.inputToTextboxByID(driver, "firstName", firstName);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutSuccess - Step 03: Enter to Last Name textbox with value is '" + lastName + "'");
        checkoutPage.inputToTextboxByID(driver, "lastName", lastName);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutSuccess - Step 04: Enter to Email textbox with value is '" + email + "'");
        checkoutPage.inputToTextboxByID(driver, "email", email);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutSuccess - Step 05: Enter to Username textbox with value is '" + userName + "'");
        checkoutPage.inputToTextboxByID(driver, "username", userName);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutSuccess - Step 06: Enter to Password textbox with value is '" + password + "'");
        checkoutPage.inputToTextboxByID(driver, "password", password);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutSuccess - Step 07: Check to 'I'm not a robot' checkbox");
        checkoutPage.checkToImNotARobotCheckBox(driver);

        ExtentTestManager.getTest().log(Status.INFO, "CheckoutSuccess - Step 09: Click to 'Create account & continue' button");
        checkoutPage.clickToCreateAccountContinueButton(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver();
    }

    private WebDriver driver;
    private HomePageObject homePage;
    private CategoryPageObject categoryPage;
    private CartPageObject cartPage;
    private CheckoutPageObject checkoutPage;

    private DataHelper dataFaker;
    private String firstName, lastName, email, userName, password;

    private String firstItemTitle, secondItemTitle;
    private double firstItemPrice, secondItemPrice;
}
