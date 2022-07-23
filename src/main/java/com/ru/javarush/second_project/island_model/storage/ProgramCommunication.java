package com.ru.javarush.second_project.island_model.storage;

public class ProgramCommunication {

    public static int OBJECT_NUMBER = 0;
    public static final String LANGUAGE_SELECTION =
            "Choose language:\nВыберите язык:\nEnglish \t\tpress \t'1'\nРусский \t\tнажать \t'2'";


    public String defaultSettings(boolean language) {

        if (language) {
            return "Set up the program \t\t\t\tpress '1'\n" +
                    "Leave settings as default \t\tpress '2'";

        } else {
            return "Настроить программу \t\t\t\tнажать '1'\n" +
                    "Настройки оставить по умолчанию \tнажать '2'";
        }
    }

    public static String settingsGameObjects(boolean language) {
        if (language) {

            return "Configure " + nameObject(OBJECT_NUMBER++, language) + " settings:\n" +
                    "Yes \t\tpress '1'\n" +
                    "No \t\t\tpress '2'";

        } else {
            return "Настроить параметры " + nameObject(OBJECT_NUMBER++, language) + ":\n" +
                    "Да \t\t\tнажми '1'\n" +
                    "Нет \t\tнажми '2'";
        }
    }

    private static String nameObject(int objectNumber, boolean language) {
        return switch (objectNumber) {
            case 0 -> language ? "island" : "острова";             //остров
            case 1 -> language ? "wolf" : "волка";             //Волк
            case 2 -> language ? "boa" : "удава";             //Удав
            case 3 -> language ? "fox" : "лисы";              //Лиса
            case 4 -> language ? "bear" : "медведя";            //Медведь
            case 5 -> language ? "eagle" : "орела";             //Орел
            case 6 -> language ? "horse" : "лошади";           //Лошадь
            case 7 -> language ? "deep" : "оленя";          //Олень
            case 8 -> language ? "rabbit" : "кролика";          //Кролик
            case 9 -> language ? "mouse" : "мыши";      //Мышь
            case 10 -> language ? "goat" : "козы";         //Коза
            case 11 -> language ? "sheep" : "овцы";          //Овца
            case 12 -> language ? "boar" : "кабана";         //Кабан
            case 13 -> language ? "buffalo" : "буйвола";         //Буйвол
            case 14 -> language ? "duck" : "утки";         //Утка
            case 15 -> language ? "caterpillar" : "гусеницы";       //Гусеница

            default -> null;
        };
    }

    public String variableNameAnimal(int serialNumber) {
        return switch (serialNumber) {
            case 0 -> "animalWeight = ";
            case 1 -> "maxInCell = ";
            case 2 -> "travelSpeed = ";
            case 3 -> "kilogramsEat = ";
            default -> null;
        };
    }

    public String variableNameIsland(int serialNumber) {
        return switch (serialNumber) {
            case 0 -> "islandLength = ";
            case 1 -> "islandWidth = ";
            default -> null;
        };
    }

    private static ProgramCommunication pc;

    private ProgramCommunication() {
    }

    public static synchronized ProgramCommunication getProgramCommunication() {
        if (pc == null) {
            pc = new ProgramCommunication();
            return pc;
        }
        return pc;
    }

    public String phrasesForNumberVerificationMethod(boolean language) {

        if (language) {
            return "You entered an invalid number";
        } else {
            return "Вы введи не верное число";
        }
    }

    public String phrasesForNumberVerificationMethodException(boolean language) {

        if (language) {
            return "Type a number, not a text";
        } else {
            return "Введите число, а не текст";
        }
    }
}



