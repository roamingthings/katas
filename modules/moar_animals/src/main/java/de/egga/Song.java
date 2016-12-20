package de.egga;

import java.util.Arrays;
import java.util.List;

public class Song {


    public static void main(String[] args) {

        List<Animal> animals = Arrays.asList(
                new Animal("fly", ""),
                new Animal("spider", "That wriggled and wiggled and tickled inside her."),
                new Animal("bird", "How absurd to swallow a bird."),
                new Animal("cat", "Fancy that to swallow a cat!"),
                new Animal("dog", "What a hog, to swallow a dog!"),
                new Animal("cow", "I don't know how she swallowed a cow!")
        );

        SongWriter songWriter = new SongWriter(animals);

        System.out.println(songWriter.beCreative());
    }


}
