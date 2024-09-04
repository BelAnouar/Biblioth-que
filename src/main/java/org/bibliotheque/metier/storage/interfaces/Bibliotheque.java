package org.bibliotheque.metier.storage.interfaces;

import org.bibliotheque.metier.entitie.abstractions.Documents;

import java.util.List;

public interface  Bibliotheque<T extends Documents> {

   boolean Ajouter(T Documents);
   boolean Emprunter(String id);
   boolean Retourner(String id);
   T getDocuments(String  id);
   List<T> Afficher();

}
