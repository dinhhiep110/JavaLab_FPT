package P0011;

import java.math.BigInteger;

public class ChangeBase {
    private BigInteger dec;
    private static String hexDigits = "0123456789ABCDEF";

    
    public void convertFromBinary(String binary,int outputBase){
        switch(outputBase){
            case 1:
            displayResult(binary);
            break;
            case 2:
            BigInteger decimal = convertBinaryToDecimal(binary);
            displayResult(decimal.toString());
            break;
            case 3:
            decimal = convertBinaryToDecimal(binary);
            String hexa = convertDecimalToBase(decimal, 16);
            displayResult(hexa);
            break;
        }
    }

    public void convertFromHexa(String hexa,int outputBase){
        switch(outputBase){
            case 1:
            BigInteger decimal = convertHexaToDecimal(hexa);
            String binary = convertDecimalToBase(decimal, 2);
            displayResult(binary);
            break;
            case 2:
            decimal = convertHexaToDecimal(hexa);
            displayResult(decimal.toString());
            break;
            case 3:
            displayResult(hexa);
            break;
        }
    }

    public void convertFromDecimal(BigInteger decimal,int outputBase){
        switch(outputBase){
            case 1:
            displayResult(convertDecimalToBase(decimal, 2));
            break;
            case 2:
            displayResult(decimal.toString());
            break;
            case 3:
            displayResult(convertDecimalToBase(decimal, 16));
            break;
        }
    }


    private BigInteger convertBinaryToDecimal(String binary){
        dec = BigInteger.valueOf(0);
        int count = binary.length() - 1;
        for (int i = 0; i < binary.length(); i++) {
            String s = Character.toString(binary.charAt(count));
            BigInteger digits = new BigInteger(s);
            BigInteger temp = BigInteger.valueOf(2).pow(i).multiply(digits);
            dec = dec.add(temp);
            count--;
        }
        return dec;
    }


    private BigInteger convertHexaToDecimal(String hexa){
        dec = BigInteger.valueOf(0);
        int count = hexa.length() - 1;
        for (int i = 0; i < hexa.length(); i++) {
            char c = hexa.charAt(count);
            BigInteger digits = BigInteger.valueOf(hexDigits.indexOf(c));
            BigInteger temp = BigInteger.valueOf(16).pow(i).multiply(digits);
            dec = dec.add(temp);
            count--;
        }
        return dec;
    }

    // private BigInteger convertBaseToDecimal(String input,int base){
    //     dec = BigInteger.valueOf(0);
    //     int count = input.length() - 1;
    //     for (int i = 0; i < input.length(); i++) {
    //         if(base == 16){
    //             char c = input.charAt(count);
    //             int digits = hexDigits.indexOf(c);
    //             dec = dec.add(BigInteger.valueOf(digits * (int) Math.pow(base, i)));
    //         }
    //         else{
    //             int temp = Integer.parseInt(Character.toString(input.charAt(count))) * (int) Math.pow(base,i);
    //             dec = dec.add(BigInteger.valueOf(temp));
    //         }
    //         count--;
    //     }
    //     return dec;
    // }


    private void displayResult(String result){
        System.out.println("Result is: " + result);
    }

    private String convertDecimalToBase(BigInteger input,int Base){
        if(input.equals(BigInteger.valueOf(0))){
            return "0";
        }
        StringBuilder storeDigits = new StringBuilder();
        dec = input;
        while (dec.compareTo(BigInteger.ZERO) == 1) {
            String temp = dec.remainder(BigInteger.valueOf(Base)).toString();
            if(Base == 16){
                storeDigits.append(hexDigits.charAt(Integer.parseInt(temp)));
            }
            else{
                storeDigits.append(temp);
            }
            dec = dec.divide(BigInteger.valueOf(Base));
        }
        return storeDigits.reverse().toString();
    }

}
