package academic.model;

/**
 * 12S23042 Pretty Purba
 * 12S23049 Clarissa Manurung
 */
public class Student  {

    private  String name;
    private  String id;
    private  String year;
    private  String StdProgram;

    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public String getId() {
        return this.id;
    }
    


    public Student() {
        this.id = "";
        this.name = "";
        this.year = "";
        this.StdProgram = "";
    }

    public Student(String id, String name, String year, String StdProgram) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.StdProgram = StdProgram;
     
    }

     

    @Override
    public String toString() {
        return this.id+"|"+this.name+"|"+this.year+"|"+this.StdProgram;
    }
    
    // @Override
    // public int compareTo(Student that){
    //     return this.id.compareTo(that.name);
    // }

}