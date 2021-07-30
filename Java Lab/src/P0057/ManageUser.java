package P0057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ManageUser {
    private BufferedReader bufferedReader;
    HashMap<String,String> listOfUser;

    public ManageUser(){
        listOfUser = new HashMap<>();
    }

    public void displayMenu(){
        System.out.println("============= USER MANAGEMENT SYSTEM ============= ");
        System.out.println("1. Create a new account.");
        System.out.println("2. Login system.");
        System.out.println("3. Exit.");
        System.out.print(">  Choose: ");
    }

    private boolean checkFileExist(){
        File file = new File("/Users/dinhhiep/Desktop/user.dat");
        if(!file.exists()){
            System.out.println("File doesn't exist");
            try {
                file.createNewFile();
                System.out.println("File is created");
                return false;
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
        return true;
    }

    
    public void createNewAccount(){
        if(!checkFileExist()){
            return;
        }
        System.out.print("Enter Username: ");
        String username = Validation.checkUserName();
        if(checkUsernameExist(username)){
            System.out.println("Username existed");
            return;
        }
        System.out.print("Enter Password: ");
        String password = Validation.checkPassword();
        if(checkPassWordExist(password)){
            System.out.println("Password existed");
            return;
        }
        
        addAccountData(username, password);

    }

    private boolean checkUsernameExist(String username){
        File file = new File("/Users/dinhhiep/Desktop/user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public  void addAccountData(String username, String password) {
        File file = new File("/Users/dinhhiep/Desktop/user.dat");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(username + ";" + password + "\n");
            bufferedWriter.close();
            fileWriter.close();
            System.err.println("Create successly.");
            listOfUser.put(username, password);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loginSystem(){
        System.out.print("Enter Username: ");
        String username = Validation.checkUserName();
        System.out.print("Enter Password: ");
        String password = Validation.checkPassword();
        
        // if(checkUsernameExist(username) && checkPassWordExist(password)){
        //     System.out.println("Login successfully");
        //     return;
        // }
        // else{
        //     System.out.println("Invalid username or pasword");
        // }

        for(Map.Entry<String,String> entry : listOfUser.entrySet()){
            if(entry.getKey().equalsIgnoreCase(username) && entry.getValue().equalsIgnoreCase(password)){
                System.out.println("Login successfully");
                return;
            }
        }
        System.out.println("Invalid username or password");
    }


    private boolean checkPassWordExist(String password){
        File file = new File("/Users/dinhhiep/Desktop/user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (password.equalsIgnoreCase(account[1])) {
                    return true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    


}
