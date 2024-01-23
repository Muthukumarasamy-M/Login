package com.muthukumarasamy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.muthukumarasamy.User.User;

public class Repository {
	private static Repository repository = null;
	private Connection connection;

	private Repository() {
		try {
			connection = DBconnection.getConnection();
			createTableIfNotExists();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createTableIfNotExists() {

		try {
			String CreatetableSQL = "CREATE TABLE IF NOT EXISTS login( username varchar(30) primary key , password varchar(20) , email varchar(30));";
			Statement statement = connection.createStatement();
			statement.execute(CreatetableSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Repository getInstance() {
		System.out.println("asdfasdfasdf");
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public int AddUser(User user) throws SQLException {
		int rows = 0;
		String query = "INSERT INTO login (name, password, email) VALUES (?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query);

		System.out.println("adduser");
		statement.setString(1, user.getName());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getEmail());

		rows = statement.executeUpdate();

		return rows;
	}

	public User checkuser(String email) {

		String query = "Select * from login where email = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			result.next();
			return new User(result.getString(1), result.getString(2), result.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
