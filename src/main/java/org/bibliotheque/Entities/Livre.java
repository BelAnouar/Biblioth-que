package org.bibliotheque.Entities;

import org.bibliotheque.Entities.Abstractions.Documents;

import java.util.Date;
import java.util.List;

public class Livre extends Documents {
    private long isbn;
    public Livre(String id, String titre, String author, Date datePublication, int nombreDePages) {
        super(id, titre, author, datePublication, nombreDePages);
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
    public List<Livre> afficherDetails() {
        return List.of();
    }
}
