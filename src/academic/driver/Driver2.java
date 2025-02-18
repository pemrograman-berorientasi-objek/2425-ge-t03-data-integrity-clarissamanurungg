package academic.driver;
import java.util.*;
import academic.model.Enrollment;
import academic.model.Course;
import academic.model.Student;

/**
    * 12S23042 Pretty Purba
    * 12S23049 Clarissa Manurung
 */
public class Driver2 {

    public static void main(String[] _args) {
        Scanner input = new Scanner(System.in);
        String str;
        List<String> courses = new ArrayList<>();
        List<String> students = new ArrayList<>();
        List<String> enrolList = new ArrayList<>();
        List<String> invalidEntries = new ArrayList<>();
        List<String> enrollments = new ArrayList<>();

        while (input.hasNextLine()) {
            str = input.nextLine();
            String[] tokens = str.split("#");
            switch (tokens[0]) {
                case "course":
                    String courseId = tokens[1];
                    courses.add(courseId);
                    break;
                case "student":
                    String studentId = tokens[1];
                    students.add(studentId);
                    break;
                case "enroll":
                    studentId = tokens[1];
                    courseId = tokens[2];
                    boolean studentExists = students.contains(studentId);
                    boolean courseExists = courses.contains(courseId);
                    if (!studentExists) {
                        invalidEntries.add("invalid student|" + studentId);
                    } else if (!courseExists) {
                        invalidEntries.add("invalid course|" + courseId);
                    } else {
                        enrollments.add(String.join("|", Arrays.copyOfRange(tokens, 1, tokens.length)) + "|None");
                    }
                    break;
                default:
                    break;
            }
            if (str.equals("---")) {
                for (String course : courses) {
                    System.out.println(course);
                }
                for (String student : students) {
                    System.out.println(student);
                }
                for (String enrol : enrollments) {
                    System.out.println(enrol);
                }
                System.exit(0);
            }
        }
    }
}