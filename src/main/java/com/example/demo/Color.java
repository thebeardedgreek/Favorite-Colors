package com.example.demo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    private String colorName;

    @ManyToMany()
    private Set<Person> people;

    public Color() {
        people = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}
