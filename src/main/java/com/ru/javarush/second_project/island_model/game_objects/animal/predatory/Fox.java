package com.ru.javarush.second_project.island_model.game_objects.animal.predatory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Predatory;

public class Fox extends Predatory {

    String icon = "\uD83E\uDD8A";

    @Override
    public String toString() {
        return icon;
    }
}
