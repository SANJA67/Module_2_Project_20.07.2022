package com.ru.javarush.second_project.island_model.game_objects.animal.herbivores;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Herbiovores;

public class Horse extends Herbiovores {

    String icon = "\uD83D\uDC0E";

    @Override
    public String toString() {
        return icon;
    }
}
