/**
 * @author liwei
 * @date 2019/7/15 10:56 PM
 */
public class Main2 {

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE - 2;
        System.out.println(a + b);

        System.out.println(a + (b - a) / 2);
        // 一定要用无符号右移
        System.out.println((a + b) >>> 1);
        System.out.println((a + b) >> 1);
    }
}
