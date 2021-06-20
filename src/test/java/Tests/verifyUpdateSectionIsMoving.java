package Tests;

import org.testng.annotations.Test;

import java.awt.*;
import org.testng.annotations.Listeners;

@Listeners(Tests.Listeners.class)
public class verifyUpdateSectionIsMoving extends MainTest{

    @Test
    public void findUpdateSection(){
        ynetPage.findUpdateSection();
    }

    @Test (description = "Verify the update article list is not moving on mouse hover")
    public void mouseHoverStopMovingSection() throws InterruptedException, AWTException {
        ynetPage.VerifyTheUpdateArticleListIsNotMovingOnMouseHover();
    }

    @Test(description = "Find update section and verify the update section is moving")
    public void verifyListUpdateIsMoving() throws InterruptedException {
        ynetPage.findUpdateLinkAndVerifyItIsMoving();
    }
}
