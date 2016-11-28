package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnection {
	 Connection getConexao(String tipoBanco, String endereco, String nomeBanco, String nomeUsuario, String senha) throws SQLException;
}
