package academic.driver;
import java.util.*;
import academic.model.Course;

/**
    * 12S23042 Pretty Purba
    * 12S23049 Clarissa Manurung
 */
public class Driver1 {

    public static void main(String[] _args) {
        Scanner input= new Scanner(System.in);
        String str;
        List<String> courses= new ArrayList<>();
        while(input.hasNextLine()){
            str= input.nextLine();
            if(str.equals("---")){
                for(String course : courses){
                System.out.println(course);
                
            }
           
            System.exit(0);
        }

            String [] tokens= str.split("#");
            courses.add(String.join("|", Arrays.copyOfRange(tokens, 0, tokens.length)));
            
        }
    
    }
}