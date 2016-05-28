package problem21spring.model;

import org.springframework.data.annotation.Id;

/**
 * Created by rklimemnko on 28.05.2016.
 */
public class Message {
    @Id
    private String id;
    private Integer missionId;
    private Integer seed;

    public Message() {}

    public Message(Integer missionId, Integer seed) {
        this.missionId = missionId;
        this.seed = seed;
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
