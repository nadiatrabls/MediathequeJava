package om;

public class Livre extends Document {
    private static final long serialVersionUID = 1L;
    private int page;
    private String auteur;
    private String editeur;

    public Livre(String titre, int page, String auteur, String editeur) {
        super(titre);
        this.page = page;
        this.auteur = auteur;
        this.editeur = editeur;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pages : " + page + ", Auteur : " + auteur + ", Éditeur : " + editeur;
    }
}