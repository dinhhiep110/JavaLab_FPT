import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        DoctorHash dhash = new DoctorHash();
        while(true)
        {
            DoctorHash.displayMenu();
            int choice = Validation.checkInput();
            switch(choice)
            {
                case 1:
                dhash.adding();
                break;
                case 2:
                dhash.updating();
                break;
                case 3:
                dhash.deleting();
                break;
                case 4:
                dhash.searchDoctor();
                case 5:
                return;
            }
            System.out.println("Press any key to continue");
            in.nextLine();
        }
    
    }
}
