package pl.Bank;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bank implements Account, OperationTransfer{
    protected ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    protected double bankBalanace = 0;
    @Override
    public void makeAccount(String name, String pesel) {
        accounts.add(new BankAccount(name, pesel));
    }
    @Override
    public void withdraw(String name, double value) {
        for (BankAccount e : accounts) {
            if (e.userName == name) {
                e.balance =- (value + 1);
                bankBalanace =+ 1;
            }
        }
    }
    @Override
    public void deposit(String name, double value) {
        for (BankAccount e : accounts) {
            if (e.userName == name) {
                e.balance = +value;
            }
        }
    }


    @Override
    public void transfer(String nameTo, String nameFrom, double value) {
        withdraw(nameFrom, value);
        deposit(nameTo, value);
    }
}


