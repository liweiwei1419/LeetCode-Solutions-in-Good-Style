import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int a = 42;
        // 42
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        // -42
        System.out.println(((Integer) b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double) c).hashCode());

        Student student1 = new Student(3, 2, "li", "weiwei");
        Student student2 = new Student(3, 2, "li", "WEIWEI");
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student1);
        set.add(student2);
        System.out.println(set.size());
    }
}
