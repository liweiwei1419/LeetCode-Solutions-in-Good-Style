import java.util.Arrays;

public class Solution3 {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                // 找到第 1 个大于等于两边之和的下标
                int left = j + 1;
                int right = len;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                count += (left - j - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int left = Integer.MAX_VALUE - 10;
        int right = Integer.MAX_VALUE - 8;
        int mid = (left + right) >>> 1;
        System.out.println("mid = " + mid);
    }
}