package org.bibliotheque.metier.storage;

import org.bibliotheque.metier.Entities.Livre;
import org.bibliotheque.metier.storage.Interfaces.Bibliotheque;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LivreImp implements Bibliotheque<Livre> {
    private static final ArrayList<Livre> livres= new ArrayList<Livre>();;
    private final HashMap<String, Livre> documentMap = new HashMap<>();
    @Override
    public boolean Ajouter(Livre livre) {
      try{
          livres.add(livre);
          documentMap.put(livre.getId(), livre);
          return true;
      }catch (Exception e){
          e.printStackTrace();
          return false;

      }
    }

    @Override
    public boolean Emprunter(String id) {
        Livre document = getDocuments(id);
        if (document == null) {
            System.out.println("Livre with ID " + id + " not found.");
            return false;
        }
        if (document.isBorrowed()) {
            System.out.println("Livre with ID " + id + " is already borrowed.");
            return false;
        }
        document.setBorrowed(true);
        System.out.println("livre with ID " + id + " has been successfully borrowed.");
        return true;

    }

    @Override
    public boolean Retourner(String id) {
        Livre document = getDocuments(id);
        if (document == null) {
            System.out.println("Livre with ID " + id + " not found.");
            return false;
        }
        if (!document.isBorrowed()) {
            System.out.println("livre with ID " + id + " was not borrowed.");
            return false;
        }
        document.setBorrowed( false); ;
        System.out.println("livre with ID " + id + " has been successfully returned.");
        return true;
    }

    @Override
    public Livre getDocuments(String id) {
        try {

           return documentMap.get(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List<Livre>  Afficher() {
        return livres;
    }



}
