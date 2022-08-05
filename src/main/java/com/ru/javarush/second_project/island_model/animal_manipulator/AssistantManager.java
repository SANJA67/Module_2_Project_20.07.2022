package com.ru.javarush.second_project.island_model.animal_manipulator;

import com.ru.javarush.second_project.island_model.factory.Settings;
import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;
import com.ru.javarush.second_project.island_model.report.Statistics;
import com.ru.javarush.second_project.island_model.storage.DataBase;
import com.ru.javarush.second_project.island_model.storage.ProgramCommunication;

import java.util.List;
import java.util.Random;

public class AssistantManager {

    protected void startTheGame
            (Statistics statistics, Island island, Settings settings, ProgramCommunication pc, boolean language,
             int width, int length) {
        System.out.println(pc.seeCellByCoordinates(language));
        if (settings.flagRegulator(pc, language)) {
            System.out.println(pc.coordinateEntryConditions(language));
            System.out.println(pc.cellСoordinateШnput(language));
            System.out.println("В пределах от 0 до " + width);
            System.out.print("X = ");
            int pperLimit = 0;
            int x = (int) settings.letAnswer(pc, language, pperLimit, width);
            System.out.println("В пределах от 0 до " + length);
            System.out.print("Y = ");
            int y = (int) settings.letAnswer(pc, language, pperLimit, length);

            statistics.printTheCage(island, x, y);
        } else {
            statistics.printTheCage(island, 0, 0);
            statistics.printTheCage(island, 0, 1);
            statistics.printTheCage(island, 1, 0);
        }
    }

    protected void seeCage
            (Settings settings, ProgramCommunication pc, boolean language, int width, int length, Island island, AssistantManager assistantManager, Statistics statistics) {
        System.out.println(pc.seeTheCageOfTheIsland(language));

        if (settings.flagRegulator(pc, language)) {
            assistantManager.startTheGame(statistics, island, settings, pc, language, width, length);
        }
    }

    public void animalsEat(Island island, Random random, int width, int length, DataBase dataBase) {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                List<Animal> animalList = island.findCage(i, j).getAnimalList();
                List<Vegetation> vegetationList = island.findCage(i, j).getGrassList();
                for (Animal animal : animalList) {
                    animal.eat(animalList, vegetationList, random, dataBase);
                }

            }
        }
 /*
        IntStream.range(0, dataBase.getIslandWidth())
                .forEach(i -> IntStream.range(0, dataBase.getIslandLength())
                        .forEach(j -> island.findCage(i, j).getAnimalList().get(j).eat()));



        Cell cell = ;

        List<Animal> animalList = island.findCage(x, y).getAnimalList();

        //List<Vegetation> vegetationList = island.findCage(x, y).getGrassList();

 */
    }

    private static AssistantManager assistantManager;

    private AssistantManager() {
    }

    public static synchronized AssistantManager getAssistantManager() {
        if (assistantManager == null) {
            assistantManager = new AssistantManager();
            return assistantManager;
        }
        return assistantManager;
    }


}
