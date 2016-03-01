package de.egga.race_cars._001.text_converter;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class HtmlPagesConverterTest {

    @Test
    public void foo() throws IOException {
        HtmlPagesConverter converter = new HtmlPagesConverter("foo");
        assertEquals("fixme", converter.getFilename());
    }
}