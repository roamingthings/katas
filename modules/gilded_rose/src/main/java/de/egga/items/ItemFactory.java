package de.egga.items;

import static de.egga.Constants.*;

public class ItemFactory {

    public static BaseItem createItem(Item item) {
        BaseItem returnedItem;
        String name = item.name;

        if (name.equals(AGED_BRIE)) {
            returnedItem = new QualityGainingItem(item);
        } else if (name.equals(BACKSTAGE_PASSES)) {
            returnedItem = new BackstagePasses(item);
        } else if (name.equals(SULFURAS)) {
            returnedItem = new Sulfuras(item);
        } else {
            returnedItem = new RegularItem(item);
        }

        return returnedItem;
    }
}
