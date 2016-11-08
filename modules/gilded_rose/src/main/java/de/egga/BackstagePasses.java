package de.egga;

public class BackstagePasses extends RegularItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {

        if (isStillGood()) {
            if (getSellIn() >= 10) {
                increaseQualityBy(1);
            } else if (getSellIn() >= 5) {
                increaseQualityBy(2);
            } else {
                increaseQualityBy(3);
            }
        } else {
            setQualityToZero();
        }
    }
}
