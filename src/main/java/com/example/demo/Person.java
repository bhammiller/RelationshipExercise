package com.example.demo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String firstname;

    private String lastname;

    @ManyToMany
    private List<Country> myCountries;

    public Person() {
        myCountries = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Country> getMyCountries() {
        return myCountries;
    }

    public void setMyCountries(List<Country> myCountries) {
        this.myCountries = myCountries;
    }

    public void addCountry(Country c)
    {
        this.myCountries.add(c);
    }
}