package com.miss.java_lib.publish;

/**
 * Created by Vola on 2020/10/26.
 */
public class StudentReader implements Reader{

    private String name;

    public StudentReader(String name) {
        this.name = name;
    }

    @Override
    public void received(String content) {
        System.out.println("[" + name + "]--->" + content);
    }
}
