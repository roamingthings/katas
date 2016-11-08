package de.egga;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CipherLetterTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"A", "N"}, {"B", "O"}, {"C", "P"}, {"D", "Q"},
                {"E", "R"}, {"F", "S"}, {"G", "T"}, {"H", "U"},
                {"I", "V"}, {"J", "W"}, {"K", "X"}, {"L", "Y"},
                {"M", "Z"}, {"N", "A"}, {"O", "B"}, {"P", "C"},
                {"Q", "D"}, {"R", "E"}, {"S", "F"}, {"T", "G"},
                {"U", "H"}, {"V", "I"}, {"W", "J"}, {"X", "K"},
                {"Y", "L"}, {"Z", "M"},
        });
    }

    @Parameter(value = 0)
    public String plain;
    @Parameter(value = 1)
    public String encoded;


    @Test
    public void cipher_should_encode_text() {
        Cipher cipher = new Cipher();
        SoftAssertions assertions = new SoftAssertions();

        assertions.assertThat(
                cipher.encode(plain.toLowerCase())).
                isEqualTo(encoded);
        assertions.assertThat(
                cipher.encode(plain)).
                isEqualTo(encoded);

        assertions.assertAll();
    }
}