package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
	public Connection connectionMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/painel_legendas","root","");
			return conexao;
		} catch(ClassNotFoundException | SQLException exception) {
                    System.out.println(exception.getMessage());
		}
		return null;
	}
}
