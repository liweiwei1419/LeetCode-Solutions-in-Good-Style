import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 定义 Person 类
 */
class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        System.out.println(this.name + "....hashCode");
        return name.hashCode() + age * 37;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;

        }
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Solution4 {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        // 将 Person 类添加进 HashSet 里面
        set.add(new Person("a1", 11));
        set.add(new Person("a2", 12));
        set.add(new Person("a3", 13));
        // 定义迭代器
        Iterator<Person> it = set.iterator();
        // 开始遍历 HashSet
        while (it.hasNext()) {
            Person p = it.next();
            System.out.println(p.getName() + "::" + p.getAge());
        }
    }
}