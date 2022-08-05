package com.ru.javarush.second_project.island_model.animal_manipulator;


import com.ru.javarush.second_project.island_model.factory.Creator;
import com.ru.javarush.second_project.island_model.factory.Settings;
import com.ru.javarush.second_project.island_model.game_objects.island.Cell;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.report.Statistics;
import com.ru.javarush.second_project.island_model.storage.DataBase;
import com.ru.javarush.second_project.island_model.storage.ProgramCommunication;

import java.util.Random;

public class ManagerGod {

    public void start(Settings settings, ProgramCommunication pc, boolean language, DataBase dataBase) {

        int width = dataBase.getIslandWidth();
        int length = dataBase.getIslandLength();

        Island island = Island.creationIsland(new Cell[width][length]);
        AssistantManager assistantManager = AssistantManager.getAssistantManager();
        Statistics statistics = Statistics.getStatistics();
        Creator creator = Creator.getCreator();
        Random random = new Random();

        System.out.println(pc.wantToStartTheGame(language));
        if (settings.flagRegulator(pc, language)) {

            theGame(settings, pc, language, dataBase, width, length, island, assistantManager, statistics, creator, random);

        } else {
            pc.gameOver(language);
        }
    }

    private void theGame(Settings settings, ProgramCommunication pc, boolean language, DataBase dataBase,
                         int width, int length, Island island, AssistantManager assistantManager,
                         Statistics statistics, Creator creator, Random random) {
        creator.start(island, dataBase, random);

        assistantManager.seeCage(settings, pc, language, width, length, island, assistantManager, statistics);

        assistantManager.animalsEat(island, random, width, length, dataBase);
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
