package de.egga;

import org.junit.Test;

import static de.egga.Constants.AGED_BRIE;
import static de.egga.Constants.BACKSTAGE_PASSES;
import static de.egga.Constants.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    public static final String DEFAULT_NAME = "foo";

    @Test
    public void it_should_reduce_sell_in_date_to_negative_values() {
        int sellIn = 0;
        int quality = 0;
        GildedRose app = createShopAndUpdateQuality(sellIn, quality);
        assertThat(app.getFirstItem().sellIn).isEqualTo(-1);
    }

    @Test
    public void it_should_reduce_quality_by_one() {
        int sellIn = 5;
        int quality = 10;
        GildedRose app = createShopAndUpdateQuality(sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(9);
    }

    @Test
    public void it_should_reduce_sell_in_date_by_one() {
        int sellIn = 5;
        int quality = 10;
        GildedRose app = createShopAndUpdateQuality(sellIn, quality);
        assertThat(app.getFirstItem().sellIn).isEqualTo(4);
    }

    @Test
    public void it_should_reduce_by_two_after_sell_by_date_has_passed() {
        int sellIn = 0;
        int quality = 10;
        GildedRose app = createShopAndUpdateQuality(sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(8);
    }

    @Test
    public void it_should_never_turn_quality_into_negative_values() {
        int sellIn = 5;
        int quality = 0;
        GildedRose app = createShopAndUpdateQuality(sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(0);
    }

    @Test
    public void it_should_increase_quality_of_aged_brie() {
        String name = AGED_BRIE;
        int sellIn = 5;
        int quality = 0;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(1);
    }

    @Test
    public void it_should_not_increase_quality_of_aged_brie_over_fifty() {
        String name = AGED_BRIE;
        int sellIn = 5;
        int quality = 50;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(50);
    }
    @Test
    public void it_should_not_decrease_quality_of_sulfuras() {
        String name = SULFURAS;
        int sellIn = 5;
        int quality = 17;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(17);
    }

    @Test
    public void it_should_increase_quality_of_backstage_passes_by_one_if_eleven_days_left() {
        String name = BACKSTAGE_PASSES;
        int sellIn = 11;
        int quality = 17;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(18);
    }

    @Test
    public void it_should_increase_quality_of_backstage_passes_by_two_if_ten_days_left() {
        String name = BACKSTAGE_PASSES;
        int sellIn = 10;
        int quality = 17;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(19);
    }

    @Test
    public void it_should_increase_quality_of_backstage_passes_by_two_if_six_days_left() {
        String name = BACKSTAGE_PASSES;
        int sellIn = 6;
        int quality = 17;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(19);
    }

    @Test
    public void it_should_increase_quality_of_backstage_passes_by_three_if_five_days_left() {
        String name = BACKSTAGE_PASSES;
        int sellIn = 5;
        int quality = 17;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(20);
    }

    @Test
    public void it_should_drop_quality_of_backstage_passes_to_zero_if_one_day_left() {
        String name = BACKSTAGE_PASSES;
        int sellIn = 1;
        int quality = 17;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(20);
    }

    @Test
    public void it_should_drop_quality_of_backstage_passes_to_zero_if_zero_days_left() {
        String name = BACKSTAGE_PASSES;
        int sellIn = 0;
        int quality = 17;
        GildedRose app = createShopAndUpdateQuality(name, sellIn, quality);
        assertThat(app.getFirstItem().quality).isEqualTo(0);
    }


    private GildedRose createShopAndUpdateQuality(int sellIn, int quality) {
        return createShopAndUpdateQuality(DEFAULT_NAME, sellIn, quality);
    }

    private GildedRose createShopAndUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app;
    }

}
