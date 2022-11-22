package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.screens.BaseScreen;



public class DashboardScreen extends BaseScreen {


    public DashboardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tab_icon\").instance(1)")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tab_icon\").instance(3)")
    private AndroidElement menuButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/tab_animated_icon\")")
    private AndroidElement addPlansButton;

    public MapScreen goToMapScreen() {
        click(mapButton);
        return new MapScreen(driver);
    }

    public MenuScreen goToMenuScreen() {
        click(menuButton);
        return new MenuScreen(driver);
    }

    public PlansScreen goToPlansScreen() {
        click(addPlansButton);
        return new PlansScreen(driver);
    }
}
