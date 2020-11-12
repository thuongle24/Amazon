package automation.amazon.tasks;

import automation.amazon.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Search implements Task {

    private final String searchTerm;
    private final String option;

    protected Search(String searchTerm, String option) {
        this.searchTerm = searchTerm;
        this.option = option;
    }

    @Step("Search for #searchTerm with option #option")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(searchTerm).into(HomePage.SEARCHTXT),
                SelectFromOptions.byVisibleText(option).from(HomePage.SEARCHBOX),
                Click.on(HomePage.SEARCHBTN)
        );
    }

    public static Search forTheTerm(String searchTerm, String option) {
        return instrumented(Search.class, searchTerm, option);
    }

}
