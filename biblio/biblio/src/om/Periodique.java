package om;

public class Periodique extends Document {
    private static final long serialVersionUID = 1L;
    private String frequence;
    private int page;

    public Periodique(String titre, int page, String frequence) {
        super(titre);
        this.page = page;
        this.frequence = frequence;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pages : " + page + ", Fréquence : " + frequence;
    }
}
