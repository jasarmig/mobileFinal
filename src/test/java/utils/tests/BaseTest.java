package utils.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import screens.DashboardScreen;
import utils.ConfigCapabilities;
import utils.reporting.Reporter;
import utils.screens.BaseScreen;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Base class for Test classes.
 *
 * @author je.sarmiento
 */
public class BaseTest {

    public static AndroidDriver<AndroidElement> driver;
    protected BaseScreen baseScreen;

    protected DashboardScreen dashboard;

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    /**
     * Method to navigate to Dashboard during environment setup
     *
     * @return DashboardScreen
     * @author je.sarmiento
     */
    public DashboardScreen setUpStartApp() {
        baseScreen = new BaseScreen(getDriver());
        Reporter.info("Navigating to Dashboard");
        return baseScreen.goToDashboard();
    }

    /**
     * Method to setup environment before each test
     *
     * @author Arley.Bolivar
     */
    @BeforeMethod(alwaysRun = true)
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetup(capabilities);
        ConfigCapabilities.applicationSetup(capabilities);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        Reporter.info("Opening App");
        dashboard = setUpStartApp();
    }

    /**
     * Method to close the app after each test
     *
     * @author Arley.Bolivar
     */
    @AfterMethod(alwaysRun = true)
    public void mobileApplicationEnd() {
        Reporter.info("Test Concluded");
        driver.quit();
    }
}
