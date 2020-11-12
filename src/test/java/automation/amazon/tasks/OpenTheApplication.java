package automation.amazon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheApplication implements Task {
    private final String url;
    protected OpenTheApplication(String url) {
        this.url = url;
    }
    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
    public static Performable with(String url) {
        return instrumented(OpenTheApplication.class, url);
    }
}
