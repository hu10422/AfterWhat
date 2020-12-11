package cn.hu.afterwhat.list;

import cn.hutool.core.collection.CollUtil;

import java.util.List;

/**
 * @author howitt
 * @version 1.0.0
 * @ClassName ListAddNull.java
 * @Description TODO 集合是否可以加入空值
 * @createTime 2020年12月11日 13:40:00
 */
public class ListAddNull {

    public static void test(){
        List<String> list = CollUtil.newArrayList();
        System.out.println("集合长度:" + list.size());

        list.add("add 1");
        System.out.println("集合长度:" + list.size());

        list.add("");
        System.out.println("集合长度:" + list.size());

        list.add(null);
        System.out.println("集合长度:" + list.size());

        list.add("add 2");
        System.out.println("集合长度:" + list.size());

        list.forEach(t -> System.out.println("循环结果:" + t));

    }

    public static void main(String[] args) {
        ListAddNull.test();
    }
}
