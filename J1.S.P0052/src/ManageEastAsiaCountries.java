import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageEastAsiaCountries {
    public void displayMenu(){
        System.out.println("1. Enter the information for 11 countries in Southeast Asia");
        System.out.println("2. Display already information.");
        System.out.println("3. Search the country according to the entered country's name.");
        System.out.println("4. Display the information increasing with the country name.");
        System.out.println("5. Exit.");
        System.out.print("Enter your choice: ");
    }

    private static String normalize(String input){
        input = input.replaceAll("\\s+", " ");
        String[] temp= input.split(" ");
        String res = "";
        for(int i = 0;i < temp.length;i++){
            res += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if(i<temp.length-1) 
                res += " "; 
        }
        return res;
    }


    private static void input(ArrayList<EastAsiaCountries> list){
        System.out.println("Enter code of country:");
        String code = Validation.checkString();
        code = code.toUpperCase();
        System.out.println("Enter name of country:");
        String name = Validation.checkString();
        name = normalize(name);
        System.out.println("Enter total Area:");
        float totalArea = Validation.checkFloat();
        System.out.println("Enter terrain of country:");
        String terrain = Validation.checkString();
        if(isExisted(code,list)){
            System.out.println("your input is exsitted in list");
            System.out.println();
        }
        else{
            list.add(new EastAsiaCountries(code, name, totalArea, terrain));
        }
    }

    private static boolean isExisted(String code,ArrayList<EastAsiaCountries> list) {
        for(EastAsiaCountries countries : list){
            if(code.equalsIgnoreCase(countries.getCountryCode())){
                return true;
            }            
        }
        return false;
    }

    public void addCountryInformation(ArrayList<EastAsiaCountries> list){
        int count = 0;
        while(count < 2){
            System.out.println("Country " + (count + 1));
            input(list);
            count++;
        }
        System.out.println("Add successful");
    }

    public void getRecentlyEnteredInformation(ArrayList<EastAsiaCountries> list){
        System.out.printf("%-17s%-15s%-15s%-15s\n","ID","Name","Total Area","Terrain");
        for(EastAsiaCountries countries : list){
            countries.display();
        }
        
    }

    public ArrayList<EastAsiaCountries> searchInformationByName(ArrayList<EastAsiaCountries> list){
        ArrayList<EastAsiaCountries> countriesList = new ArrayList<>();
        System.out.println("Enter the name you want to search for:");
        String name = Validation.checkString();
        name = normalize(name);
        String temp[] = name.split(" ");
        for(EastAsiaCountries countries : list){
            for(int i = 0;i < temp.length;i++){
                if(countries.getCountryName().contains(temp[i]) && !isExisted(countries.countryCode, countriesList) ){
                    countriesList.add(countries);
                }
            }
        }
        return countriesList;
    }

    public void displayListCountryByName(ArrayList<EastAsiaCountries> list){
        ArrayList<EastAsiaCountries> countries = searchInformationByName(list);
        if(countries == null){
            System.out.println("The name doesn't exsit");
            return;
        }
        getRecentlyEnteredInformation(countries);
    }

    public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder(ArrayList<EastAsiaCountries> list){
        Collections.sort(list, new Comparator<EastAsiaCountries>(){

            @Override
            public int compare(EastAsiaCountries c1, EastAsiaCountries c2) {

                return c1.getCountryName().compareTo(c2.getCountryName());
            }
            
        });
        
        return list;
    }



    

}
