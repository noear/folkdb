package org.noear.folkdb.client;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author noear
 * @see 1.0
 */
public interface DbClient<T> {
    /**
     * 获取
     */
    T get(String key) throws IOException;

    /**
     * 设置
     */
    void set(String key, T data, int seconds) throws IOException;

    //====

    /**
     * 原子增
     */
    long atomIncrement(String key, int seconds) throws IOException;

    /**
     * 原子减
     */
    long atomDecrement(String key, int seconds) throws IOException;

    /**
     * 原子锁
     */
    boolean atomLock(String key, int seconds) throws IOException;

    //=======

    /**
     * 啥希获取字段
     */
    T hashGetField(String key, String field) throws IOException;

    /**
     * 啥希获取所有字段
     */
    Map<String, T> hashGetAll(String key) throws IOException;

    /**
     * 啥希设置字段
     */
    void hashSetField(String key, String field, T data) throws IOException;

    /**
     * 啥希设置全部
     */
    void hashSetAll(String key, Map<String, T> hashAll) throws IOException;


    //======

    void listAdd(String key, T data) throws IOException;

    T listPop(String key) throws IOException;


    int listSize(String key) throws IOException;


    T listGet(String key, int index) throws IOException;

    Collection<T> listGetRange(String key, int start, int count) throws IOException;

    Collection<T> listGetAll(String key) throws IOException;
}