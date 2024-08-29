package org.bibliotheque.Entities;

import org.bibliotheque.Entities.Abstractions.Documents;

import java.util.Date;
import java.util.List;

public class Magasine extends Documents {
    private long numero;

    public Magasine(String id, String titre, String author, Date datePublication, int nombreDePages) {
        super(id, titre, author, datePublication, nombreDePages);
    }
    public  Magasine(){
        super();
    }

    @Override
    public boolean emprunt() {
        return false;
    }

    @Override
    public boolean retourner() {
        return false;
    }

    @Override
    public List<? extends Documents> afficherDetails() {
        return List.of();
    }
}
