package com.ru.javarush.second_project.island_model.factory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.island.Cell;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.storage.DataBase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilePrinting {
    private static int maximumLength;

    void writingDataToAFileReceivedAfterProcessing(Island island, DataBase dataBase) {
        int numberColumnsInFile = 20;
        int k = 0;
        int z = 0;
        List<Animal> animalList = null;
        List<Vegetation> vegetationList;
        List<String> allAnimalVegetation;

        for (int i = 0; i < dataBase.getIslandWidth(); i++) {
            for (int j = 0; j < dataBase.getIslandLength(); j++) {
                animalList = island.findCage(i, j).getAnimalList();
                maximumLength = Math.max(animalList.size(), maximumLength);
            }
        }

        allAnimalVegetation = new ArrayList<>();
        System.out.println("Я здесь");
        //allAnimalVegetation.add(10, getObjectFieldValue(animalList.get(20)));
        for (int i = 0; i < maximumLength * dataBase.getIslandWidth() * dataBase.getIslandLength(); i++) {
            allAnimalVegetation.add(i, "0");
        }


        System.out.println(allAnimalVegetation);
        System.out.println("Я тут");
        System.out.println(allAnimalVegetation.size());
        System.out.println(animalList.size());
        System.out.println(maximumLength);



    }

        /*
        animalList = island.findCage(i, j).getAnimalList();
                for (k = 0; k < numberColumnsInFile / dataBase.getIslandLength(); k++) {
                    if (k == numberColumnsInFile / dataBase.getIslandLength() - 1)  {//
                        z++;
                        maximumLength++;
                        allAnimalVegetation.add("|||");

                        continue;
                    }
                    allAnimalVegetation.add(getObjectFieldValue(animalList.get(k)));
                    System.out.println(getObjectFieldValue(animalList.get(k)));
               }
            }
         */

    private String getObjectFieldValue(Animal a) {

        Class<?> aClass = a.getClass();
        Field declaredFields;
        String result = null;
        try {
            declaredFields = aClass.getDeclaredField("icon");
            declaredFields.setAccessible(true);
            result = String.valueOf(declaredFields.get(a));
        } catch (NoSuchFieldException e) {
            System.out.println("Нет такого поля");
        } catch (IllegalAccessException e) {
            System.out.println("Исключение незаконного доступа");
        }
        return result;
    }

    private static List<String> getFieldNames(Field[] fields) {
        return Arrays.stream(fields)
                .map(Field::getName)
                .collect(Collectors.toList());
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
     */
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


}
