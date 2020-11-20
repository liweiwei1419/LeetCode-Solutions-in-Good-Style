public class Solution2 {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (num > 0) {
            int times = num / nums[index];
            while (times > 0) {
                stringBuilder.append(romans[index]);
                times--;
            }
            num = num % nums[index];
            index++;
        }
        return stringBuilder.toString();
    }
}