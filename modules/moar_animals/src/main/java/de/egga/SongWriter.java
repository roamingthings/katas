package de.egga;

import java.util.ArrayList;
import java.util.List;

class SongWriter {

    private String firstSentence = "There was an old lady who swallowed a ";
    private String lastSentenceBeginning = "I don't know why she swallowed a ";
    private String lastSentenceEnding = " - perhaps she'll die!\n";
    private String listBeginning = "She swallowed the ";
    private String listMiddle = " to catch the ";

    private ArrayList<String> names = new ArrayList<>();
    private List<Animal> animals;

    SongWriter(List<Animal> animals) {
        this.animals = animals;
    }


    String beCreative() {
        String song = "";

        for (Animal animal : animals) {
            song += createParagraph(animal);
        }

        song += conclusion();
        return song;
    }

    private String createParagraph(Animal animal) {
        String paragraph = paragraph(animal.name, animal.text, toArray(names));
        names.add(0, animal.name);
        return paragraph;
    }

    private String paragraph(String animal, String text, String... previousAnimals) {

        String strophe = getStrophe(animal, previousAnimals);

        String lastAnimal = previousAnimals.length > 0 ? getLastAnimal(previousAnimals) : animal;
        String separator = previousAnimals.length > 0 ? ";\n" : ".";
        String separator2 = previousAnimals.length > 0 ? ";\n" : "";

        return firstSentence + animal + separator +
                text + "\n" +
                strophe + separator2 +
                lastSentenceBeginning + lastAnimal + lastSentenceEnding + "\n";
    }

    private String getStrophe(String animal, String[] previousAnimals) {

        if (previousAnimals.length == 0) {
            return "";
        }


        String strophe = "";

        for (String previousAnimal : previousAnimals) {
            strophe += stropheLine(animal, previousAnimal);
            animal = previousAnimal;
        }

        return cutOffLastTwoCharacters(strophe);
    }

    private String stropheLine(String animal, String previousAnimal) {
        return listBeginning + animal + listMiddle + previousAnimal + ",\n";
    }

    private String conclusion() {
        return firstSentence + "horse...\n" + "...She's dead, of course!";
    }


    private String[] toArray(ArrayList<String> names) {
        return names.toArray(new String[names.size()]);
    }

    private String getLastAnimal(String[] animals) {
        return animals[animals.length - 1];
    }

    private String cutOffLastTwoCharacters(String meat) {
        return meat.substring(0, meat.length() - 2);
    }
}