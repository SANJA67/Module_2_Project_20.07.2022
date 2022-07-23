package com.ru.javarush.second_project.island_model.game_objects.animal.predatory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Predatory;

public class Wolf extends Predatory {

    String icon = "\uD83D\uDC3A";

    @Override
    public String toString() {
        return icon;
    }
}
