package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FirstArticlePage extends PageObject{
    public FirstArticlePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[title=\"comment\"]")
    WebElement comment;

    @FindBy(css= ".textDoubleBubleIcon")
    WebElement addComment;

    public void verifyNewCommentLinkIsExist(){
        wait.until(ExpectedConditions.elementToBeClickable(comment));
        Assert.assertEquals(comment.getText(),"comment");
        System.out.println(comment.getText());
    }

    public void addCommentWithoutDetails() throws InterruptedException {
        comment.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", addComment);
        String validation = driver.switchTo().alert().getText();
        Assert.assertEquals(validation,"You must enter a headline");
        driver.switchTo().alert().dismiss();
    }
}
