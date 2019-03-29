package pages;

import org.apache.jackrabbit.webdav.WebdavRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplyForNumberPage extends Page{

    public void getSearchBox(String location){
        driver.findElement(By.id("edit-contains")).sendKeys(location);
    }

    public void clickSubmitButton(){
        driver.findElement(By.id("edit-submit-site-search")).click();
    }

    public FindNSWLocationPage clickLocateUsButton(){
        driver.findElement(By.linkText("Locate us")).click();
        return new FindNSWLocationPage();
    }
}
