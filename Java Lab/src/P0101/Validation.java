package P0101;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validation {

    private static Scanner in = new Scanner(System.in);
    private static final String phoneNUmber = "([+84|84|0]+(3|5|7|8|9|1[2|6|8|9]))+([0-9]{8})";
    private static final String email = "^[A-Za-z0-9]+@gmail.com+$";
    private static final String name = "^[A-Z a-z]+$";
    private static final String id = "^[A-Za-z0-9]+$";

    public static int checkInput(){
        while(true){
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if(input < 1 || input > 6){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be in range [1,6]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkString() {
        while(true){
            String input = in.nextLine().trim();
            if(input.isEmpty() || !input.matches(name)){
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }   
        }
    }

    public static String checkID() {
        while(true){
            String input = in.nextLine().trim();
            if(input.isEmpty() || !input.matches(id)){
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }   
        }
    }

    public static String checkPhoneNumber(){
        while(true){
            String phone = in.nextLine().trim();
            if(phone.length() != 10 && !phone.matches(phoneNUmber)){
                System.out.println("Wrong format,Phone number has a ten number and start at 09 or +84");
                System.out.println("Enter again: ");
            }
            else{
                return phone;
            }
        }
    }

    public static String checkEmail(){
        while(true){
            String input = in.nextLine().trim();
            if(!input.matches(email)){
                System.out.println("Wrong format abcd@gmail.com");
                System.out.println("Enter again: ");
            }
            else{
                return input;
            }
        }
    }

    public static String checkGender() {
        while(true){
            String input = in.nextLine().trim();
            if( !(input.toLowerCase().equals("male") ||  input.toLowerCase().equals("female")
            || input.toLowerCase().equals("other"))){
                System.out.println("Wrong Input,Gender must be (male,female,other)");
                System.out.println("Enter again: ");
            }
            else{
                return input;
            }
        }
    }

    public static double checkDouble(){
        while(true){
           try {
            double input = Double.parseDouble(in.nextLine().trim());
            if(input <= 0 ){
                throw new Exception();
            }
            else{
                return input;
            }
           } catch (Exception e) {
               System.out.println("Re-input: ");
           }
            
        }
    }

    public static Date checkInputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return date;
                } else {
                    System.out.println("Re-input in format dd-MM-yyyy");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Re-input in format dd-MM-yyyy");
            } catch (ParseException ex) {
                System.out.println("Re-input in format dd-MM-yyyy");
            }
        }
    }


    public static String checkYN(){
        while(true){
            try {
                String input = in.nextLine().trim();
                if(!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be Y or N");
                System.out.print("Enter again: ");
            }
        }
    }

    
}
