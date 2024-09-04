package org.bibliotheque.presentation.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

import org.bibliotheque.metier.Entities.Livre;
import org.bibliotheque.metier.Entities.Magasine;
import org.bibliotheque.metier.storage.Interfaces.Bibliotheque;
import org.bibliotheque.metier.storage.LivreImp;
import org.bibliotheque.metier.storage.MagasineImp;
import org.bibliotheque.presentation.custom.ConsoleColors;
import org.bibliotheque.utils.DateUtil;

public class ConsoleUI {

    private static final Livre livre = new Livre();
    private static final Bibliotheque LivreImp = new LivreImp();
    private static final Bibliotheque MagasineImp = new MagasineImp();
    private static final Magasine magasine = new Magasine();

    public ConsoleUI() {
        Scanner sc = new Scanner(System.in);
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
                default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice" + ConsoleColors.RESET);
            }
        }
    }

    private void displayMenu() {
        System.out.println(ConsoleColors.BROWN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Welcome to LivreImp : " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Choose an option from below according to your designation: " + ConsoleColors.RESET);

        String format = "| %-4s | %-40s |\n";

        System.out.println("+------+------------------------------------------+");
        System.out.printf(format, "Key", "Option");
        System.out.println("+------+------------------------------------------+");
        System.out.printf(format, "1", ConsoleColors.PURPLE_BOLD_BRIGHT + "Ajouter un document (livre ou magazine)" + ConsoleColors.RESET);
        System.out.printf(format, "2", ConsoleColors.PURPLE_BOLD_BRIGHT + "Emprunter un document" + ConsoleColors.RESET);
        System.out.printf(format, "3", ConsoleColors.PURPLE_BOLD_BRIGHT + "Retourner un document" + ConsoleColors.RESET);
        System.out.printf(format, "4", ConsoleColors.PURPLE_BOLD_BRIGHT + "Rechercher un document" + ConsoleColors.RESET);
        System.out.printf(format, "5", ConsoleColors.PURPLE_BOLD_BRIGHT + "Afficher tous les documents" + ConsoleColors.RESET);
        System.out.printf(format, "6", ConsoleColors.PURPLE_BOLD_BRIGHT + "EXIT" + ConsoleColors.RESET);
        System.out.println("+------+------------------------------------------+");
    }


    public void ajouterDocument(Scanner sc) {
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Ajouter un livre" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Ajouter une magazine" + ConsoleColors.RESET);

        try {
            int ch = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter ISBN: ");
            int isbn = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String titre = sc.nextLine();

            System.out.print("Enter Author: ");
            String auteur = sc.nextLine();

            System.out.print("Enter date (yyyy/mmm/dd): ");
            String date = sc.nextLine();

            System.out.print("Enter Number of Pages: ");
            int nombreDePages = sc.nextInt();
            sc.nextLine();

            UUID uuid = UUID.randomUUID();
            String id = uuid.toString();

            switch (ch) {
                case 1 -> {
                    Livre livre = new Livre();
                    livre.setId(id);
                    livre.setIsbn(isbn);
                    livre.setTitre(titre);
                    livre.setAuteur(auteur);
                    livre.setDatePublication(DateUtil.parseDate(date));
                    livre.setNombreDePages(nombreDePages);
                    livre.setBorrowed(false);
                    LivreImp.Ajouter(livre);
                }
                case 2 -> {
                    Magasine magasine = new Magasine();
                    magasine.setId(id);
                    magasine.setNumero(isbn);
                    magasine.setTitre(titre);
                    magasine.setAuteur(auteur);
                    magasine.setDatePublication(DateUtil.parseDate(date));
                    magasine.setNombreDePages(nombreDePages);
                    magasine.setBorrowed(false);
                    MagasineImp.Ajouter(magasine);
                }
                default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice" + ConsoleColors.RESET);
            }
        } catch (InputMismatchException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Please enter the correct data type." + ConsoleColors.RESET);
            sc.nextLine();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "An error occurred: " + e.getMessage() + ConsoleColors.RESET);
        }
    }

    public void emprunterDocument(Scanner sc) {
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Emprunter un livre" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Emprunter une magazine" + ConsoleColors.RESET);
        try {
            int ch = sc.nextInt();
            System.out.print("Enter Document ID: ");
            String id = sc.next();
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    LivreImp.Emprunter(id);
                }
                case 2 -> {
                    MagasineImp.Emprunter(id);
                }
                default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice" + ConsoleColors.RESET);
            }
        } catch (InputMismatchException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Please enter the correct data type." + ConsoleColors.RESET);
            sc.nextLine();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "An error occurred: " + e.getMessage() + ConsoleColors.RESET);
        }
    }

    public void retournerDocument(Scanner sc) {
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Retourner un livre" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Retourner une magazine" + ConsoleColors.RESET);
        try {
            int ch = sc.nextInt();
            System.out.print("Enter Document ID: ");
            String id = sc.next();
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    LivreImp.Retourner(id);
                }
                case 2 -> {
                    MagasineImp.Retourner(id);
                }
                default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice" + ConsoleColors.RESET);
            }

        } catch (InputMismatchException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Please enter the correct data type." + ConsoleColors.RESET);
            sc.nextLine();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "An error occurred: " + e.getMessage() + ConsoleColors.RESET);
        }
    }

    public void afficherDocument(Scanner sc) {
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Afficher un livre" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Afficher une magazine" + ConsoleColors.RESET);
        try {
            int ch = sc.nextInt();
            switch (ch) {
                case 1 ->  System.out.println(LivreImp.Afficher());
                case 2 -> MagasineImp.Afficher();
                default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice" + ConsoleColors.RESET);
            }
        } catch (InputMismatchException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Please enter the correct data type." + ConsoleColors.RESET);
            sc.nextLine();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "An error occurred: " + e.getMessage() + ConsoleColors.RESET);
        }
    }

    public void rechercherDocument(Scanner sc) {
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Rechercher un livre" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Rechercher une magazine" + ConsoleColors.RESET);
        try {


            int ch = sc.nextInt();
            System.out.print("Enter Document ID: ");
            String id = sc.next();
            sc.nextLine();

            switch (ch) {
                case 1 -> System.out.println(LivreImp.getDocuments(id));
                case 2 -> System.out.println(MagasineImp.getDocuments(id));
                default -> System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice" + ConsoleColors.RESET);
            }
        } catch (InputMismatchException e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid input. Please enter the correct data type." + ConsoleColors.RESET);
            sc.nextLine();
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "An error occurred: " + e.getMessage() + ConsoleColors.RESET);
        }
    }
}