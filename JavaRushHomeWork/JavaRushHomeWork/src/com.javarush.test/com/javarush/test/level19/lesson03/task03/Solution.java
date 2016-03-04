package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static class IncomeDataAdapter implements Customer, Contact{

        IncomeData incomeData;

        IncomeDataAdapter (IncomeData incomeData){this.incomeData=incomeData;}

        @Override
        public String getCompanyName() {
            return this.incomeData.getCompany();
        }

        @Override
        public String getCountryName() {return countries.get(this.incomeData.getCountryCode());}

        @Override
        public String getName() {return this.incomeData.getContactLastName()+", "+this.incomeData.getContactFirstName();}

        @Override
        public String getPhoneNumber() {
            int phoneNumber =this.incomeData.getPhoneNumber();
            String phoneNumberString=Integer.toString(phoneNumber);

            while (phoneNumberString.length()<10)
            {
                phoneNumberString="0"+phoneNumberString;
            }
            return "+"+this.incomeData.getCountryPhoneCode()+"("+phoneNumberString.substring(0,3)+")"+phoneNumberString.substring(3,6)+"-"+phoneNumberString.substring(6,8)+"-"+phoneNumberString.substring(8);}
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

}