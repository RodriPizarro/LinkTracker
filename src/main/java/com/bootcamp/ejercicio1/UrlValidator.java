package com.bootcamp.ejercicio1;

import org.springframework.beans.propertyeditors.URLEditor;

import java.beans.PropertyEditor;

public class UrlValidator {
    public static boolean validate(String url) {
        try {
            PropertyEditor urlEditor = new URLEditor();
            urlEditor.setAsText(url);
        }
        catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

}
