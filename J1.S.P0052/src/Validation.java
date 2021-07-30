import java.util.Scanner;

public class Validation {
    private static Scanner in = new Scanner(System.in);
    public static int checkInput(){
        while(true){
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if(input < 1 || input > 5){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be from 1 to 5");
                System.out.print("Enter again: ");
            }
        }
    }
    public static String checkString() {
        while(true){
            try {
                String input = in.nextLine().trim();
                if(input.isEmpty() || !input.matches("^[a-z A-Z]*$")){
                    throw new NumberFormatException(); 
                }
                else{
                    return input;
                }
            } catch (Exception e) {
                System.out.print("Please reinput: ");
            }
        }
    }
    public static float checkFloat() {
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
                System.out.println("Area must be greater than  0");
                System.out.print("Please reinput: ");
            }
        }
    }
    
}
