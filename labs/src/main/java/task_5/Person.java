package task_5;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
    private String name;

    @JsonProperty("isWorking")
    private boolean working;

    private long timestamp;
    private List<String> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isWorking=" + working +
                ", timestamp=" + timestamp +
                ", friends=" + friends +
                '}';
    }
}