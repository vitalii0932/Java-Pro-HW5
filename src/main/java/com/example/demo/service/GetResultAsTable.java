package com.example.demo.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class GetResultAsTable {
    public static <T> String getResultAsTable(List<T> values) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String result = "";
        Field[] fields = values.get(0).getClass().getDeclaredFields();
        Method[] methods = new Method[fields.length];

        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            result += fieldName + "\t";
            methods[i] = values.get(0).getClass().getDeclaredMethod("get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        }

        for (int i = 0; i < values.size(); i++) {
            result += "\n";
            for (var method : methods) {
                result += method.invoke(values.get(i)) + "\t";
            }
        }

        return result;
    }

    public static <T> String getResultAsTable(T value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String result = "";
        Field[] fields = value.getClass().getDeclaredFields();
        Method[] methods = new Method[fields.length];

        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            result += fieldName + "\t";
            methods[i] = value.getClass().getDeclaredMethod("get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        }

        result += "\n";
        for (var method : methods) {
            result += method.invoke(value) + "\t";
        }

        return result;
    }
}
