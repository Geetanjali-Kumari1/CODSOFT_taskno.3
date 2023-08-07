import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystemx{
    private String dataFilePath;
    private List<Studentx> students;

    public StudentManagementSystemx(String dataFilePath){
        this.dataFilePath = dataFilePath;
        students = new ArrayList<>();
        loadStudentsx();
    }
// method to add students
    public void addStudentx(Studentx student){
        students.add(student);
        saveStudentsx();
    }
// method to remove students with the help of their roll number
    public void removeStudentx(Studentx student){
        students.remove(student);
        saveStudentsx();
    }
//method to search students with the help of their roll number
    public Studentx searchStudentx(int rollnumber){
        for (Studentx student : students){
            if (student.getRollnumber() == rollnumber){
                return student;
            }
        }
        return null;
    }
//method to  get list of all students saved in the students.txt file which is in CSV(Comma Separated Values) format
    public List<Studentx> getAllStudentsx(){
        return new ArrayList<>(students);
    }
//method to load students from CSV file
    public void loadStudentsx(){
        try ( BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))){
            String line;
            while((line = reader.readLine())!= null){
                String [] studentData = line.split(",");
                if (studentData.length == 6){
                    String name = studentData[0];
                    int rollnumber = Integer.parseInt(studentData[1]);
                    String grade = studentData[2];
                    int age = Integer.parseInt(studentData[3]);
                    String email = studentData[4];
                    String mobilenumber = studentData[5];
                    Studentx student = new Studentx(name, rollnumber, grade, age, email, mobilenumber);
                    students.add(student);
                }
            }
        }
        catch(IOException e){
           students = new ArrayList<>(); 
        }
    }
//method to save students to the CSV file
    public void saveStudentsx(){
        try ( PrintWriter writer = new PrintWriter(new FileWriter(dataFilePath))){
            for (Studentx student : students){
                writer.println(student.getName() + "," + student.getRollnumber() + "," + student.getGrade() + "," + student.getAge() + "," + student.getEmail() + "," + student.getMobilenumber()); 
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

