package com.ru.javarush.second_project.island_model.start;

import com.ru.javarush.second_project.island_model.factory.*;
import com.ru.javarush.second_project.island_model.storage.ProgramCommunication;


public class MyClass {

    public static void main(String[] args) {
        final String WELCOME_MESSAGE =
                """
                        *************
                        ** Welcome **
                        *************
                        """;
        System.out.println(WELCOME_MESSAGE);
        ProgramCommunication pc = ProgramCommunication.getProgramCommunication();
        Settings settings = Settings.getSettings();

        System.out.println(ProgramCommunication.LANGUAGE_SELECTION);
        boolean initialLanguageType = true;
        boolean language = settings.flagRegulator(pc, initialLanguageType);
        settings.selectsDefaultSettingsOrCustomSettings(pc, language);
    }

}
