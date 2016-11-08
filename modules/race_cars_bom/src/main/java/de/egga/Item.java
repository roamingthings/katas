package de.egga;

public class Item {

    private final String name;
    private final String serialNo;
    private final Integer weight;

    public Item(String name, String serialNo, Integer weight) {
        this.name = name;
        this.serialNo = serialNo;
        this.weight = weight;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (serialNo != null ? !serialNo.equals(item.serialNo) : item.serialNo != null) return false;
        return !(weight != null ? !weight.equals(item.weight) : item.weight != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (serialNo != null ? serialNo.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }
}
