package org.bibliotheque.storage;

import org.bibliotheque.Entities.Abstractions.Documents;
import org.bibliotheque.Entities.Livre;
import org.bibliotheque.storage.Interfaces.Bibliotheque;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

public class LivreImp implements Bibliotheque<Livre> {
    private static ArrayList<Livre> livres= new ArrayList<Livre>();;

    @Override
    public boolean Ajouter(Livre livre) {
      try{
          livres.add(livre);
          return true;
      }catch (Exception e){
          e.printStackTrace();
          return false;
      }
    }

    @Override
    public boolean Emprunter() {
        return false;
    }

    @Override
    public boolean Retourner() {
        return false;
    }

    @Override
    public Livre getDocuments() {
        return null;
    }

    @Override
    public List<Livre> Afficher() {
        return List.of();
    }



}
