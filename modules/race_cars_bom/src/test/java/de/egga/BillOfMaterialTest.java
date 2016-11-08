package de.egga;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BillOfMaterialTest {

    @Test
    public void it_should_list_all_items() {
        BillOfMaterial bom = new BillOfMaterial();

        bom.add(item());
        assertThat(bom.getItems()).contains(new Item("Steering wheel", "---", 4));

        bom.add(stockpart());
        assertThat(bom.getItems()).contains(new Item("Stickers (Sponsor #1)", "A382462", 20));

        bom.add(packagedItem());
        assertThat(bom.getItems()).contains(new Item("Helmet", "Rainbow Dash", 18));

    }

    private PackagedItem packagedItem() {
        return new PackagedItem("Helmet", "Rainbow Dash", 18);
    }


    private Item item() {
        return new Item("Steering wheel", "---", 4);
    }

    private StockPart stockpart() {
        return new StockPart("Stickers", "A382462", 20, "Sponsor #1");
    }
}