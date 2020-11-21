import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len < 2) {
            return len;
        }

        // [w, h] 表示 [宽度，高度]
        // 关键在这里：宽度相同的时候，高度倒序排序
        Arrays.sort(envelopes, (envelope1, envelope2) -> {
            if (envelope1[0] != envelope2[0]) {
                return envelope1[0] - envelope2[0];
            }
            return envelope2[1] - envelope1[1];
        });

        int[] tail = new int[len];
        tail[0] = envelopes[0][1];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;
        for (int i = 1; i < len; i++) {
            int target = envelopes[i][1];
            if (target > tail[end]) {
                end++;
                tail[end] = target;
            } else {
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tail[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = target;
            }
        }
        return end + 1;
    }
}