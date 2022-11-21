package utils.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import screens.DashboardScreen;
import utils.ConfigCapabilities;
import utils.screens.BaseScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static AndroidDriver<AndroidElement> driver;
    protected BaseScreen baseScreen;

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public void setUpStartApp() {
        baseScreen = new BaseScreen(getDriver());
    }

    @BeforeMethod(alwaysRun = true)
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetup(capabilities);
        ConfigCapabilities.applicationSetup(capabilities);
        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        baseScreen.goToDashboard();
    }
}
