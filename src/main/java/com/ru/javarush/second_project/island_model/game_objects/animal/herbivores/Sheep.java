package com.ru.javarush.second_project.island_model.game_objects.animal.herbivores;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Herbiovores;

public class Sheep extends Herbiovores {

    String icon = "\uD83D\uDC11";

    @Override
    public String toString() {
        return icon;
    }
}
