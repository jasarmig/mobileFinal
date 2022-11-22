package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.screens.BaseScreen;

public class MapScreen extends BaseScreen {

    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/categoryTitleLayout\")")
    private AndroidElement categoryButton;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceId(\"com.disney.wdpro.dlr:id/facilityTypeTitle\").text(\"Hotels\")")
    private AndroidElement hotelsText;

    public AndroidElement getCategoryButton() {
        return categoryButton;
    }

    public boolean categoryButtonDisplayed() {
        return isElementAvailable(categoryButton);
    }

    public boolean hotelsCategoryAvailable() {
        return isElementAvailable(hotelsText);
    }
}
