package com.ru.javarush.second_project.island_model.animal_manipulator;


import com.ru.javarush.second_project.island_model.factory.Creator;
import com.ru.javarush.second_project.island_model.factory.EntityFactory;
import com.ru.javarush.second_project.island_model.factory.Settings;
import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.island.Cell;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.report.Statistics;
import com.ru.javarush.second_project.island_model.storage.DataBase;
import com.ru.javarush.second_project.island_model.storage.ProgramCommunication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManagerGod {

    public void start(Settings settings, ProgramCommunication pc, boolean language, DataBase dataBase) {

        int width = dataBase.getIslandWidth();
        int length = dataBase.getIslandLength();
        System.out.println(width + " " + length);
        System.out.println();
        Island island = Island.creationIsland(new Cell[width][length]);
        AssistantManager assistantManager = AssistantManager.getAssistantManager();
        EntityFactory entityFactory = EntityFactory.getEntityFactory();
        Statistics statistics = Statistics.getStatistics();
        Creator creator = Creator.getCreator();
        Random random = new Random();

        System.out.println(pc.wantToStartTheGame(language));
        if (settings.flagRegulator(pc, language)) {

            theGame(entityFactory, settings, pc, language, dataBase, width, length, island, assistantManager, statistics, creator, random);

        } else {
            pc.gameOver(language);
        }
    }

    private void theGame(EntityFactory entityFactory, Settings settings, ProgramCommunication pc, boolean language, DataBase dataBase,
                         int width, int length, Island island, AssistantManager assistantManager,
                         Statistics statistics, Creator creator, Random random) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        creator.start(island, dataBase, random);

        assistantManager.seeCage(settings, pc, language, width, length, island, assistantManager, statistics);

        statistics.islandStatistics(dataBase, island);

        boolean flag = true;



        while (flag) {
            worker(entityFactory, dataBase, width, length, island, assistantManager, random, executorService);
            assistantManager.dies(island, width, length, dataBase);
            statistics.islandStatistics(dataBase, island);
            System.out.println();
            System.out.println(pc.wantToProceedTheGame(language));
            if (!settings.flagRegulator(pc, language)) {
                flag = false;
            }
            executorService.shutdown();
        }



        statistics.countingAnimals(dataBase, island);



    }

    private static void worker(EntityFactory entityFactory, DataBase dataBase, int width, int length, Island island, AssistantManager assistantManager, Random random, ExecutorService executorService) {
        System.out.println();
        Date currentTime = new Date();
        Date newTime;

        int result = 0;
        while (result < 5) {
            executorService.execute(new Worker(island, random, width, length, dataBase, entityFactory, assistantManager));
            newTime = new Date();
            result = newTime.getSeconds() - currentTime.getSeconds();
        }
        executorService.shutdownNow();
    }


    private static ManagerGod managerGod;

    private ManagerGod() {
    }

    public static synchronized ManagerGod getManagerGod() {
        if (managerGod == null) {
            managerGod = new ManagerGod();
            return managerGod;
        }
        return managerGod;
    }
}
