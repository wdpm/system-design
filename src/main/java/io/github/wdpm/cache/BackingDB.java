package io.github.wdpm.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created evan
 * @Date 2020/4/18
 */
public class BackingDB<E> {
    private List<E> dataList = new ArrayList<>();

    public void write(E e) {
        dataList.add(e);
    }

    public E read(int index) {
        return dataList.get(index);
    }
}
