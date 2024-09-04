package org.bibliotheque.presentation.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

import org.bibliotheque.metier.entitie.Livre;
import org.bibliotheque.metier.entitie.Magasine;
import org.bibliotheque.metier.storage.LivreImp;
import org.bibliotheque.metier.storage.MagasineImp;
import org.bibliotheque.utils.DateUtil;
import org.bibliotheque.utils.Print;

public class ConsoleUI {

    private static final LivreImp LivreImp = new LivreImp();
    private static final MagasineImp MagasineImp = new MagasineImp();

    public ConsoleUI() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                int ch = sc.nextInt();
                switch (ch) {
                    case 1 -> ajouterDocument(sc);
                    case 2 -> emprunterDocument(sc);
                    case 3 -> retournerDocument(sc);
                    case 4 -> rechercherDocument(sc);
                    case 5 -> afficherDocument(sc);
                    case 6 -> {
                        return;
                    }
                    default -> Print.log("Invalid choice");
                }
            }
        }
    }

    private void displayMenu() {
        Print.log("Welcome to LivreImp : ");
        Print.log("Choose an option from below according to your designation:");

        String format = "| %-4s | %-40s |\n";

        Print.log("+------+------------------------------------------+");
        Print.log(String.format(format, "Key", "Option"));
        Print.log("+------+------------------------------------------+");
        Print.log(String.format(format, "1", "Ajouter un document (livre ou magazine)"));
        Print.log(String.format(format, "2", "Emprunter un document"));
        Print.log(String.format(format, "3", "Retourner un document"));
        Print.log(String.format(format, "4", "Rechercher un document"));
        Print.log(String.format(format, "5", "Afficher tous les documents"));
        Print.log(String.format(format, "6", "EXIT"));
        Print.log("+------+------------------------------------------+");
    }

    public void ajouterDocument(Scanner sc) {
        Print.log("Press 1 to Ajouter un livre");
        Print.log("Press 2 to Ajouter une magazine");

        try {
            int ch = sc.nextInt();
            sc.nextLine();

            Print.log("Enter ISBN: ");
            int isbn = sc.nextInt();
            sc.nextLine();

            Print.log("Enter Title: ");
            String titre = sc.nextLine();

            Print.log("Enter Author: ");
            String auteur = sc.nextLine();

            Print.log("Enter date (yyyy/MM/dd): ");
            String date = sc.nextLine();

            Print.log("Enter Number of Pages: ");
            int nombreDePages = sc.nextInt();
            sc.nextLine();

            UUID uuid = UUID.randomUUID();
            String id = uuid.toString();

            switch (ch) {
                case 1 -> {
                    Livre livre = new Livre(id, titre, auteur, DateUtil.parseDate(date), nombreDePages, isbn, false);
                    LivreImp.Ajouter(livre);
                }
                case 2 -> {
                    Magasine magasine = new Magasine(id, titre, auteur, DateUtil.parseDate(date), nombreDePages, isbn, false);
                    MagasineImp.Ajouter(magasine);
                }
                default -> Print.log("Invalid choice");
            }
        } catch (InputMismatchException e) {
            Print.log("Invalid input. Please enter the correct data type.");
            sc.nextLine();
        }
    }

    public void emprunterDocument(Scanner sc) {
        Print.log("Press 1 to Emprunter un livre");
        Print.log("Press 2 to Emprunter une magazine");
        try {
            int ch = sc.nextInt();
            Print.log("Enter Document ID: ");
            String id = sc.next();
            sc.nextLine();

            switch (ch) {
                case 1 -> LivreImp.Emprunter(id);
                case 2 -> MagasineImp.Emprunter(id);
                default -> Print.log("Invalid choice");
            }
        } catch (InputMismatchException e) {
            Print.log("Invalid input. Please enter the correct data type.");
            sc.nextLine();
        }
    }

    public void retournerDocument(Scanner sc) {
        Print.log("Press 1 to Retourner un livre");
        Print.log("Press 2 to Retourner une magazine");
        try {
            int ch = sc.nextInt();
            Print.log("Enter Document ID: ");
            String id = sc.next();
            sc.nextLine();

            switch (ch) {
                case 1 -> LivreImp.Retourner(id);
                case 2 -> MagasineImp.Retourner(id);
                default -> Print.log("Invalid choice");
            }
        } catch (InputMismatchException e) {
            Print.log("Invalid input. Please enter the correct data type.");
            sc.nextLine();
        }
    }

    public void afficherDocument(Scanner sc) {
        Print.log("Press 1 to Afficher un livre");
        Print.log("Press 2 to Afficher une magazine");
        try {
            int ch = sc.nextInt();
            switch (ch) {
                case 1 -> Print.log(LivreImp.Afficher());
                case 2 -> Print.log(MagasineImp.Afficher());
                default -> Print.log("Invalid choice");
            }
        } catch (InputMismatchException e) {
            Print.log("Invalid input. Please enter the correct data type.");
            sc.nextLine();
        }
    }

    public void rechercherDocument(Scanner sc) {
        Print.log("Press 1 to Rechercher un livre");
        Print.log("Press 2 to Rechercher une magazine");
        try {
            int ch = sc.nextInt();
            Print.log("Enter Document ID: ");
            String id = sc.next();
            sc.nextLine();

            switch (ch) {
                case 1 -> Print.log(LivreImp.getDocuments(id));
                case 2 -> Print.log(MagasineImp.getDocuments(id));
                default -> Print.log("Invalid choice");
            }
        } catch (InputMismatchException e) {
            Print.log("Invalid input. Please enter the correct data type.");
            sc.nextLine();
        }
    }
}
