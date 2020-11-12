package automation.amazon.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {
    public static final Target EMAILTXT = Target.the("Email textbox").locatedBy("#ap_email");
    public static final Target PASSTXT = Target.the("Password textbox").locatedBy("#ap_password");
    public static final Target CONTINUEBTN = Target.the("Continue button").locatedBy("#continue");
    public static final Target SIGNINBTN = Target.the("Signin button").locatedBy("#signInSubmit");
    public static final Target PHONESKIPLINK = Target.the("Phone Number Skip link").locatedBy("#ap-account-fixup-phone-skip-link");

}


