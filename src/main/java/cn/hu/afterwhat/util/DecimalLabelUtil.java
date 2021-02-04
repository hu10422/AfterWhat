package cn.hu.afterwhat.util;


/**
 * 递进制标签
 *
 * @author huibox
 */
public class DecimalLabelUtil {

    private static String defaultTag = "tag_";
    private static Integer defaultMaxValue = 1000;
    private static Integer defaultDecimalValue = 10;

    /**
     * 指定数值转换为标签
     *
     * @param value  指定数值
     * @param prefix 标签前缀
     * @return
     */
    public static String[] conversionToTag(Integer value, String prefix) {
        String[] strs = {};
        if (value == null) {
            return strs;
        }

        if(defaultMaxValue < value) {
            throw new RuntimeException("指定数值超出可识别标记上限");
        }

//        Integer
//        while ()
        for (int i = 0; i < defaultDecimalValue; i++) {

        }


        return null;
    }

    /**
     * 范围数值转换为标签
     *
     * @param minValue 范围最小数组 包含
     * @param maxValue 范围最大数组 包含
     * @param prefix   标签前缀
     * @return
     */
    public static String[] conversionToTag(Integer minValue, Integer maxValue, String prefix) {

        return null;
    }
}
