package org.bibliotheque.metier.Entities.Abstractions;

import org.bibliotheque.utils.DateUtil;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public abstract class Documents {
    protected String id;
    protected String title;
    protected String author;
    protected LocalDate datePublication;
    protected int  nombreDePages ;
    protected  Documents(){

    }

    public Documents(String id , String titre ,String author ,LocalDate datePublication ,int nombreDePages ) {
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

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
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
