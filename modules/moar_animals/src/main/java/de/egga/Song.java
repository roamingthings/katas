package de.egga;

import java.util.ArrayList;
import java.util.List;

class Song {

    private String firstSentence = "There was an old lady who swallowed a ";
    private String lastSentenceBeginning = "I don't know why she swallowed a ";
    private String lastSentenceEnding = " - perhaps she'll die!\n";
    private String listBeginning = "She swallowed the ";
    private String listMiddle = " to catch the ";

    private ArrayList<String> names = new ArrayList<>();
    private List<Animal> animals;

    Song(List<Animal> animals) {
        this.animals = animals;
    }

    String sing() {
        String song = "";

        for (Animal animal : animals) {
            song += createParagraph(animal);
        }

        song += conclusion();
        return song;
    }

    private String createParagraph(Animal animal) {

        String paragraph = paragraph(animal);
        names.add(0, animal.name);
        return paragraph;
    }


    private String paragraph(Animal animal) {

        return beginningOfParagraph(animal) +
                getStrophe(animal) +
                endingOFParapraph(animal);
    }

    private String endingOFParapraph(String animal) {
        String lastAnimal = names.size() > 0 ? getLastAnimal() : animal;
        return lastSentenceBeginning + lastAnimal + lastSentenceEnding + "\n";
    }

    private String beginningOfParagraph(Animal animal) {
        String separator = previousAnimals.length > 0 ? ";\n" : ".";
        return firstSentence + animal.name + separator +  animal.text + "\n";
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

        String cutOffLastTwoCharacters = cutOffLastTwoCharacters(strophe);

        String separator2 = previousAnimals.length > 0 ? ";\n" : "";

        return cutOffLastTwoCharacters + separator2;
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

    private String getLastAnimal() {
        return names.get(names.size() - 1);
    }

    private String cutOffLastTwoCharacters(String string) {
        return string.substring(0, string.length() - 2);
    }
}