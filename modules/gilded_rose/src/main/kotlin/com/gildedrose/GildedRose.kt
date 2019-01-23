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

const val SULFURAS = "Sulfuras, Hand of Ragnaros"
const val AGED_BRIE = "Aged Brie"
const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"

private fun Item.isBrie() = name == AGED_BRIE

private fun Item.isBackstage() = name == BACKSTAGE_PASSES

private fun Item.isSulfuras() = name == SULFURAS

private fun Item.incrementQuality() = if (quality < 50) ++quality else quality

private fun Item.decrementQuality() = --quality

private fun Item.decrementSellIn() = sellIn--
