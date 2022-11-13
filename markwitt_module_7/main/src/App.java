

import java.io.IOException;
import java.util.Scanner;

import files.compare;


public class App {

    static Scanner input = new Scanner(System.in);
    static String passwordRequirements = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$"; 
    static String passwordLimits;
    public static void main(String[] args) throws Exception {
        passwordRules();
        
    }

   
    public static void passwordRules() throws IOException{
        System.out.println("\nPlease choose a password with the following requirements: ");
        System.out.println("1. Requires at least one uppercase letter");
        System.out.println("2. Requires at least one lowercase letter");
        System.out.println("3. Requires at least one number");
        System.out.println("4. Requires at least one special character (!@#$%^&*)");
        System.out.println("5. Password be at least 8 characters.");
        System.out.println("6. Passowrd cannot be/contain the top 20 common passwords");
    
        checkPassword(passwordRequirements);
    }  
        
    public static void checkPassword(String PasswordRequirements) throws IOException{
        System.out.print("\n\nEnter Password: ");       
        String password = input.nextLine();
        System.out.println();
        if(password.equals("editpasswordlist")){
            compare.secretMenu();
        }
        else{        
        boolean containsCommon = compare.commonPasswords(password);
        
        boolean valid = compare.isvalid(password, passwordRequirements);
        passwordResults(valid, containsCommon, password);
    }}

    public static void passwordResults(boolean valid, boolean containsCommon, String password){
        if (valid == true && containsCommon == false){
            
            System.out.println(password + " is a valid password.");
            }           
        else {
            System.out.println(password + " is not a valid password");
            }
        
        if(containsCommon == true){
            System.out.println(password + " is one of the most common passwords.");
        }

    }
}
