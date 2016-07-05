package com.it.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/6/15.
 */
public class Config {
    private static Properties properties = new Properties();

    static {

        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("获取文件异常", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);

    }

}
