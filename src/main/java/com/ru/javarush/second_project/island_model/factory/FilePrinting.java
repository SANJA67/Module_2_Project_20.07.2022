package com.ru.javarush.second_project.island_model.factory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.island.Cell;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.storage.DataBase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilePrinting {
private static int maximumLength;
    static void writingDataToAFileReceivedAfterProcessing(Island island, DataBase dataBase) {

        for (int i = 0; i < dataBase.getIslandWidth(); i++) {
            for (int j = 0; j < dataBase.getIslandLength(); j++) {
                List<Animal> animalList = island.findCage(i, j).getAnimalList();
                List<Vegetation> vegetationList = island.findCage(i, j).getGrassList();

                maximumLength = Math.max(maximumLength, animalList.size() + vegetationList.size());
                System.out.println(maximumLength);
            }
        }
    }
/*
        try (BufferedWriter writter = new BufferedWriter(new FileWriter("text.txt", true))) {
            Cell cell = island.findCage(x, y);
            List<Animal> animalList = island.findCage(x, y).getAnimalList();
            List<Vegetation> vegetationList = island.findCage(x, y).getGrassList();
            System.out.println(cell);
            int a = 1;
            for (int i = 0; i < animalList.size(); i++, a++) {
                writter.write("[" + animalList.get(i) + ']');
                if (a % 43 == 0 && a != 0) {
                    writter.write("");
                }

            }
            writter.write("");
            for (int i = 0; i < vegetationList.size(); i++, a++) {
                writter.write("[" + vegetationList.get(i) + ']');
                if (a % 43 == 0) {
                    writter.write("");
                }
            }
        } catch (IOException e) {

            System.out.println(e + " File path is incorrect");

            //enterThePathToTheFileToWriting("File not found", scanner, lineBuffer);
        }
    }

    private static FilePrinting filePrinting;

    private FilePrinting() {
    }

    public static synchronized FilePrinting getFilePrinting() {
        if (filePrinting == null) {
            filePrinting = new FilePrinting();
            return filePrinting;
        }
        return filePrinting;
    }

 */
}
