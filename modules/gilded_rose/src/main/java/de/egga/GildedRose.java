package de.egga;

import de.egga.items.Item;

import java.util.ArrayList;
import java.util.List;

import static de.egga.items.ItemFactory.createItem;
import static java.util.Arrays.asList;

class GildedRose {

    private List<Item> items = new ArrayList<>();

    public GildedRose(Item[] items) {
        this.items = asList(items);
    }

    public void updateQuality() {
        for (Item item : items) {
            createItem(item).update();
        }
    }

    public Item getFirstItem() {
        return items.get(0);
    }
}
