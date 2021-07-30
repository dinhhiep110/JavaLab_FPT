package P0070;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class Ebank {
    private ResourceBundle rb;
    private Locale locate;
    private static ResourceBundle res;

    public Ebank(){
    }

    public void setLocate(Locale locate){
        this.locate = locate;
    }

    

    public void changeLanguage(int choice){
        if(choice == 1){
            locate = new Locale("vi");
        }
        else if(choice == 2){
            locate = new Locale("en");
        }
        setLocate(locate);
        this.rb = ResourceBundle.getBundle("P0070.Language." + locate, locate);
        res = rb;
    }

    public void getWordOfLanguage(String key){
        String value = res.getString(key);
        System.out.print(value);
    }

    public String getNotification(String key){
        String value = res.getString(key);
        return value;
    }

    public String checkAccountNumber (String accountNumber){
        if(accountNumber.isEmpty()){
            getWordOfLanguage("accountNumberInValid");
            System.out.println();
            getWordOfLanguage("errCheckString");
            System.out.println();
        }
        else{
            Pattern p = Pattern.compile("^[0-9]{10}$");
            if(!p.matcher(accountNumber).find()){
                getWordOfLanguage("accountNumberInValid");
                System.out.println();
                getWordOfLanguage("errCheckAccount");
                System.out.println();
            }
            else{
                return getNotification("accountNumberValid");
            }
        }
        return null;
    }

    public String checkPassWord(String password){
        if(password.isEmpty()){
            getWordOfLanguage("passwordInValid");
            System.out.println();
            getWordOfLanguage("errCheckString");
            System.out.println();
        }
        else{
            Pattern p = Pattern.compile("^[0-9A-Za-z]{8,31}$");
            Pattern digit = Pattern.compile("^[0-9A-Za-z]*[0-9]+[0-9A-Za-z]*");
            Pattern letter = Pattern.compile("^[0-9A-Za-z]*[A-Za-z]+[0-9A-Za-z]*");
            if(!(p.matcher(password).find() && digit.matcher(password).find()
            && letter.matcher(password).find())){
                getWordOfLanguage("passwordInValid");
                System.out.println();
                getWordOfLanguage("errCheckPassword");
                System.out.println();
            }
            else{
                return getNotification("passwordValid");
            }
        }
        return null;
    }

    public String generateCaptcha(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
        Random r = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = r.nextInt(AlphaNumericString.length());
            str.append(AlphaNumericString.charAt(index));
        }
        return str.toString();
    }

    public String checkCaptcha(String captchaGenerate,String captchaInput){
        if(captchaGenerate.length() != captchaInput.length()){
            return getNotification("errCaptchaIncorrect");
        }
        else{
            for(int i = 0;i < captchaGenerate.length();i++){
                if(!captchaGenerate.contains(Character.toString(captchaInput.charAt(i)))){
                    return getNotification("errCaptchaIncorrect");
                }
            }
        }
        
        return getNotification("CaptchaValid");
    }
}
