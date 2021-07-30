import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        ManageTask mt = new ManageTask();
        int choose;
        while(true)
        {
            mt.displayMenu();
            choose = Validation.checkInput();
            switch(choose){
                case 1:
                    mt.addTask();
                    break;
                case 2:
                    mt.deleteTask();
                    break;
                case 3:
                    mt.displayTask();
                    break;
                case 4:
                    return;
            }
            
            System.out.println("Press any key to continue");
            in.nextLine();
        } 

    }

    
}
