public class Professor {
    private String name;
    private String researchInterest;
    private String website;

    public Professor(String name, String researchInterest, String website) {
        this.name = name;
        this.researchInterest = researchInterest;
        this.website = website;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getResearchInterest() {
        return researchInterest;
    }
    public String getWebsite() {
        return website;
    }
}