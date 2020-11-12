package automation.amazon.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends PageObject {
    public static final By LASTPAGEBTN= By.cssSelector(".a-last");
    public static final By SORTBYCOMBOX = By.xpath("//span[@class='a-dropdown-prompt']");

    @FindBy(xpath = "//div[@data-component-type='s-search-result'][15]//span[@class='a-size-base a-color-secondary a-text-normal']")
    public static WebElementFacade LASTLISTITEM;

    public List<String> getTotalSearchItemOnPage() {
        return findAll("//span[@class = 'a-size-base a-color-secondary a-text-normal']").stream()
                .map(WebElementFacade::getText).collect(Collectors.toList());

    }
    public List<String> getPubDateList() {
        return findAll("//div[@data-component-type='s-search-result']//span[@class='a-size-base a-color-secondary a-text-normal']").stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
    public String getPubDateValue() {
        return find("//div[@data-component-type='s-search-result'][1]//span[@class='a-size-base a-color-secondary a-text-normal']").getText();
    }

}
