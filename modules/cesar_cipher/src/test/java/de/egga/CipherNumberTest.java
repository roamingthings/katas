package de.egga;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CipherNumberTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1"}, {"2"},
                {"3"}, {"4"},
                {"5"}, {"6"},
                {"7"}, {"8"},
                {"9"}, {"0"},

                {"!"}, {"§"},
                {"$"}, {"%"},
                {"&"}, {"*+"},
                {"|"}, {"<"},
                {"#"}, {"'"},
                {"`"}, {"("},
                {"/"}, {"'"},
                {"-"}, {"."},
                {";"},
        });
    }

    @Parameter
    public String plain;

    @Test
    public void cipher_should_encode_text() {
        Cipher cipher = new Cipher();
        String encoded = cipher.encode(plain);
        assertThat(encoded).isEqualTo(plain);
    }
}