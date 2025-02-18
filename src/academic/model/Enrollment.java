package academic.model;
/**
 * @author 12S22031 - Ioka Purba
 */
public class Enrollment {

    private  Student student;
    private  Course course;
    private String year;
    private String semester;
    private String grade = "None";

    public Enrollment(Course course, Student student, String year, String semester) {
        
        this.student = student;
        this.course = course;
        this.year = year;
        this.semester = semester;
    }

    @Override 
    public String toString() {
        return this.course.getCode() + "|" + this.student.getId() + "|" + this.year + "|" + this.semester + "|" + this.grade;
    } 


}