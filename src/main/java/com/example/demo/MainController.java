package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    CountryRepo countryRepo;

    @Autowired
    PersonRepo personRepo;

    @RequestMapping("/")
    public String addHere()
    {

        Country c = new Country("Ghana");
        countryRepo.save(c);

        c = new Country ("Dominican Republic");
        countryRepo.save(c);
        c = new Country ("United States");
        countryRepo.save(c);

        //List Countries:
        System.out.println("This is a list of countries in the database:");

        for(Country thisCountry:countryRepo.findAll()) {
            System.out.println(thisCountry.getCountryname());
        }

        Person A = new Person();
        A.setFirstname("Jane");
        A.setLastname("Doe");
        A.addCountry(countryRepo.findByCountryname("Ghana"));
        personRepo.save(A);


        //Update this exercise:
        /* For each Person in the database, show where they are from. A person can be from more than one country.*/

//Use this section to display a list of people and the countries they are from.

        return "Check the console for your details";

    }
    @RequestMapping("/home")
    public String tohome(){
        return "homepage";
    }

    @GetMapping("/addperson")
    public String addperson(Model model){
        model.addAttribute("addperson", new Person());
        return "person";
    }

    @PostMapping("/processperson")
    public String processperson(@ModelAttribute("addperson") Person person){
        personRepo.save(person);
        return "redirect:/home";
    }

    @GetMapping("/addcountry")
    public String addcountry(Model model){
        model.addAttribute("addcountry", new Country());
        return "country";

    }

    @PostMapping("/processcountry")
    public String addcountry(@ModelAttribute("addcountry")Country country){
        countryRepo.save(country);
        return "redirect:/home";
    }

}
