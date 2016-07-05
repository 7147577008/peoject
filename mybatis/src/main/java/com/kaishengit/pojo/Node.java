package com.kaishengit.pojo;

import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_zh_CN;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/28.
 */
public class Node implements Serializable {


    private Integer id;
    private String nodename;

    /**
     *
     * @param nodename  带有参数的构造方法 方便测试new出来添加对象
     */
    public Node(String nodename) {
        this.nodename = nodename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", nodename='" + nodename + '\'' +
                '}';
    }
}
