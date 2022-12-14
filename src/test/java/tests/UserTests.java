package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;
import utils.reporting.Reporter;
import utils.tests.BaseTest;

/**
 * Case tests
 *
 * @author je.sarmiento
 */
public class UserTests extends BaseTest {

    /**
     * Navigates from Dashboard to Map screen and validates Hotel is an option in the categories list
     */
    @Test
    public void categoryTest() {
        Reporter.info("Navigating to Map Screen");
        MapScreen maps = dashboard.goToMapScreen();
        Reporter.info("Validating Category Button is available");
        Assert.assertTrue(maps.isElementAvailable(maps.getCategoryButton()),"Category Button Not Avaliable");
        Reporter.info("Displaying categories list");
        maps.click(maps.getCategoryButton());
        Reporter.info("Validating Hotels option is available");
        Assert.assertTrue(maps.hotelsCategoryAvailable(),"Category Not Available");
    }

    /**
     * Navigates from Dashboard to Privacy Screen and validates the requested options
     */
    @Test
    public void privacyAndLegal() {
        Reporter.info("Navigating to Menu Screen");
        MenuScreen menu = dashboard.goToMenuScreen();
        Reporter.info("Navigating to Privacy Screen");
        PrivacyScreen privacy = menu.goToPrivacyScreen();
        Reporter.info("Validating options in Privacy Screen");
        Assert.assertTrue(privacy.optionsExist(),"Options don't match");
    }

    /**
     * Navigates from Dashboard to Plans screen and validates there is an option for dining reservations
     */
    @Test
    public void addPlansOption() {
        Reporter.info("Navigating to Plans Screen");
        PlansScreen plans = dashboard.goToPlansScreen();
        Reporter.info(("Validating Dining Option is present"));
        Assert.assertTrue(plans.getDiningReserveButton(),"Dining reservations are not available");
    }

}
