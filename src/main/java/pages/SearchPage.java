package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.fradgments.HeaderFragment;
import pages.fradgments.SideBarFragment;

import java.util.List;

/**
 * Created by numash on 28.12.2016.
 */
public class SearchPage extends AbstractPage {

    @FindBy(xpath = ".//*[@class='page_block_sub_header clear_fix']")
    private List<WebElement> statisticDataList;
    @FindBy(xpath = ".//*[@class='audio_play_wrap']")
    private List<WebElement> audioList;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getRelativeUrl() {
        return "search";
    }

    public static SearchPage searchPage(WebDriver driver){
        SearchPage page = new SearchPage(driver);
        page.open();

        return page;
    }

    @Override
    public HeaderFragment getHeader() {
        return header;
    }

    @Override
    public SideBarFragment getSideBar() {
        return sideBar;
    }

    public String getStatisticsData(){
        String statisticsData = "I've found some results on your request! ";

        for (WebElement data: statisticDataList){
            WebElement innerHeader = data.findElement(By.xpath("./*[@class='page_block_header_inner _header_inner']"));

            String resultNumber = innerHeader.findElement(By.xpath("./span")).getText();
            String title = innerHeader.getText().replace(resultNumber, "");

            statisticsData += title + " - " + resultNumber + "; ";
        }
        return statisticsData;
    }

    public void playAudioFile(int index){
        WebElement playButton = audioList.get(index).findElement(By.xpath("./button[contains(@id, 'play')]"));
        playButton.click();
    }
}
