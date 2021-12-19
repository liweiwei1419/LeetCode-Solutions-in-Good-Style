public class Solution {

    // 模拟、贪心（优先），参考官方题解：https://leetcode-cn.com/problems/lemonade-change/solution/ning-meng-shui-zhao-ling-by-leetcode-sol-nvp7/

    public boolean lemonadeChange(int[] bills) {
        // 5 美元的钞票张数
        int five = 0;
        // 10 美元的钞票张数
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // 模拟
                five++;
            } else if (bill == 10) {
                // 模拟
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                // 此时收了 20 美元，优先选择 10 块钱和 5 块钱找给用户，这一步体现了贪心
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    // 在 5 块钱张数够用的情况下，用掉 3 张 5 块钱
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}