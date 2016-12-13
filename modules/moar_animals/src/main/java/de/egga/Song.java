package de.egga;

import java.util.ArrayList;

public class Song {

    private static String first_sentence = "There was an old lady who swallowed a ";
    private static String last_sentence_beginning = "I don't know why she swallowed a ";
    private static String last_sentence_ending = " - perhaps she'll die!\n";

    private static String list_beginning = "She swallowed the ";
    private static String list_middle = " to catch the ";

    private static ArrayList<String> names = new ArrayList<>();


    public static void main(String[] args) {

        String song = createParagraph("fly", "") +
                createParagraph("spider", "That wriggled and wiggled and tickled inside her.") +
                createParagraph("bird", "How absurd to swallow a bird.") +
                createParagraph("cat", "Fancy that to swallow a cat!") +
                createParagraph("dog", "What a hog, to swallow a dog!") +
                createParagraph("cow", "I don't know how she swallowed a cow!") +
                first_sentence + "horse...\n" + "...She's dead, of course!";

        System.out.println(song);
    }

    public static String createParagraph(String second_animal, String second_animal_text) {
        String second_paragraph = paragraph(second_animal, second_animal_text, toArray(names));
        names.add(0, second_animal);
        return second_paragraph;
    }

    public static String[] toArray(ArrayList<String> names) {
        return names.toArray(new String[names.size()]);
    }

    private static String paragraph(String animal, String text, String... previousAnimals) {

        String strophe = getStrophe(animal, previousAnimals);

        String lastAnimal = previousAnimals.length > 0 ? getLastAnimal(previousAnimals) : animal;
        String separator = previousAnimals.length > 0 ? ";\n" : ".";
        String separator2 = previousAnimals.length > 0 ? ";\n" : "";

        return first_sentence + animal + separator +
                text + "\n" +
                strophe + separator2 +
                last_sentence_beginning + lastAnimal + last_sentence_ending + "\n";
    }

    private static String getStrophe(String animal, String[] previousAnimals) {

        if (previousAnimals.length == 0) {
            return "";
        }


        String strophe = "";

        for (String previousAnimal : previousAnimals) {
            strophe += list_beginning + animal + list_middle + previousAnimal + ",\n";
            animal = previousAnimal;
        }

        return cutOffLastTwoCharacters(strophe);
    }

    private static String getLastAnimal(String[] animals) {
        return animals[animals.length - 1];
    }

    private static String cutOffLastTwoCharacters(String meat) {
        return meat.substring(0, meat.length() - 2);
    }
}
