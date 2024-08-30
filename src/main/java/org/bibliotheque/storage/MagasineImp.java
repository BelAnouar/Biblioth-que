package org.bibliotheque.storage;

import org.bibliotheque.Entities.Abstractions.Documents;
import org.bibliotheque.Entities.Livre;
import org.bibliotheque.Entities.Magasine;
import org.bibliotheque.storage.Interfaces.Bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class MagasineImp implements Bibliotheque<Magasine> {
    private static ArrayList<Magasine> magasines= new ArrayList<Magasine>();;
    @Override
    public boolean Ajouter(Magasine magasine) {
        try{
            magasines.add(magasine);
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
    public Magasine getDocuments(String id) {
        try {
            for (Magasine m : magasines) {
                if(m.getId().equals(id)){
                    return m;
                }
            }
        }catch (Exception e){
            e.printStackTrace();

            return null;
        }

        return null;
    }

    @Override
    public List<Magasine> Afficher() {
      return magasines;
    }
}
