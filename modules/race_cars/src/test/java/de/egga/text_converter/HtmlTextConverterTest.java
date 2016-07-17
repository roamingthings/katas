package de.egga.text_converter;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {

    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter("fixme");
        assertEquals("fixme", converter.getFilename());
    }
}