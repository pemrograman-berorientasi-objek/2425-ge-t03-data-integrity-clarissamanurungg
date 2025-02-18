package academic.driver;
import java.util.*;
import academic.model.Enrollment;
import academic.model.Course;
import academic.model.Student;

/**
    * 12S23042 Pretty Purba
    * 12S23049 Clarissa Manurung
 */
import java.util.*;
import academic.model.Enrollment;
import academic.model.Course;
import academic.model.Student;

public class Driver2 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        int y = 0;
        String command;
        int indexCourse = 0;
        int indexStd = 0;
        int indexErl = 0;
        Student[] studentStd = new Student[100];
        Student[] studentErl = new Student[100];
        Course[] c = new Course[100];
        Course[] cErl = new Course[100];
        Enrollment[] enroll = new Enrollment[100];
        List<String> invalidEntries = new ArrayList<>();

        while (scanner.hasNextLine() && y == 0) {
            command = scanner.nextLine();
            String[] pecahan = command.split("#");

            if (pecahan[0].equals("course-add")) {
                String code = pecahan[1];
                String temp_matkul = pecahan[2];
                String temp_sks = pecahan[3];
                String temp_grade = pecahan[4];

                boolean sama = false;
                for (int i = 0; i < indexCourse; i++) {
                    if (c[i].getCode().equalsIgnoreCase(code)) {
                        sama = true;
                    }
                }
                if (!sama) {
                    c[indexCourse] = new Course(code, temp_matkul, temp_sks, temp_grade);
                    indexCourse++;
                }
            }

            if (pecahan[0].equals("student-add")) {
                String nim = pecahan[1];
                String nama = pecahan[2];
                String year = pecahan[3];
                String std_pgr = pecahan[4];

                boolean sama = false;
                for (int i = 0; i < indexStd; i++) {
                    if (studentStd[i].getName().equalsIgnoreCase(nama)) {
                        sama = true;
                    }
                }
                if (!sama) {
                    studentStd[indexStd] = new Student(nim, nama, year, std_pgr);
                    indexStd++;
                }
            }

            if (pecahan[0].equals("enrollment-add")) {
                String code = pecahan[1];
                String id = pecahan[2];
                String year = pecahan[3];
                String semester = pecahan[4];

                boolean studentExists = false;
                for (int i = 0; i < indexStd; i++) {
                    if (studentStd[i].getId().equalsIgnoreCase(id)) {
                        studentExists = true;
                        studentErl[indexErl] = studentStd[i];
                        break;
                    }
                }

                boolean courseExists = false;
                for (int i = 0; i < indexCourse; i++) {
                    if (c[i].getCode().equalsIgnoreCase(code)) {
                        courseExists = true;
                        cErl[indexErl] = c[i];
                        break;
                    }
                }

                if (!studentExists) {
                    invalidEntries.add("invalid student|" + id);
                } else if (!courseExists) {
                    invalidEntries.add("invalid course|" + code);
                } else {
                    enroll[indexErl] = new Enrollment(cErl[indexErl], studentErl[indexErl], year, semester);
                    indexErl++;
                }
            }

            if (pecahan[0].equals("---")) {
                y = 54;
                break;
            }
        }

        scanner.close();

        invalidEntries.forEach(System.out::println);
        for (int i = 0; i < indexCourse; i++) {
            System.out.println(c[i]);
        }
        for (int x = 0; x < indexStd; x++) {
            System.out.println(studentStd[x]);
        }
        for (int z = 0; z < indexErl; z++) {
            System.out.println(enroll[z]);
        }
    }
}