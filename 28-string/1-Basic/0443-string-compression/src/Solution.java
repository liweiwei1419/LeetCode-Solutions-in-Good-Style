import java.util.Arrays;

public class Solution {

    public int compress(char[] chars) {
        int len = chars.length;
        if (len < 2) {
            return len;
        }

        // write 指向下一个要写的索引位置

        int write = 0;
        // 当前重复的次数
        int duplicateTimes = 1;
        for (int i = 0; i < len; i++) {
            if (i != len - 1 && chars[i] == chars[i + 1]) {
                duplicateTimes++;
            } else {
                // 如果遇到不同，就要结算
                // 当 i = len - 1 的时候同样也要结算
                chars[write] = chars[i];
                write++;
                // 如果只重复了 1 次，就不压缩
                if (duplicateTimes == 1) {
                    continue;
                }
                char[] timesArr = String.valueOf(duplicateTimes).toCharArray();
                for (char c : timesArr) {
                    chars[write] = c;
                    write++;
                }
                duplicateTimes = 1;
            }
        }
        return write;
    }
}