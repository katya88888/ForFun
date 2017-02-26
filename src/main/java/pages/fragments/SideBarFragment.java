package pages.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.FeedPage;
import pages.MessagesPage;

import java.util.List;

/**
 * Created by numash on 26.12.2016.
 */
public class SideBarFragment extends AbstractFragment {

    @FindBy(xpath = ".//*[@class='left_label inl_bl']")
    private List<WebElement> sideBarLinksList;

    public SideBarFragment(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSideBarLinksList(){
        return sideBarLinksList;
    }

    public MessagesPage clickOnMessagesLink(){
        getMessagesLink().click();
        return new MessagesPage(driver);
    }

    public FeedPage clickOnFeedLink(){
        getFeedLink().click();
        return new FeedPage(driver);
    }

    public WebElement getMyProfileLink(){
        return sideBarLinksList.get(0);
    }

    public WebElement getFeedLink(){
        return sideBarLinksList.get(1);
    }

    public WebElement getMessagesLink(){
        return sideBarLinksList.get(2);
    }
}
