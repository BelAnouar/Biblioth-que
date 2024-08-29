package org.bibliotheque.main;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import org.bibliotheque.Entities.Livre;
import org.bibliotheque.storage.Interfaces.Bibliotheque;
import org.bibliotheque.storage.LivreImp;
import org.example.custom.ConsoleColors;

public class ConsoleUI {
    public void main(String[] args) {
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
                    this.ajouterDocument();
                    break;
                case 2:
                    this.emprunterDocument();
                    break;
                case 3:
                    this.retournerDocument();
                    break;
                case 4:
                    this.rechercherDocument();
                    break;
                case 5:
                    this.afficherDocument();
                    break;
                case 6:
                    return;

                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Invalid choice");
                    break;
            }
        } while (true);
    }


    public void ajouterDocument() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + " Ajouter un livre  magazine)" + ConsoleColors.RESET);
        System.out.println("Press 2 to" + ConsoleColors.PURPLE_BOLD_BRIGHT + "• Ajouter  une magazine" + ConsoleColors.RESET);
        Livre livre=new Livre();
        Bibliotheque LivreImp=new LivreImp();
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                UUID uuid = UUID.randomUUID();
                livre.setId(uuid.toString());
                livre.setIsbn(344);
                livre.setTitre("Nouveau Titre");
                livre.setAuteur("Nouvel Auteur");
                livre.setDatePublication(new Date());
                livre.setNombreDePages(450);
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

    public void afficherDocument() {

    }

    public void rechercherDocument() {

    }
}