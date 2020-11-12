package automation.amazon.tasks;

import automation.amazon.actions.SortResultsByInputOption;
import automation.amazon.ui.SearchResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckSortingByPublicationDate implements Task {
    SearchResultPage page = new SearchResultPage();
    public boolean isSorted;

    protected CheckSortingByPublicationDate(boolean isSorted) {
        this.isSorted=isSorted;
    }

    @Step("{0} check the search results is sorted by #sortOption")
    public <T extends Actor> void performAs(T actor) {
        isSorted=false;
        System.out.println("Items are Sorted by Publication date");
        //Select sort option
        actor.attemptsTo(SortResultsByInputOption.by("Publication Date"));
        //Get list is sorted
        try {
            isSorted=getListSorted();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        actor.attemptsTo(Ensure.that(isSorted).isEqualTo(true));
   }
    public static CheckSortingByPublicationDate is(boolean isSorted) {
        return instrumented(CheckSortingByPublicationDate.class,isSorted);
    }
    public boolean getListSorted() throws ParseException {
        //Get the Publication Date of first item and pass the value into date1, date2 variables
        //This is for having the value to check at the 1st time
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        String date = "";
        date = page.getPubDateValue();
        System.out.println(date);
        Date date1 = formatter.parse(date);
        System.out.println(date1);
        Date date2 = formatter.parse(date);
        System.out.println(date2);
        //Get current List size value
        int totalitems = page.getPubDateList().size();
        System.out.println(totalitems); ;
        //Start to compare the Publication Date of the 1st item with the 2nd one
        //If the 1st one >= the 2nd one, return true
        //Otherwise, return false
        //Keep comparing for the next items in the list to make sure the next date is always <= the previous date
        for (int i=0; i<totalitems; i++)
        {
            date = page.getPubDateList().get(i).toString();
            System.out.println(date);
            try {
                date1 = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date1.after(date2))
            {
                isSorted= false;
            }
            date2 = date1;
        }
        return isSorted;
    }
}