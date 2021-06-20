package Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Tests.Listeners.class)
public class clickOnArticle extends MainTest{

    @Test (description = "Press on new comment without filling any details and verify there is a validation")
    public void addCommentWithoutDetails() throws InterruptedException {
        ynetPage.clickOnArticle();
        firstArticlePage.verifyNewCommentLinkIsExist();
        firstArticlePage.addCommentWithoutDetails();
    }
}
