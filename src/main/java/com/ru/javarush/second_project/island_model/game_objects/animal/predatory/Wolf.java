package com.ru.javarush.second_project.island_model.game_objects.animal.predatory;

import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Predatory;
import com.ru.javarush.second_project.island_model.game_objects.animal.herbivores.*;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.storage.DataBase;

import java.util.List;
import java.util.Random;

public class Wolf extends Predatory {

    int[] whoToEatAndHowToEat;
    double maximumSatiety;

    public Wolf(String icon, double weight, int speedCell, double maximumSatiety,
                int[] whoToEatAndHowToEat, int id) {
        super(icon, weight, speedCell, id);
        this.whoToEatAndHowToEat = whoToEatAndHowToEat;
        this.maximumSatiety = maximumSatiety;
    }

    @Override
    public  void eat(List<Animal> animalList, List<Vegetation> vegetationList, Random random, DataBase dataBase) {
        Animal animal = animalList.get(random.nextInt(animalList.size() - 1)); // выбираем случайное животное
        if (this != animal) { // определяем что выбор не пал на самого себя
            if (animal instanceof Horse horse) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[horse.getId()]) { // определяем вероятность, что волк победил лошадь
                    eatAnimal(random, dataBase, horse);
                }

            } else if (animal instanceof Deer deer) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[deer.getId()]) {
                    eatAnimal(random, dataBase, deer);
                }

            } else if (animal instanceof Rabbit rabbit) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[rabbit.getId()]) {
                    eatAnimal(random, dataBase, rabbit);
                }

            } else if (animal instanceof Mouse mouse) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[mouse.getId()]) {
                    eatAnimal(random, dataBase, mouse);
                }

            } else if (animal instanceof Goat goat) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[goat.getId()]) {
                    eatAnimal(random, dataBase, goat);
                }
            } else if (animal instanceof Sheep sheep) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[sheep.getId()]) {
                    eatAnimal(random, dataBase, sheep);
                }
            } else if (animal instanceof Boar boar) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[boar.getId()]) {
                    eatAnimal(random, dataBase, boar);
                }
            } else if (animal instanceof Buffalo buffalo) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[buffalo.getId()]) {
                    eatAnimal(random, dataBase, buffalo);
                }
            } else if (animal instanceof Duck duck) {
                if (random.nextInt(100) <= whoToEatAndHowToEat[duck.getId()]) {
                    eatAnimal(random, dataBase, duck);
                }
            }
        }
    }

    private <E extends Animal> void  eatAnimal(Random random, DataBase dataBase, E e) {
        if (random.nextInt(100) <= whoToEatAndHowToEat[e.getId()]) {
            double weight = e.getWeight();
            while (permissionToEat(dataBase, e)) { // наелся ли волк, есть ли еще что есть не сел ли животное полностью
                
                maximumSatiety -= 0.01;
                weight -= 0.01;         // тут кушает
                e.setWeight(weight);
            }
        }
    }

    private <V extends Animal> boolean permissionToEat(DataBase dataBase, V v) {
        return maximumSatiety < dataBase.animalParameters(1)[3]
                || dataBase.animalParameters(v.getId())[0] != 0;
    }
}
