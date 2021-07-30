package P0057;

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ManageUser mu = new ManageUser();
        int choose;
        while(true){
            mu.displayMenu();
            choose = Validation.checkInput();
            switch(choose){
                case 1:
                    mu.createNewAccount();
                    break;
                case 2:
                    mu.loginSystem();
                    break;
                case 3:
                    return;
            }
            System.out.println("Press any key to continue");
            in.nextLine();
        }
    }
}
