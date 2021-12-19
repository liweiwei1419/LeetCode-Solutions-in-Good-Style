public class Main {

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        Student s1 = new Student("student1",90);
        Student s2 = new Student("student2",80);
        Student s3 = new Student("student3",70);
        arr.add(0,s1);
        arr.add(1,s2);
        arr.add(2,s3);
        System.out.println(arr);
    }
}
