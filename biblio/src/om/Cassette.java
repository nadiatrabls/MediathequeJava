package om;

public class Cassette extends Document {
    private String auteur;
    private int duree;

    public Cassette(String titre, String auteur, int duree) {
        super(titre);
        this.auteur = auteur;
        this.duree = duree;
    }

    @Override
    public String toString() {
        return super.toString() + ", Auteur : " + auteur + ", Durée : " + duree + " min";
    }
}
