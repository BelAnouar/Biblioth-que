package org.bibliotheque.storage.Interfaces;

import org.bibliotheque.Entities.Abstractions.Documents;
import org.bibliotheque.Entities.Livre;

import java.util.List;

public interface  Bibliotheque<T extends Documents> {

   boolean Ajouter(T Documents);
   boolean Emprunter();
   boolean Retourner();
   T getDocuments();
   List<T> Afficher();

}
