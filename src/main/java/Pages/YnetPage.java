package Pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class YnetPage extends PageObject {

    public YnetPage(WebDriver driver) {
        super(driver);
    }

    List<Point> first = new ArrayList<>();
    List<Point> second = new ArrayList<>();
    public int i = 0;


    @FindBy(css = ".weathertemps")
    WebElement weathertemps;
    //Select area
    @FindBy(id = "weathercityselect")
    WebElement weathercityselect;

    @FindBy(css = "span[style='color:black;font-size:26px;min-height:26px;line-height:27px']")
    WebElement article;

    @FindBy(xpath = "//div[contains(text(),'Updates')]")
    WebElement Update;

    @FindBy(css = ".moreDetails > a")
    List<WebElement> listUpdate;

    @FindBy(css = ".animationDiv")
    WebElement list;

    //Print weather
    public void printWeather() {
        System.out.println("The weather temps is : " + weathertemps.getText());
    }

    //Change area to Eilat and print the weather
    public void changeAreaToEilat() {
        Select select = new Select(weathercityselect);
        select.selectByVisibleText("Eilat");
        System.out.println("The weather temps in Eilat is : " + weathertemps.getText());
    }

    //Click on first article
    public void clickOnArticle() {
        article.click();
    }

    //Find update section and verify is moving
    public void findUpdateLinkAndVerifyItIsMoving() throws InterruptedException {
        for (i = 0; i < listUpdate.size(); i++) {
            first.add(listUpdate.get(i).getLocation());
        }

        for (i = 0; i < listUpdate.size(); i++) {
            second.add(listUpdate.get(i).getLocation());
        }
        for (i = 0; i < listUpdate.size(); i++) {
            if (!(first.get(i) == second.get(i))) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("The update section is not moving");
            }
        }
    }
   // Verify the update article list is not moving on mouse hover
    public void VerifyTheUpdateArticleListIsNotMovingOnMouseHover() {
        Actions actions = new Actions(driver);
        actions.moveToElement(list).perform();
        for (i = 0; i < listUpdate.size(); i++) {
            first.add(listUpdate.get(i).getLocation());
            second.add(listUpdate.get(i).getLocation());
            Assert.assertEquals(first.get(i), second.get(i));
            System.out.println(first.get(i).toString());
            System.out.println(second.get(i).toString());
        }
    }

    //Find update section and print the article links
    public void findUpdateSection() {
        for (i = 0; i < listUpdate.size(); i++) {
            System.out.println(listUpdate.get(i).getAttribute("href"));
        }
    }
}
