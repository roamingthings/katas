package de.egga;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

public class SongTest {

    PrintStream originalStandardOut = System.out;

    @Test
    public void expected_song_should_be_printed_to_standard_out() throws UnsupportedEncodingException {

        ByteArrayOutputStream capturedOutput = captureStandardOut();

        Song.main(anyArgs());

        setStandardOutBackToOriginal();

        assertThat(capturedOutput.toString("UTF8")).isEqualTo(expectedSong());
    }

    void setStandardOutBackToOriginal() {
        System.setOut(originalStandardOut);
    }

    ByteArrayOutputStream captureStandardOut() {
        ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));
        return capturedOutput;
    }

    String[] anyArgs() {
        return new String[1];
    }

    String expectedSong() {
        return "There was an old lady who swallowed a fly.\n" +
                    "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a spider;\n" +
                    "That wriggled and wiggled and tickled inside her.\n" +
                    "She swallowed the spider to catch the fly;\n" +
                    "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a bird;\n" +
                    "How absurd to swallow a bird.\n" +
                    "She swallowed the bird to catch the spider,\n" +
                    "She swallowed the spider to catch the fly;\n" +
                    "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a cat;\n" +
                    "Fancy that to swallow a cat!\n" +
                    "She swallowed the cat to catch the bird,\n" +
                    "She swallowed the bird to catch the spider,\n" +
                    "She swallowed the spider to catch the fly;\n" +
                    "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a dog;\n" +
                    "What a hog, to swallow a dog!\n" +
                    "She swallowed the dog to catch the cat,\n" +
                    "She swallowed the cat to catch the bird,\n" +
                    "She swallowed the bird to catch the spider,\n" +
                    "She swallowed the spider to catch the fly;\n" +
                    "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a cow;\n" +
                    "I don't know how she swallowed a cow!\n" +
                    "She swallowed the cow to catch the dog,\n" +
                    "She swallowed the dog to catch the cat,\n" +
                    "She swallowed the cat to catch the bird,\n" +
                    "She swallowed the bird to catch the spider,\n" +
                    "She swallowed the spider to catch the fly;\n" +
                    "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                    "\n" +
                    "There was an old lady who swallowed a horse...\n" +
                    "...She's dead, of course!\n";
    }

}