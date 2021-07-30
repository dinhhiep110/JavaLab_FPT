import java.util.Scanner;

public class Validation {
    private static final String standard = "^[A-Z a-z]+$";
    private static final String id = "^[A-Z a-z 0-9]+$";
    private static final String digit = "^[0-9]+$";
    static Scanner in = new Scanner(System.in);
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
                System.out.println("Input must be in range [1,5]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkString() {
        while(true){
            String input = in.nextLine().trim();
            if(input.isEmpty() || !input.matches(standard)){
                System.out.println("Wrong input,Input must not contain digit");
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
            if(!input.matches(id)){
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }   
        }
    }

    public static int checkAvailability() {
        while(true){
            try {
                int availability = Integer.parseInt(in.nextLine().trim());
                System.out.println(availability);
                if(Integer.toString(availability).isEmpty()){
                    return -1;
                }
                if(availability < 0){
                    throw new NumberFormatException();
                }
                else{
                    return availability;
                }
            } catch (NumberFormatException e) {
                System.out.println("Availability must be greater equal than 0");
                System.out.print("Enter again: ");
            }
        }
    }


    public static String checkInputOfString() {
        while(true){
            String input = in.nextLine().trim();
            if(input.isBlank()){
                return null;
            }
            if(!input.matches(standard)){
                System.out.println("Wrong input,Input must not contain digit");
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }
        }
    }

    public static int checkInputOfAvailability() {
        while(true){
            String input = in.nextLine().trim();
            if(input.isBlank()){
                return -1;
            }
            if(!input.matches(digit)){
                System.out.println("Wrong input");
                System.out.print("Please reinput: ");
            }
            else{
                return Integer.parseInt(input);
            }
        }
    }

}
