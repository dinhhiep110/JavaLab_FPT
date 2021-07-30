package P0070;

// import java.util.Locale;
import java.util.Scanner;

public class Main {
     
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // Locale language;
        View view = new View();
        Ebank ebank = new Ebank();
        Login login = new Login();
        while(true){
            int choose = view.displayChooseOfMenu();
            switch(choose){
                case 1:
                    // language = new Locale("vi");
                    // ebank.setLocate(language);
                    ebank.changeLanguage(choose);
                    login.checklogin();
                    break;
                case 2:
                    // language = new Locale("en");
                    // ebank.setLocate(language);
                    ebank.changeLanguage(choose);
                    login.checklogin();
                    break;
                case 3:
                    return;
            }
            System.out.println("Press any key to continue");
            in.nextLine();
        }   
    }
}


