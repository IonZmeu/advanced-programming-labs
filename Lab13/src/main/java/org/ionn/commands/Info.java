package org.ionn.commands;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public void execute(Locale locale) {
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);

        String pattern = messages.getString("info");
        Object[] arguments = {locale.toLanguageTag()};
        String result = new MessageFormat(pattern).format(arguments);

        System.out.println(result);

        String country = locale.getDisplayCountry();
        String countryInLocalLanguage = locale.getDisplayCountry(locale);
        System.out.println("Country: " + country + " (" + countryInLocalLanguage + ")");
        String language = locale.getDisplayLanguage();
        String languageInLocalLanguage = locale.getDisplayLanguage(locale);
        System.out.println("Language: " + language + " (" + languageInLocalLanguage + ")");
        Currency currency = Currency.getInstance(locale);
        String currencyCode = currency.getCurrencyCode();
        String currencyDisplayName = currency.getDisplayName(Locale.forLanguageTag("ro-RO"));
        System.out.println("Currency: " + currencyCode + " (" + currencyDisplayName + ")");
        System.out.println("Week Days: " + getWeekDays(locale));
        System.out.println("Months: " + getMonths(locale));
        System.out.println("Today: " + formatDate(new Date(), locale));
    }

    private String getWeekDays(Locale locale) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        return String.join(", ", dateFormatSymbols.getWeekdays());
    }

    private String getMonths(Locale locale) {
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        return String.join(", ", dateFormatSymbols.getMonths());
    }

    private String formatDate(Date date, Locale locale) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", locale);
        return dateFormat.format(date);
    }
}
