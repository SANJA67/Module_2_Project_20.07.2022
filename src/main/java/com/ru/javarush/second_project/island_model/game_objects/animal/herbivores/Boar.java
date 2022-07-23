package com.ru.javarush.second_project.island_model.game_objects.animal.herbivores;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Herbiovores;

public class Boar extends Herbiovores {

    String icon = "\uD83D\uDC17";

    @Override
    public String toString() {
        return icon;
    }
}
