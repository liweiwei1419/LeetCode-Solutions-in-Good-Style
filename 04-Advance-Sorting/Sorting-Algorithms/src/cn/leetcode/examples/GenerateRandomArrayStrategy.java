package cn.leetcode.examples;

import cn.leetcode.utils.SortingUtil;

/**
 * 生成随机数组
 *
 * @author liweiwei1419
 * @date 2019/9/8 3:59 AM
 */
public class GenerateRandomArrayStrategy implements IGenerateArrayStrategy {

    private int len = 1_0000;
    private int min = 1;
    private int max = 1_0000;

    @Override
    public int getLen() {
        return this.len;
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return this.max;
    }

    public GenerateRandomArrayStrategy() {
    }

    /**
     * 如果只指定了数组的长度，数组内的随机数值取 [1, len]
     *
     * @param len
     */
    public GenerateRandomArrayStrategy(int len) {
        this.len = len;
        this.max = len;
    }

    public GenerateRandomArrayStrategy(int len, int min, int max) {
        this.len = len;
        this.min = min;
        this.max = max;
    }

    @Override
    public String getFeature() {
        return "完全随机";
    }

    @Override
    public int[] generateArray() {
        // 参数校验
        assert len > 0;
        if (min > max) {
            int temp = max;
            max = min;
            min = temp;
        }
        int[] randomArray = new int[len];
        for (int i = 0; i < len; i++) {
            // nextint(n) 生成 [0, n) 的随机整数
            randomArray[i] = min + SortingUtil.RANDOM.nextInt(max - min + 1);
        }
        return randomArray;
    }
}