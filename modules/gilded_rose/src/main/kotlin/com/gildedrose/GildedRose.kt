package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (isBrie(item) || isBackstage(item)) {
                item.incrementQuality()

                if (isBackstage(item)) {
                    if (item.sellIn < 11) {
                        item.incrementQuality()
                    }

                    if (item.sellIn < 6) {
                        item.incrementQuality()
                    }
                }
            } else {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.decrementQuality()
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (isBrie(item)) {
                    item.incrementQuality()
                } else {
                    if (isBackstage(item)) {
                        item.quality = 0
                    } else {
                        if (item.quality > 0) {
                            if (!isSulfuras(item)) {
                                item.decrementQuality()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun isSulfuras(item: Item) = item.name.equals("Sulfuras, Hand of Ragnaros")

    private fun isBackstage(item: Item) = item.name.equals("Backstage passes to a TAFKAL80ETC concert")

    private fun isBrie(item: Item) = item.name.equals("Aged Brie")

}

fun Item.incrementQuality() = if (this.quality < 50) this.quality++ else this.quality

fun Item.decrementQuality() = this.quality--

