package pl.Bank;

import java.util.ArrayList;

interface Account {
    void makeAccount(String name, String pesel);
    void withdraw (String name, double value);
    void deposit(String name, double value);
}
