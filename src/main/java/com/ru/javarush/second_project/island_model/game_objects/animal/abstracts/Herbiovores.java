package com.ru.javarush.second_project.island_model.game_objects.animal.abstracts;

public abstract class Herbiovores extends Animal {

    protected Herbiovores(String icon, double weight, int speedCell, int id) {
        super(icon, weight, speedCell, id);
    }


    //метод кушать растения
    //метод быть съеденным

}
