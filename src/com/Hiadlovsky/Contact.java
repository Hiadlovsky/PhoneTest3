package com.Hiadlovsky;

public class Contact {

    private String name;
    private String number;


    public Contact() {
        this.name = null;
        this.number = null;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }


    public int setName(String name) {
        if((name.length()>2)&&(name.length()<=32)) {
            this.name = name;
            return 1;
        }
        else {
            return -1;
        }
    }

    public int setNumber(String number) {

        if((number == null)||(number.length()<8)||(number.length()>13))
            return -1;

        String digits;
        if(number.charAt(0) == '+')
        {
            if(number.length() <11) {
                return -1;
            }
            digits = number.substring(1, number.length()-1);
        }
        else
        {
            digits = number;
        }
        try {
            double tmp = Double.parseDouble(digits);
        }
        catch(NumberFormatException nfe)
        {
            return -1;
        }

        this.number = number;
        return 1;
    }
}
