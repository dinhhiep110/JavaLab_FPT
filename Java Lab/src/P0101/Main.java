package P0101;
    
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Manager m = new Manager();
        int choose;
        while(true){
            m.displayMenu();
            choose = Validation.checkInput();
            switch(choose){
                case 1:
                    m.addEmployee();
                    break;
                case 2:
                    m.updateEmployee();
                    break;
                case 3:
                    m.removeEmployee();
                    break;
                case 4:
                    m.searchEmployees();
                    break;
                case 5:
                    m.sortEmployee();
                    break;
                case 6:
                    return;
            }
            System.out.println("Press any key to continue");
            in.nextLine();
        }
    }
}

