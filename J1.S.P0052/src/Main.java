import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        ArrayList<EastAsiaCountries> list = new ArrayList<>();
        int choose;
        while(true)
        {
            manager.displayMenu();
            choose = Validation.checkInput();
            switch(choose){
                case 1:
                    manager.addCountryInformation(list);
                    break;
                case 2:
                    manager.getRecentlyEnteredInformation(list);
                    break;
                case 3:
                    manager.displayListCountryByName(list);
                    break;
                case 4:
                    ArrayList<EastAsiaCountries> ls = manager.sortInformationByAscendingOrder(list);
                    System.out.println("List after sort increasing with the country name:");
                    manager.getRecentlyEnteredInformation(ls);
                    break;
                case 5:
                    return;
            }
            
            System.out.println("Press any key to continue");
            in.nextLine();
        } 
        
    }
}
