import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validation {

    private static Scanner in = new Scanner(System.in);
    private static final String str = "^[A-Z a-z]+$";
    private static final String plan = "^[0-9.]+[5|0]+$";

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

    public static String checkString() {
        while(true){
            String input = in.nextLine().trim();
            if(input.isEmpty() || !input.matches(str)){
                System.out.println("Wrong Input");
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }
        }
    }

    public static int checkInteger() {
        while(true){
            try {
                int number = Integer.parseInt(in.nextLine());
                if(number < 0){
                    throw new NumberFormatException();
                }
                else{
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Number must be greater equal than 0");
                System.out.print("Enter again: ");
            }
        }
    }

    public static Date checkInputDate() {
        while (true) {
            try {
                String input = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(input);
                Date now = new Date();
                if (date.after(now) || input.equalsIgnoreCase(format.format(now))) {
                    return date;
                } else {
                    System.out.println("Date must be today or after");
                    System.out.print("Enter again: ");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Re-input in format dd-MM-yyyy");
            } catch (ParseException ex) {
                System.out.println("Re-input in format dd-MM-yyyy");
            }
        }
    }

    public static double checkPlan(){
        while(true){
           try {
            double input = Double.parseDouble(in.nextLine().trim());
            if(input < 8 || input > 17.5 || !Double.toString(input).matches(plan)){
                throw new Exception();
            }
            else{
                return input;
            }
           } catch (Exception e) {
               System.out.println("Plan time must be in range[8,17.5] ");
               System.out.println("Plan time must be in h.0 or h.5 ");
               System.out.print("Enter again: ");
           }
            
        }
    }
}
