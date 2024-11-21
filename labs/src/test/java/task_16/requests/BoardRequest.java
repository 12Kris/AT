package task_16.requests;

public class BoardRequest {
    private final String name;
    private final String idOrganization;

    public BoardRequest(String name, String idOrganization) {
        this.name = name;
        this.idOrganization = idOrganization;
    }

    public String getName() {
        return name;
    }
    public String getIdOrganization() {
        return idOrganization;
    }
}
