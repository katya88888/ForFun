package pages.fradgments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FeedPage;

/**
 * Created by numash on 28.12.2016.
 */
public class HeaderFragment extends AbstractFragment{

    @FindBy(id = "ts_input")
    private WebElement searchInput;

    private WebDriver driver;

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    public void searchForWord(String searchedWord){
        searchInput.sendKeys(searchedWord);
        searchInput.sendKeys(Keys.ENTER);
    }
}
