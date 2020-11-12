package automation.amazon.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.SelectedStatus;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FilterByBookLanguage implements Task {

    private final String language;

    protected FilterByBookLanguage(String language) {
        this.language = language;
    }

    @Step("Filter search result by #language")
    public <T extends Actor> void performAs(T actor) {
        By element = By.xpath("//li[@aria-label='" + language + "']//input");
        Boolean itemChecked = SelectedStatus.of(element)
                .viewedBy(actor).as(Boolean.class);
        System.out.println(itemChecked);
        if(!itemChecked)
        {
                actor.attemptsTo(Hit.the(Keys.SPACE).into(element));
        }
    }

    public static FilterByBookLanguage forTheOption(String language) {
        return instrumented(FilterByBookLanguage.class, language);
    }

}
