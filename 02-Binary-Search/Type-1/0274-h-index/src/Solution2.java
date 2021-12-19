import java.util.Arrays;

public class Solution2 {

    public int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);

        // 特殊判断
        if (citations[len - 1] == 0) {
            return 0;
        }
        // 二分查找猜测论文的数量，需要满足：分割线右边的最少引用次数 >= 分割线右边的论文篇数
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // citations[mid] 表示引用的次数
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return len - left;
    }
}
