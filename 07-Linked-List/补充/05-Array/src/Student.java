public class Student {

    private String name;
    private int score;


    public Student(String studentName, int studentScore) {
        this.name = studentName;
        this.score = studentScore;
    }


    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
