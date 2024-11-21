package task_16.requests;

public class OrganizationRequest {
    private final String name;
    private final String displayName;
    private final String website;

    public OrganizationRequest(String name, String website) {
        this.name = name;
        this.displayName = name;
        this.website = website;
    }

    public String getName() {
        return name;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getWebsite() {
        return website;
    }
}
