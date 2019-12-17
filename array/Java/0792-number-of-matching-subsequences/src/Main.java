import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    /**
     * 如果它包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。
     * 插入点 被定义为将键插入数组的那一点：即第一个大于此键的元素索引，
     * 如果数组中的所有元素都小于指定的键，则为 a.length。
     * 注意，这保证了当且仅当此键被找到时，返回的值将 >= 0。
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(20 + i);
        }

        System.out.println(list);
        int binarySearch = Collections.binarySearch(list, 100);
        System.out.println(binarySearch);

        binarySearch = Collections.binarySearch(list, 101);
        System.out.println(binarySearch);

        binarySearch = Collections.binarySearch(list, 102);
        System.out.println(binarySearch);

        binarySearch = Collections.binarySearch(list, 20);
        System.out.println(binarySearch);

        binarySearch = Collections.binarySearch(list, 21);
        System.out.println(binarySearch);

        binarySearch = Collections.binarySearch(list, 22);
        System.out.println(binarySearch);

        binarySearch = Collections.binarySearch(list, 23);
        System.out.println(binarySearch);


        binarySearch = Collections.binarySearch(list, 1);
        System.out.println(binarySearch);

        binarySearch = Collections.binarySearch(list, 2);
        System.out.println(binarySearch);
    }


}
