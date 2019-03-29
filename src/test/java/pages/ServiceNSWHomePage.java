package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ServiceNSWHomePage extends Page {

    public ApplyForNumberPage goToApplyForNumberPlate(){
        WebElement element = driver.findElement(By.linkText("Find the billing number for a vehicle"));
        explicitWait(element);
        return new ApplyForNumberPage();
    }

    public void goToHomePage(){

    }
}
