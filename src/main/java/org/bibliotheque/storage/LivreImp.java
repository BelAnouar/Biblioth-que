package org.bibliotheque.storage;

import org.bibliotheque.Entities.Abstractions.Documents;
import org.bibliotheque.Entities.Livre;
import org.bibliotheque.Entities.Magasine;
import org.bibliotheque.storage.Interfaces.Bibliotheque;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

public class LivreImp implements Bibliotheque<Livre> {
    private static ArrayList<Livre> livres= new ArrayList<Livre>();;
    private  HashMap<String, Livre> documentMap = new HashMap<>();
    @Override
    public boolean Ajouter(Livre livre) {
      try{
          livres.add(livre);
          System.out.println(livre.getId());

          documentMap.put(livre.getId(), livre);
          System.out.println(documentMap);
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
