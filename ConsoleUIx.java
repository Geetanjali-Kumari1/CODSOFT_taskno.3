import java.util.List;
import java.util.Scanner;

public class ConsoleUIx {
private static final String DATA_FILE_PATH = "students.txt"; // CSV file name or we can also give here the actual location path of the CSV file 
private static StudentManagementSystemx system = new StudentManagementSystemx(DATA_FILE_PATH);
private static final Scanner scanner = new Scanner (System.in);



// main method 
public static void main(String[] args) {
    displayMenux();
    
}

// method to display all the possible options 
private static void displayMenux(){
    while (true){
        System.out.println("\n Student Management System----------------------------------");
        System.out.println("1. Add a student: ");
        System.out.println("2. Remove a student: ");
        System.out.println("3. Search any student: ");
        System.out.println("4. Display all students: ");
        System.out.println("5. Exit the system !!");
        System.out.println(" \n Enter your option (1-5): ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option){
            case 1:
            addNewStudentx();
            break;
            case 2:
            removeStudentx();
            break;
            case 3:
            searchStudentx();
            break;
            case 4:
            displayAllStudentsx();
            break;
            case 5:
            System.out.println("Exiting the system. \nThankyou for using the system. \n Byee!!");
            System.exit(0);
        }

    }
}
// method to add  new  student with the implementation of input validation 
private static void addNewStudentx(){
    System.out.println("Enter the student name : ");
    String name = scanner.nextLine().trim();
   while (name.isEmpty()){
        System.out.println("Name can't be empty.\n Enter the student name : ");
        name = scanner.nextLine().trim();
    }
    System.out.println("Enter rollnumber : ");
    int rollnumber;
    while(true){
        try{
            rollnumber = Integer.parseInt(scanner.nextLine());
            break;
        }
        catch(NumberFormatException e){
            System.out.println("This is not a valid rollnumber.\n Enter rollnumber : ");
        }
    }

    System.out.println ("Enter students' grade : ");
    String grade = scanner.nextLine().trim();
    while (grade.isEmpty()){
        System.out.println("Grade can't be empty.\n Enter students' grade : ");
       grade = scanner.nextLine().trim();
    }

    System.out.println("Enter students' age : ");
    int age;
    while (true){
        try{
            age = Integer.parseInt(scanner.nextLine());
            break;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid age. \n Enter students' age: ");
        }
    }

    System.out.println("Enter email: ");
    String email = scanner.nextLine().trim();
    while (email.isEmpty()){
        System.out.println("Email can't be empty.\n Enter email :");
        email = scanner.nextLine().trim();
    }

    System.out.println("Enter moblilenumber: ");
    String mobilenumber = scanner.nextLine().trim();
    while (mobilenumber.isEmpty()){
        System.out.println("Invalid mobilenumber. \n Enter moblilenumber : ");
        mobilenumber = scanner.nextLine().trim();
    }


Studentx newStudentx = new Studentx (name, rollnumber, grade, age, email, mobilenumber);
//add new student to the system    
system.addStudentx(newStudentx);
    System.out.println("Student added successfully !! ");
}

// method to search a student
private static void searchStudentx (){
    System.out.println("Enter rollnumber to search the student : ");
    int rollnumber = scanner.nextInt();
    scanner.nextLine();

// search for student in the system
    Studentx student = system.searchStudentx( rollnumber);
    if (student != null){
        System.out.println("Student found. ");
        System.out.println("Name : " + student.getName() + "," + "Rollnumber : " + student.getRollnumber() + "," + " Grade : " + student.getGrade() + ","  +"Age : " +student.getAge() + "," +"Email :" +student.getEmail() + "," +"Mobilenumber: " + student.getMobilenumber());
    }
    else {
        System.out.println("Student not found.");
    }
}

// method to display all students
private static void displayAllStudentsx(){
    List<Studentx> students = system.getAllStudentsx();
    if (students.isEmpty()){
        System.out.println("List is empty.\n No students are there.");
    }
    else{
        System.out.println("Here is the list of all Students:   -----");
        for (Studentx student : students){
           System.out.println("\n Name : " + student.getName() + "," +  "Rollnumber : " + student.getRollnumber() + "," + " Grade : " + student.getGrade() + "," +"Age : " +student.getAge() + "," +"Email :" +student.getEmail() + "," +"Mobilenumber: " + student.getMobilenumber()); 
        }
    }
}


// method to remove a student
private static void removeStudentx(){
    System.out.println("Enter students' rollnumber : ");
    int rollnumber = scanner.nextInt();
    scanner.nextLine();

    Studentx studentToRemove = system.searchStudentx( rollnumber);
    if (studentToRemove != null){
        system.removeStudentx(studentToRemove);// remove the student from the system
        System.out.println("Student removed successfully. ");

}
else{
            System.out.println("Student not found.");


}
}}
