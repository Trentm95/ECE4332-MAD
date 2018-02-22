package codes.trent.travelguide;

public class Place {

    private int smallImage;

    private int largeImage;

    private String name;

    private String description;

    private String details;

    // Constructor
    public Place(int smallImage, int largeImage, String name, String description, String details) {
        this.smallImage = smallImage;
        this.largeImage = largeImage;
        this.name = name;
        this.description = description;
        this.details = details;
    }

    // Getters & Setters
    public int getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(int image) {
        this.smallImage = image;
    }

    public int getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(int image) {
        this.largeImage = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getDetails() { return details; }

    public void setDetails(String description) { this.details = details; }
}