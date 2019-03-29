package tests;

import org.testng.annotations.Test;
import pages.ApplyForNumberPage;
import pages.FindNSWLocationPage;
import pages.ServiceNSWHomePage;

public class TestCase {

    @Test
    public void applyForNumberPlate(){
        ServiceNSWHomePage home = new ServiceNSWHomePage();
        ApplyForNumberPage apply = home.goToApplyForNumberPlate();
        FindNSWLocationPage find = apply.clickLocateUsButton();
        find.verifyFindServiceLocationPageDisplayed();
        find.typeLocationAddress(ServiceNSWHomePage.config.getProperty("serviceLocation"));
        find.clickSubmitButton();
        find.verifyDesiredLocationDisplayed(ServiceNSWHomePage.config.getProperty("expectedServiceCentre"));
    }
}
