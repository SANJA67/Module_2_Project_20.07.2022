package com.ru.javarush.second_project.island_model.game_objects.animal.predatory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Predatory;

import java.math.BigDecimal;

public class Wolf extends Predatory {

     public Wolf(String icon, BigDecimal weight, int speedCell, BigDecimal maximumSatiety, int[] whoToEatAndHowToEat, int id) {
         super(icon, weight, speedCell, id, maximumSatiety, whoToEatAndHowToEat);
    }


}
