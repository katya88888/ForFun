package pages.fragments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by numash on 28.12.2016.
 */
public class HeaderFragment extends AbstractFragment{

    @FindBy(id = "ts_input")
    private WebElement searchInput;

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    public void searchForWord(String searchedWord){
        searchInput.sendKeys(searchedWord);
        searchInput.sendKeys(Keys.ENTER);
    }
}
