public class Solution {

    // 罗列出所有数字与罗马字母对应的可能性，按照从大到小排列
    // 求解的过程中使用到了贪心算法

    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]).append(" ");
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 2845;
        String intToRoman = solution.intToRoman(num);
        System.out.println(intToRoman);

        num = 1994;
        intToRoman = solution.intToRoman(num);
        System.out.println(intToRoman);
    }
}