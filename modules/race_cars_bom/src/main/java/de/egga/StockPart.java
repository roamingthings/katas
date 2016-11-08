package de.egga;

public class StockPart {

    private final String name;
    private final String serialNo;
    private final Integer weight;
    private final String manufacturer;

    public StockPart(String name, String serialNo, Integer weight, String manufacturer) {
        this.name = name;
        this.serialNo = serialNo;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
