package project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
        private String customerName;
        private String password;
        private double checkingBalance =0;
        private double savingBalance=0;

        Scanner input =new Scanner(System.in);
        DecimalFormat money_Format= new DecimalFormat("'$'###,##0.00");

        public String setCustomerName(String customerName){
            this.customerName=customerName;
            return customerName;
        }

        public String getCustomerName(){
            return customerName;
        }

        public String setPassword(String password){
            this.password=password;
            return password;
        }

        public String getPassword(){
            return password;
        }

        public double getCheckingBalance(){
            return checkingBalance;
        }

        public double getSavingBalance(){
            return savingBalance;
        }

        public double WithdrawCheckingBalance(double amount){
            checkingBalance= checkingBalance -amount;
            return checkingBalance;

        }

        public double WithdrawSavingBalance(double amount){
            savingBalance =savingBalance - amount;
            return savingBalance;
        }

        public double DepositCheckingAccount (double amount){
            checkingBalance =checkingBalance+amount;
            return checkingBalance;
        }

        public double DepositSavingAccount (double amount){
        savingBalance =savingBalance+amount;
        return savingBalance;
        }

        public void getCheckingWithdrawInput(){
            System.out.println("checking account balance: "+money_Format.format(checkingBalance));
            System.out.println("Amount you want to withdraw from checking account ");
            double a =input.nextDouble();

            if (checkingBalance - a >=0){
                WithdrawCheckingBalance(a);
                System.out.println("New checking account balance "+checkingBalance+"\n");
            }else System.out.println("balance can't be negative"+"\n");
        }

        public void getSavingWithdrawInput(){
            System.out.println("saving account balance: "+money_Format.format(savingBalance));
            System.out.println("Amount you want to withdraw from saving account ");
            double amount =input.nextDouble();

            if (savingBalance -amount >=0){
                WithdrawSavingBalance(amount);
                System.out.println("new account balance: "+money_Format.format(savingBalance));
            }else System.out.println("amount can't be negative");
        }
        public void getCheckingDepositInput(){
            System.out.println("checking account balance: "+money_Format.format(checkingBalance));
            System.out.println("Amount you want to Deposit in checking account: ");
            double amount =input.nextDouble();
            if (checkingBalance+amount >=0){
                DepositCheckingAccount(amount);
                System.out.println("New account balance "+money_Format.format(checkingBalance));
            }else{
                System.out.println("balance can't be negative ");
            }
        }

        public void getSavingDepositInput(){
            System.out.println("New account balance "+money_Format.format(savingBalance));
            System.out.println("Amount you want to Deposit in saving account ");
            double amount =input.nextDouble();

            if (savingBalance+amount >=0){
                DepositSavingAccount(amount);
                System.out.println("New account balance: "+money_Format.format(savingBalance))
                ;
            }
            else System.out.println("balance can't be negative");
        }
}



