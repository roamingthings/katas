package de.egga;

public class CustomMadeItem extends Item {

    private final String manufacturer;

    public CustomMadeItem(String name, String serialNo, Integer weight, String manufacturer) {
        super(name, serialNo, weight);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
