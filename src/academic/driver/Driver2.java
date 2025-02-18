package academic.driver;

import java.util.*;
import academic.model.Enrollment;
import academic.model.Course;
import academic.model.Student;

public class Driver2 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        int indexCourse = 0, indexStd = 0, indexErl = 0;
        Student[] studentStd = new Student[100];
        Course[] courses = new Course[100];
        Enrollment[] enrollments = new Enrollment[100];
        Set<String> invalidEntries = new LinkedHashSet<>(); // Menghindari duplikasi entri tidak valid

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            String[] tokens = command.split("#");

            if (tokens[0].equals("course-add")) {
                String code = tokens[1];
                String name = tokens[2];
                String credits = tokens[3];
                String grade = tokens[4];

                boolean exists = false;
                for (int i = 0; i < indexCourse; i++) {
                    if (courses[i].getCode().equalsIgnoreCase(code)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    courses[indexCourse++] = new Course(code, name, credits, grade);
                }
            } else if (tokens[0].equals("student-add")) {
                String id = tokens[1];
                String name = tokens[2];
                String year = tokens[3];
                String program = tokens[4];

                boolean exists = false;
                for (int i = 0; i < indexStd; i++) {
                    if (studentStd[i].getId().equalsIgnoreCase(id)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    studentStd[indexStd++] = new Student(id, name, year, program);
                }
            } else if (tokens[0].equals("enrollment-add")) {
                String courseCode = tokens[1];
                String studentId = tokens[2];
                String year = tokens[3];
                String semester = tokens[4];

                boolean validStudent = false, validCourse = false;
                Student matchedStudent = null;
                Course matchedCourse = null;

                for (int i = 0; i < indexStd; i++) {
                    if (studentStd[i].getId().equalsIgnoreCase(studentId)) {
                        validStudent = true;
                        matchedStudent = studentStd[i];
                        break;
                    }
                }

                for (int i = 0; i < indexCourse; i++) {
                    if (courses[i].getCode().equalsIgnoreCase(courseCode)) {
                        validCourse = true;
                        matchedCourse = courses[i];
                        break;
                    }
                }

                if (!validStudent) {
                    invalidEntries.add("invalid student|" + studentId); // Hindari duplikasi
                }
                if (!validCourse) {
                    invalidEntries.add("invalid course|" + courseCode); // Hindari duplikasi
                }

                if (validStudent && validCourse) {
                    enrollments[indexErl++] = new Enrollment(matchedCourse, matchedStudent, year, semester);
                }
            } else if (tokens[0].equals("---")) {
                break;
            }
        }

        scanner.close();

        // Output invalid entries
        invalidEntries.forEach(System.out::println);

        // Output courses
        Arrays.sort(courses, 0, indexCourse, Comparator.comparing(Course::getCode));
        for (int i = 0; i < indexCourse; i++) {
            System.out.println(courses[i]);
        }

        // Output students
        Arrays.sort(studentStd, 0, indexStd, Comparator.comparing(Student::getId));
        for (int i = 0; i < indexStd; i++) {
            System.out.println(studentStd[i]);
        }

        // Output enrollments
        Arrays.sort(enrollments, 0, indexErl, Comparator.comparing(e -> e.getCourse().getCode()));
        for (int i = 0; i < indexErl; i++) {
            System.out.println(enrollments[i] + "|None");
        }
    }
}
