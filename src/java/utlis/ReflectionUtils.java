package utlis;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class ReflectionUtils {

    public static  <T> void reflectParameter(T obj, HttpServletRequest request) {
        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field f : fields) {
                //filter final and static param
                if ((f.getModifiers() & Modifier.FINAL) > 0
                        || (f.getModifiers() & Modifier.STATIC) > 0) {
                    continue;
                }

                f.setAccessible(true);
                Class<?> fieldType = f.getType();

                String fieldName = f.getName();
                String paramVal = request.getParameter(fieldName);

                Map<String, String[]> parameterMap = request.getParameterMap();
                if (paramVal == null || Objects.equals("", paramVal)) {
                    continue;
                }

                // type
                if (String.class == fieldType) {
                    f.set(obj, paramVal);
                } else if (long.class == fieldType || Long.class == fieldType) {
                    f.set(obj, Long.valueOf(paramVal));
                } else if (int.class == fieldType || Integer.class == fieldType) {
                    f.set(obj, Integer.valueOf(paramVal));
                } else if (Date.class == fieldType) {
                    f.set(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramVal));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
