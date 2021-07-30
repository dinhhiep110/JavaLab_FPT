package P0059;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        List<Person> list = new ArrayList<>();
        ManagePerson mp = new ManagePerson();
        int choose;
        while(true){
            mp.displayMenu();
            choose = Validation.checkInput();
            switch(choose){
                case 1:
                    mp.findPersonInfo(list);
                    break;
                case 2:
                    mp.copyNewFile();
                    break;
                case 3:
                    return;
            }
            System.out.println("Press any key to continue");
            in.nextLine();
        }
    }
}
