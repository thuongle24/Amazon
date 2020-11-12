package automation.amazon.tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectButton implements Task {

    private final Target button;

    public SelectButton(Target button) {
        this.button = button;
    }

    @Step("{0} clicks on #button")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(button));
    }

    public static SelectButton of(Target button) {
        return instrumented(SelectButton.class, button);
    }

}
