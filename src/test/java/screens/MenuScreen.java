package screens;

import io.appium.java_client.MobileBy;
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

    private final AndroidElement scrollableMenu = driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));

    public PrivacyScreen goToPrivacyScreen() {
        if(getScrollableMenu()){
            click(privacyButton);
        }
        return new PrivacyScreen(driver);
    }

    public boolean getScrollableMenu() {
        return scrollableMenu != null ;
    }
}
