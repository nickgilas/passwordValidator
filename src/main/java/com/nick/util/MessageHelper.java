package com.nick.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageHelper {

    private ResourceBundle messages;
    private Locale currentLocale;

    public MessageHelper(String bundleName, Locale currentLocale) {

        initialize(bundleName, currentLocale);
    }

    public String getMessage(String key) {

        return messages.getString(key);
    }

    public void updateCurrentLocaleMessages(String bundleName, Locale newLocale) {

        initialize(bundleName, newLocale);
    }

    private void initialize(String bundleName, Locale newLocale) {

        this.messages = ResourceBundle.getBundle(bundleName, newLocale, this.getClass().getClassLoader());
        this.currentLocale = newLocale;
    }

    public Locale getCurrentLocale() {

        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {

        this.currentLocale = currentLocale;
    }

}
