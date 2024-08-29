package org.bibliotheque.main;

import java.util.Scanner;
import org.example.custom.ConsoleColors;
public class ConsoleUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        do {
            System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Bibliotheque : "+ ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Choose  Option from Below According to your Designation  : " + ConsoleColors.RESET);
            System.out.println("Press 1 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " Ajouter un document (livre ou magazine)"      + ConsoleColors.RESET);
            System.out.println("Press 2 to" +ConsoleColors.PURPLE_BOLD_BRIGHT +  "• Emprunter un document"  + ConsoleColors.RESET);
            System.out.println("Press 3 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + "• Retourner un document"+ ConsoleColors.RESET);
            System.out.println("Press 4 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + "• Afficher tous les documents "+ ConsoleColors.RESET);
            System.out.println("Press 5 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + "•  Rechercher un document "+ ConsoleColors.RESET);
            System.out.println("Press 6 to" +ConsoleColors.PURPLE_BOLD_BRIGHT +" EXIT"+ ConsoleColors.RESET);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:


                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6 :
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Invalid choice");
                    break;
            }
        }while (true);
    }
}