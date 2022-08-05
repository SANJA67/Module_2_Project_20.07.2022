package com.ru.javarush.second_project.island_model.game_objects.animal.abstracts;

import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.storage.DataBase;

import java.util.List;
import java.util.Random;

public abstract class Animal {

    private String icon;
    private int speedCell;
    private double weight;
    private int id;


    protected Animal(String icon, double weight, int speedCell, int id) {
        this.icon = icon;
        this.speedCell = speedCell;
        this.weight = weight;
        this.id = id;
    }

    public abstract void eat(List<Animal> animalList, List<Vegetation> vegetationList, Random random, DataBase dataBase);

    //метод передвигаться
    //метод размножаться
    //метод умирать от голода


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return icon;
    }
}
