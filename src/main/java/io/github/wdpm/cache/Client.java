package io.github.wdpm.cache;

/**
 * @Created evan
 * @Date 2020/4/18
 */
public class Client {
    public static void main(String[] args) {
        Cache<Object>     cache     = new Cache<>();
        BackingDB<Object> backingDB = new BackingDB<>();
        Object            data      = new Object();

        writeThrough(cache, backingDB, data);
    }

    public static <E> void writeThrough(Cache<E> cache, BackingDB<E> backingDB, E e) {
        cache.write(e);
        backingDB.write(e);
    }

    public static <E> void writeAround(BackingDB<E> backingDB, E e) {
        // only write to db
        backingDB.write(e);
    }

    public static <E> void writeBack(Cache<E> cache, BackingDB<E> backingDB, E e) {
        cache.write(e);
        // async backingDB.write(e); dirty bit + valid bit
        // return
    }
}
