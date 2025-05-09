package om;

import java.util.Enumeration;
import java.util.Vector;
import java.util.Hashtable;
import java.io.*;

public class Bibliotheque implements Serializable {
    private static final long serialVersionUID = 1L;
    private Vector<Document> tdocument;
    private String nom;
    private Hashtable<String, Vector<Document>> indexTable;

    public Bibliotheque(String nom) {
        this.nom = nom;
        this.tdocument = new Vector<>();
        this.indexTable = new Hashtable<>();
    }

    public void ajouterDocument(Document doc) {
        tdocument.add(doc);
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Bibliotheque : " + nom + " (" + tdocument.size() + " documents)";
    }

    public void listerDocuments() {
        System.out.println("Documents dans la bibliotheque \"" + nom + "\" :");
        for (Document doc : tdocument) {
            System.out.println("- " + doc.toString());
        }
    }

    public Enumeration<Document> documents() {
        return tdocument.elements();
    }

    public void ajouterIndex(Document doc, String index) {
        Vector<Document> docs;
        if (indexTable.containsKey(index)) {
            docs = indexTable.get(index);
        } else {
            docs = new Vector<>();
            indexTable.put(index, docs);
        }

        if (!docs.contains(doc)) {
            docs.add(doc);
        }
    }

    public Enumeration<String> trouverIndexDocument(Document doc) {
        Vector<String> resultats = new Vector<>();

        for (String key : indexTable.keySet()) {
            Vector<Document> docs = indexTable.get(key);
            if (docs.contains(doc)) {
                resultats.add(key);
            }
        }

        return resultats.elements();
    }

    public Enumeration<Document> trouverDocumentsIndex(String index) throws DocumentPasTrouve {
        if (indexTable.containsKey(index)) {
            return indexTable.get(index).elements();
        } else {
            throw new DocumentPasTrouve(this, index);
        }
    }

    public Enumeration<String> indexes() {
        return indexTable.keys();
    }

    public static Bibliotheque charger(String chemin) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(chemin))) {
            return (Bibliotheque) ois.readObject();
        } catch (Exception e) {
            return new Bibliotheque("Nouvelle Bibliotheque");
        }
    }

    public void sauvegarder(String chemin) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(chemin))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Erreur de sauvegarde : " + e.getMessage());
        }
    }
}
