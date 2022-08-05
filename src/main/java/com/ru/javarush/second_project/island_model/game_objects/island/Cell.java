package com.ru.javarush.second_project.island_model.game_objects.island;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;

import java.util.List;

public class Cell {
    int fieldCoordinateX;
    int fieldCoordinateY;
    List<Animal> animalList;
    List<Vegetation>  grassList;

    public Cell(int fieldCoordinateX, int fieldCoordinateY, List<Animal> animalList, List<Vegetation> grassList) {
        this.fieldCoordinateX = fieldCoordinateX;
        this.fieldCoordinateY = fieldCoordinateY;
        this.animalList = animalList;
        this.grassList = grassList;
    }

    public int getFieldCoordinateX() {
        return fieldCoordinateX;
    }

    public int getFieldCoordinateY() {
        return fieldCoordinateY;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<Vegetation> getGrassList() {
        return grassList;
    }

    @Override

    public String toString() {
        System.out.println();
        return "Cell " + "X = " + fieldCoordinateX +
                ", Y = " + fieldCoordinateY +
                ", A L = " + animalList +
                ", G L = " + grassList +
                '}';
    }
}
