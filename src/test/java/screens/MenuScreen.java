package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.screens.BaseScreen;

public class MenuScreen extends BaseScreen {
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\").textContains(\"Privacy\")")
    private AndroidElement privacyButton;

    public PrivacyScreen privacyScreen() {
        swipeVertical(100);
        click(privacyButton);
        return new PrivacyScreen(driver);
    }
}
