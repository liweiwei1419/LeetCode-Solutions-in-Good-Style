import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String minNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return nums[0] + "";
        }

        Comparator<String> comparator = (o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            int len1 = a.length();
            for (int i = 0; i < len1; i++) {
                if (a.charAt(i) < b.charAt(i)) {
                    return -1;
                } else if (a.charAt(i) > b.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        };

        String[] numsStr = new String[len];
        for (int i = 0; i < len; i++) {
            numsStr[i] = nums[i] + "";
        }

        Arrays.sort(numsStr, comparator);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(numsStr[i]);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 32, 321};
        Solution solution = new Solution();
        String printMinNumber = solution.minNumber(nums);
        System.out.println(printMinNumber);
    }
}