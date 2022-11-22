package utils.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.DashboardScreen;

import java.time.Duration;

public class BaseScreen {

    protected final AndroidDriver<AndroidElement> driver;

    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
    }

    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

/*    public void swipeVertical(double anchorPercentage, double topPercentage, double bottomPercentage) {
        Dimension windowSize = driver.manage().window().getSize();
        int anchor = (int)(windowSize.width * anchorPercentage);
        int startPoint = (int)(windowSize.height * bottomPercentage);
        int endPoint = (int)(windowSize.height * topPercentage);
        new TouchAction(driver).press(PointOption.point(anchor,startPoint)).moveTo(PointOption.point(anchor,endPoint)).release().perform();
    }*/

    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/permission_primary_btn\")")
    private AndroidElement getStartedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/skip_text\")")
    private AndroidElement skipButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
    private AndroidElement dismissUpdateButton;

    public DashboardScreen goToDashboard() {
        click(getStartedButton);
        click(skipButton);
        click(dismissButton);
        click(dismissUpdateButton);
        return new DashboardScreen(driver);
    }
}
