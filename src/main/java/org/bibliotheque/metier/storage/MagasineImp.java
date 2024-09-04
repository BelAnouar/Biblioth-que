package org.bibliotheque.metier.storage;

import org.bibliotheque.metier.Entities.Magasine;
import org.bibliotheque.metier.storage.Interfaces.Bibliotheque;
import org.bibliotheque.utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MagasineImp implements Bibliotheque<Magasine> {
    private static final ArrayList<Magasine> magasines = new ArrayList<>();
    private final HashMap<String, Magasine> documentMap = new HashMap<>();

    @Override
    public boolean Ajouter(Magasine magasine) {
        try {
            magasines.add(magasine);
            documentMap.put(magasine.getId(), magasine);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Emprunter(String id) {
        Magasine document = getDocuments(id);
        if (document == null) {
           Print.log("Magasine with ID " + id + " not found.");
            return false;
        }
       return document.emprunt();
    }

    @Override
    public boolean Retourner(String id) {
        Magasine document = getDocuments(id);
        if (document == null) {
            Print.log("Magasine with ID " + id + " not found.");
            return false;
        }
       return document.retourner();
    }

    @Override
    public Magasine getDocuments(String id) {
        try {
            return documentMap.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Magasine> Afficher() {
        return magasines;
    }
}