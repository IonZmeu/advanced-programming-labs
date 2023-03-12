package com.ionn;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Person> personList = new ArrayList<>();
    private List<Company> companyList = new ArrayList<>();

    public int getImportance(Person person){
        return person.getConnections();
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }


    public void print() {
        String[] nameArr = new String[99];
        Integer[] integerArr = new Integer[99];
        String[] relArr = new String[99];
        int m = 0;
        for(Person x : personList){
            nameArr[m] = x.getName();
            integerArr[m] = x.getConnections();
            relArr[m] = x.getRelationships().toString();
            m++;
        }
        for(Company x : companyList){
            nameArr[m] = x.getName();
            integerArr[m] = x.getConnections();
            relArr[m] = x.getRelationships().toString();
            m++;
        }

        int n = m;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (integerArr[j] < integerArr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = integerArr[j];
                    integerArr[j] = integerArr[j + 1];
                    integerArr[j + 1] = temp;
                    String temp2 = nameArr[j];
                    nameArr[j] = nameArr[j + 1];
                    nameArr[j + 1] = temp2;
                    String temp3 = relArr[j];
                    relArr[j] = relArr[j + 1];
                    relArr[j + 1] = temp3;
        }

        for (int d = 0 ; d < m ; d++ ){
            System.out.println(nameArr[d] + " " + integerArr[d]);
            System.out.println(relArr[d]);
        }

    }
}
