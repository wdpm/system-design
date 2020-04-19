package io.github.wdpm.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created evan
 * @Date 2020/4/18
 */
public class Cache<E> {

    private List<E> cacheList = new ArrayList<>();

    public void write(E e) {
        cacheList.add(e);
    }

    public E read(int index) {
        return cacheList.get(index);
    }
}
