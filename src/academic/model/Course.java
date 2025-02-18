package academic.model;

/**
    *  12S23042 Pretty Purba
    *  12S23049 Clarissa Manurung
 */
public class Course {  

    private String code;
    private String name;
    private String credits;
    private String passingGrade;

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public Course() { 
        this.code = "";
        this.name = "";
        this.credits = "";
        this.passingGrade = "";
    }

    public Course(String code, String name, String credits, String passingGrade) {
        this.code = code;
        this.name = name; 
        this.credits = credits;
        this.passingGrade = passingGrade;
    }

    @Override
    public String toString() {
        return this.code + "|" + this.name + "|" + this.credits + "|" + this.passingGrade;
    }



}