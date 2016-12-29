package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FeedPage;
import pages.MessagesPage;
import pages.SearchPage;

import java.util.List;

/**
 * Created by numash on 28.12.2016.
 */
@Listeners(BaseTest.class)
public class ForFunTests extends BaseTest{
    private static SearchPage searchPage;

    @BeforeMethod(dependsOnGroups = "positiveLogin", alwaysRun = true)
    public void beforeMethod(){
        super.beforeMethod();

        searchPage = SearchPage.searchPage(driver);
    }

    /**
     * Description:
     * Open feed page, enters a property "wordToSearch" into search line on page header
     * Play audio
     * Send statistics of found data to first conversation
     * Save "picturesToSave" number of pictures from that conversation
     */
    @Parameters({"wordToSearch", "picturesToSave"})
    @Test
    public void myAwesomeScenario(String word, int numberOfPictures){

        //play audio
        searchPage.getHeader().searchForWord(word);
        searchPage.playAudioFile(1);

        //get and send statistics
        String statisticsData = searchPage.getStatisticsData();

        MessagesPage messagesPage = searchPage
                .getSideBar()
                .clickOnMessagesLink();

        messagesPage
                .goToFirstConversation()
                .sendMessage(statisticsData);

        //save pictures from conversation
        List<WebElement> picture = messagesPage.getImages(numberOfPictures);
        savePictures(picture);
    }
}
