package iu;

import om.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bibliotheque biblio = Bibliotheque.charger("biblio.ser");

        while (true) {
            System.out.println("\n1) Créer un document\n2) Lister les documents\n3) Rechercher les documents par critère\n4) Quitter l'application\nVotre choix : ");
            String choix = sc.nextLine();

            switch (choix) {
                case "1":
                    System.out.println("\n1) Créer une cassette\n2) Créer un livre\n3) Créer un périodique\n4) Retour");
                    String sousChoix = sc.nextLine();
                    switch (sousChoix) {
                        case "1":
                            System.out.print("Titre : "); String titre = sc.nextLine();
                            System.out.print("Auteur : "); String auteur = sc.nextLine();
                            System.out.print("Durée (en minutes, nombre uniquement) : ");
                            int duree = Integer.parseInt(sc.nextLine());
                            Cassette cassette = new Cassette(titre, auteur, duree);
                            ajouterCriteres(sc, cassette);
                            biblio.ajouterDocument(cassette);
                            break;
                        case "2":
                            System.out.print("Titre : "); titre = sc.nextLine();
                            System.out.print("Nb pages : "); int pages = Integer.parseInt(sc.nextLine());
                            System.out.print("Auteur : "); auteur = sc.nextLine();
                            System.out.print("Editeur : "); String editeur = sc.nextLine();
                            Livre livre = new Livre(titre, pages, auteur, editeur);
                            ajouterCriteres(sc, livre);
                            biblio.ajouterDocument(livre);
                            break;
                        case "3":
                            System.out.print("Titre : "); titre = sc.nextLine();
                            System.out.print("Nb pages : "); pages = Integer.parseInt(sc.nextLine());
                            System.out.print("Fréquence : "); String freq = sc.nextLine();
                            Periodique per = new Periodique(titre, pages, freq);
                            ajouterCriteres(sc, per);
                            biblio.ajouterDocument(per);
                            break;
                        default: break;
                    }
                    break;
                case "2":
                    System.out.println("\nDocuments dans la bibliothèque :");
                    Enumeration<Document> docs = biblio.documents();
                    while (docs.hasMoreElements()) {
                        System.out.println(docs.nextElement());
                    }
                    break;
                case "3":
                    System.out.print("Entrez un critère : ");
                    String crit = sc.nextLine();
                    System.out.println("\nDocuments correspondant :");
                    Enumeration<Document> tous = biblio.documents();
                    while (tous.hasMoreElements()) {
                        Document d = tous.nextElement();
                        if (d.getCriteres().contains(crit)) {
                            System.out.println(d);
                        }
                    }
                    break;
                case "4":
                    biblio.sauvegarder("biblio.ser");
                    System.out.println("Bibliothèque sauvegardée. Au revoir !");
                    System.exit(0);
                default: break;
            }
        }
    }

    public static void ajouterCriteres(Scanner sc, Document doc) {
        System.out.print("Critères (séparés par virgules) : ");
        String ligne = sc.nextLine();
        for (String crit : ligne.split(",")) {
            doc.ajouterCritere(crit.trim());
        }
    }
}