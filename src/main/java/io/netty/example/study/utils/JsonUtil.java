package io.netty.example.study.utils;

import com.google.gson.Gson;

/**
 * @author chenjiena
 * @version 1.0
 * @created 2020/9/13.
 */
public final class JsonUtil {

    private static final Gson GSON = new Gson();

    public JsonUtil() {
    }

    public static <T> T fromJson(String jsonStr,Class<T> clazz){
        return GSON.fromJson(jsonStr, clazz);
    }

    public static String toJson(Object object){
        return GSON.toJson(object);
    }

}
