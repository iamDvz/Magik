package ru.iamdvz.magik.utils;

public class ParserUtil {
    public static String getFrom(String str) {
        if (str.contains("{") && str.contains("}")) {
            return str.substring(str.indexOf("{")+1, str.lastIndexOf("}"));
        }
        return null;
    }
    public static String getParameterFromArr(String[] strArr, String parameterName) {
        for (String str : strArr) {
            if (str.contains(parameterName)) {
                return str.substring(str.indexOf(":")+1);
            }
        }
        return null;
    }
    public static String[] getParameters(String str) {
        return str.split(",");
    }
}
