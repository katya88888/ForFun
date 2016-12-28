package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.fradgments.SideBarFragment;

import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by numash on 26.12.2016.
 */
public class FeedPage extends AbstractPage {

    @FindBy(xpath = ".//*[contains(@class,'page_post_thumb_wrap')]")
    private List<WebElement> feedImages;

    private SideBarFragment sideBar;

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public String getRelativeUrl() {
        return "feed";
    }

    //initialize a new instance and open page
    public static FeedPage feedPage(WebDriver driver){
        FeedPage page = new FeedPage(driver);
        page.open();

        return page;
    }

    public SideBarFragment getSideBar() {
        return new SideBarFragment(driver);
    }

    public WebElement getFirstImage(){
        WebElement im = feedImages.get(0);
        return im;
    }
}
