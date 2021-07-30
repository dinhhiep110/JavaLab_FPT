package P0059;

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

    public static String checkString() {
        while(true){
            String input = in.nextLine().trim();
            if(input.isEmpty()){
                System.out.println("Input is empty");
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }   
        }
    }

    public static double checkDouble() {
        while(true){
            try {
                float input = Float.parseFloat(in.nextLine().trim());
                if(input <= 0){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be double");
                System.out.print("Please reinput: ");
            }
        }
    }

}
