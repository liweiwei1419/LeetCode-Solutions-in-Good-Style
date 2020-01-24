import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        int lowLen = howManyDigits(low);
        int highLen = howManyDigits(high);

        String number = "123456789";
        List<Integer> res1 = new ArrayList<>();
        for (int i = lowLen; i <= highLen; i++) {
            getSequentialDigits(number, i, res1);
        }

        // 过滤结果集
        List<Integer> res2 = new ArrayList<>();
        for (Integer num : res1) {
            if (num > high) {
                break;
            }
            if (num >= low) {
                res2.add(num);
            }
        }
        return res2;
    }

    private void getSequentialDigits(String number, int count, List<Integer> res) {
        int left = 0;
        int right = count;

        while (right <= 9) {
            String subString = number.substring(left, right);
            int num = Integer.parseInt(subString);
            res.add(num);
            left++;
            right++;
        }
    }

    private int howManyDigits(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int low = 10;
        int high = 1000000000;

        Solution solution = new Solution();
        List<Integer> res = solution.sequentialDigits(low, high);
        System.out.println(res.size());

        int[] arr = {12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789};
        System.out.println(arr.length);
    }
}
