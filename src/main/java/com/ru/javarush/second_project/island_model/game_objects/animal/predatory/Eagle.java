package com.ru.javarush.second_project.island_model.game_objects.animal.predatory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Predatory;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.storage.DataBase;

import java.util.List;
import java.util.Random;

public class Eagle extends Predatory {

    int[] whoToEatAndHowToEat;
    double maximumSatiety;
    public Eagle(String icon, double weight, int speedCell, double maximumSatiety,
                 int[] whoToEatAndHowToEat, int id) {
        super(icon, weight, speedCell, id);
        this.whoToEatAndHowToEat = whoToEatAndHowToEat;
        this.maximumSatiety = maximumSatiety;
    }

    @Override
    public void eat(List<Animal> animalList, List<Vegetation> vegetationList, Random random, DataBase dataBase) {

    }
}
