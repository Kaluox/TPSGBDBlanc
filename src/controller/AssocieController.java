package controller;

import model.Associe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssocieController {
	private DatabaseController db;

	public AssocieController(DatabaseController db) {
		this.db = db;
	}

	public ArrayList<Associe> getAssocie(String name, String lastname) throws SQLException {
		ResultSet associes = db.query("select * from Associe where ASS_NOM = '" + name + "' AND ASS_PRENOM = '" + lastname + "';");
		ArrayList<Associe> result = new ArrayList<>();

		return populateList(associes);
	}

	public ArrayList<Associe> getAssocieByName(String name) throws SQLException {
		ResultSet associes = db.query("select * from Associe where ASS_NOM = '" + name + "';");

		return populateList(associes);
	}

	public ArrayList<Associe> getAssocieByLastname(String lastname) throws SQLException {
		ResultSet associes = db.query("select * from Associe where ASS_PRENOM = '" + lastname + "';");

		return populateList(associes);
	}

	public ArrayList<Associe> getAssocieWhoBorrowedLivre(String titre) throws SQLException {
		ResultSet associes = db.query("select * from Emprunte join Livre using(LIV_ID) join Associe using(ASS_ID) where LIV_TITRE = '" + titre + "';");

		return populateList(associes);
	}

	private ArrayList<Associe> populateList(ResultSet associes) throws SQLException {
		ArrayList<Associe> result = new ArrayList<>();

		while(associes.next()) {
			Associe associe = new Associe();

			associe.setId(associes.getInt("ASS_ID"));
			associe.setNom(associes.getString("ASS_NOM"));
			associe.setPrenom(associes.getString("ASS_PRENOM"));

			result.add(associe);
		}

		return result;
	}
}
