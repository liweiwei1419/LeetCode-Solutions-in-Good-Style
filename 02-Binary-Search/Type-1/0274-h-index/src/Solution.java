import java.util.Arrays;

public class Solution {

    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(citations);

        if (citations[len - 1] == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return len - left;
    }
}