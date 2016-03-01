package de.egga.race_cars._001.text_converter;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {

    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("fixme", converter.getFilename());
    }
}