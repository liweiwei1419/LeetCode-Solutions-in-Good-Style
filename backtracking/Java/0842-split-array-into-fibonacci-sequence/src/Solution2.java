import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Integer> splitIntoFibonacci(String S) {

        // 字符串长度小于 3 直接返回
        if (S.length() < 3) {
            return new ArrayList<>();
        }

        int len = S.length();

        // i 有上界，这里相当于剪枝
        // 第一个数字的长度不超过数组的一半和 10 两者的最小值
        for (int i = 1; i <= Math.min((len - 1) / 2, 10); i++) {

            // 遇到 00112 这种
            if (i > 1 && S.charAt(0) == '0') {
                break;
            }

            // 斐波那契数列中第一个数字的长度和第二个数字的长度都小于等于第三个数字的长度
            for (int j = i + 1; len - j >= i && len - j >= j - i; j++) {
                // 遇到 199001200这种
                if (S.charAt(i) == '0' && j - i > 1) {
                    break;
                }

                long num1 = Long.parseLong(S.substring(0, i));
                long num2 = Long.parseLong(S.substring(i, j));

                // 大于 int 型最大值直接跳过
                if (num1 > Integer.MAX_VALUE || num2 > Integer.MAX_VALUE) {
                    break;
                }

                // 用中间数组来保存中间值
                List<Integer> tempList = new ArrayList<>();
                tempList.add(Math.toIntExact(num1));
                tempList.add(Math.toIntExact(num2));
                if (canSplitIntoFibonacci(tempList, S.substring(j), Math.toIntExact(num1), Math.toIntExact(num2))) {
                    return tempList;
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean canSplitIntoFibonacci(List<Integer> tempList, String str, Integer num1, Integer num2) {
        if ("".equals(str)) {
            return true;
        }

        int sum = num1 + num2;
        String next = String.valueOf(sum);

        // 剩下的部分一定要包含前两个数的结果
        if (!str.startsWith(next)) {
            return false;
        }
        tempList.add(sum);

        // 将第二个数作为第一个数，结果作为第二个数,继续回溯
        return canSplitIntoFibonacci(tempList, str.substring(next.length()), num2, sum);
    }

}
