package com.Hiadlovsky;

import java.util.ArrayList;

public class MobilePhone {

    private String mobileName;
    private String number;
    private ArrayList<Contact> myContacts;


    public MobilePhone(String mobileName, String number) {
        this.mobileName = mobileName;
        this.number = number;
        this.myContacts = new ArrayList<Contact>();
    }


    public boolean checkContact(String name) {

        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Contact searchContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact searchContact = myContacts.get(i);
            if (searchContact.getName().equals(name)) {
                return searchContact;
            }
        }
        return null;
    }


    public boolean addContact(String name, String number) {
        Contact newContact = new Contact();
        if((newContact.setName(name) < 0)||(newContact.setNumber(number) < 0))
        {
            System.out.println("Name or Number in wrong format, please try again.");
            return false;
        }

        if (checkContact(name)) {
            System.out.println("Contact already exists.");
            return false;
        }
        this.myContacts.add(newContact);
        System.out.println("Contact " + name + " : " + number + " added.");
        return true;
    }

    public boolean modifyContactName(String name, String newName) {

        Contact searchedContact = searchContact(name);
        if (searchedContact == null) {
            System.out.println("Contact doest't exists.");
            return false;
        } else {
            if(searchedContact.setName(newName) < 0) {
                System.out.println("Name must be max 32 characters long");
                return false;
            }
            else {
                return true;
            }
        }

    }

    public boolean modifyContactNumber(String name, String newNumber) {

        if (searchContact(name) == null) {
            System.out.println("Contact doest't exists.");
            return false;
        } else {
            Contact searchedContact = searchContact(name);
            if(searchedContact.setNumber(newNumber) < 0)
            {
                System.out.println("Number in wrong format, please try again.");
                return false;
            }
            return true;
        }

    }

    public void removeContact(String name) {
        Contact searchedContact = searchContact(name);
        if(searchedContact == null){
            System.out.println("Contact doesn't exist.");
        }else {
            this.myContacts.remove(searchedContact);
        }

    }

    public void printer (){
        if (this.myContacts.isEmpty()){
            System.out.println("Contact list is empty.");
        }
        for (int i =0; i<this.myContacts.size(); i++ ){
            System.out.println((i+1)+". Name: "+this.myContacts.get(i).getName()+" Number:"+ this.myContacts.get(i).getNumber());
        }
    }

}
