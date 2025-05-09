package om;

import java.util.Date;

public class Document {
    private String titre;
    private Date creationDate;

    // Constructeur sans paramètre
    public Document() {
        this.titre = "Sans titre";
        this.creationDate = new Date(); // date actuelle
    }

    // Constructeur avec paramètre titre
    public Document(String titre) {
        this.titre = titre;
        this.creationDate = new Date(); // date actuelle
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Titre : " + titre + ", Date de creation : " + creationDate;
    }

    // Getter pour titre
    public String getTitre() {
        return titre;
    }

    // Setter pour titre
    public void setTitre(String titre) {
        this.titre = titre;
    }

    // Getter pour creationDate
    public Date getCreationDate() {
        return creationDate;
    }
}
