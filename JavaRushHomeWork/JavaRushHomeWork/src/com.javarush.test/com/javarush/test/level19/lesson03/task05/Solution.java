package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {

    //test

    public static void main(String[] args) {
      Customer customer=new Customer() {
          @Override
          public String getCompanyName() {
              return "JavaRush Ltd.";
          }

          @Override
          public String getCountryName() {
              return "Ukraine";
          }
      };

        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };

        DataAdapter dataAdapter = new DataAdapter(customer, contact);
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getDialString());
    }

    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem{
        Customer customer;
        Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer=customer;
            this.contact=contact;
        }

        @Override
        public String getCountryCode() {

            String country="";
            for (Map.Entry<String, String> entry: countries.entrySet()) {
                if (customer.getCountryName().equals(entry.getValue()))
                {
                    country=entry.getKey();
                }
            }
            return country;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String firstName=contact.getName().substring(contact.getName().indexOf(" ")+1);
            return firstName;
        }

        @Override
        public String getContactLastName() {
            String lastName=contact.getName().substring(0, contact.getName().indexOf(","));
            return lastName;
        }

        @Override
        public String getDialString() {
            String dialStringTemp=contact.getPhoneNumber();
            return "callto://"+dialStringTemp.replaceAll("[()-]","");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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