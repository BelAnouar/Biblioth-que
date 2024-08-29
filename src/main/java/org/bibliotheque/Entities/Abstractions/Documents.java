package org.bibliotheque.Entities.Abstractions;

import java.util.Date;
import java.util.List;

public abstract class Documents {
    private String id;
    private String title;
    private String author;
    private Date datePublication;
    private int  nombreDePages ;

    public Documents(String id , String titre ,String author ,Date datePublication ,int nombreDePages ) {
        this.id = id;
        this.title = author;
        this.author = titre;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return this.title;
    }

    public void setTitre(String titre) {
        this.title = titre;
    }

    public String getAuteur() {
        return author;
    }

    public void setAuteur(String auteur) {
        this.author = auteur;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }
    public abstract boolean emprunt();
    public abstract boolean retourner();
    public abstract List<? extends  Documents> afficherDetails();
}
