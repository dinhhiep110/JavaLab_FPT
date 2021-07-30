package P0101;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Manager {

    private ArrayList<Employee> list;

    public Manager() {
        list = new ArrayList<>();
    }

    public void displayMenu(){
        System.out.println("1.Add employees");
        System.out.println("2.Update employees");
        System.out.println("3.Remove employees");
        System.out.println("4.Search employees");
        System.out.println("5.Sort employees by salary");
        System.out.println("6.Exit");
        System.out.print("Enter your choice: ");
    }

    private String nomalizeString(String input){
        input = input.replaceAll("\\s+", " ");
        String temp[] = input.split(" ");
        String res = "";
        for(int i = 0;i < temp.length;i++){
            res += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i<temp.length-1) {
                res += " "; 
            }              
        }
        return res;
    }

    private Employee inputEmployee(){
        System.out.print("Enter ID: ");
        String id = Validation.checkID();
        if(getIndexOfID(id) != -1){
            System.out.println("ID is exsited");
            return null;
        }
        id = nomalizeString(id);
        System.out.print("Enter Fisrt Name: ");
        String firstName = Validation.checkString();
        firstName = nomalizeString(firstName);
        System.out.print("Enter Last Name: ");
        String lastName = Validation.checkString();
        lastName = nomalizeString(lastName);
        System.out.print("Enter Phone Number: ");
        String phone = Validation.checkPhoneNumber();
        System.out.print("Enter email: ");
        String email = Validation.checkEmail();
        System.out.print("Enter Address: ");
        String address = Validation.checkString();
        address = nomalizeString(address);
        System.out.print("Enter Date of Birth: ");
        Date dob = Validation.checkInputDate();
        System.out.print("Enter Gender(Male,Female,Other): ");
        String sex = Validation.checkGender();
        sex = nomalizeString(sex);
        System.out.print("Enter Salary: ");
        double salary = Validation.checkDouble();
        System.out.print("Enter Agency: ");
        String agency = Validation.checkString();
        agency = nomalizeString(agency);
        Employee em = new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
        return em;
    }


    public void addEmployee(){
        Employee em = inputEmployee();
        if(em == null){
            return;
        }
        list.add(em);
        System.out.println("Add Successfully");
        printList(list);
    }

    private void printList(ArrayList<Employee> list){
        System.out.printf("%-10s%-15s%-15s%-25s%-15s%-15s%-15s%-15s%-15s\n","ID","Name","Phone Number","Email","Address","Date of Birth","Gender","Salary","Agency");
        for(Employee em : list){
            em.display();
        }
    }

    private int getIndexOfID(String id){
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;// ID ko ton tai
    }

    public void updateEmployee(){
        System.out.print("Enter ID to update: ");
        String id = Validation.checkID();
        int index = getIndexOfID(id);
        if(index == -1){
            System.out.println("ID doesn't exist");
            return;
        }

        Employee em = list.get(index);
        System.out.printf("%-10s%-15s%-15s%-25s%-15s%-15s%-15s%-15s%-15s\n","ID","Name","Phone Number","Email","Address","Date of Birth","Gender","Salary","Agency");
        em.display();
        updating(em);        
        System.out.println("Update successfully"); 
        printList(list);
    }

    private void updating(Employee em){
        System.out.print("Do you want to update this employee(Y or N):");
        if(getYesNo()){
            System.out.print("Do you want to update first name(Y or N): ");
            if(getYesNo() == true){
                System.out.print("Enter Fisrt Name: ");
                String firstName = Validation.checkString();
                firstName = nomalizeString(firstName);
                em.setFirstName(firstName);
            }
           
            System.out.print("Do you want to update last name(Y or N): ");
            if(getYesNo() == true){
                System.out.print("Enter Last Name: ");
                String lastName = Validation.checkString();
                lastName = nomalizeString(lastName);
                em.setLastName(lastName);
            }

            System.out.print("Do you want to update PhoneNumber(Y or N): ");
            if(getYesNo() == true){
                System.out.print("Enter Phone Number: ");
                String phone = Validation.checkPhoneNumber();
                em.setPhone(phone);
            }
            
            System.out.print("Do you want to update Email(Y or N): ");
            if(getYesNo() == true){
                System.out.print("Enter email: ");
                String email = Validation.checkEmail();
                em.setEmail(email);
            }

            System.out.print("Do you want to update Addres(Y or N); ");
            if(getYesNo() == true){
                System.out.print("Enter Address: ");
                String address = Validation.checkString();
                address = nomalizeString(address);
                em.setAddress(address);
            }

            System.out.print("Do you want to update Date Of Birth(Y or N): ");
            if(getYesNo() == true){
                System.out.print("Enter Date of Birth: ");
                Date dob = Validation.checkInputDate();
                em.setDob(dob);
            }
            
            System.out.print("Do you want to update Gender(Y or N): ");
            if(getYesNo() == true){
                System.out.print("Enter Gender(Male,Female,Other): ");
                String sex = Validation.checkGender();
                sex = nomalizeString(sex);
                em.setSex(sex);
            }

            System.out.print("Do you want to update Salary(Y or N): ");
            if(getYesNo() == true){
                System.out.print("Enter Salary: ");
                double salary = Validation.checkDouble();
                em.setSalary(salary);
            }
            
            System.out.print("Do you want to update Agency(Y or N): ");
            if(getYesNo() == true){
                System.out.print("Enter Agency: ");
                String agency = Validation.checkString();
                agency = nomalizeString(agency);
                em.setAgency(agency);
            }
        }
    }

    public boolean getYesNo(){
        if(Validation.checkYN().equalsIgnoreCase("n")){
            return false;
        }
        return true;
    }


    public void removeEmployee(){
        System.out.print("Enter ID to remove: ");
        String id = Validation.checkID();
        int index = getIndexOfID(id);
        if(index == -1){
            System.out.println("ID doesn't exsited");
            return;
        }
        Employee em = list.get(index);
        list.remove(em);
        System.out.println("Remove successfully");
        printList(list);
    }

    public void searchEmployees(){
        System.out.print("Enter name: ");
        String name = Validation.checkString();
        name = nomalizeString(name);
        String word[] = name.split(" ");
        Set<Employee> lsOfName = new TreeSet<>();
        

        for(int i = 0;i < word.length;i++){
            for(Employee em : list){
                for(int j = 0; j < word[i].length();j++){
                    if(em.getFirstName().indexOf(word[i].charAt(j)) != -1
                    || em.getLastName().indexOf(word[i].charAt(j)) != -1){
                        lsOfName.add(em);
                    }
                }
            }
        }
        ArrayList<Employee> result = new ArrayList<>(lsOfName);
        if(result.isEmpty()){
            System.out.println("Employee doesn't have in list");
            return;
        }
        printList(result);
        System.out.println("Search successfully");
    }
    

    public void sortEmployee(){
        Collections.sort(list,new Comparator<Employee>(){

            public int compare(Employee e1, Employee e2) {
                if(e1.getSalary() > e2.getSalary()){
                    return 1;
                }
                return -1;
            }  
        });
        printList(list);
        System.out.println("Sort list successfully");
    }
}
