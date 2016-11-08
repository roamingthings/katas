package de.egga;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterial {

    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        if (item instanceof PackagedItem) {
            items.add(new Item(item.getName(), item.getSerialNo(), ((PackagedItem) item).getGrossWeight()));
        } else {
            items.add(item);
        }
    }

    public void add(StockPart part) {
        items.add(new Item(part.getName() + " (" + part.getManufacturer() + ")", part.getSerialNo(), part.getWeight()));
    }

    public List<Item> getItems() {
        return items;
    }
}
