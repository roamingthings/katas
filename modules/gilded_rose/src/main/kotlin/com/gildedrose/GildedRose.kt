package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.isBrie() || item.isBackstage()) {
                item.incrementQuality()

                if (item.isBackstage()) {
                    if (item.sellIn < 11) {
                        item.incrementQuality()
                    }

                    if (item.sellIn < 6) {
                        item.incrementQuality()
                    }
                }
            } else {
                if (item.quality > 0) {
                    if (!item.isSulfuras()) {
                        item.decrementQuality()
                    }
                }
            }

            if (!item.isSulfuras()) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.isBrie()) {
                    item.incrementQuality()
                } else {
                    if (item.isBackstage()) {
                        item.quality = 0
                    } else {
                        if (item.quality > 0) {
                            if (!item.isSulfuras()) {
                                item.decrementQuality()
                            }
                        }
                    }
                }
            }
        }
    }

}

private fun Item.isBrie() = name.equals("Aged Brie")

private fun Item.isBackstage() = name.equals("Backstage passes to a TAFKAL80ETC concert")

private fun Item.isSulfuras() = name.equals("Sulfuras, Hand of Ragnaros")

private fun Item.incrementQuality() = if (quality < 50) quality++ else quality

private fun Item.decrementQuality() = quality--

