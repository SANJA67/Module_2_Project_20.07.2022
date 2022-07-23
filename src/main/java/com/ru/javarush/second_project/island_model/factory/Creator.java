package com.ru.javarush.second_project.island_model.factory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.island.Cell;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.storage.DataBase;

import java.util.*;

public class Creator {
    Random random = new Random();

    public void start() {

        DataBase dataBase = DataBase.getDataBase();
        EntityFactory entityFactory = new EntityFactory();


        Island island = Island.creationIsland(new Cell[dataBase.getIslandWidth()][dataBase.getIslandLength()]);
        for (int i = 0; i < dataBase.getIslandWidth(); i++) {
            for (int j = 0; j < dataBase.getIslandLength(); j++) {
                island.matrix[i][j] = new Cell(i, j,
                        creatorAnimal(entityFactory, random, i, j, dataBase),
                        creatorVegetation(entityFactory, random, dataBase));

            }
        }

        FilePrinting.writingDataToAFileReceivedAfterProcessing(island, dataBase);
/*
        printTheCage(island, 5, 25);
        printTheCage(island, 15, 75);
        printTheCage(island, 0, 0);
        printTheCage(island, 19, 99);

 */

    }



    void printTheCage(Island island, int x, int y) {
        Cell cell = island.findCage(x, y);
        List<Animal> animalList = island.findCage(x, y).getAnimalList();
        List<Vegetation> vegetationList = island.findCage(x, y).getGrassList();
        System.out.println(cell);
        int a = 1;
        for (int i = 0; i < animalList.size(); i++, a++) {
            System.out.print("[" + animalList.get(i) + ']');
            if (a % 43 == 0 && a != 0) {
                System.out.println();
            }
        }

        for (int i = 0; i < vegetationList.size(); i++, a++) {
            System.out.print("[" + vegetationList.get(i) + ']');
            if (a % 43 == 0) {
                System.out.println();
            }
        }

    }

    public List<Vegetation> creatorVegetation(EntityFactory entityFactory, Random random, DataBase dataBase) {

        List<Vegetation> vegetationlInCell = new ArrayList<>();

        int numberObjects = random.nextInt((int) (dataBase.vegetationParameters()[1]));

        for (int i = 0; i < numberObjects; i++) {
            vegetationlInCell.add(entityFactory.readyVegetation(dataBase, numberObjects));
        }


        return vegetationlInCell;
    }

    public List<Animal> creatorAnimal(EntityFactory entityFactory, Random random, int conditionX, int conditionY, DataBase dataBase) {

        String[] animals = {"Wolf", "Boa", "Fox", "Bear", "Eagle", "Horse", "Deep", "Rabbit", "Mouse", "Goat",
                "Sheep", "Boar", "Buffalo", "Duck", "Caterpillar"};


        List<Animal> animalInCell = new ArrayList<>();
        for (int i = 0; i < animals.length; i++) {

            int numberObjects = random.nextInt((int) (dataBase.animalParameters(i + 1)[1] + 1));

            for (int j = 0; j < numberObjects; j++) {

                animalInCell.add(entityFactory.readyAnimal(animals[i], i + 1, conditionX, conditionY, dataBase));
            }
        }
        Collections.shuffle(animalInCell);
        return animalInCell;
    }

    private static Creator creator;

    private Creator() {
    }

    public static synchronized Creator getCreator() {
        if (creator == null) {
            creator = new Creator();
            return creator;
        }
        return creator;
    }
}


