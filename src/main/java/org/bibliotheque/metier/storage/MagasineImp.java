package org.bibliotheque.metier.storage;

import org.bibliotheque.metier.entitie.Livre;
import org.bibliotheque.metier.entitie.Magasine;
import org.bibliotheque.metier.storage.interfaces.Bibliotheque;
import org.bibliotheque.utils.DataUtil;
import org.bibliotheque.utils.Print;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class MagasineImp implements Bibliotheque<Magasine> {
    private static final ArrayList<Magasine> magasines = new ArrayList<>();
    private final HashMap<String, Magasine> documentMap = new HashMap<>();
    private final Connection connection= DataUtil.con;
    @Override
    public boolean ajouter(Magasine magasine) {
        int generatedId;
        try {
            magasines.add(magasine);
            documentMap.put(magasine.getId(), magasine);
            String insertDocumentSQL = "INSERT INTO Document ( titre, auteur, datePublication, nombreDePages) VALUES ( ?, ?, ?, ?)";
            String insertLivreSQL = "INSERT INTO  Magazine (id, numero) VALUES (?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(insertDocumentSQL, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, magasine.getTitre());
                ps.setString(2, magasine.getAuteur());
                ps.setObject(3, magasine.getDatePublication());
                ps.setDouble(4, magasine.getNombreDePages());
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
                ps.setDouble(2, magasine.getNumero());
                ps.executeUpdate();
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public boolean emprunter(String id) {
        Magasine document = getDocuments(id);
        if (document == null) {
           Print.log("Magasine with ID " + id + " not found.");
            return false;
        }
       return document.emprunt();
    }

    @Override
    public boolean retourner(String id) {
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
            Magasine magasine = documentMap.get(id);
            if (magasine != null) {
                Print.log(magasine.afficherDetails());
            }
            return magasine;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public  void afficher() {
        for (Magasine magasine : magasines) {
            Print.log(magasine.afficherDetails());
        }
    }
}