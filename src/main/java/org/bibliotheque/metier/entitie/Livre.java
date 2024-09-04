package org.bibliotheque.metier.entitie;

import org.bibliotheque.metier.entitie.abstractions.Documents;
import org.bibliotheque.utils.Print;


import java.time.LocalDate;

public class Livre extends Documents {
    private long isbn;

    public Livre(String id, String titre, String author, LocalDate datePublication, int nombreDePages, long isbn, boolean isBorroweb) {
        super(id, titre, author, datePublication, nombreDePages, isBorroweb);
        this.isbn = isbn;
    }


    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean emprunt() {

        if (isBorrowed()) {
            Print.log("Livre with ID " + id + " is already borrowed.");
            return false;
        }
        setBorrowed(true);
        Print.log("livre with ID " + id + " has been successfully borrowed.");
        return true;
    }

    @Override
    public boolean retourner() {

        if (!isBorrowed()) {
            Print.log("livre with ID " + id + " was not borrowed.");
            return false;
        }
        setBorrowed(false);

        Print.log("livre with ID " + id + " has been successfully returned.");
        return true;
    }

    @Override
    public String afficherDetails() {
        return "Livre {" +
                "ID='" + getId() + '\'' +
                ", Titre='" + getTitre() + '\'' +
                ", Auteur='" + getAuteur() + '\'' +
                ", Date de publication=" + getDatePublication() +
                ", Nombre de pages=" + getNombreDePages() +
                ", ISBN=" + isbn +
                '}';
    }


}
