public class Student {

    private int grade;
    private int cls;
    private String firstName;
    private String lastName;

    public Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // 在产生哈希冲突的时候，调用这个方法
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return grade == student.grade &&
                cls == student.cls &&
                this.firstName.toLowerCase().equals(student.firstName) &&
                this.lastName.toLowerCase().equals(student.lastName);
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;

        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();

        return hash;
    }
}
