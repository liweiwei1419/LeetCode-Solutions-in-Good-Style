import java.util.TreeSet;


/**
 * TreeSet 的特殊 API
 */
public class TreeSetDemo {

    // floor 表示地板，即小于等于输入值的最大元素
    // ceiling 表示天花板，即大于等于输入值的最元素

    // 例如：1，3，7，12
    // 输入是 8
    // floor(8) = 7
    // ceiling(8) = 12


    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(7);
        set.add(12);
        System.out.println("8 的地板是：" + set.floor(8));
        System.out.println("8 的天花板是：" + set.ceiling(8));
    }
}
