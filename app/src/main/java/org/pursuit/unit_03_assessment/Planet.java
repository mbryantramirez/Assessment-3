package org.pursuit.unit_03_assessment;

public class Planet {

    private String name;
    private int number;
    private String image;

    public Planet(String name, int number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getImage() {
        return image;
    }
}
