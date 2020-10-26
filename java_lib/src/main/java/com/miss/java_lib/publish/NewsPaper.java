package com.miss.java_lib.publish;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vola on 2020/10/26.
 */
public class NewsPaper implements News{

    private List<Reader> readerList = new LinkedList<>();

    @Override
    public void addReader(Reader reader) {
        readerList.add(reader);
    }

    @Override
    public void removeReader(Reader reader) {
        if (readerList.contains(reader)) {
            readerList.remove(reader);
        }
    }

    @Override
    public void publishNews(String content) {
        for (Reader reader : readerList) {
            reader.received(content);
        }
    }
}
