package model;

import java.util.Date;

public class Livre {
    private int id;
    String titre;
    String auteur;
    Date date;

    public Livre(int id, String titre, String auteur, Date date) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
