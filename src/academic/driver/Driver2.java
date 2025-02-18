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
        Scanner scanner = new Scanner(System.in);
        List<String> courses = new ArrayList<>();
        List<String> students = new ArrayList<>();
        List<String> enrollments = new ArrayList<>();
        List<String> invalidEntries = new ArrayList<>();
        
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] tokens = input.split("#");
            
            switch (tokens[0]) {
                case "course-add":
                    courses.add(String.join("|", Arrays.copyOfRange(tokens, 1, tokens.length)));
                    break;
                case "student-add":
                    students.add(String.join("|", Arrays.copyOfRange(tokens, 1, tokens.length)));
                    break;
                case "enrollment-add":
                    String courseId = tokens[1];
                    String studentId = tokens[2];
                    boolean courseExists = courses.stream().anyMatch(course -> course.startsWith(courseId));
                    boolean studentExists = students.stream().anyMatch(student -> student.startsWith(studentId));
                    
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
            
            if (input.equals("---")) {
                invalidEntries.forEach(System.out::println);
                courses.forEach(System.out::println);
                students.forEach(System.out::println);
                enrollments.forEach(System.out::println);
                System.exit(0);
            }
        }
    }
}