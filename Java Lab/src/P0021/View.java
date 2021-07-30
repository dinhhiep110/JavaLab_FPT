package P0021;

import java.util.Scanner;

public class View {

    private static Scanner in = new Scanner(System.in);
    private static Manager manager = new Manager();

    

    public void Menu(){
        while(true){
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("\t1. Create");
            System.out.println("\t2. Find and Sort");
            System.out.println("\t3. Update/Delete");
            System.out.println("\t4. Report");
            System.out.println("\t5. Exit");
            System.out.print("Enter your choice: ");
            int choose = Validation.checkInput();
            switch(choose){
                case 1:
                    manager.Create();
                    break;
                case 2:
                    manager.sort();
                    break;
                case 3:
                    manager.updateOrDelete();
                    break;
                case 4:
                    manager.report();
                    break;
                case 5:
                    return;
            }
            System.out.println("Press any key to continue");
            in.nextLine();
        }
        
    }

    public String inputStudent(){
        String message = "Input Unsuccessfully";
        String id,name,course;
        System.out.print("Enter ID: ");
        while(true){
            id = Validation.getID();
            if(manager.isIDExisted(id) == true){
                System.out.println("ID is existed in the list");
                manager.displayStudentByID(id);
                name = manager.getNameById(id);
                System.out.println("Do you want to add semester and course name (Y or N): ");
                if(getYesNo() == true){
                    break;
                }
                else{
                    return message;
                }
            }
            else{
                System.out.print("Enter Name: ");
                name = Validation.getName();
                break;
            }
            
        }
        System.out.print("Enter Semester: ");
        int semester = Validation.getSemester();
        System.out.print("Enter Course Name: ");
        while(true){
            course = Validation.getCourse();
            if (manager.checkCourse(course) == false) {
                System.out.println("Available courses are: Java, C/C++, .Net!");
                System.out.println("Invalid course's name! Enter Again");
            }
            else{
                break;
            }
        }
        if (manager.isStudentExisted(id, name, semester, course) == true){
            message = "Student Information is dupplicated";
            return message;
        }
        manager.getList().add(new Student(id, name, semester, course));
        return "Input successfull";
    }


    public String inputName(){
        System.out.print("Enter student's name to find: ");
        String name = Validation.getName();
        return name;
    }

    

    public boolean getYesNo(){
        if(Validation.inputYN().equalsIgnoreCase("n")){
            return false;
        }
        return true;
    }

    public void update(){
        System.out.print("Enter Student's ID to update: ");
        String id = Validation.getID();
        if(manager.isIDExisted(id) == false){
            System.out.println("Student is  not existed");
            return;
        }
        manager.displayStudentByID(id);
        System.out.print("Do you want to update Student(Y or N): ");
        if(getYesNo() == false){
            return;
        }
        System.out.print("Enter index you want to update: ");
        int index = Validation.getIndex();
        updateStudentByIndex(id, index);

    }


    public void updateStudentByIndex(String id,int index){
        Student student = getStudentByIndex(index, id);
        if(student == null){
            System.out.println("Index is greater than index in the list");
            return;
        }
        String temp = student.getName();
        System.out.print("Enter Name: ");
        String name = Validation.checkInputUpdateName();
        if(name.isEmpty()){
            name = student.getName();
        }
        name = manager.nomalizeString(name);
        System.out.print("Enter Semester: ");
        int semester = Validation.checkInputUpdateSemester();
        if(semester == -1){
            semester = student.getSemester();
        }
        System.out.print("Enter Course Name: ");
        String course = Validation.checkInputUpdateCourseName();
        if(course.isEmpty()){
            course = student.getCourseName();
        }
        course = manager.nomalizeString(course);
        if(manager.isStudentExisted(id, name, semester, course) == true){
            System.out.println("Update information is dupplicates");
            return;
        }

        for(Student st : manager.getList()){
            if(st.getName().equals(temp)){
                st.setName(name);
            }
        }
        student.setSemester(semester);
        student.setCourseName(course);
        manager.displayStudentByID(id);
    }

    public Student getStudentByIndex(int index,String id){
        int count = 0;
        Student student = null;
        for (Student st : manager.getList()) {
            if (st.getId().equalsIgnoreCase(id)) {
                count++;
                if(index == count){
                    student = st;
                }
            }
        }
        if(index > count){
            return null;
        }
        return student;
    }


    public void deleteStudent(){
        System.out.print("Enter Student's ID to delete: ");
        String id = Validation.getID();
        Student student = manager.SearchByID(id);
        if(student == null){
            System.out.println("Student is not existed");
            return;
        }
        manager.displayStudentByID(id);
        manager.getList().remove(student);

    }

    public String chooseUpdateOrDelete(){
        System.out.println("Do you want to Update or Delete(U or D)");
        System.out.print("Enter your choice: ");
        String choice = Validation.inputUD();
        return choice;

    }

}
 