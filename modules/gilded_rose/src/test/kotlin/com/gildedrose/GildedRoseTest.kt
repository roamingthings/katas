package com.gildedrose

import com.gildedrose.Constants.AGED_BRIE
import com.gildedrose.Constants.BACKSTAGE_PASSES
import com.gildedrose.Constants.SULFURAS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

object Constants {

    val SULFURAS = "Sulfuras, Hand of Ragnaros"

    val AGED_BRIE = "Aged Brie"

    val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"

    val TOP_QUALITY = 50

}

class GildedRoseTest {

    @Test
    fun it_should_reduce_sell_in_date_to_negative_values() {
        val sellIn = 0
        val quality = 0
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().sellIn).isEqualTo(-1)
    }

    @Test
    fun it_should_reduce_quality_by_one() {
        val sellIn = 5
        val quality = 10
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(9)
    }

    @Test
    fun it_should_reduce_sell_in_date_by_one() {
        val sellIn = 5
        val quality = 10
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().sellIn).isEqualTo(4)
    }

    @Test
    fun it_should_reduce_by_two_after_sell_by_date_has_passed() {
        val sellIn = 0
        val quality = 10
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(8)
    }

    @Test
    fun it_should_never_turn_quality_into_negative_values() {
        val sellIn = 5
        val quality = 0
        val app = createShopAndUpdateQuality(sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(0)
    }

    @Test
    fun it_should_increase_quality_of_aged_brie() {
        val name = AGED_BRIE
        val sellIn = 5
        val quality = 0
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(1)
    }

    @Test
    fun it_should_not_increase_quality_of_aged_brie_over_fifty() {
        val name = AGED_BRIE
        val sellIn = 5
        val quality = 50
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(50)
    }

    @Test
    fun it_should_not_decrease_quality_of_sulfuras() {
        val name = SULFURAS
        val sellIn = 5
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(17)
    }

    @Test
    fun it_should_increase_quality_of_backstage_passes_by_one_if_eleven_days_left() {
        val name = BACKSTAGE_PASSES
        val sellIn = 11
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(18)
    }

    @Test
    fun it_should_increase_quality_of_backstage_passes_by_two_if_ten_days_left() {
        val name = BACKSTAGE_PASSES
        val sellIn = 10
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(19)
    }

    @Test
    fun it_should_increase_quality_of_backstage_passes_by_two_if_six_days_left() {
        val name = BACKSTAGE_PASSES
        val sellIn = 6
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(19)
    }

    @Test
    fun it_should_increase_quality_of_backstage_passes_by_three_if_five_days_left() {
        val name = BACKSTAGE_PASSES
        val sellIn = 5
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(20)
    }

    @Test
    fun it_should_drop_quality_of_backstage_passes_to_zero_if_one_day_left() {
        val name = BACKSTAGE_PASSES
        val sellIn = 1
        val quality = 17
        val app = createShopAndUpdateQuality(name, sellIn, quality)
        assertThat(app.items.first().quality).isEqualTo(20)
    }

    @Test
    fun it_should_drop_quality_of_backstage_passes_to_zero_if_zero_days_left() {
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

    companion object {

        val DEFAULT_NAME = "foo"
    }

}
