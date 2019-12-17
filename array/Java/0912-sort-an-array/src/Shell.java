/**
 * @author liweiwei1419
 * @date 2019/11/23 3:03 上午
 */
public class Shell {

    // 打表
    public static void main(String[] args) {
        int h = 1;
        while (h < 1000000000) {
            h = 3 * h + 1;
            System.out.println(h);
        }
    }
}
