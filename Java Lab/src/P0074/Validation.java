package P0074;

import java.util.Scanner;

public class Validation {
    private static Scanner in = new Scanner(System.in);
    public static int checkInput(){
        while(true){
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if(input < 1 || input > 4){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be in range [1,4]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkRowandColumn() {
        while(true){
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if(input <= 0){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Must be positive number");
                System.out.print("Please reinput: ");
            }
        }
    }

    public static int checkInt() {
        while(true){
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if(Integer.toString(input).isEmpty()){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Value of matrix is digit");
                System.out.println("Enter again: ");
            }
        }
    }
}
