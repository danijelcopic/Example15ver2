package com.danijelcopic.example15dc.model;

import java.util.ArrayList;
import java.util.List;

public class Ingridient {

    private int id;
    private String name;
    private List<Jelo> jela;

    public Ingridient() {
        this.jela = new ArrayList<>();
    }

    public Ingridient(int id, String name) {
        this.id = id;
        this.name = name;
        this.jela = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Jelo> getJela() {
        return jela;
    }

    public void setJela(List<Jelo> jela) {
        this.jela = jela;
    }


    // dodatne metode

    public void addJelo(Jelo jelo) {

        jela.add(jelo);
    }

    public void removeJelo(Jelo jelo) {

        jela.remove(jelo);
    }

    public Jelo getJelo(int position) {

        return jela.get(position);
    }
}
