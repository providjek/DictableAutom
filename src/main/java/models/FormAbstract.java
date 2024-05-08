package models;

import java.lang.reflect.Field;
import java.util.Map;

public abstract class FormAbstract {



        public void buildFromDatableCucumber(Map<String, String> dataList) throws IllegalAccessException {
            Class<? extends FormAbstract> clazz = this.getClass();

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();

                if (dataList.containsKey(fieldName)) {
                    field.setAccessible(true);
                    String value = dataList.get(fieldName);
                    setValue(field, this, value);
                }
            }
        }

     private static void setValue(Field field, Object object, String value) throws IllegalAccessException {
            Class<?> fieldType = field.getType();

            if (fieldType == String.class) {
                field.set(object, value);
            } else if (fieldType == int.class || fieldType == Integer.class) {
                field.set(object, Integer.parseInt(value));
            } else if (fieldType == double.class || fieldType == Double.class) {
                field.set(object, Double.parseDouble(value));
            }
        }



}
