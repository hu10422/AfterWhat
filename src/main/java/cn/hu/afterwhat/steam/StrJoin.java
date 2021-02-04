package cn.hu.afterwhat.steam;

import cn.hutool.core.util.NumberUtil;

public class StrJoin {

    public static void main(String[] args) {
        Integer i = 1;
        Integer j = 1;
        Integer k = null;

        int add = NumberUtil.add(i, j, k).intValue();
        System.out.println(add);
    }
}
