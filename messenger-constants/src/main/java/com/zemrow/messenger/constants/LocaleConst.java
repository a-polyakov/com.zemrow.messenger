package com.zemrow.messenger.constants;

import java.util.Locale;

/**
 * Константы сокращений существующих языков
 *
 * @author Alexandr Polyakov on 2020.10.30
 */
public class LocaleConst {
    /**
     * English - английский
     */
    public static final Locale EN = Locale.ENGLISH;
    /**
     * Russian - русский
     */
    public static final Locale RU = Locale.forLanguageTag("ru");

    /**
     * Получить список доступных языков
     *
     * @param args
     */
    public static void main(String[] args) {
        final Locale en = Locale.forLanguageTag("en");
        final Locale ru = Locale.forLanguageTag("ru");
        for (Locale locale : Locale.getAvailableLocales()) {
            if (!locale.getLanguage().isEmpty() && locale.getCountry().isEmpty()) {
                System.out.println(new StringBuilder("    /**\n")
                        .append("     * ")
                        .append(locale.getDisplayName(en))
                        .append(" - ")
                        .append(locale.getDisplayName(ru))
                        .append("\n")
                        .append("     */\n")
                        .append("    public static final Locale ").append(locale.getLanguage().toUpperCase())
                        .append(" = Locale.forLanguageTag(\"").append(locale.getLanguage()).append("\");\n")
                );
            }
        }
    }
}
