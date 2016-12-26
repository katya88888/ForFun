package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by numash on 26.12.2016.
 */
public class FeedPage extends AbstractPage {

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return "https://vk.com/feed";
    }

    //initialize a new instance and open page
    public static FeedPage feedPage(WebDriver driver){
        FeedPage page = new FeedPage(driver);
        page.open();

        return page;
    }
}
