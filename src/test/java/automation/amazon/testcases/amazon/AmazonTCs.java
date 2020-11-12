package automation.amazon.testcases.amazon;

import automation.amazon.actions.SortResultsByInputOption;
import automation.amazon.tasks.CheckNoOfItemsOnPage;
import automation.amazon.tasks.CheckSortingByPublicationDate;
import automation.amazon.testcases.Hook;
import automation.amazon.tasks.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class AmazonTCs extends Hook {

    Actor anna = Actor.named("thuong-amazon");

    @Managed
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb(){
        initialize(anna.getName());
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void User_only_see_16_result_items_per_page() {
        givenThat(anna).wasAbleTo(OpenTheApplication.with(url));
        //when(anna).attemptsTo(Login.withTheCredentials(username,password));
        and(anna).attemptsTo(Search.forTheTerm("apple","Books"),
                FilterByBookLanguage.forTheOption("English"));
        then(anna).attemptsTo(CheckNoOfItemsOnPage.is(16));
    }
    @Test
    public void User_able_to_sort_results_by_Publish_Date() {
        givenThat(anna).wasAbleTo(OpenTheApplication.with(url));
        //when(anna).attemptsTo(Login.withTheCredentials(username,password));
        and(anna).attemptsTo(
                Search.forTheTerm("apple","Books"),
                FilterByBookLanguage.forTheOption("English"),
                SortResultsByInputOption.by("Publication Date"));
        then(anna).attemptsTo(CheckSortingByPublicationDate.is(true));
    }
}