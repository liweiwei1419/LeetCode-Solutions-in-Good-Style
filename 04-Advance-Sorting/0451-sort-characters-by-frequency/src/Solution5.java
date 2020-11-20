import java.util.Random;

public class Solution5 {

    // 使用三路快排来做

    private int[] freq;

    private static final Random RANDOM = new Random();

    public String frequencySort(String s) {
        // 先转换为字符数组，以避免 charAt() 方法每次都检查下标有效性
        char[] charArray = s.toCharArray();
        // 用 128 是测试出来的，说明题目中的字符只有 a-zA-Z
        freq = new int[128];
        for (char c : charArray) {
            freq[c]++;
        }

        int len = charArray.length;
        quickSort(charArray, 0, len - 1);
        return new String(charArray);
    }

    private void quickSort(char[] charArray, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(charArray, randomIndex, left);

        // 循环不变量定义
        // all in [left + 1, lt] 的频数 > pivot 的频数
        // all in [lt + 1, i) 的频数 = pivot 的频数
        // all in [gt, right] 的频数 < pivot 的频数
        int pivot = charArray[left];
        int lt = left;
        int gt = right + 1;

        int i = left + 1;
        while (i < gt) {
            // 只需要在这句话外面套一层 freq [] ，其它逻辑和快速排序一样
            if (freq[charArray[i]] > freq[pivot]) {
                lt++;
                swap(charArray, i, lt);
                i++;
            } else if (charArray[i] == pivot) {
                i++;
            } else {
                gt--;
                swap(charArray, i, gt);
            }
        }
        swap(charArray, left, lt);
        // 注意这里，大大减少了分治的区间
        quickSort(charArray, left, lt - 1);
        quickSort(charArray, gt, right);
    }

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}