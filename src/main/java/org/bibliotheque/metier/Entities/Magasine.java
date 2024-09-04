package org.bibliotheque.metier.Entities;

import org.bibliotheque.metier.Entities.Abstractions.Documents;
import org.bibliotheque.utils.DateUtil;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Magasine extends Documents {
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    private long numero;

    public Magasine(String id, String titre, String author, LocalDate datePublication, int nombreDePages, long numero,boolean isBorroweb) {
        super(id, titre, author, datePublication, nombreDePages,isBorroweb);
        this.numero = numero;
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
