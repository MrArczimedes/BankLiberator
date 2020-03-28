package pl.Bank;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank Liberator = new Bank();
        Account account = Liberator;
        OperationTransfer operationTransfer = Liberator;
        Scanner choiceScanner = new Scanner(System.in);
        System.out.println("Wybierz co chcesz zrobic:" + "\n"+
        "1 - Utworz konto \n" +
        "2 - Transfer środków \n");
        while(!choiceScanner.hasNext("exit")) {
            int choice = choiceScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Podaj imie i nazwisko");
                    String name = scannerS();
                    System.out.println("Podaj pesel");
                    String pesel = scannerS();
                    account.makeAccount(name, pesel);
                    break;
                case 2:
                    String nameFrom = scannerS();
                    String nameTo = scannerS();
                    double value =scannerD();
                    operationTransfer.transfer(nameFrom,nameTo,value);
                    break;
                default:
                    System.out.println("Wpisz od jeden do dwa.");
            }
        }
    }
    public static String scannerS()
    {
        Scanner stringScanner = new Scanner(System.in);
        return stringScanner.nextLine();
    }
    public static double scannerD()
    {
        Scanner doubleScanner = new Scanner(System.in);
        return doubleScanner.nextDouble();
    }
}
