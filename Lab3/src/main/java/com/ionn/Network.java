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

    @Override
    public String toString() {
        return "Network{" +
                "personList=" + personList +
                ", companyList=" + companyList +
                '}';
    }
}
