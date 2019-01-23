package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
         for (item in items) when {
             item.isBrie() -> updateBrie(item)
             item.isBackstage() -> updateBackstage(item)
             item.isSulfuras() -> {}    // Sulfuras does not age nor decrease in quality
             else -> updateOrdinary(item)
         }
    }

    private fun updateOrdinary(item: Item) {

        if (item.quality > 0) item.decrementQuality()

        item.decrementSellIn()

        if (item.sellIn < 0 && item.quality > 0) item.decrementQuality()
    }


    private fun updateBrie(item: Item) {

        item.incrementQuality()

        item.decrementSellIn()

        if (item.sellIn < 0) item.incrementQuality()
    }

    private fun updateBackstage(item: Item) {

        item.incrementQuality()

        if (item.sellIn < 11) item.incrementQuality()

        if (item.sellIn < 6) item.incrementQuality()

        item.decrementSellIn()

        if (item.sellIn < 0) item.quality = 0
    }

}
