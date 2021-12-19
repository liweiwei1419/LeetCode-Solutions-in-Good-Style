import java.io.IOException;

public class Solution5 {

    public static void main(String[] args) throws IOException {
        System.out.println("-12  \t\t：" + Integer.toBinaryString(-12));
        System.out.println("-12 >>> 2 \t：" + Integer.toBinaryString((-12) >>> 2));
        System.out.println(-12 >>> 2);
    }
}
