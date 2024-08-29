package org.bibliotheque.Entities.Abstractions;

import java.util.Date;
import java.util.List;

abstract class Documents {
    protected int id;
    protected String title;
    protected String author;
    protected Date datePublication;
    protected int  nombreDePages ;

    abstract boolean emprunt();
    abstract boolean retourner();
    abstract List<Documents> afficherDetails();
}
