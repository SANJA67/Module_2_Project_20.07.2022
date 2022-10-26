package com.ru.javarush.second_project.island_model.animal_manipulator;

import com.ru.javarush.second_project.island_model.factory.EntityFactory;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.storage.DataBase;

import java.util.Random;

public class Worker implements Runnable {
    Island island;
    Random random;
    int width;
    int length;
    DataBase dataBase;
    EntityFactory entityFactory;
    AssistantManager assistantManager;

    public Worker(Island island, Random random, int width, int length, DataBase dataBase, EntityFactory entityFactory, AssistantManager assistantManager) {
        this.island = island;
        this.random = random;
        this.width = width;
        this.length = length;
        this.dataBase = dataBase;
        this.entityFactory = entityFactory;
        this.assistantManager = assistantManager;
    }

    @Override
    public void run() {
        assistantManager.animalsEat(island, random, width, length, dataBase);

        assistantManager.animalsReproduction(island, random, width, length, dataBase, entityFactory);

        assistantManager.moving(island, random, width, length, dataBase);
    }
}
