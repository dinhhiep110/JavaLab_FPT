package P0057;

import java.util.Scanner;

public class Validation {
    static Scanner in = new Scanner(System.in);

    public static int checkInput(){
        while(true){
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if(input < 1 || input > 3){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be in range [1,3]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkUserName() {
        String username = "^\\S{5}\\S*$"; 
        while(true){ 
            String input = in.nextLine().trim();
            if(input.isEmpty() || !input.matches(username)){
                System.out.println("Username must be at least 5 characters and no spaces");
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }         
        }
    }

    public static String checkPassword() {
        String password = "^\\S{6}\\S*$"; 
        while(true){         
            String input = in.nextLine().trim();
            if(input.isEmpty() || !input.matches(password)){
                System.out.println("Password must be at least 6 characters and no spaces");
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }         
        }
    }
}
