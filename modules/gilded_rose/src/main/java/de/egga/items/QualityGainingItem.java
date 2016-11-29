package de.egga.items;

public class QualityGainingItem extends BaseItem {

    public QualityGainingItem(Item item) {
        super(item);
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    public void updateQuality() {
        increaseQualityBy(1);
    }
}
