package P0011;

import java.math.BigInteger;
import java.util.Scanner;

public class Validation {
    private static Scanner in = new Scanner(System.in);

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
                System.out.println("Input must be inrage[1,3]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String inputYN(){
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

    public static BigInteger inputDecimal(){
        String result = "";
        while(true){
            String input = in.nextLine().trim();
            BigInteger temp = new BigInteger(input);
            if(!input.matches("^[-0-9]+$")){
                System.out.println("Wrong input");
                System.out.print("Enter again: ");
            }
            else if(temp.compareTo(BigInteger.ZERO) == -1){
                System.out.println("Decimal must be positive");
                System.out.print("Enter again: ");
            }
            else{
                result = input;
                break;
            }
        }
        BigInteger bigInteger = new BigInteger(result);
        return bigInteger;
    }
    

    public static String inputBinary() {
        while(true){
            String input = in.nextLine().trim();
            if(!input.matches("^[0-1]+$")){
                System.out.println("Binary must be 0 and 1");
            }
            else{
                return input;
            }   
        }
    }
    
    
    public static String inputHexaDecimal() {
        while(true){
            String input = in.nextLine().trim();
            if(!input.matches("^[0-9A-Fa-f]+$")){
                System.out.println("Wrong input hexadecimal");
                System.out.print("Please reinput: ");
            }
            else{
                return input;
            }   
        }
    }
}
