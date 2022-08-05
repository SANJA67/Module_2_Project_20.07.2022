package com.ru.javarush.second_project.island_model.report;

import com.ru.javarush.second_project.island_model.factory.Settings;
import com.ru.javarush.second_project.island_model.game_objects.animal.abstracts.Animal;
import com.ru.javarush.second_project.island_model.game_objects.island.Cell;
import com.ru.javarush.second_project.island_model.game_objects.island.Island;
import com.ru.javarush.second_project.island_model.game_objects.vegetation.abstracts.Vegetation;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Statistics {

    public void printTheCage(Island island, int x, int y) {

        Cell cell = island.findCage(x, y);

        List<Animal> animalList = island.findCage(x, y).getAnimalList();
        List<Vegetation> vegetationList = island.findCage(x, y).getGrassList();
        System.out.println(cell);

        Stream<String> stream1 = animalList.stream().map(k -> "[" + k.getIcon() + "]");
        Stream<String> stream2 = vegetationList.stream().map(k -> "[" + k.getIcon() + "]");
        List<String> stringList = Stream.concat(stream1, stream2).toList();

        IntStream.rangeClosed(0, stringList.size() - 1)
                .mapToObj(i -> (i % 43 == 0 && i != 0) ? String.format("%s%n", stringList.get(i)) :
                        String.format("%s", stringList.get(i)))
                .forEachOrdered(System.out::print);


/*
        for (int i = 0; i < animalList.size(); i++, a++) {
            System.out.print("[" + animalList.get(i) + ']');
            if (a % 43 == 0 && a != 0) {
                System.out.println();
            }
        }

        for (int i = 0; i < vegetationList.size(); i++, a++) {
            System.out.print("[" + vegetationList.get(i) + ']');
            if (a % 43 == 0) {
                System.out.println();
            }
        }

 */

    }

    private static Statistics statistics;

    private Statistics() {
    }

    public static synchronized Statistics getStatistics() {
        if (statistics == null) {
            statistics = new Statistics();
            return statistics;
        }
        return statistics;
    }
}
