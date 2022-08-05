package com.ru.javarush.second_project.island_model.factory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.island.Cell;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.storage.DataBase;

import java.util.*;
import java.util.stream.IntStream;


public class Creator {

     public void start(Island island, DataBase dataBase, Random random) {

        EntityFactory entityFactory = EntityFactory.getEntityFactory();
        IntStream.range(0, dataBase.getIslandWidth())
                .forEach(i -> IntStream.range(0, dataBase.getIslandLength())
                        .forEach(j -> island.matrix[i][j] = new Cell(i, j,
                                        creatorAnimal(entityFactory, random, dataBase),
                                        creatorVegetation(entityFactory, random, dataBase))));
    }

    public List<Vegetation> creatorVegetation(EntityFactory entityFactory, Random random, DataBase dataBase) {

        List<Vegetation> vegetationlInCell = new ArrayList<>();

        int numberObjects = random.nextInt((int) (dataBase.vegetationParameters()[1]));

        for (int i = 0; i < numberObjects; i++) {
            vegetationlInCell.add(entityFactory.readyVegetation(dataBase, numberObjects));
        }


        return vegetationlInCell;
    }

    public List<Animal> creatorAnimal(EntityFactory entityFactory, Random random, DataBase dataBase) {

        String[] animals = {"Wolf", "Boa", "Fox", "Bear", "Eagle", "Horse", "Deep", "Rabbit", "Mouse", "Goat",
                "Sheep", "Boar", "Buffalo", "Duck", "Caterpillar"};


        List<Animal> animalInCell = new ArrayList<>();
        for (int i = 0; i < animals.length; i++) {

            int numberObjects = random.nextInt((int) (dataBase.animalParameters(i + 1)[1] + 1));

            for (int j = 0; j < numberObjects; j++) {

                animalInCell.add(entityFactory.readyAnimal(animals[i], i + 1,  dataBase));
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


