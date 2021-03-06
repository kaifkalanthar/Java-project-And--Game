package project;

import javax.swing.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OptionMenu extends Account{
    DecimalFormat Money_Format = new DecimalFormat("'$'###,##0.00");

    Scanner menu_Input =new Scanner(System.in);

    HashMap <Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException{
        int x=1;
        do{
            try {
                data.put(656747,556788);
                data.put(663234,787698);
                data.put(555556,783568);
                

                System.out.println("Enter Customer Name : ");
                setCustomerName(menu_Input.nextInt());

                System.out.println("Enter a password : ");
                setPassword(menu_Input.nextInt());

            }catch (Exception e){
                System.out.println("Invalid customer id or password ");
                x=2;
            }
           int  cn = getCustomerName();
            int  pn = getPassword();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            }else
                System.out.println("Invaild name or password");
           
        }while (x == 1);
    }
    public void getAccountType(){
        System.out.println("Select the account you want to access ");
        System.out.println("1.checking account ");
        System.out.println("2.saving account ");
        System.out.println("3.Exit ");
        System.out.println("choice ");
        selection =menu_Input.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thanks for your coming ");
                break;
            default:
                System.out.println("Invalid choice");
                getAccountType();
        }
    }
    public void getChecking(){
        System.out.println("Checking account : ");
        System.out.println("1.View balance ");
        System.out.println("2.withdraw amount ");
        System.out.println("3.Deposit amount ");
        System.out.println("4.Exit");

        System.out.println("choice ");
        selection =menu_Input.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking current balance: "+ Money_Format.format(getCheckingBalance()));
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thanks you! for your coming ");
                break;
            default:
                System.out.println("\n"+"Invalid"+"\n");
                getAccountType();

        }
    }
    public void getSaving(){
        System.out.println("Saving account : ");
        System.out.println("1.View balance ");
        System.out.println("2.withdraw amount ");
        System.out.println("3.Deposit amount ");
        System.out.println("4.Exit");

        System.out.println("Enter choice ");
        selection=menu_Input.nextInt();
        switch (selection){
            case 1:
                System.out.println("Current saving balance: "+Money_Format.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:

                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:

                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you !,for your coming ");
                break;
            default:
                System.out.println("invalid number entered");
                getSaving();

        }
    }

    int selection;
}
