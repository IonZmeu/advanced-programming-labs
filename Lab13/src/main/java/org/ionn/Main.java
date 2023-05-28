package org.ionn;

import org.ionn.commands.DisplayLocales;
import org.ionn.commands.Info;
import org.ionn.commands.SetLocale;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void displayMessages(Locale locale) {
        String baseName = "Messages";
        ResourceBundle messages =
                ResourceBundle.getBundle(baseName, locale);
        String pattern = messages.getString("welcome");
        Object[] arguments = {"Duke", LocalDate.now()};
        String welcome = new MessageFormat(pattern).format(arguments);
        System.out.println(welcome);
    }
    public static void main(String args[]) throws IOException {

        //displayMessages(Locale.forLanguageTag("ro"));

        //displayMessages(Locale.getDefault());

        DisplayLocales displayLocales = new DisplayLocales();
        //displayLocales.execute();

        SetLocale setLocale = new SetLocale();
        //setLocale.execute("ro");

        Info info = new Info();
        //info.execute(Locale.forLanguageTag("ro-RO"));

        ResourceBundle messages =
                ResourceBundle.getBundle("Messages", Locale.getDefault());

        while (true){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println(messages.getString("prompt") + " 1-DisplayLocales 2-SetLocale 3-Info" );
            String userInput = myObj.nextLine();
            if (userInput.equals("1")){
                displayLocales.execute();
            } else if (userInput.equals("2")) {
                System.out.println("which locale?");
                setLocale.execute(myObj.nextLine());
                messages = ResourceBundle.getBundle("Messages", Locale.getDefault());
            } else if (userInput.equals("3")) {
                System.out.println("which locale?");
                Locale l = Locale.forLanguageTag(myObj.nextLine());
                info.execute(l);
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }

    }
}