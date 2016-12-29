package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FeedPage;
import pages.MessagesPage;
import pages.SearchPage;

/**
 * Created by numash on 28.12.2016.
 */
public class SearchTests extends BaseTest{
    private static SearchPage searchPage;

    @BeforeMethod(dependsOnGroups = "positiveLogin", alwaysRun = true)
    public void beforeMethod(){
        super.beforeMethod();

        searchPage = new SearchPage(driver);
    }

    /**
     * Description:
     * Opens feed page, enters a property "wordToSearch" into search line on page header
     * Plays first audio
     */
    @Parameters({"wordToSearch"})
    @Test(groups = "playAudio")
    public void searchAndPlayAudio(String word){
        FeedPage.feedPage(driver).getHeader().searchForWord(word);

        searchPage.playAudio(searchPage.getAudioElement(0));
    }

    /**
     * Description:
     * Opens feed page, enters a property "wordToSearch" into search line on page header
     * Sends statistics of find data to first conversation
     */
    @Parameters({"wordToSearch"})
    @Test(dependsOnGroups = "playAudio")
    public void searchAndSendStatistics(String word){
        FeedPage.feedPage(driver).getHeader().searchForWord(word);

        String statisticsData = searchPage.getStatisticsData();

        searchPage.getSideBar().clickOnMessagesLink();
        new MessagesPage(driver)
                .goToFirstConversation()
                .sendMessage(statisticsData);
    }
}
