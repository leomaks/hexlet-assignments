package exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        var res = new ArrayList<String>();

        for (Field field: address.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                     if (field.get(address) == null) {
                        res.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    System.out.println("Access error");
                }
            }
        }
        return res;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {

        var res = new HashMap<String, List<String>>();


        for (Field field: address.getClass().getDeclaredFields()) {

            try {
                field.setAccessible(true);
                if ((field.isAnnotationPresent(NotNull.class) && (field.get(address) == null))
                        || field.isAnnotationPresent(MinLength.class)) {

                    var errorList = new ArrayList<String>();
                    if (field.isAnnotationPresent(NotNull.class) && (field.get(address) == null)) {
                        errorList.add("can not be null");
                    }


                if ( !(field.get(address) == null) && field.isAnnotationPresent(MinLength.class) &&
                        (field.get(address).toString().length() < field.getAnnotation(MinLength.class).minLength())) {
                    errorList.add("length less than " + field.getAnnotation(MinLength.class).minLength());
                }

                    res.put(field.getName(), errorList);
                }
            } catch (IllegalAccessException e) {
                System.out.println("Access error");
            }
        }
        return res;
    }
}

