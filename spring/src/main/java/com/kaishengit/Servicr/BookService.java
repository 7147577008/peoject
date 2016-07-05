package com.kaishengit.Servicr;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 测试各种属性在XML配置文件里怎么配置
 */
public class BookService {
    String name;
    Integer age;
    List<String> list;
    Set<String> set;
    Map<String, Object> map;
    Properties properties;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public void showBook() {
        System.out.println("BookService{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}');
        }
}
