package org.bibliotheque.metier.storage;

import org.bibliotheque.metier.entitie.Livre;
import org.bibliotheque.metier.storage.interfaces.Bibliotheque;
import org.bibliotheque.utils.DataUtil;
import org.bibliotheque.utils.Print;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LivreImp implements Bibliotheque<Livre> {
    private static final ArrayList<Livre> livres= new ArrayList<>();
    private final HashMap<String, Livre> documentMap = new HashMap<>();
    private final Connection connection= DataUtil.con;
    @Override
    public boolean Ajouter(Livre livre) {
        int generatedId;
      try{
          livres.add(livre);
          documentMap.put(livre.getId(), livre);

          String insertDocumentSQL = "INSERT INTO Document ( titre, auteur, datePublication, nombreDePages) VALUES ( ?, ?, ?, ?)";
          String insertLivreSQL = "INSERT INTO Livre (id, isbn) VALUES (?, ?)";
          try (PreparedStatement ps = connection.prepareStatement(insertDocumentSQL, Statement.RETURN_GENERATED_KEYS)) {

              ps.setString(1, livre.getTitre());
              ps.setString(2, livre.getAuteur());
              ps.setObject(3, livre.getDatePublication());
              ps.setDouble(4, livre.getNombreDePages());
              ps.executeUpdate();

              try (ResultSet res=ps.getGeneratedKeys();) {

                  if (res.next()) {
                     generatedId = res.getInt(1);


                 } else {
                     throw new SQLException("Creating document failed, no ID obtained.");
                }
             }
         }


          try (PreparedStatement ps = connection.prepareStatement(insertLivreSQL)) {
              ps.setInt(1,generatedId );
              ps.setLong(2, livre.getIsbn());
              ps.executeUpdate();
          }
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
            Print.log("Livre with ID " + id + " not found.");
            return false;
        }
        return   document.emprunt();

    }

    @Override
    public boolean Retourner(String id) {
        Livre document = getDocuments(id);
        if (document == null) {
            Print.log("Livre with ID " + id + " not found.");
            return false;
        }
        return document.retourner();
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
