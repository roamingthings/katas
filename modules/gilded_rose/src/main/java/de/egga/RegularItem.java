package de.egga;

public class RegularItem extends BaseItem {

    public RegularItem(Item item) {
        super(item);
    }

    public void updateSellIn() {
        decreaseSellIn();
    }

    public void updateQuality() {
        if (isStillGood()) {
            decreaseQualityBy(1);
        } else {
            decreaseQualityBy(2);
        }
    }
}
