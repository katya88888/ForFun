package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by numash on 26.12.2016.
 */
public class LoginPage extends AbstractPage{

    @FindBy(id = "index_email")
    private WebElement usernameField;
    @FindBy(id = "index_pass")
    private WebElement passwordField;
    @FindBy(id = "index_login_button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return "https://vk.com";
    }

    public static LoginPage loginPage(WebDriver driver){
        LoginPage page = new LoginPage(driver);
        page.open();

        return page;
    }

    public LoginPage login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickOnLogin();

        return this;
    }

    public void setUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLogin() {
        loginBtn.click();
    }
}
