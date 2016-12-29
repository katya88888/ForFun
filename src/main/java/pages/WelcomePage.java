package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.fradgments.HeaderFragment;
import pages.fradgments.SideBarFragment;

/**
 * Created by numash on 26.12.2016.
 */
public class WelcomePage extends AbstractPage{

    @FindBy(id = "index_email")
    private WebElement emailField;
    @FindBy(id = "index_pass")
    private WebElement passwordField;
    @FindBy(id = "index_login_button")
    private WebElement loginBtn;
    @FindBy(id = "index_expire")
    private WebElement dontRememberMeCheckbox;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public String getRelativeUrl() {
        return "";
    }

    @Override
    public HeaderFragment getHeader() {
        return header;
    }

    @Override
    public SideBarFragment getSideBar() {
        return null;
    }

    public static WelcomePage welcomePage(WebDriver driver){
        WelcomePage page = new WelcomePage(driver);
        page.open();

        return page;
    }

    public WelcomePage login(String username, String password){
        setUsername(username);
        setPassword(password);
        checkDontRememberMe();
        clickOnLogin();

        return this;
    }

    public void setUsername(String username){
        emailField.clear();
        emailField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLogin() {
        loginBtn.click();
    }

    public void checkDontRememberMe(){
        if (dontRememberMeCheckbox.isSelected()){
            return;
        }
        dontRememberMeCheckbox.click();
    }
}
