package com.ru.javarush.second_project.island_model.storage;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.animal.herbivores.*;
import com.ru.javarush.second_project.island_model.game_objects.animal.predatory.*;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.plant.Grass;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static DataBase dataBase;

    private final List<double[]> doublesObject = new ArrayList<>();


    public List<double[]> getDoublesObject() {
        return doublesObject;
    }

    public int getIslandLength() {
        return islandLength;
    }

    public void setIslandLength(int islandLength) {
        dataBase.islandLength = islandLength;
    }

    public int getIslandWidth() {
        return islandWidth;
    }

    public void setIslandWidth(int islandWidth) {
        dataBase.islandWidth = islandWidth;
    }

    private int islandLength;
    private int islandWidth;

    public void islandDimensions() {
        this.islandLength = 100;
        this.islandWidth = 20;
    }

    public int[] whoToEatAndHowToEat(int operationNumber) {
        return switch (operationNumber) {
            case 1 -> new int[]{0, 0, 0, 0, 0, 10, 15, 60, 80, 60, 70, 15, 10, 40, 0, 0};       //Волк
            case 2 -> new int[]{0, 0, 15, 0, 0, 0, 0, 20, 40, 0, 0, 0, 0, 10, 0, 0};            //Удав
            case 3 -> new int[]{0, 0, 0, 0, 0, 0, 0, 70, 90, 0, 0, 0, 0, 60, 40, 0};            //Лиса
            case 4 -> new int[]{0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0};      //Медведь
            case 5 -> new int[]{0, 0, 10, 0, 0, 0, 0, 90, 90, 0, 0, 0, 0, 80, 0, 0};            //Орел
            case 6 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};              //Лошадь
            case 7 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};              //Олень
            case 8 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};              //Кролик
            case 9 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100};             //Мышь
            case 10 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};             //Коза
            case 11 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};             //Овца
            case 12 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 90, 100};           //Кабан
            case 13 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};             //Буйвол
            case 14 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 100};            //Утка
            case 15 -> new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100};             //Гусеница
            default -> null;
        };
    }

    public double[] animalParameters(int operationNumber) {
        return switch (operationNumber) {
            case 1 -> new double[]{50, 30, 3, 8};             //Волк
            case 2 -> new double[]{15, 30, 1, 3};             //Удав
            case 3 -> new double[]{8, 30, 2, 2};              //Лиса
            case 4 -> new double[]{500, 5, 2, 80};            //Медведь
            case 5 -> new double[]{6, 20, 3, 1};              //Орел
            case 6 -> new double[]{400, 20, 4, 60};           //Лошадь
            case 7 -> new double[]{300, 20, 4, 50};           //Олень
            case 8 -> new double[]{2, 150, 2, 0.45};          //Кролик
            case 9 -> new double[]{0.05, 500, 1, 0.01};       //Мышь
            case 10 -> new double[]{60, 140, 3, 10};          //Коза
            case 11 -> new double[]{70, 140, 3, 15};          //Овца
            case 12 -> new double[]{400, 50, 2, 50};          //Кабан
            case 13 -> new double[]{700, 10, 3, 100};         //Буйвол
            case 14 -> new double[]{1, 200, 4, 0.15};         //Утка
            case 15 -> new double[]{0.01, 1000, 0, 0};        //Гусеница

            default -> null;
        };

    }

    public String giveMeAnIcon(int operationNumber) {
        return switch (operationNumber) {
            case 1 -> "\uD83D\uDC3A";             //Волк
            case 2 -> "\uD83D\uDC0D";             //Удав
            case 3 -> "\uD83E\uDD8A";              //Лиса
            case 4 -> "\uD83D\uDC3B";            //Медведь
            case 5 -> "\uD83E\uDD85";              //Орел
            case 6 -> "\uD83D\uDC0E";           //Лошадь
            case 7 -> "\uD83E\uDD8C";           //Олень
            case 8 -> "\uD83D\uDC07";          //Кролик
            case 9 -> "\uD83D\uDC01";       //Мышь
            case 10 -> "\uD83D\uDC10";          //Коза
            case 11 -> "\uD83D\uDC11";          //Овца
            case 12 -> "\uD83D\uDC17";          //Кабан
            case 13 -> "\uD83D\uDC03";         //Буйвол
            case 14 -> "\uD83E\uDD86";         //Утка
            case 15 -> "\uD83D\uDC1B";        //Гусеница

            default -> null;
        };
    }

    //animalName, icon, animalParameters[0], (int) animalParameters[3], whoToEatAndHowToEat, conditionX, conditionY
    public Animal allAnimal
    (String animalName, String icon, double weight, int speedCell, double maximumSatiety, int[] whoToEatAndHowToEat, int id) {
        return switch (animalName) {
            case "Wolf" ->
                    new Wolf(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);            //Волк
            case "Boa" ->
                    new Boa(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);             //Удав
            case "Fox" ->
                    new Fox(icon, weight, speedCell, maximumSatiety,  whoToEatAndHowToEat, id);             //Лиса
            case "Bear" ->
                    new Bear(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);         //Медведь
            case "Eagle" ->
                    new Eagle(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);           //Орел
            case "Horse" ->
                    new Horse(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);         //Лошадь
            case "Deep" ->
                    new Deer(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);           //Олень
            case "Rabbit" ->
                    new Rabbit(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);        //Кролик
            case "Mouse" ->
                    new Mouse(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);           //Мышь
            case "Goat" ->
                    new Goat(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);            //Коза
            case "Sheep" ->
                    new Sheep(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);           //Овца
            case "Boar" ->
                    new Boar(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);           //Кабан
            case "Buffalo" ->
                    new Buffalo(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);       //Буйвол
            case "Duck" ->
                    new Duck(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id);            //Утка
            case "Caterpillar" ->
                    new Caterpillar(icon, weight, speedCell, maximumSatiety, whoToEatAndHowToEat, id); //Гусеница
            default -> null;
        };
    }

    public Vegetation allVegetation() {
        return new Grass();            //Трава
    }

    public double[] vegetationParameters() {
        return new double[]{1, 200};
    }

    private DataBase() {
    }

    public static synchronized DataBase getDataBase() {
        if (dataBase == null) {
            dataBase = new DataBase();
            return dataBase;
        }
        return dataBase;
    }
}


