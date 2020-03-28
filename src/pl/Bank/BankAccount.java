package pl.Bank;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccount extends Bank {

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", userName='" + userName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", balance=" + balance +
                '}';
    }

    protected ArrayList<Integer> accountNumber = new ArrayList<Integer>(28);
    protected String userName;
    protected String pesel;
    protected double balance;

    public BankAccount(String userName, String pesel) {
        pesel = veryfication(pesel);
        this.userName = userName;
        this.pesel = pesel;
        generateAccountNumber();
        System.out.println(toString());
    }

    private void generateAccountNumber() {
        for (int i = 0; i < 28; i++) {
            this.accountNumber.add((int) (Math.random() * 9));
        }
        checkingAccountNumber();
    }

    private void checkingAccountNumber() {
        for (int i = 0; i < accounts.size(); i++) {
            if (this.accountNumber == accounts.get(i).accountNumber) {
                generateAccountNumber();
            }
        }
    }

    protected String veryfication(String pesel) {
        boolean length = false;
        boolean isNumber = false;
        while (length == false || isNumber == false) {
            for(int i = 0; i < pesel.length(); i++){
                if(!(pesel.length()==11))
                {
                    System.out.println("Pesel powinien zawierać 11 cyfr.");
                    pesel = inputS();
                }
                else{length = true;}
                char a = pesel.charAt(i);
                String s = String.valueOf(a);
                isNumber = Pattern.compile("[0-9]").matcher(s).matches();
                if(isNumber == false){
                    System.out.println("Pesel nie sklada sie z liter. Prosze podać jeszcze raz ");
                    pesel = inputS();
                    break;
                }

            }
        }
        return pesel;
    }

    private String inputS() {
        Scanner inputS = new Scanner(System.in);
        return inputS.nextLine();
    }


}


