package org.bibliotheque.storage;

import org.bibliotheque.Entities.Abstractions.Documents;
import org.bibliotheque.Entities.Livre;
import org.bibliotheque.Entities.Magasine;
import org.bibliotheque.storage.Interfaces.Bibliotheque;

import java.util.List;

public class MagasineImp implements Bibliotheque<Magasine> {
    @Override
    public boolean Ajouter(Magasine magasine) {
        return false;
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
    public Magasine getDocuments() {
        return null;
    }

    @Override
    public List<Magasine> Afficher() {
        return List.of();
    }
}
