package com.ru.javarush.second_project.island_model.game_objects.vegetation.plant;

import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;

public class Grass extends Vegetation {

    String icon = "\uD83C\uDF3F";

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return icon;
    }
}
