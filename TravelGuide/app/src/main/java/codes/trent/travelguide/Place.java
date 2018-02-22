package codes.trent.travelguide;

public class Place {

    private int image;

    private String name;

    private String description;

    // Constructor
    public Place(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    // Getters & Setters
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}