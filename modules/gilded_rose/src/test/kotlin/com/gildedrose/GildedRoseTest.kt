package com.gildedrose

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

const val SULFURAS = "Sulfuras, Hand of Ragnaros"
const val AGED_BRIE = "Aged Brie"
const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
const val DEFAULT_NAME = "foo"

class GildedRoseTest {

    @Test
    fun `it should reduce sell in date to negative values`() {
        val sellIn = 0
        val quality = 0
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().sellIn).isEqualTo(-1)
    }

    @Test
    fun `it should reduce quality by one`() {
        val sellIn = 5
        val quality = 10
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(9)
    }

    @Test
    fun `it should reduce sell in date by one`() {
        val sellIn = 5
        val quality = 10
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().sellIn).isEqualTo(4)
    }

    @Test
    fun `it should reduce by two after sell by date has passed`() {
        val sellIn = 0
        val quality = 10
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(8)
    }

    @Test
    fun `it should never turn quality into negative values`() {
        val sellIn = 5
        val quality = 0
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(0)
    }

    @Test
    fun `it should increase quality of aged brie`() {
        val name = AGED_BRIE
        val sellIn = 5
        val quality = 0
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(1)
    }

    @Test
    fun `it should not increase quality of aged brie over fifty`() {
        val name = AGED_BRIE
        val sellIn = 5
        val quality = 50
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(50)
    }

    @Test
    fun `it should not decrease quality of sulfuras`() {
        val name = SULFURAS
        val sellIn = 5
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(17)
    }

    @Test
    fun `it should increase quality of backstage passes by one if eleven days left`() {
        val name = BACKSTAGE_PASSES
        val sellIn = 11
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(18)
    }

    @Test
    fun `it should increase quality of backstage passes by two if ten days left`() {
        val name = BACKSTAGE_PASSES
        val sellIn = 10
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(19)
    }

    @Test
    fun `it should increase quality of backstage passes by two if six days left`() {
        val name = BACKSTAGE_PASSES
        val sellIn = 6
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(19)
    }

    @Test
    fun `it should increase quality of backstage passes by three if five days left`() {
        val name = BACKSTAGE_PASSES
        val sellIn = 5
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(20)
    }

    @Test
    fun `it should drop quality of backstage passes to zero if one day left`() {
        val name = BACKSTAGE_PASSES
        val sellIn = 1
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(20)
    }

    @Test
    fun `it should drop quality of backstage passes to zero if zero days left`() {
        val name = BACKSTAGE_PASSES
        val sellIn = 0
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(0)
    }


    private fun createShopAndUpdateQuality(sellIn: Int, quality: Int): GildedRose {
        return createShopAndUpdateQuality(DEFAULT_NAME, sellIn, quality)
    }

    private fun createShopAndUpdateQuality(name: String, sellIn: Int, quality: Int): GildedRose {
        val items = arrayOf(Item(name, sellIn, quality))
        val app = GildedRose(items)
        app.updateQuality()
        return app
    }
}

