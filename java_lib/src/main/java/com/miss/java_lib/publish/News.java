package com.miss.java_lib.publish;

/**
 *      被观察者
 *
 * Created by Vola on 2020/10/26.
 */
interface News {

    void addReader(Reader reader);

    void removeReader(Reader reader);

    void publishNews(String content);

}
