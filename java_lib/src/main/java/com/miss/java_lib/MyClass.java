package com.miss.java_lib;

import com.miss.java_lib.publish.NewsPaper;
import com.miss.java_lib.publish.StudentReader;

public class MyClass {

    public static void main(String[] args) {

        StudentReader studentReader1 = new StudentReader("史珍香1");
        StudentReader studentReader2 = new StudentReader("史珍香2");
        StudentReader studentReader3 = new StudentReader("史珍香3");

        NewsPaper newsPaper = new NewsPaper();
        newsPaper.addReader(studentReader1);
        newsPaper.addReader(studentReader2);
        newsPaper.addReader(studentReader3);

        newsPaper.publishNews("二狗子呼叫土豆~");
    }

}