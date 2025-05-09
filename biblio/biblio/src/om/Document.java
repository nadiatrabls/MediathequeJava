package om;

import java.util.Vector;
import java.util.Date;
import java.io.Serializable;

public abstract class Document implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String titre;
    protected Date creationDate;
    protected Vector<String> criteres = new Vector<>();

    public Document(String titre) {
        this.titre = titre;
        this.creationDate = new Date();
    }

    public String getTitre() {
        return titre;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void ajouterCritere(String critere) {
        criteres.add(critere);
    }

    public Vector<String> getCriteres() {
        return criteres;
    }

    public String toString() {
        return "Titre : " + titre + ", Date : " + creationDate + ", Critères : " + criteres;
    }
}
