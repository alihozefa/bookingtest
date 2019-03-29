package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class FindNSWLocationPage extends Page{

    SoftAssert softAssert = new SoftAssert();

    public void verifyFindServiceLocationPageDisplayed(){
        softAssert.assertTrue(driver.findElement(By.cssSelector("header h1")).isDisplayed(),"Find service location page isn't displayed.");
    }

    public void typeLocationAddress(String location){
        driver.findElement(By.id("locatorTextSearch")).sendKeys(location);
    }

    public void clickSubmitButton(){
        driver.findElement(By.cssSelector("button.button--primary.button--xxlarge")).click();
    }

    private List<WebElement> getServiceLocations(){
        return driver.findElements(By.cssSelector("a.location__title"));
    }

    public void verifyDesiredLocationDisplayed(String desiredLcation){
        List<WebElement> links = new ArrayList<WebElement>();
        links = getServiceLocations();
        boolean matchFound = false;
        if (!links.isEmpty() && links.size() != 0){
            for (WebElement link : links){
                if (link.getAttribute("text").contains(desiredLcation)){
                    matchFound = true;
                    break;
                }
            }
        }
        Assert.assertTrue(matchFound,desiredLcation + ", is not found!");
    }
}
