package automation.amazon.actions;

import automation.amazon.ui.SearchResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SortResultsByInputOption implements Task {
    private final String sortOption;
    protected SortResultsByInputOption(String sortOption) {
        this.sortOption = sortOption;
    }

    @Step("{0} sort the search results by #sortOption")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
              Click.on(SearchResultPage.SORTBYCOMBOX),
              WaitAndClick.forElement(By.xpath("//li[@class='a-dropdown-item']//a[text()='"+ sortOption +"']")));
        //Wait for the last list item loaded
        SearchResultPage.LASTLISTITEM.waitUntilVisible();
    }

    public static SortResultsByInputOption by(String sortOption) {
        return instrumented(SortResultsByInputOption.class, sortOption);
    }

}