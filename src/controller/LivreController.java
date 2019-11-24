package controller;

import model.Livre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivreController {
	DatabaseController db;

	public LivreController(DatabaseController db) {
		this.db = db;
	}

	public ArrayList<Livre> getAllLivres() throws SQLException {
		ResultSet livres = db.query("select * from Livre order by LIV_TITRE asc;");

		return populateList(livres);
	}

	public ArrayList<Livre> getLivreByTitle(String titre) throws SQLException {
		ResultSet livres = db.query("select * from Livre where LIV_TITRE = '" + titre + "' order by LIV_TITRE asc;");

		return populateList(livres);
	}

	public ArrayList<Livre> getLivreByAuthor(String author) throws SQLException {
		ResultSet livres = db.query("select * from Livre where LIV_AUTEUR = '" + author + "' order by LIV_TITRE asc;");

		return populateList(livres);
	}

	public ArrayList<Livre> getLivreByDate(String date) throws SQLException {
		ResultSet livres = db.query("select * from Livre where LIV_DATE = '" + date + "' order by LIV_TITRE asc;");

		return populateList(livres);
	}

	public ArrayList<Livre> getBurrowedLivres(String name, String lastname) throws SQLException {
		ResultSet livres = db.query("select * from Emprunte join Livre using(LIV_ID) join Associe using(ASS_ID) where ASS_NOM = '" + name + "' AND ASS_PRENOM = '" + lastname + "' order by titre asc;");

        return populateList(livres);
	}

	private ArrayList<Livre> populateList(ResultSet livres) throws SQLException {
		ArrayList<Livre> result = new ArrayList<>();

		while (livres.next()) {
			Livre livre = new Livre();

			livre.setId(livres.getInt("LIV_ID"));
			livre.setTitre(livres.getString("LIV_TITRE"));
			livre.setAuteur(livres.getString("LIV_AUTEUR"));
			livre.setDate(livres.getDate("LIV_DATE"));

			result.add(livre);
		}

		return result;
	}

	public void addCopy(int id) throws SQLException
	{
		ResultSet livre = db.query("select * from Livre where LIV_ID = " + id);
		livre.next();

		db.execute("insert into Livre(LIV_TITRE, LIV_AUTEUR, LIV_DATE) values('" + livre.getString("LIV_TITRE") + "', '" + livre.getString("LIV_AUTEUR") + "', '" + livre.getDate("LIV_DATE") +"';");
	}
}
