package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.fradgments.FooterFragment;
import pages.fradgments.HeaderFragment;
import pages.fradgments.SideBarFragment;

import java.util.List;

/**
 * Created by numash on 26.12.2016.
 */
public class FeedPage extends AbstractPage {

    @FindBy(xpath = ".//*[contains(@class,'page_post_thumb_wrap')]")
    private List<WebElement> feedImages;

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public String getRelativeUrl() {
        return "feed";
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

    //initialize a new instance and open page
    public static FeedPage feedPage(WebDriver driver){
        FeedPage page = new FeedPage(driver);
        page.open();

        return page;
    }

    public WebElement getFirstImage(){
        WebElement im = feedImages.get(0);
        return im;
    }
}
