package task_16.responses;

public class OrganizationResponse {
    private String id;
    private String displayName;
    private String desc;
    private String website;
    private String name;
    private String url; // Додаємо поле url

    // Геттери та сеттери
    public String getId() { return id; }
    public String getDisplayName() { return displayName; }
    public String getDesc() { return desc; }
    public String getWebsite() { return website; }
    public String getName() { return name; }
    public String getUrl() { return url; }

    public void setId(String id) { this.id = id; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public void setDesc(String desc) { this.desc = desc; }
    public void setWebsite(String website) { this.website = website; }
    public void setName(String name) { this.name = name; }
    public void setUrl(String url) { this.url = url; }
}