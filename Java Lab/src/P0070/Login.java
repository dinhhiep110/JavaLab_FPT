package P0070;

import java.util.ArrayList;

public class Login {
    private View view;
    private Ebank ebank;
    private ArrayList<User> list;

    public Login(){
        view = new View();
        ebank = new Ebank();
        list = new ArrayList<>();
        list.add(new User("0123456789", "123456ab"));
    }

    private boolean checkUser(){
        View view = new View();
        String accountNumber = view.inputAccount();
        String password = view.inputPassword();
        for (User user : list) {
            if (accountNumber.equals(user.getAccountNumber()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void checklogin(){    
        boolean checkUser = checkUser();
        boolean captcha = view.getCaptcha();
        if(checkUser == true && captcha == true){
            ebank.getWordOfLanguage("loginSuccess");
            System.out.println();
        }
        else{
            ebank.getWordOfLanguage("loginUnSuccess");
            System.out.println();
        }

    }
}
