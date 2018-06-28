package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class ColorController {
    @Autowired
    PersonRepository peopleList;

    @Autowired
    ColorRepository colorList;

    @RequestMapping("/")
    public String index(Model model)
    {
        model.addAttribute("colorList", colorList.findAll());
        model.addAttribute("personlist", peopleList.findAll());
        return "index";
    }

    @RequestMapping("/addcolor")
    public String addColor(Model model)
    {
        model.addAttribute("aColor", new Color());
        model.addAttribute("people", peopleList.findAll());
        return "color";
    }

    @RequestMapping("/savecolor")
    public String saveColor(@ModelAttribute("aColor") Color color, Model model)
    {
        colorList.save(color);
        return "redirect:/";
    }

    ////

    @RequestMapping("/addperson")
    public String addPerson(Model model)
    {
        model.addAttribute("aPerson", new Person());
        model.addAttribute("people", peopleList.findAll());
        return "person";
    }

    @RequestMapping("/saveperson")
    public String savePerson(@ModelAttribute("aPerson") Person person, Model model)
    {
        peopleList.save(person);
        return "redirect:/";
    }

    @PostConstruct
    public void fillTables()
    {
        Person p = new Person();
        p.setMyName("John Smith");
        peopleList.save(p);

        p = new Person();
        p.setMyName("Owen Richards");
        peopleList.save(p);

        p = new Person();
        p.setMyName("Tasso Stamboulis");
        peopleList.save(p);
    }
}
