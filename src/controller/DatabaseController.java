package controller;

import java.sql.*;

/**
 * Représente la base de données.
 * Permet la connection et l'execution de requêtes à une bdd.
 */
public class DatabaseController {
	/**
	 * Lien du server où tourne le SGBD (ex: 127.0.0.1)
	 */
	private String host;

	/**
	 * Port où écoute le SGBD (ex: 50300)
	 */
	private int port;

	/**
	 * nom du SGBD (ex: mysql)
	 */
	private String type;

	/**
	 * Nom de la base de données (ex: test)
	 */
	private String name;

	/**
	 * Paramètres à passer au SGBD (ex: useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC)
	 */
	private String parameters;

	/**
	 * Nom de l'utilisateur avec lequel on veut se connecter
	 */
	private String user;

	/**
	 * Mot de passe de l'utilisateur avec lequel on veut se connecter
	 */
	private String password;

	private Connection connection;

	/**
	 * Rempli les membres de la classe et essaye de se connecter à la base
	 */
	public DatabaseController(String host, int port, String dbType, String dbName, String parameters, String user, String password) {
		this.host = host;
		this.port = port;
		this.type = dbType;
		this.name = dbName;
		this.parameters = parameters;
		this.user = user;
		this.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connect();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Pilote non trouvé !");
			System.exit(1);
		}
		catch (SQLException e) {
			System.out.println("La connection à la base a échouée.");
			System.out.println("--------- ERREUR ---------");
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * Créé la chaine de connection et essaye de se connecter à la base correspondante
	 * @return La connection créée
	 * @throws SQLException
	 */
	private Connection connect() throws SQLException{
		return DriverManager.getConnection(
				"jdbc:" + type + "://" + host + ":" + port + "/" + name + "?" + parameters,
				user,
				password
		);
	}

	/**
	 * Execute une requête de type select
	 * @param sql requête à executer
	 * @return le resultset contenant les résultats de la requête
	 * @throws SQLException
	 */
	public ResultSet query(String sql) throws SQLException{
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(
				sql
		);
	}

	/**
	 * Execute une requête de type CRUD
	 * @param sql requête à executer
	 * @throws SQLException
	 */
	public void execute(String sql) throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate(
				sql
		);
	}
}
