package P0011;

import java.math.BigInteger;

public class UserView {

    public int inputBase(){
        System.out.print("Enter Base Of Input(1 Binary,2 Decimal,3 Hexadecimal): ");
        int choose = Validation.checkInput();
        int BaseInput = 0;
        switch(choose){
            case 1:
            BaseInput = 1;
            break;
            case 2:
            BaseInput = 2;
            break;
            case 3:
            BaseInput = 3;
            break;
        }
        return BaseInput;
    }

    public int outputBase(){
        System.out.print("Enter Base Of Output(1 Binary,2 Decimal,3 Hexadecimal): ");
        int choose = Validation.checkInput();
        int BaseOutput = 0;
        switch(choose){
            case 1:
            BaseOutput = 1;
            break;
            case 2:
            BaseOutput = 2;
            break;
            case 3:
            BaseOutput = 3;
            break;
        }
        return BaseOutput;
    }

    public String inputBinary(){
        System.out.print("Input your Binary: ");
        String binary = Validation.inputBinary();
        return binary;
    }

    public BigInteger inputDecimal(){
        System.out.print("Input your Decimal: ");
        BigInteger decimal= Validation.inputDecimal();
        return decimal;
    }

    public String inputHexadecimal(){
        System.out.print("Input your Hexadecimal: ");
        String hexa = Validation.inputHexaDecimal();
        return hexa;
    }
    

    public void displayMeunu(){
        int BaseInput,BaseOutput;
        ChangeBase changeBase =  new ChangeBase();
        while(true){
            BaseInput = inputBase();
            BaseOutput = outputBase();
            switch(BaseInput){
                case 1:
                String binary = inputBinary();
                changeBase.convertFromBinary(binary, BaseOutput);
                break;
                case 2:
                BigInteger decimal = inputDecimal();
                changeBase.convertFromDecimal(decimal, BaseOutput);
                break;
                case 3:
                String hexa = inputHexadecimal();
                changeBase.convertFromHexa(hexa, BaseOutput);
                break;
            }

            System.out.print("Do you want to continue(Y or N): ");
            String choice = Validation.inputYN();
            if(choice.equalsIgnoreCase("n")){
                return;
            }
            System.out.println();
        }
    }
}
