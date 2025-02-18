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

        while(scanner.hasNextLine() && y == 0){

        command = scanner.nextLine();
        String[] pecahan = command.split("#");
        
        if(pecahan[0].equals("course-add")){
  
            String code = "";
            String temp_matkul = "";
            String temp_sks = "";
            String temp_grade = "";

            code = pecahan[1];
            temp_matkul = pecahan[2];
            temp_sks = pecahan[3];
            temp_grade = pecahan[4];


            boolean sama = false;

            for(int i = 0; i < indexCourse; i++){
                if(c[i].getCode().equalsIgnoreCase(code)){
                    sama = true;
                }
            }
            if(!sama){
                c[indexCourse] = new Course(code, temp_matkul, temp_sks, temp_grade);
                indexCourse++;
            }    
       }

       if(pecahan[0].equals("student-add")){

            String nim = "";
            String nama = "";
            String year = "";
            String std_pgr = "";

            nim = pecahan[1];
            nama = pecahan[2];
            year = pecahan[3];
            std_pgr = pecahan[4];
            boolean sama = false;

            for(int i = 0; i < indexStd; i++){
                if(studentStd[i].getName().equalsIgnoreCase(nama)){
                    sama = true;
                }
            }
            if(!sama){
                studentStd[indexStd] = new Student(nim, nama, year, std_pgr);
                indexStd++;
            }
            
            
        
       }

       if(pecahan[0].equals("enrollment-add")){
              
    

            studentErl[indexErl] = new Student();
            cErl[indexErl] = new Course();
        
            String code = "";
            String id = "";
            String year = "";
            String semester = "";

            code = pecahan[1];
            id = pecahan[2];
            year = pecahan[3];
            semester = pecahan[4];

            boolean sama = false;

            for(int i = 0; i < indexStd; i++){
                if(studentStd[i].getId().equalsIgnoreCase(id)){
                    sama = true;
                    studentErl[indexErl].setId(id);
                    
                }
            }

            boolean doope = false;

            for(int i = 0; i < indexCourse; i++){
                if(c[i].getCode().equalsIgnoreCase(code)){
                    doope = true;
                    cErl[indexErl].setCode(code);

                }
            }

            
            
            if(!sama && !doope){
                System.out.println("invalid student|" + id + " and invalid course|" + code);
            } else if(!sama){
                System.out.println("invalid student|" + id);
            } else if(!doope){
                System.out.println("invalid course|" + code);
            }

            if(sama == true && doope == true){
                enroll[indexErl] = new Enrollment(cErl[indexErl], studentErl[indexErl], year, semester); 
                indexErl++;
            }
        
       }

    
       
        if (pecahan[0].equals("---")){  
            y = 54;
            break;
        }
        
        
    }
 
    scanner.close();


    for(int i = indexCourse-1; i >= 0; i--){
        System.out.println(c[i]);
    }
    for(int x = 0; x < indexStd; x++){
        System.out.println(studentStd[x]);
    }
    for(int z = 0; z < indexErl; z++){
        System.out.println(enroll[z]);
    }
 }
}