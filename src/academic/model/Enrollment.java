package academic.model;

/**
 *  12S23042 Pretty Purba
 *  12S23049 Clarissa Manurung
 */

public class Enrollment {
    private Course course;
    private Student student;
    private String year;
    private String semester;

    public Enrollment(Course course, Student student, String year, String semester) {
        this.course = course;
        this.student = student;
        this.year = year;
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return course.getCode() + "|" + student.getId() + "|" + year + "|" + semester;
    }
}