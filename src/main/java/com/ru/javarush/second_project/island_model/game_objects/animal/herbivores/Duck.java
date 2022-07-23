package com.ru.javarush.second_project.island_model.game_objects.animal.herbivores;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Herbiovores;

public class Duck extends Herbiovores {

    String icon = "\uD83E\uDD86";

    @Override
    public String toString() {
        return icon;
    }
}
