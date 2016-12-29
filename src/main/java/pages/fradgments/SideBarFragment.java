package pages.fradgments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void clickOnMessagesLink(){
        getMessagesLink().click();
    }

    public WebElement getMyProfileLink(){
        return sideBarLinksList.get(0);
    }

    public WebElement getMessagesLink(){
        return sideBarLinksList.get(2);
    }
}
