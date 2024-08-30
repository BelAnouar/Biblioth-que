package org.bibliotheque.main;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import org.bibliotheque.Entities.Livre;
import org.bibliotheque.Entities.Magasine;
import org.bibliotheque.storage.Interfaces.Bibliotheque;
import org.bibliotheque.storage.LivreImp;
import org.bibliotheque.storage.MagasineImp;
import org.example.custom.ConsoleColors;

public class ConsoleUI {

    private static final Livre livre = new Livre();
    private static final Bibliotheque LivreImp = new LivreImp();
    private static final  Bibliotheque MagasineImp=new MagasineImp();
    private static final Magasine magasine=new Magasine();

     public  ConsoleUI() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(ConsoleColors.BROWN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "Welcome to LivreImp : " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Choose  Option from Below According to your Designation  : " + ConsoleColors.RESET);
            System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Ajouter un document (livre ou magazine)" + ConsoleColors.RESET);
            System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "• Emprunter un document" + ConsoleColors.RESET);
            System.out.println("Press 3 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "• Retourner un document" + ConsoleColors.RESET);
            System.out.println("Press 4 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "• Afficher tous les documents " + ConsoleColors.RESET);
            System.out.println("Press 5 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "•  Rechercher un document " + ConsoleColors.RESET);
            System.out.println("Press 6 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " EXIT" + ConsoleColors.RESET);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    this.ajouterDocument(sc);
                    break;
                case 2:
                    this.emprunterDocument();
                    break;
                case 3:
                    this.retournerDocument();
                    break;
                case 4:
                    this.rechercherDocument(sc);
                    break;
                case 5:
                    this.afficherDocument(sc);
                    break;
                case 6:
                    return;

                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice");
                    break;
            }
        } while (true);
    }


    public void ajouterDocument(Scanner sc) {
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Ajouter un livre  magazine)" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "• Ajouter  une magazine" + ConsoleColors.RESET);

        int ch = sc.nextInt();
        System.out.print("Enter ISBN: ");
        int isbn = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String titre = sc.nextLine();

        System.out.print("Enter Author: ");
        String auteur = sc.nextLine();

        System.out.print("Enter Number of Pages: ");
        int nombreDePages = sc.nextInt();
        sc.nextLine();


        switch (ch) {
            case 1:
                UUID uuid = UUID.randomUUID();
                livre.setId(uuid.toString());
                livre.setIsbn(isbn);
                livre.setTitre(titre);
                livre.setAuteur(auteur);
                livre.setDatePublication(new Date());
                livre.setNombreDePages(nombreDePages);
                LivreImp.Ajouter(livre);
                break;
            case 2:

                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice");
                break;
        }
    }

    public void emprunterDocument() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Emprunter un livre  )" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "Emprunter  une magazine" + ConsoleColors.RESET);

        int ch = sc.nextInt();
        switch (ch) {
            case 1:

                break;
            case 2:
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice");
                break;
        }
    }

    public void retournerDocument() {

    }

    public void afficherDocument(Scanner sc) {
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Affiche  un livre  )" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "Affiche  une magazine" + ConsoleColors.RESET);
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                 LivreImp.Afficher();
                break;
            case 2:
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice");
                break;
        }
    }

    public void rechercherDocument(Scanner sc) {
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Emprunter un livre  )" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "Emprunter  une magazine" + ConsoleColors.RESET);
        int ch = sc.nextInt();
        System.out.print("Enter ID: ");
        String id = sc.next();
        sc.nextLine();

        switch (ch) {
            case 1:
                    System.out.println(LivreImp.getDocuments(id));
                break;
            case 2:
                break;
            default:
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice");
                break;
        }
    }
}