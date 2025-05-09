package om;

public class Bibliotheque {
    private Document[] tdocument;
    private int nbDocuments;
    private String nom;

    public Bibliotheque(String nom) {
        this.nom = nom;
        this.tdocument = new Document[100]; // capacité max
        this.nbDocuments = 0;
    }

    public void ajouterDocument(Document doc) {
        if (nbDocuments < tdocument.length) {
            tdocument[nbDocuments] = doc;
            nbDocuments++;
        } else {
            System.out.println("La bibliotheque est pleine !");
        }
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return "Bibliotheque : " + nom + " (" + nbDocuments + " documents)";
    }

    public void listerDocuments() {
        System.out.println("Documents dans la bibliotheque \"" + nom + "\" :");
        for (int i = 0; i < nbDocuments; i++) {
            System.out.println("- " + tdocument[i].toString());
        }
    }
}
