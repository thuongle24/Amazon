package automation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Actors {
    @JsonProperty("actors")
    private List<ActorInfo> actorInfo;

    public List<ActorInfo> getActorInfo() {
        return actorInfo;
    }

    public void setActorInfo(List<ActorInfo> actorInfo) {
        this.actorInfo = actorInfo;
    }
}
