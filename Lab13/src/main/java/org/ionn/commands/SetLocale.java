package org.ionn.commands;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public void execute(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(locale);
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);
        String pattern = messages.getString("locale.set");
        Object[] arguments = {locale.toLanguageTag()};
        String result = new MessageFormat(pattern).format(arguments);
        System.out.println(result);
    }
}
