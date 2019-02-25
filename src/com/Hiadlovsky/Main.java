package com.Hiadlovsky;

import java.util.Scanner;

public class Main {

    public static MobilePhone myPhone = new MobilePhone("Samsung", "0949447445");
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Booting...\n" +
                "Welcome\n" +
                "Samsung ");
        printMenu();
        boolean quit = false;
        while (!quit) {


            System.out.println("Your choice?\n" +
                    " 1 - FOR MENU.");
            while (!intCheck()){
                intCheck();
            }

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    scanner.close();
                    System.out.println("Shutting down.");
                    break;
                case 1:
                    printMenu();
                    break;
                case 2:
                    myPhone.printer();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    modify();
                    break;
                case 5:
                    remove();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("wrong choice \n please select from menu.");
                    break;


            }
        }


    }


    public static void printMenu() {
        System.out.println("Press for action :\n" +
                "0 - to quit\n" +
                "1 - to print menu\n" +
                "2 - to print contacts\n" +
                "3 - to add contact\n" +
                "4 - to modify contact\n" +
                "5 - to delete contact ");
    }


    public static boolean addContact() {
        System.out.println("Enter contact name :\n ");
        String name = scanner.nextLine();
        if (myPhone.checkContact(name)) {
            System.out.println("Can't add, already exists.");
            return false;
        }
        System.out.println("Enter number:\n");
        String number = scanner.nextLine();
        myPhone.addContact(name, number);
        return true;

    }

    public static boolean modify() {
        System.out.println("What you want to modify ?\n" +
                "1 - name\n" +
                "2 - number");
        while (!intCheck()){
            intCheck();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter name to modify\n");
                String searchName = scanner.nextLine();
                if (!myPhone.checkContact(searchName)) {
                    System.out.println("There is no contact with name" + searchName);
                    return false;
                }
                System.out.println("Enter new name\n");
                String newName = scanner.nextLine();
                myPhone.modifyContactName(searchName, newName);
                System.out.println("Contact name successful modified.");
                break;
            case 2:
                System.out.println("Enter name to modify\n");
                String name = scanner.nextLine();
                if (!myPhone.checkContact(name)) {
                    System.out.println("There is no contact with name" + name);
                    return false;
                }
                System.out.println("Enter new number\n");
                String newNumber = scanner.nextLine();
                myPhone.modifyContactNumber(name, newNumber);
                System.out.println("Contact number successful modified.");
                break;
        }
        return true;
    }


    public static void remove() {
        System.out.println("Enter name to remove");
        String name = scanner.nextLine();
        myPhone.removeContact(name);
    }

    public static boolean intCheck() {
        boolean isNUmber = scanner.hasNextInt();
        if (isNUmber) {
            return true;
        } else
            System.out.println("Wrong input\n try again. ");
        scanner.nextLine();
        return false;
    }




}
