/**
 * @author liweiwei1419
 * @date 2019/10/24 4:48 下午
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        StringBuilder xx = new StringBuilder(Integer.toBinaryString(x));
        StringBuilder yy = new StringBuilder(Integer.toBinaryString(y));

        // System.out.println("xx:" + xx);
        // System.out.println("yy:" + yy);
        int sum = 0;

        // 这个特判不对，如果其中一个数为 0，那么它们的汉明距离就是另一个数的二进制中 1 出现的个数
        if (xx.length() == 0 || yy.length() == 0) {
            return 0;
        }

        // 下面这个逻辑也不正确，例如：
        // xx =   100
        // yy = 10100

        // 这种就不能用，- yy.length() + xx.length(); 或者 yy.length() - xx.length(); 来表示它们的差距了
        // 解决的思路很简单，你把它们的位数补齐，然后比较即可

        if (xx.length() > yy.length()) {
            for (int i = 0; i < yy.length(); i++) {
                if (xx.charAt(i) != yy.charAt(i)) {
                    sum++;
                }
            }
            sum = sum - yy.length() + xx.length();
        } else {
            for (int i = 0; i < xx.length(); i++) {
                if (xx.charAt(i) != yy.charAt(i)) {
                    sum++;
                }
            }
            sum = sum + yy.length() - xx.length();
        }
//        System.out.println(xx.toString());
//        System.out.println(yy.toString());
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 4;
        int y = 14;


        int res = solution.hammingDistance(x, y);
        System.out.println(res);


        System.out.println(Integer.toBinaryString(0));
    }

}
