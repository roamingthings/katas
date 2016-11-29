package de.egga.items;

import static de.egga.Constants.TOP_QUALITY;

public abstract class BaseItem {
    protected final Item item;

    public BaseItem(Item item) {
        this.item = item;
    }

    public void update() {
        updateSellIn();
        updateQuality();
    }

    public abstract void updateSellIn();

    public abstract void updateQuality();

    public boolean isStillGood() {
        return !sellInDateHasPassed();
    }
    public boolean sellInDateHasPassed() {
        return getSellIn() < 0;
    }

    public int getQuality() {
        return item.quality;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    void decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    void increaseQualityBy(int amount) {
        if (isNotTopQuality()) {
            item.quality = item.quality + amount;
        }
    }

    boolean isNotTopQuality() {
        return item.quality < TOP_QUALITY;
    }

    void setQualityToZero() {
        item.quality = 0;
    }

    void decreaseQualityBy(int amount) {
        if (getQuality() > 0) {
            item.quality = item.quality - amount;
        }
    }
}
