package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.fradgments.HeaderFragment;
import pages.fradgments.SideBarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by numash on 29.12.2016.
 */
public class MessagesPage extends AbstractPage {

    @FindBy(xpath = ".//*[@class='nim-dialog--cw']/*[@class='blind_label']")
    private List<WebElement> messagesList;
    @FindBy(id = "im_editable0")
    private WebElement messageInput;
    @FindBy(xpath = ".//*[contains(@class,'im-send-btn im-chat-input--send _im_send')]")
    private WebElement sendBtn;
    @FindBy(xpath = ".//*[contains(@class,'page_post_thumb_wrap')]")
    private List<WebElement> messagesImages;

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    public String getRelativeUrl() {
        return "im";
    }

    @Override
    public HeaderFragment getHeader() {
        return header;
    }

    @Override
    public SideBarFragment getSideBar() {
        return sideBar;
    }

    public MessagesPage goToFirstConversation(){
        messagesList.get(0).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(messageInput));

        return this;
    }

    public MessagesPage sendMessage(String message){
        messageInput.sendKeys(message);
        sendBtn.click();

        return this;
    }

    public List<WebElement> getImages(int number){
        List<WebElement> list = new ArrayList<WebElement>();

        for (int i = 0; i < number ; i++){
            if (messagesImages.get(i) != null){
                list.add(messagesImages.get(i));
            }
        }
        return list;
        //WebElement im = messagesImages.get(0);
        //return im;
    }
}
