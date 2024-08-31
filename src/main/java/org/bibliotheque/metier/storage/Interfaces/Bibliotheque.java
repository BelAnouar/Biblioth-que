package org.bibliotheque.metier.storage.Interfaces;

import org.bibliotheque.metier.Entities.Abstractions.Documents;

import java.util.List;

public interface  Bibliotheque<T extends Documents> {

   boolean Ajouter(T Documents);
   boolean Emprunter();
   boolean Retourner();
   T getDocuments(String  id);
   List<T> Afficher();

}
