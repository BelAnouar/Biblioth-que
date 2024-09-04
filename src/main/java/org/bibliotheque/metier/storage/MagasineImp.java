package org.bibliotheque.metier.storage;

import org.bibliotheque.metier.Entities.Magasine;
import org.bibliotheque.metier.storage.Interfaces.Bibliotheque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MagasineImp implements Bibliotheque<Magasine> {
    private static final ArrayList<Magasine> magasines = new ArrayList<Magasine>();
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
            System.out.println("Magasine with ID " + id + " not found.");
            return false;
        }
        if (document.isBorrowed()) {
            System.out.println("Magasine with ID " + id + " is already borrowed.");
            return false;
        }
        document.setBorrowed(true);
        System.out.println("Magasine with ID " + id + " has been successfully borrowed.");
        return true;
    }

    @Override
    public boolean Retourner(String id) {
        Magasine document = getDocuments(id);
        if (document == null) {
            System.out.println("Magasine with ID " + id + " not found.");
            return false;
        }
        if (!document.isBorrowed()) {
            System.out.println("Magasine with ID " + id + " was not borrowed.");
            return false;
        }
        document.setBorrowed(false);
        System.out.println("Magasine with ID " + id + " has been successfully returned.");
        return true;
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