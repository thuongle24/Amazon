package automation.amazon.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateFieldValue implements Task {
    Target field;
    String newValue;

    protected UpdateFieldValue(Target field, String newValue) {
        this.field = field;
        this.newValue = newValue;
    }

    @Step("{0} enters #newValue into the #field")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.keyValues(newValue).into(field));
    }


    public static Performable with(Target field, String newValue) {
        return instrumented(UpdateFieldValue.class, field, newValue);
    }
}