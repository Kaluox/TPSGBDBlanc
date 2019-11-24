package view;

import controller.DatabaseController;
import controller.LivreController;
import model.Livre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    private DatabaseController dbController;

    public MenuView(DatabaseController dbController) {
        this.dbController = dbController;
    }

    public void display() {
        System.out.println("Que voulez vous faire ?");
        System.out.println("1) Afficher tous les livres");
        System.out.println("2) Ajouter un exemplaire d'un livre");
        Scanner sc = new Scanner(System.in);

        int response = sc.nextInt();

        if(response == 1) {
            LivreController livreController = new LivreController(dbController);

            try {
                ArrayList<Livre> livres = livreController.getAllLivres();
                new LivreView(livres).display();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
