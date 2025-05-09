package iu;

import om.Bibliotheque;
import om.Document;
import om.Livre;
import om.Periodique;
import om.Cassette;

public class Main {
    public static void main(String[] args) {
        // Création d'une bibliothèque
        Bibliotheque biblio = new Bibliotheque("Mediatheque Municipale");

        // Création de documents
        Document d1 = new Livre("1984", 328, "George Orwell", "Gallimard");
        Document d2 = new Periodique("Sciences & Vie", 120, "Mensuel");
        Document d3 = new Cassette("Mozart - Requiem", "Mozart", 55);

        // Ajout des documents à la bibliothèque
        biblio.ajouterDocument(d1);
        biblio.ajouterDocument(d2);
        biblio.ajouterDocument(d3);

        // Affichage
        System.out.println(biblio.toString());
        biblio.listerDocuments();
    }
}
