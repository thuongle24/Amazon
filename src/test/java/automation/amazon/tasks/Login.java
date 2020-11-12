package automation.amazon.tasks;

import automation.amazon.ui.HomePage;
import automation.amazon.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {

    private final String email;
    private final String passWord;

    protected Login(String email, String passWord) {
        this.email=email;
        this.passWord = passWord;
    }

    @Step("Login with #email and #passWord")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.LOGINLINK),
                Enter.keyValues(email)
                        .into(LoginPage.EMAILTXT),
                Click.on(LoginPage.CONTINUEBTN),
                Enter.keyValues(passWord)
                        .into(LoginPage.PASSTXT),
                Click.on(LoginPage.SIGNINBTN)
                //Click.on(LoginPage.PHONESKIPLINK)
        );
    }

    public static Login withTheCredentials(String email, String passWord) {
        return instrumented(Login.class, email,passWord);
    }

}
