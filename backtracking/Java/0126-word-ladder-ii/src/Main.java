import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("abc");
        set1.add("aaa");

        Set<String> set2 = new HashSet<>();
        set2.add("aaa");

        set1.remove(set2);
    }
}
