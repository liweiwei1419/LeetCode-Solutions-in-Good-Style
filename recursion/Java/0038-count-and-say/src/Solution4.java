/**
 * @author liweiwei1419
 * @date 2019/10/31 8:16 下午
 */
public class Solution4 {


    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        // 哨兵
        pre += "#";
        Character cur = pre.charAt(0);
        int counter = 1;
        StringBuilder res = new StringBuilder(cur);
        for (int i = 1; i < pre.length(); i++) {
            if (pre.charAt(i) == cur) {
                counter += 1;
            } else {
                res.append(counter);
                res.append(cur);

                cur = pre.charAt(i);
                counter = 1;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String res = solution4.countAndSay(5);
        System.out.println(res);
    }
}
