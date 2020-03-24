public class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();

        // 考虑特殊情况，直接返回结果
        if (len1 == 0) {
            return num2;
        }
        if (len2 == 0) {
            return num1;
        }

        int index1 = len1 - 1;
        int index2 = len2 - 1;
        int sum = 0;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0) {
                int a = num1.charAt(index1) - '0';
                sum += a;
                index1--;
            }

            if (index2 >= 0) {
                int b = num2.charAt(index2) - '0';
                sum += b;
                index2--;
            }

            stringBuilder.append(sum % 10);
            // 表示是否进位
            sum /= 10;
        }

        // 最后这一步不要忘记了
        if (sum == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "1234";
        String num2 = "5678";
        String addStrings = solution.addStrings(num1, num2);
        System.out.println(addStrings);

        System.out.println(Integer.valueOf(num1) + Integer.valueOf(num2));
    }
}