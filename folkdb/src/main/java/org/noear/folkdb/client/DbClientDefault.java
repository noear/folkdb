package org.noear.folkdb.client;

import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.entity.EntityDefault;
import org.noear.socketd.transport.core.entity.StringEntity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author noear
 * @since 1.0
 */
public class DbClientDefault implements DbClient<ByteBuffer> {
    ClientSession session;


    @Override
    public ByteBuffer get(String key) throws IOException {
        Entity entity = new StringEntity("").meta("db.key", key);
        return session.sendAndRequest("cmd.get", entity)
                .data();
    }

    @Override
    public void set(String key, ByteBuffer data, int seconds) throws IOException {
        Entity entity = new EntityDefault().data(data).meta("db.key", key);
        session.sendAndRequest("cmd.set", entity);
    }

    @Override
    public long atomIncrement(String key, int seconds) throws IOException {
        Entity entity = new StringEntity("").meta("db.key", key);
        return session.sendAndRequest("cmd.atomIncrement", entity)
                .data().getLong();
    }

    @Override
    public long atomDecrement(String key, int seconds) throws IOException {
        Entity entity = new StringEntity("").meta("db.key", key);
        return session.sendAndRequest("cmd.atomDecrement", entity)
                .data().getLong();
    }

    @Override
    public boolean atomLock(String key, int seconds) throws IOException {
        Entity entity = new StringEntity("").meta("db.key", key);
        return session.sendAndRequest("cmd.atomLock", entity)
                .data().getInt() > 0;
    }

    @Override
    public ByteBuffer hashGetField(String key, String field) throws IOException {
        Entity entity = new StringEntity("").meta("db.key", key).meta("db.field", field);
        return session.sendAndRequest("cmd.hashGetField", entity)
                .data();
    }

    @Override
    public Map<String, ByteBuffer> hashGetAll(String key) throws IOException {
        return null;
    }

    @Override
    public void hashSetField(String key, String field, ByteBuffer data) throws IOException {
        Entity entity = new StringEntity("").data(data).meta("db.key", key).meta("db.field", field);
        session.sendAndRequest("cmd.hashSetField", entity)
                .data();
    }

    @Override
    public void hashSetAll(String key, Map<String, ByteBuffer> hashAll) throws IOException {

    }

    @Override
    public void listAdd(String key, ByteBuffer data) throws IOException {

    }

    @Override
    public ByteBuffer listPop(String key) throws IOException {
        return null;
    }

    @Override
    public int listSize(String key) throws IOException {
        return 0;
    }

    @Override
    public ByteBuffer listGet(String key, int index) throws IOException {
        return null;
    }

    @Override
    public Collection<ByteBuffer> listGetRange(String key, int start, int count) throws IOException {
        return null;
    }

    @Override
    public Collection<ByteBuffer> listGetAll(String key) throws IOException {
        return null;
    }
}
