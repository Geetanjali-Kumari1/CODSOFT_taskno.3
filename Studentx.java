import java.io.Serializable;



public class Studentx implements Serializable{
    //Adding attributes
    private String name;
    private int rollnumber;
    private String grade;
    private int age;
    private String email;
    private String mobilenumber;

    public Studentx(String name, int rollnumber, String grade,int age,String email,  String mobilenumber ){ 
        this.name = name;
        this.rollnumber = rollnumber;
        this.grade = grade;
        this.age = age;
        this.email = email;
        this.mobilenumber = mobilenumber;
    }
// getters for the sttributes
    public String getName(){
        return name;
    }
    public int getRollnumber(){
        return rollnumber;
    }
    public String getGrade(){
        return grade;
    }
    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }
    public String getMobilenumber(){
        return mobilenumber;
    }


// setters for the attributes
    public void setName(String name){
        this.name = name;
    }
    public void setRollnumber(int rollnumber){
        this.rollnumber = rollnumber;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setMobilenumber(String mobilenumber){
        this.mobilenumber = mobilenumber;
    }

}
