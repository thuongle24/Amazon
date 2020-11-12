package automation.amazon.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.*;
import org.openqa.selenium.By;


public class SelectFilterOptions implements Performable {
    String filterOption;

    public SelectFilterOptions to(String filterOption) {
        this.filterOption = filterOption;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(By.xpath("//li[@aria-label='" + filterOption + "']//input")));
    }
}
