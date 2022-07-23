package com.ru.javarush.second_project.island_model.factory;

import com.ru.javarush.second_project.island_model.storage.DataBase;
import com.ru.javarush.second_project.island_model.storage.ProgramCommunication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Settings {
    /**
     * Sets the value of boolean language
     * who will be responsible for the use in the program,
     * either Russian or English
     * depending on the value of the variable
     */
    public boolean flagRegulator(ProgramCommunication pc, boolean language) {
        double upperLimit = 1;
        double lowerLimit = 2;
        int numberSettings = (int) numberCheck(pc, language, upperLimit, lowerLimit);
        return numberSettings == 1;
    }

    public void selectsDefaultSettingsOrCustomSettings(ProgramCommunication pc, boolean language) {
        Creator creator = Creator.getCreator();
        DataBase dataBase = DataBase.getDataBase();
        System.out.printf("%s%n", pc.defaultSettings(language));

        if (flagRegulator(pc, language)) {
            settingsOptions(dataBase, creator, pc, language);
        } else {
            defaultInitializationAllVariables(dataBase);
            creator.start();
        }
    }

    private void settingsOptions(DataBase dataBase, Creator creator, ProgramCommunication pc, boolean language) {
        int numberOfProcessedObjects = ProgramCommunication.OBJECT_NUMBER;
        System.out.printf("%s%n", ProgramCommunication.settingsGameObjects(language));
        boolean choice = flagRegulator(pc, language);

        if (choice) parameterInitialization(dataBase, pc, language, numberOfProcessedObjects);

        else defaultInitializationRequiredVariable(dataBase, numberOfProcessedObjects);

        if (flagSettingsOptions(numberOfProcessedObjects)) settingsOptions(dataBase, creator, pc, language);
        if (flagCreatorStart(numberOfProcessedObjects)) creator.start();
    }

    private void parameterInitialization(DataBase dataBase, ProgramCommunication pc, boolean language, int objectNumber) {
        if (objectNumber == 0) {
            dataBase.setIslandLength((int) giveANumber
                    (pc, language, pc.variableNameIsland(0), 0, objectNumber));
            dataBase.setIslandWidth((int) giveANumber
                    (pc, language, pc.variableNameIsland(1), 1, objectNumber));
        } else {
            double[] doubles = new double[4];
            for (int i = 0; i < doubles.length; i++) {
                doubles[i] = giveANumber
                        (pc, language, pc.variableNameAnimal(i), i, objectNumber);
            }
            dataBase.getDoublesObject().add(doubles);
        }
    }

    private double giveANumber
            (ProgramCommunication pc, boolean language, String appropriation, int variableNumber, int objectNumber) {
        double[][] doubles = animalParametersLimit(objectNumber);

        System.out.printf("Введите число больше %.2f и меньше %.2f%n",
                doubles[variableNumber][0], doubles[variableNumber][1]);
        System.out.print(appropriation);

        return numberCheck(pc, language, doubles[variableNumber][0], doubles[variableNumber][1]);
    }

    private void defaultInitializationRequiredVariable(DataBase dataBase, int numberOfProcessedObjects) {
        if (numberOfProcessedObjects == 0) {
            dataBase.islandDimensions();
        } else {
            dataBase.getDoublesObject().add(dataBase.animalParameters(numberOfProcessedObjects));
        }

    }

    private void defaultInitializationAllVariables(DataBase dataBase) {
        dataBase.islandDimensions();
        for (int i = 1; i < 16; i++) {
            dataBase.getDoublesObject().add(dataBase.animalParameters(i));
        }
    }

    private boolean flagCreatorStart(int numberOfProcessedObjects) {
        int numberOfObjects = 16;
        int correctionFactorZero = 1;
        return numberOfProcessedObjects == numberOfObjects - correctionFactorZero;
    }

    private boolean flagSettingsOptions(int numberOfProcessedObjects) {
        int numberOfObjects = 16;
        int correctionFactorZero = 1;
        return numberOfProcessedObjects != numberOfObjects - correctionFactorZero;
    }

    private double[][] animalParametersLimit(int operationNumber) {
        return switch (operationNumber) {
            case 0 -> new double[][]{{1, 200}, {1, 200}};                                    //Поле
            case 1 -> new double[][]{{40, 80}, {0, 100}, {0, 10}, {3, 10}};                  //Волк
            case 2 -> new double[][]{{10, 20}, {0, 100}, {0, 10}, {1, 8}};                   //Удав
            case 3 -> new double[][]{{5, 15}, {0, 100}, {0, 10}, {1, 6}};                    //Лиса
            case 4 -> new double[][]{{300, 700}, {0, 15}, {0, 10}, {40, 100}};               //Медведь
            case 5 -> new double[][]{{3, 15}, {0, 100}, {0, 10}, {1, 4}};                    //Орел
            case 6 -> new double[][]{{150, 800}, {0, 100}, {0, 10}, {30, 80}};               //Лошадь
            case 7 -> new double[][]{{150, 500}, {0, 100}, {0, 10}, {20, 70}};               //Олень
            case 8 -> new double[][]{{1, 8}, {0, 100}, {0, 10}, {0.1, 0.5}};                 //Кролик
            case 9 -> new double[][]{{0.02, 0.1}, {0, 2000}, {0, 10}, {0.01, 0.08}};         //Мышь
            case 10 -> new double[][]{{30, 80}, {0, 500}, {0, 10}, {3, 15}};                 //Коза
            case 11 -> new double[][]{{30, 80}, {0, 500}, {0, 10}, {5, 25}};                 //Овца
            case 12 -> new double[][]{{150, 700}, {0, 200}, {0, 10}, {20, 100}};             //Кабан
            case 13 -> new double[][]{{150, 1000}, {0, 50}, {0, 10}, {30, 200}};             //Буйвол
            case 14 -> new double[][]{{1, 5}, {0, 1000}, {0, 10}, {0.01, 0.5}};              //Утка
            case 15 -> new double[][]{{0.01, 0.1}, {0, 5000}, {0, 10}, {0, 0.03}};           //Гусеница

            default -> throw new IllegalStateException("Unexpected value: " + operationNumber);
        };
    }

    /**
     * Strongly recommends the user to select one of the required integer value options
     */
    private double numberCheck(ProgramCommunication pc, boolean language, double upperLimit, double lowerLimit) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double numberSettings;
        while (true) {
            try {
                String number = br.readLine();
                numberSettings = Double.parseDouble(number);
                if (numberSettings > (upperLimit - 0.01) && numberSettings < (lowerLimit + 0.01)) {
                    break;
                } else {
                    System.out.println(pc.phrasesForNumberVerificationMethod(language));
                }
            } catch (Exception e) {
                System.out.println(pc.phrasesForNumberVerificationMethodException(language));
            }
        }
        return numberSettings;
    }

    private static Settings settings;

    private Settings() {
    }

    public static synchronized Settings getSettings() {
        if (settings == null) {
            settings = new Settings();
            return settings;
        }
        return settings;
    }
}