package com.danijelcopic.example15dc.provider;

import com.danijelcopic.example15dc.model.Category;
import com.danijelcopic.example15dc.model.Ingridient;
import com.danijelcopic.example15dc.model.Jelo;

import java.util.ArrayList;
import java.util.List;


public class JeloProvider {

    public static List<Jelo> getJelo() {

        Category pizzaCat = new Category(0, "Pizza");
        Category saladCat = new Category(1, "Salad");
        Category soupCat = new Category(2, "Soup");

        Ingridient pizzaIng = new Ingridient(0, "Pizza");
        Ingridient saladIng = new Ingridient(1, "Salad");
        Ingridient soupIng = new Ingridient(2, "Soup");


        List<Jelo> jela = new ArrayList<>();
        jela.add(new Jelo(0, "pizza.png", "PIZZA MARGHERITA", 3.0f, "hot pizza with chilli flakes", pizzaCat, pizzaIng, "100g  eq.  266kcal", 9.45));
        jela.add(new Jelo(1, "salad.png", "CAESAR SALAD", 4.0f, "fresh salad with bacon and cheese", saladCat, saladIng, "100g  eq.  166kcal", 7.73));
        jela.add(new Jelo(2, "soup.png", "TOMATO SOUP", 5.0f, "tomato soup with blue cheese", soupCat, soupIng, "100g  eq.  98kcal", 4.92));
        return jela;
    }


    public static List<String> getJeloIme() {

        List<String> names = new ArrayList<>();
        names.add("Pizza");
        names.add("Salad");
        names.add("Soup");
        return names;
    }


    public static Jelo getJeloById(int id) {

        Category pizzaCat = new Category(0, "Pizza");
        Category saladCat = new Category(1, "Salad");
        Category soupCat = new Category(2, "Soup");

        Ingridient pizzaIng = new Ingridient(0, "Pizza");
        Ingridient saladIng = new Ingridient(1, "Salad");
        Ingridient soupIng = new Ingridient(2, "Soup");


        switch (id) {
            case 0:
                return new Jelo(0, "pizza.png", "PIZZA MARGHERITA", 3.0f, "hot pizza with chilli flakes", pizzaCat, pizzaIng, "100g  eq.  266kcal", 9.45);
            case 1:
                return new Jelo(1, "salad.png", "CAESAR SALAD", 4.0f, "fresh salad with bacon and cheese", saladCat, saladIng, "100g  eq.  166kcal", 7.73);
            case 2:
                return new Jelo(2, "soup.png", "TOMATO SOUP", 5.0f, "tomato soup with blue cheese", soupCat, soupIng, "100g  eq.  98kcal", 4.92);
            default:
                return null;
        }
    }
}
