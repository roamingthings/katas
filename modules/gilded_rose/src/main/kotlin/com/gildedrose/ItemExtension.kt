package com.gildedrose;

const val SULFURAS = "Sulfuras, Hand of Ragnaros"
        const val AGED_BRIE = "Aged Brie"
        const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"

fun Item.isBrie() = name == AGED_BRIE

fun Item.isBackstage() = name == BACKSTAGE_PASSES

fun Item.isSulfuras() = name == SULFURAS

fun Item.incrementQuality() = if (quality < 50) ++quality else quality

fun Item.decrementQuality() = --quality

fun Item.decrementSellIn() = sellIn--

