package cn.leetcode.examples;

import cn.leetcode.utils.SortingUtil;

/**
 * 生成逆序数组，这是一个极端测试用例
 *
 * @author liweiwei1419
 * @date 2019/9/8 3:59 AM
 */
public class GenerateReversedArrayStrategy implements IGenerateArrayStrategy {

    private int len = 10000;

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

    public GenerateReversedArrayStrategy() {
    }

    public GenerateReversedArrayStrategy(int len) {
        // 参数校验
        assert len > 0;
        this.len = len;
    }

    @Override
    public String getFeature() {
        return "逆序数组";
    }

    @Override
    public int[] generateArray() {
        int[] reversedArray = new int[len];
        for (int i = 0; i < len; i++) {
            reversedArray[i] = len - i;
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        IGenerateArrayStrategy generateArrayStrategy = new GenerateReversedArrayStrategy(100);
        SortingUtil.printArray(generateArrayStrategy.generateArray());
    }
}