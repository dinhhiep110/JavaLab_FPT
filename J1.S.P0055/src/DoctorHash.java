import java.util.HashMap;
import java.util.Map;


public class DoctorHash {

    HashMap<String,Doctor> hm;
    
    public DoctorHash(){
        hm = new HashMap<>();
    }

    public static void displayMenu(){
        System.out.println("======== Doctor Management ========");
        System.out.println("1.Add Doctor");
        System.out.println("2.Update Doctor");
        System.out.println("3.Delete Doctor");
        System.out.println("4.Search Doctor");
        System.out.println("5.Exit");
        System.out.print("Enter your choice: ");
    }

    public boolean isEmpty(Doctor doctor){
        if(doctor.getCode() == null && doctor.getName() == null
        && doctor.getSpecialization() == null && Integer.toString(doctor.getAvailability()) == null){
            return true;
        }
        return false;
    }

    private boolean isExsitedCode(String code){
        for(String key : hm.keySet()){
            if(key.toLowerCase().equals(code.toLowerCase())){
                System.out.println(key);
                return true;
            }
        }
        return false;
    }

    public void adding() throws Exception{
        System.out.println("- - - - - - - - Add Doctor - - - - - - - -");
        System.out.print("Enter Code: ");
        String code = Validation.checkID();
        if(isExsitedCode(code) == true){
            System.out.println("Doctor code [" + code + "] is duplicate");
            return;
        }
        code = normalizeString(code);
        System.out.print("Enter Name: ");
        String name = Validation.checkString();
        System.out.print("Enter Specialization: ");
        String specialization = Validation.checkString();
        System.out.print("Enter Availability: ");
        int availability = Validation.checkAvailability();
        hm.put(code, new Doctor(name, specialization, availability));
        Doctor doctor = new Doctor(code, name, specialization, availability);
        checkAddDoctor(doctor);
        System.out.println("Add successfull");
        displayDoctorList();

    }

    public static String normalizeString(String input){
        input = input.replaceAll("\\s+", " ");
        String[] temp= input.split(" ");
        String res = "";
        for(int i = 0;i < temp.length;i++){
            res += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i<temp.length-1) 
                res += " "; 
        }
        return res;
    }

    public void checkAddDoctor(Doctor Doctor) throws Exception{
        if(isEmpty(Doctor)){
            throw new Exception("Data doesn't exist");
        }
        else if(hm.isEmpty()){
            throw new Exception("Database doesn't exsit");
        }
    }

    public void checkUpdateDoctor(Doctor Doctor) throws Exception{
        if(isEmpty(Doctor)){
            throw new Exception("Data doesn't exist");
        }
        else if(hm.isEmpty()){
            throw new Exception("Database doesn't exsit");
        }
        
    }


    public String findCode(){
        System.out.print("Enter code of Doctor: ");
        String code = Validation.checkID();
        code = normalizeString(code);
        if(!hm.containsKey(code)){
            System.out.println("Code doesn't exist");
            System.out.print("Enter again: ");
            code = Validation.checkID();
        }
        return code;
       
    }

    public void updating() throws Exception{
        System.out.println("- - - - - - - - Update Doctor - - - - - - - -");
        String code = findCode();
        Doctor doctor = hm.get(code);
        if(isEmpty(doctor)){
            System.out.println("Doctor is empty");
            return;
        }
        doctor.display();
        System.out.print("Enter Name: ");
        String name = Validation.checkInputOfString();
        if(name == null){
            name = doctor.getName();
        }
        System.out.print("Enter Specialization: ");
        String specialization = Validation.checkInputOfString();
        if(specialization == null){
            specialization = doctor.getSpecialization();
        }
        System.out.print("Enter Availability: ");
        int availability = Validation.checkInputOfAvailability();
        if(availability == -1){
            availability = doctor.getAvailability();
        }
        hm.replace(code, new Doctor(name, specialization, availability));
        Doctor doc = new Doctor(code, name, specialization, availability);
        checkUpdateDoctor(doc);
        System.out.println("Update successfull");
        displayDoctorList();

        
    }

    public void displayDoctorList(){
        System.out.printf("%-10s%-10s%-20s%-20s\n","Code","Name","Specialization","Availability");
        for (Map.Entry<String,Doctor> entry : hm.entrySet()){
            System.out.printf("%-10s",entry.getKey());
            entry.getValue().display();
        }
    }


    public void deleting(){
        System.out.println("- - - - - - - - Deleting Doctor - - - - - - - -");
        String code = findCode();
        Doctor doctor = hm.get(code);
        if(isEmpty(doctor)){
            System.out.println("Doctor is empty");
            return;
        }
        hm.remove(code);
        System.out.println("Status doctor fix");
        displayDoctorList();
    }

    public void searchDoctor() throws Exception{
        System.out.println("- - - - - - - - Search Doctor - - - - - - - -");
        System.out.print("Enter text: ");
        String text = Validation.checkString();
        HashMap<String,Doctor> getListDoctor = getListDoctor(text);
        displayDoctorOfSearch(getListDoctor);
        if(getListDoctor.isEmpty()){
            throw new Exception("Database does not exist");
        }
        else{
            System.out.println("List of doctors found");
        }
        
    }

    public void displayDoctorOfSearch(HashMap<String,Doctor> ListDoctor){
        System.out.printf("%-10s%-10s%-20s%-20s\n","Code","Name","Specialization","Availability");
        for (Map.Entry<String,Doctor> entry : ListDoctor.entrySet()){
            System.out.printf("%-10s",entry.getKey());
            entry.getValue().display();
        }
    }

    public HashMap<String,Doctor> getListDoctor(String input){
        HashMap<String,Doctor> getListDoctor = new HashMap<>();
        for(String key : hm.keySet()){
            if(key.contains(input) || hm.get(key).getName().contains(input) || hm.get(key).getSpecialization().contains(input)){
                getListDoctor.put(key, hm.get(key));
            }
        }
        return getListDoctor;
    }
}
