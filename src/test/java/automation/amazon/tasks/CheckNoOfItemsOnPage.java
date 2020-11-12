package automation.amazon.tasks;

import automation.amazon.actions.WaitAndClick;
import automation.amazon.ui.SearchResultPage;
import automation.utils.Constant;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.locators.WaitForWebElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckNoOfItemsOnPage implements Task {
    SearchResultPage page = new SearchResultPage();
    private final int expectedItems;

    protected CheckNoOfItemsOnPage(int expectedItems) {
        this.expectedItems = expectedItems;
    }

    @Step("{0} ensure total of resut items display is #expectedItems")
    public <T extends Actor> void performAs(T actor) {
        //It quite takes a long execution time to go from the first to the end page,
        //So I just check the first 5 pages for example
        for(int i=0; i<5;i++) {
            //Wait for the next button is actually visible
            actor.attemptsTo(Wait.until(
                    WebElementQuestion.the(SearchResultPage.NEXTBTN) , WebElementStateMatchers.isCurrentlyVisible())
                    .forNoLongerThan(Constant.TIMEOUT).seconds());
            actor.attemptsTo(WaitAndClick.forElement(SearchResultPage.NEXTBTN));
            //Wait for the last list item loaded
            SearchResultPage.LASTLISTITEM.waitUntilVisible();
            actor.attemptsTo(Ensure.that(page.getTotalSearchItemOnPage().size()).isEqualTo(expectedItems));
        }
    }

    public static CheckNoOfItemsOnPage is(int expectedItems) {
        return instrumented(CheckNoOfItemsOnPage.class, expectedItems);
    }
}