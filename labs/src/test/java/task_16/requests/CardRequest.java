package task_16.requests;

public class CardRequest {
    private final String name;
    private final String idList;

    public CardRequest(String name, String idList) {
        this.name = name;
        this.idList = idList;
    }

    public String getName() {
        return name;
    }
    public String getIdList() {
        return idList;
    }
}
