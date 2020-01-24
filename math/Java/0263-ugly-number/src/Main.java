/**
 * @author liwei
 * @date 18/6/22 下午10:03
 */
public class Main {

    // 打印出所有质数因子
    public static void main(String[] args) {
        int num = 150;
        while (num!=1){
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    num /= i;
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
