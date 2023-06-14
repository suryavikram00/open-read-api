/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.open.read.api.utility;

import com.api.open.read.api.entity.BaseEntity;
import com.api.open.read.api.entity.OpenReadMetadata;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author NMSLAP570
 */
@Slf4j
public class OpenReadApiUtility {

    public static <T> String getFieldNames(Class<T> clazz) {
        List<String> fieldNames = new ArrayList();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase("serialVersionUID")) {
                continue;
            }
            fieldNames.add(field.getName());
        }
        return String.join(",", fieldNames);
    }

    public static <T> String extractFieldValues(T object) throws IllegalAccessException {
        List<String> fieldValues = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase("serialVersionUID")) {
                continue;
            }
            field.setAccessible(true);
            Object value = field.get(object);
            if (value != null) {
                String fieldValue = String.valueOf(value).replace(",", "\\,"); // Escape pipe symbols
                fieldValues.add('"' + fieldValue + '"');
            } else {
                fieldValues.add(""); // Add an empty string if the value is null
            }
        }
        return String.join(",", fieldValues);
    }

    public static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static List<BaseEntity<?>> getDerivedInstances() throws IOException, ClassNotFoundException {
        List<BaseEntity<?>> derivedInstances = new ArrayList<>();

        // Get all classes in the classpath
        List<Class<?>> classes = OpenReadApiUtility.find("com.netmeds.magnum");

        // Iterate over the classes and check if they extend BaseEntity
        for (Class<?> clazz : classes) {
            if (!Modifier.isAbstract(clazz.getModifiers()) && BaseEntity.class.isAssignableFrom(clazz)) {
                try {
                    BaseEntity<?> instance = (BaseEntity<?>) clazz.getDeclaredConstructor().newInstance();
                    derivedInstances.add(instance);
                } catch (Exception e) {
                    // Handle any exception during instance creation
                    e.printStackTrace();
                }
            }
        }

        return derivedInstances;
    }
    public static List<OpenReadMetadata> getClassName() throws IOException, ClassNotFoundException {
        List<OpenReadMetadata> classNameList = new ArrayList<>();
        List<BaseEntity<?>> derivedInstances = new ArrayList<>();

        // Get all classes in the classpath
        List<Class<?>> classes = OpenReadApiUtility.find("com.netmeds.magnum");

        // Iterate over the classes and check if they extend BaseEntity
        for (Class<?> clazz : classes) {
            if (!Modifier.isAbstract(clazz.getModifiers()) && BaseEntity.class.isAssignableFrom(clazz)) {
                try {
                    BaseEntity<?> instance = (BaseEntity<?>) clazz.getDeclaredConstructor().newInstance();
                    derivedInstances.add(instance);
                    classNameList.add(new OpenReadMetadata(clazz.getSimpleName()));
                } catch (Exception e) {
                    // Handle any exception during instance creation
                    e.printStackTrace();
                }
            }
        }

        return classNameList;
    }

    private static List<Class<?>> find(String packageName) throws IOException, ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);

        List<File> directories = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            directories.add(new File(resource.getFile()));
        }

        List<Class<?>> classes = new ArrayList<>();
        for (File directory : directories) {
            classes.addAll(findClasses(directory, packageName));
        }

        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    classes.addAll(findClasses(file, packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    Class<?> clazz = Class.forName(className);
                    if (BaseEntity.class.isAssignableFrom(clazz) && !Modifier.isAbstract(clazz.getModifiers())) {
                        classes.add(clazz);
                    }
                }
            }
        }

        return classes;
    }

}
