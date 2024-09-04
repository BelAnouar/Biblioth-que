package org.bibliotheque.metier.storage.interfaces;

import org.bibliotheque.metier.entitie.abstractions.Documents;



public interface  Bibliotheque<T extends Documents> {

   boolean ajouter(T Documents);
   boolean emprunter(String id);
   boolean retourner(String id);
   T getDocuments(String  id);
   void afficher();

}
