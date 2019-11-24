package view;

import model.Livre;

import java.util.ArrayList;

public class LivreView {
    private ArrayList<Livre> livres;

    public LivreView(ArrayList<Livre> livres) {
        this.livres = livres;
    }

    public void display() {
        System.out.println("======== Liste des livres ========");

        for(Livre livre : livres) {
            System.out.println("livre n°" + livre.getId() + " - " + livre.getTitre() + " by " + livre.getAuteur() + ". Released " + livre.getDate());
        }
    }
}
