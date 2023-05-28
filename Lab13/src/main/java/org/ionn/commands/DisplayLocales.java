package org.ionn.commands;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public void execute() {
        ResourceBundle messages = ResourceBundle.getBundle("Messages");
        System.out.println(messages.getString("locales"));

        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            System.out.println(locale.toLanguageTag());
        }
    }
}
