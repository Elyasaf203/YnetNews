package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(Tests.Listeners.class)
public class enterTheWebsite extends MainTest {

    @Test(description = "Enter the website and verify the correct web page is opened ")
    public void verifyTheCorrectWebPageIsOpened(){
        String title= driver.getTitle();
        Assert.assertEquals(title,getData("Title"));
        System.out.println("The correct title is : " + title);
    }
}
