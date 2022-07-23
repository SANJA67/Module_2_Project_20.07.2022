package com.ru.javarush.second_project.island_model.factory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.storage.DataBase;

public class EntityFactory {

    public Vegetation readyVegetation(DataBase dataBase, int numberObjects) {

        return dataBase.allVegetation();
    }

    public Animal readyAnimal(String animalName, int id, int conditionX, int conditionY, DataBase dataBase) {

        double[] animalParameters = dataBase.animalParameters(id);

        int[] whoToEat = dataBase.whoToEat(id);

        return dataBase.allAnimal(animalName, (int) animalParameters[1], (int) animalParameters[2], animalParameters[0],
                animalParameters[3],
                whoToEat, conditionX, conditionY, id);
    }

}
