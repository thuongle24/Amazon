package automation.amazon.testcases;

import automation.model.Actors;
import automation.utils.Constant;
import automation.utils.JsonUtil;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;

public class Hook extends PageObject {
    private static Actors actors = JsonUtil.convertJsonToObject(Constant.ACTOR_INFO_JSON_FILE, Actors.class);
    public static String username = Constant.DEFAULT_USERNAME;
    public static String password = Constant.DEFAULT_PASSWORD;
    public static String environment;
    public static String url;
    private static EnvironmentVariables environmentVariables;
    public static void initialize(String actorName) {
        url = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");
        for(int i=0; i<actors.getActorInfo().size();i++)
        {
            if(actors.getActorInfo().get(i).getName().equalsIgnoreCase(actorName))
            {
                username=actors.getActorInfo().get(i).getUsername();
                password=actors.getActorInfo().get(i).getPassword();
                environment=actors.getActorInfo().get(i).getEnvironment();
                url =  EnvironmentSpecificConfiguration.from(environmentVariables)
                        .getProperty("environments." + environment +".webdriver.base.url");
                break;
            }
        }

    }
}
