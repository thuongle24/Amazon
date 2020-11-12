package automation.amazon.actions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitAndClick extends PageObject implements Task {

    private By by;
    private WebElementFacade element;
    EnvironmentVariables environmentVariables;
    private int timeout = 15; //seconds
    private int interval = 3; // Integer.parseInt(SerenitySystemProperties.getProperties().getValue(ThucydidesSystemProperty.WEBDRIVER_TIMEOUTS_FLUENTWAIT)); //seconds

    public WaitAndClick(By by) {
        this.by = by;
    }

   /* public WaitAndClick(WebElementFacade element) {
        this.element = element;
    }

    public static WaitAndClick forElement(WebElementFacade element){
        return instrumented(WaitAndClick.class, element);
    }*/

    public static WaitAndClick forElement(By by){
        return instrumented(WaitAndClick.class, by);
    }

    public WaitAndClick withTimeOut(int timeout){
        this.timeout = timeout;
        return this;
    }

    public WaitAndClick andInterval(int interval){
        this.interval = interval;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //System.out.print(timeout);
        if (by != null) {
            waitForCondition().withTimeout(
                    Duration.ofSeconds(timeout)).pollingEvery(Duration.ofSeconds(interval))
                    .until(ExpectedConditions.elementToBeClickable(by)).click();
        }
    }
}
