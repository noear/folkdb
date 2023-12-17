package org.noear.folkdb.client;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author noear
 * @see 1.0
 */
public interface DbClient {
    /**
     * 获取
     */
    byte[] get(String key);

    /**
     * 设置
     */
    void set(String key, byte[] data, int seconds);

    //====

    /**
     * 原子增
     */
    long atomIncrement(String key, int seconds);

    /**
     * 原子减
     */
    long atomDecrement(String key, int seconds);

    /**
     * 原子锁
     */
    boolean atomLock(String key, int seconds);

    //=======

    /**
     * 啥希获取字段
     */
    byte[] hashGetField(String key, String field);

    /**
     * 啥希获取所有字段
     */
    Map<String, byte[]> hashGetAll(String key);

    /**
     * 啥希设置字段
     */
    void hashSetField(String key, String field, byte[] data);

    /**
     * 啥希设置全部
     */
    void hashSetAll(String key, Map<String, byte[]> hashAll);

    //=======
    void setAdd(String key, byte[] data);

    void setSize(String key);

    Set<byte[]> setGetAll(String key);

    //======

    void listAdd(String key, byte[] data);

    byte[] listPop(String key);


    int listSize(String key);


    byte[] listGet(String key, int index);

    Collection<byte[]> listGetRange(String key, int start, int count);

    Collection<byte[]> listGetAll(String key);

    //=====

    void docAdd(String key, Document doc);
    void docUpset(String key, Document doc);
    Document docGet(String key, String docId);
    Collection<Document> docSearch(String key, String sql);
}
