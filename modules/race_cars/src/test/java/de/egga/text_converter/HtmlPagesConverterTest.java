package de.egga.text_converter;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class HtmlPagesConverterTest {

    @Test
    @Ignore
    public void foo() throws IOException {
        HtmlPagesConverter converter = new HtmlPagesConverter("fixme");
        assertEquals("fixme", converter.getFilename());
    }
}