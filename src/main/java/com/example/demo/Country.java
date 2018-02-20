package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    private String countryname;

    @ManyToMany(mappedBy = "myCountries")
    private List<Person> countryPeople;

    public Country() {
    }

    public Country(String countryname) {
        this.countryname = countryname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public List<Person> getCountryPeople() {
        return countryPeople;
    }

    public void setCountryPeople(List<Person> countryPeople) {
        this.countryPeople = countryPeople;
    }
}