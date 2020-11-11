package app;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        ArrayList<Account> accounts = new ArrayList<Account>();
        Account activeAccount = new Account(0, 0, null);
        boolean exit = false;
        boolean inMainMenu;
        boolean inAccountMenu;

        while (!exit) {

            // main menu
            inMainMenu = true;
            while (inMainMenu) {
                System.out.print("create account (create), log in (log in), or exit (exit): ");
                String input = sc.nextLine().toLowerCase();
                switch (input) {
                    case "create":
                        System.out.print("initial deposit amount: ");
                        float deposit = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("password: ");
                        String password = sc.nextLine();
                        int createAccountNumber;
                        boolean match;
                        do {
                            createAccountNumber = random.nextInt(9000) + 1000;
                            match = false;
                            for (Account account : accounts) {
                                if (account.getAccountNumber() == createAccountNumber) {
                                    match = true;
                                }
                            }
                        } while (match);
                        System.out.println("your account number is " + createAccountNumber);
                        Account newAccount = new Account(deposit, createAccountNumber, password);
                        accounts.add(newAccount);
                        activeAccount = newAccount;
                        inMainMenu = false;
                        break;
                    case "log in":
                        System.out.print("account number: ");
                        int accountNumber = sc.nextInt();
                        sc.nextLine();
                        boolean foundAccount = false;
                        for (Account account : accounts) {
                            if (account.getAccountNumber() == accountNumber) {
                                foundAccount = true;
                                activeAccount = account;
                            }
                        }
                        if (foundAccount) {
                            System.out.print("password: ");
                            if (activeAccount.checkPassword(sc.nextLine())) {
                                inMainMenu = false;
                            } else {
                                System.out.println("password is not correct");
                            }
                        } else {
                            System.out.println("could not find account");
                        }
                        break;
                    case "exit":
                        System.out.println("goodbye");
                        inMainMenu = false;
                        exit = true;
                        break;
                    default:
                        System.out.println("not a valid command");
                        break;
                }
            }

            // account menu
            if (!exit) {
                inAccountMenu = true;
                while (inAccountMenu) {
                    System.out.print("check balance (check), deposit (deposit), withdraw (withdraw), transfer (transfer), change password (change password), log out (log out): ");
                    String input = sc.nextLine().toLowerCase();
                    switch (input) {
                        case "check":
                            System.out.println("$" + activeAccount.getBalance());
                            break;
                        case "deposit":
                            System.out.print("how much would you like to deposit: ");
                            activeAccount.deposit(sc.nextFloat());
                            sc.nextLine();
                            break;
                        case "withdraw":
                            System.out.print("how much would you like to withdraw: ");
                            activeAccount.withdraw(sc.nextFloat());
                            sc.nextLine();
                            break;
                        case "transfer":
                            System.out.print("account number of other account: ");
                            int targetAccountNumber = sc.nextInt();
                            sc.nextLine();
                            Account targetAccount = null;
                            for (Account account : accounts) {
                                if (account.getAccountNumber() == targetAccountNumber) {
                                    targetAccount = account;
                                }
                            }
                            if (targetAccount != null) {
                                System.out.print("transfer amount: ");
                                float transferAmount = sc.nextFloat();
                                sc.nextLine();
                                if (transferAmount > activeAccount.getBalance()) {
                                    System.out.println("insufficient funds");
                                } else {
                                    activeAccount.withdraw(transferAmount);
                                    targetAccount.deposit(transferAmount);
                                }
                            } else {
                                System.out.println("account not found");
                                System.out.println("transfer cancelled");
                            }
                            break;
                        case "change password":
                            System.out.print("enter old password: ");
                            if (activeAccount.checkPassword(sc.nextLine())) {
                                System.out.print("enter new password: ");
                                String newPassword = sc.nextLine();
                                System.out.print("confirm new password: ");
                                if (sc.nextLine().equals(newPassword)) {
                                    activeAccount.changePassword(newPassword);
                                    System.out.println("password successfully changed");
                                } else {
                                    System.out.println("passwords don't match");
                                    System.out.println("cancelling password change");
                                }
                            } else {
                                System.out.println("password is incorrect");
                                System.out.println("cancelling password change");
                            }
                            break;
                        case "log out":
                            System.out.println("logging out");
                            inAccountMenu = false;
                            break;
                        default:
                            System.out.println("not a valid command");
                            break;
                    }
                }
            }

        }
        sc.close();

    }

}
