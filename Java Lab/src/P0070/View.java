package P0070;

import java.util.Scanner;

public class View {
    private Ebank ebank;
    private static Scanner in = new Scanner(System.in);

    public View(){
        ebank = new Ebank();
    }

    public int displayChooseOfMenu(){
        System.out.println("================= Login System =================");
        System.out.println("1.Vietnamese");
        System.out.println("2.English");
        System.out.println("3.Exit");
        System.out.print("Enter your choice: ");
        int choose = checkInput();
        return choose;
    }

    private int checkInput(){
        while(true){
            try {
                int input = Integer.parseInt(in.nextLine().trim());
                if(input < 1 || input > 3){
                    throw new NumberFormatException();
                }
                else{
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be inrage[1,3]");
                System.out.print("Enter again: ");
            }
        }
    }
    

    public String inputAccount(){
        while(true){
            ebank.getWordOfLanguage("enterAccountNumber");
            String accountNumber = in.nextLine().trim();
            String notification = ebank.checkAccountNumber(accountNumber);
            if(notification == null){
                continue;
            }
            else if(notification.equals(ebank.getNotification("accountNumberValid"))){
                System.out.println(notification);
                return accountNumber;
            }
        }
    }

    public String inputPassword(){
        while (true) {
            ebank.getWordOfLanguage("enterPassword");
            String password = in.nextLine().trim();
            String notification = ebank.checkPassWord(password);
            if(notification == null){
                continue;
            }
            else if(notification.equals(ebank.getNotification("passwordValid"))){
                System.out.println(notification);
                return password;
            }
        }
    }

    // public boolean getCaptcha(){
    //     String captcha = null;
    //     while(captcha == null){
    //         System.out.println();
    //         ebank.getWordOfLanguage("captcha");
    //         String captchaGenerate = ebank.generateCaptcha();
    //         System.out.println(captchaGenerate);
    //         ebank.getWordOfLanguage("enterCaptcha");
    //         String captchaInput = in.nextLine().trim();
    //         captcha = ebank.checkCaptcha(captchaGenerate,captchaInput);
    //         if(captcha != null){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public boolean getCaptcha(){
        while(true){
            System.out.println();
            ebank.getWordOfLanguage("captcha");
            String captchaGenerate = ebank.generateCaptcha();
            System.out.println(captchaGenerate);
            ebank.getWordOfLanguage("enterCaptcha");
            String captchaInput = in.nextLine().trim();
            String notification = ebank.checkCaptcha(captchaGenerate, captchaInput);
            System.out.println(notification);
            System.out.println();
            if(notification.equals(ebank.getNotification("CaptchaValid"))){
                return true;
            }
        }
    }
}
