package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.fradgments.FooterFragment;
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

    private static SideBarFragment sideBar;

    public SearchPage(WebDriver driver) {
        super(driver);
        sideBar = new SideBarFragment(driver);
    }

    public String getRelativeUrl() {
        return "search";
    }

    @Override
    public HeaderFragment getHeader() {
        return header;
    }

    @Override
    public FooterFragment getFooter() {
        return footer;
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
        System.out.println(statisticsData);
        return statisticsData;
    }

    public WebElement getAudioElement(int index){
        WebElement playButton = audioList.get(index).findElement(By.xpath("./button[contains(@id, 'play')]"));
        return playButton;
    }

    public void playAudio(WebElement audioElement){
        audioElement.click();
    }
}
