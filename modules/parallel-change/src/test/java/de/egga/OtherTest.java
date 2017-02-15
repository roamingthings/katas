package de.egga;


import org.junit.Assert;
import org.junit.Test;


public class OtherTest {

    @Test
    public void singleItem_numberOfProductsInTheCart() throws Exception {
        ImagineThisIsAClientInADifferentRepository client = new ImagineThisIsAClientInADifferentRepository();

        Assert.assertEquals("Total price is 50 euro", client.formattedTotalPrice(50));
    }

}
