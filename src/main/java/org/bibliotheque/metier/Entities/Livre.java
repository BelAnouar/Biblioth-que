package org.bibliotheque.metier.Entities;

import org.bibliotheque.metier.Entities.Abstractions.Documents;
import org.bibliotheque.utils.DateUtil;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Livre extends Documents {
    private long isbn;
    public Livre(String id, String titre, String author, LocalDate datePublication, int nombreDePages, long isbn,boolean isBorroweb) {
        super(id, titre, author,  datePublication, nombreDePages,isBorroweb);
        this.isbn = isbn;
    }
    public Livre(){
        super();
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
            System.out.println("Livre with ID " + id + " is already borrowed.");
            return false;
        }
        setBorrowed(true);
        System.out.println("livre with ID " + id + " has been successfully borrowed.");
        return true;
    }

    @Override
    public boolean retourner() {

        if (!isBorrowed()) {
            System.out.println("livre with ID " + id + " was not borrowed.");
            return false;
        }
        setBorrowed( false); ;
        System.out.println("livre with ID " + id + " has been successfully returned.");
        return true;
    }

    @Override
    public List<Livre> afficherDetails() {
        return List.of();
    }

    @Override
    public String toString() {
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
