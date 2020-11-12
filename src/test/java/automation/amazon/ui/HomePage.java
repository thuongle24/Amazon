package automation.amazon.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {
    public static final Target SEARCHTXT = Target.the( "Search textbox" ).locatedBy( "#twotabsearchtextbox" );
    public static final Target SEARCHBTN = Target.the( "Search button" ).locatedBy( "#nav-search-submit-text" );
    public static final Target SEARCHBOX = Target.the( "Search dropdown box" ).locatedBy( "#searchDropdownBox" );
    public static final Target LOGINLINK = Target.the("Login link").locatedBy("#nav-link-accountList");
}
