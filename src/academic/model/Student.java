package academic.model;

/**
 * 12S23042 Pretty Purba
 * 12S23049 Clarissa Manurung
 */
public class Student {
    private String studentId;
    private String name;
    private int year;

    public Student(String studentId, String name, int year) {
        this.studentId = studentId;
        this.name = name;
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}