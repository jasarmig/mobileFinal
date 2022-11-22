package tests;

import org.testng.annotations.Test;
import screens.*;
import utils.tests.BaseTest;


public class UserTests extends BaseTest {

    @Test
    public void categoryTest() {
        DashboardScreen dashboard = baseScreen.goToDashboard();
        MapScreen maps = dashboard.goToMapScreen();
        maps.click(maps.getCategoryButton());
        if (maps.hotelsCategoryAvailable()){
            System.out.println("done");
        }
    }

    @Test
    public void privacyAndLegal() {
        DashboardScreen dashboard = baseScreen.goToDashboard();
        MenuScreen menu = dashboard.goToMenuScreen();
        PrivacyScreen privacy = menu.goToPrivacyScreen();
        if (privacy.optionsExist()) {
            System.out.println("done");
        }
    }

    @Test
    public void addPlansOption() {
        DashboardScreen dashboard = baseScreen.goToDashboard();
        PlansScreen plans = dashboard.goToPlansScreen();
        if(plans.getDiningReserveButton()){
            System.out.println("done");
        }
    }

}
