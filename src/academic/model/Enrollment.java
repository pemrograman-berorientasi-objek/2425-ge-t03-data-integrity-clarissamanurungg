package academic.model;

/**
    * 12S23042 Pretty Purba
    * 12S23049 Clarissa Manurung
 */
public class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}