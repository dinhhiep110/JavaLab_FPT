package P0074;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int choose;
        Matrix ma = new Matrix();
        int[][] matrix1;
        int[][] matrix2;
        while(true)
        {
            ma.displayMenu();
            choose = Validation.checkInput();
            switch(choose){
                case 1:
                    System.out.println("----------- Addition -----------");
                    matrix1 = ma.inputMaxtrix(1);
                    matrix2 = ma.inputMaxtrix(2);
                    ma.addMaxtrix(matrix1, matrix2);
                    break;
                case 2:
                    System.out.println("----------- Subtraction -----------");
                    matrix1 = ma.inputMaxtrix(1);
                    matrix2 = ma.inputMaxtrix(2);
                    ma.subMatrix(matrix1, matrix2);
                    break;
                case 3:
                    System.out.println("----------- Multiplication -----------");
                    matrix1 = ma.inputMaxtrix(1);
                    matrix2 = ma.inputMaxtrix(2);
                    ma.multiMatrix(matrix1, matrix2);
                    break;
                case 4:
                    return;
            }
            System.out.println("Press any key to continue");
            in.nextLine();
        } 
    }
}
