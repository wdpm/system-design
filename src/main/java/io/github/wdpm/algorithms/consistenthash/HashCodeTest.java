package io.github.wdpm.algorithms.consistenthash;

/**
 * hashCode 测试
 *
 * @author evan
 * @date 2020/5/6
 */
public class HashCodeTest {
    public static void main(String[] args) {
        String name = "wdpm";
        int    code = name.hashCode();
        System.out.println(code);
    }
}
