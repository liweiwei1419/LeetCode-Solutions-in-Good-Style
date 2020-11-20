package cn.leetcode.examples;

import cn.leetcode.utils.SortingUtil;

/**
 * 生成接近有序的数组
 * 生成的策略是：按照一定的百分比，
 * 将有序数组内的随机的两个元素交换，产生逆序对
 * 交换次数越多，有序性越差，随机性越好
 *
 * @author liweiwei1419
 * @date 2019/9/8 3:59 AM
 */
public class GenerateNearlySortedArrayStrategy implements IGenerateArrayStrategy {

    private int len = 1_0000;

    /**
     * 有序的百分比，有序因子
     */
    private double orderlyFactor = 0.9;

    @Override
    public int getLen() {
        return this.len;
    }

    @Override
    public int getMin() {
        return 1;
    }

    @Override
    public int getMax() {
        return len;
    }

    @Override
    public String getFeature() {
        return String.format("接近有序（有序程度百分比 %d%%）", (int) (this.orderlyFactor * 100));
    }


    public GenerateNearlySortedArrayStrategy() {
    }

    /**
     * 如果只指定了数组的长度，数组内的随机数值取 [1, len]
     *
     * @param len
     */
    public GenerateNearlySortedArrayStrategy(int len) {
        // 参数校验
        assert len > 0;
        this.len = len;
    }

    /**
     * @param len
     * @param orderlyFactor 表征有序程度的浮点数，0 表示完全随机，1 表示顺序数组
     */
    public GenerateNearlySortedArrayStrategy(int len, Double orderlyFactor) {
        // 参数校验
        assert len > 0;
        if (orderlyFactor > 1 || orderlyFactor < 0) {
            throw new IllegalArgumentException("表征有序程度的浮点数需要传入浮点数，并且数值介于 0 和 1 之间，可 0 可 1。");
        }
        this.len = len;
        this.orderlyFactor = orderlyFactor;
    }

    @Override
    public int[] generateArray() {
        int[] nearlySortedArray = new int[len];
        // 步骤 1：先生成顺序数组
        for (int i = 0; i < len; i++) {
            nearlySortedArray[i] = i;
        }
        // 步骤 2：1 - percent 表示无序的百分比，乘以 len ，就表示要制造多少逆序对
        int swapTimes = (int) (len * (1 - orderlyFactor));
        for (int i = 0; i < swapTimes; i++) {
            // nextint(n) 生成 [0, n) 的随机整数
            int index1 = SortingUtil.RANDOM.nextInt(len);
            int index2 = SortingUtil.RANDOM.nextInt(len);
            SortingUtil.swap(nearlySortedArray, index1, index2);
        }
        return nearlySortedArray;
    }

    public static void main(String[] args) {
        int len = 100;
        double percent = 0.8888;
        int swapTimes = (int) (len * (1 - percent));
        System.out.println(swapTimes);
    }
}