package de.egga;

public class PackagedItem extends Item {

    private final Integer grossWeight;

    public PackagedItem(String name, String serialNo, Integer grossWeight) {
        super(name, serialNo, null);
        this.grossWeight = grossWeight;
    }

    public Integer getGrossWeight() {
        return grossWeight;
    }
}
