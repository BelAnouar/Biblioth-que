package org.bibliotheque.metier.Entities;

import org.bibliotheque.metier.Entities.Abstractions.Documents;
import org.bibliotheque.utils.Print;


import java.time.LocalDate;

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
        if (isBorrowed()) {
            Print.log("Magasine with ID " + id + " is already borrowed.");
            return false;
        }
        setBorrowed(true);
        Print.log("Magasine with ID " + id + " has been successfully borrowed.");
        return true;
    }

    @Override
    public boolean retourner() {
        if (!isBorrowed()) {
            Print.log("Magasine with ID " + id + " was not borrowed.");
            return false;
        }
        setBorrowed(false);
        Print.log("Magasine with ID " + id + " has been successfully returned.");
        return true;
    }

    @Override
    public List<? extends Documents> afficherDetails() {
        return List.of();
    }
}
